/*
Link: https://practice.geeksforgeeks.org/problems/distinct-absolute-array-elements4529/1

Given a sorted array of size N. Count the number of distinct absolute values present in the array.
 

Example 1:

Input:
N = 6
Arr[] = {-3, -2, 0, 3, 4, 5}
Output: 5
Explanation: There are 5 distinct absolute 
values i.e. 0, 2, 3, 4 and 5.

Example 2:

Input:
N = 9
Arr[] = {-1, -1, -1, -1, 0, 1, 1, 1, 1}
Output: 2
Explanation: There are 2 distinct absolute values 
among the elements of this array, i.e. 0 and 1.

Example 3:

Input:
N = 6
Arr[] = {-3, -3, -2, -1, 1, 3, 4, 5, 5}
Output: 5
Explanation: 
There are 7 distinct values
Distinct: -3, -2, -1, 1, 3, 4, 5

There are 5 distinct absolute 
values i.e.
Distinct absolute: 3, 2, 1, 4, 5

Your Task:
You don't need to read input or print anything. Your task is to complete the function distinctCount() which takes the array of integers arr[] and its size n as input parameters and returns an integer denoting the answer.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


*/

package Searching_And_Sorting;

import java.util.Arrays;

public class A30_Distinct_Absolute_Array_Elements {

	public static int distinctAbsoluteArrayElements(int[] arr) {
		 Arrays.sort(arr);
		 
		int prev = Integer.MIN_VALUE;
		int next = Integer.MAX_VALUE;
		
		int count = 0;
		
		int i = 0;
		int j = arr.length-1;
		
		while( i <= j ) {
			int absVali = Math.abs(arr[i]);
			int absValj = Math.abs(arr[j]);
			
			if( absVali == absValj ) {
				if( prev != next ) {
					count++;
				}
				prev = arr[i];
				next = arr[j];
				i++;
				j--;
				
			} else if( absVali < absValj ) {
				if (arr[j] != next) {
					// count increment krenge
					count++;
				}
				// next me value dalenge
				next = arr[j];
				j--;
			
			} else {
				if (arr[i] != prev) {
					// count increment krenge
					count++;
				}
				// prev me value dalenge
				prev = arr[i];
				i++;
			}
			
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int arr[] = {-3, -2, 0, 3, 4, 5}; // Ans: 5
		
		System.out.println( distinctAbsoluteArrayElements(arr) );
		
	}

}
