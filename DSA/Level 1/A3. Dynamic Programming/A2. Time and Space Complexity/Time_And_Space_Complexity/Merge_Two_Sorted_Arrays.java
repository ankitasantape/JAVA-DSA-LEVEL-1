package Time_And_Space_Complexity;

import java.util.Scanner;

/*
 1. You are given two sorted arrays(a,b) of integers.
2. You have to merge them and form one sorted array.
3. You have to do it in linear time complexity.
Input Format
An Integer n 
a1
a2..n integers
An integer m
b1
b2..m integers
Sample Input
4
-2 
5 
9 
11
3
4 
6 
8
Sample Output
-2
4
5
6
8
9
11
 */

// Time complexity - O(m + n)
public class Merge_Two_Sorted_Arrays {
	
	public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
		int n = a.length;
		int m = b.length;
		int i = 0, j = 0, k = 0;
		int ans[] = new int[n + m];
		while (i < n && j < m) {
			if (a[i] < b[j]) {
				ans[k] = a[i];
				i++;
				k++;
			} else {
				ans[k] = b[j];
				j++;
				k++;
			}
			
		}
		while (i < n) {
			ans[k] = a[i];
			i++;
			k++;
		}
		while (j < m) {
			ans[k] = b[j];
			j++;
			k++;
		}
		
		return ans;
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scn.nextInt();
		}
		int m = scn.nextInt();
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = scn.nextInt();
		}
		int[] mergedArray = mergeTwoSortedArrays(a, b);
		print(mergedArray);
		scn.close();
	}
}