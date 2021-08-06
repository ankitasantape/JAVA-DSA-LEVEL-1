package Time_And_Space_Complexity;

import java.util.Scanner;

/*
1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using count sort.
Input Format
An Integer n 
arr1
arr2..
n integers
Sample Input
5
7 
-2 
4 
1 
3
Sample Output
-2
1
3
4
7

Sample Input 
9
18 20 22 20 13 18 20 17 14

Sample Output
13 14 17 18 18 20 20 20 22 

 */

public class Count_Sort {
    
	public static void countSort(int[] arr, int min, int max) {
		int range = max - min + 1;
		int freq[] = new int[range];
		// create the frequency array
		for (int i = 0; i < arr.length; i++) {
			int idx = arr[i] - min;
			freq[idx]++;
		}

		// convert frequency array into prefix sum array
		for (int i = 1; i < range; i++) {
			freq[i] = freq[i - 1] + freq[i];
		}

		int ans[] = new int[arr.length];

		// travel from right to left in original array and fill the ans array
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = freq[arr[i] - min];
			ans[pos - 1] = arr[i];
			freq[arr[i] - min]--;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		countSort(arr, min, max);
		print(arr);
		scn.close();
	}
}
