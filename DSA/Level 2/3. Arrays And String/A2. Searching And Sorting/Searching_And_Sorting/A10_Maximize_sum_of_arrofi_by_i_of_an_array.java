/*
GFG: https://www.geeksforgeeks.org/maximize-sum-arrii/

Given an array of N integers. You are allowed to rearrange the elements of the array. The task is to find the maximum value of Σarr[i]*i, where i = 0, 1, 2,…., n – 1.

Examples:  

Input : N = 4, arr[] = { 3, 5, 6, 1 }
Output : 31
If we arrange arr[] as { 1, 3, 5, 6 }. 
Sum of arr[i]*i is 1*0 + 3*1 + 5*2 + 6*3 
= 31, which is maximum

Input : N = 2, arr[] = { 19, 20 }
Output : 20

*/

package Searching_And_Sorting;

import java.util.Arrays;

public class A10_Maximize_sum_of_arrofi_by_i_of_an_array {

	// T : O(n Log n)
	private static int maximize(int[] arr) {
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += (arr[i] * i);
		}
		
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = {3, 5, 6, 1}; // output: 31
		
		int ans = maximize(arr);
		System.out.println(ans);
	}
}
