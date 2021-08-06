package Time_And_Space_Complexity;

import java.util.Scanner;
/*
 1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using radix sort.
Input Format
An Integer n 
arr1
arr2..
n integers
Sample Input
5
7 
2 
4 
1 
3
Sample Output
After sorting on 1 place -> 1 2 3 4 7 
1 2 3 4 7 
 */

public class Radix_Sort {
    
	public static void radixSort(int[] arr) {
		// write code here
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		int exp = 1;
		while(max != 0) {
			max = max / 10;
			countSort(arr, exp);
			exp*=10;
		}
		
	}

	public static void countSort(int[] arr, int exp) {
//		int range = 9 - 0 + 1; // max - min + 1
		
		int freq[] = new int[10];
		// create the frequency array
		for (int i = 0; i < arr.length; i++) {
			int idx = ( arr[i] / exp % 10 );
			freq[idx]++;
		}

		// convert frequency array into prefix sum array
		for (int i = 1; i < freq.length; i++) {
			freq[i] = freq[i - 1] + freq[i];
		}

		int ans[] = new int[arr.length];

		// travel from right to left in original array and fill the ans array
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = freq[( arr[i] / exp % 10 )];
			ans[pos - 1] = arr[i];
			freq[( arr[i] / exp % 10 )]--;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}
		// write code here
		System.out.print("After sorting on " + exp + " place -> ");
		print(arr);
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		radixSort(arr);
		print(arr);
		scn.close();
	}
}
