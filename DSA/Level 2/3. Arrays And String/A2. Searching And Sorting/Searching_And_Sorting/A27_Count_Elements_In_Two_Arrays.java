/*

Link: https://practice.geeksforgeeks.org/problems/counting-elements-in-two-arrays/1

Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].

Example 1:

Input:
m = 6, n = 6
arr1[] = {1,2,3,4,7,9}
arr2[] = {0,1,2,1,1,4}
Output: 4 5 5 6 6 6
Explanation: Number of elements less than
or equal to 1, 2, 3, 4, 7, and 9 in the
second array are respectively 4,5,5,6,6,6
Example 2:

Input:
m = 5, n = 7
arr1[] = {4 8 7 5 1}
arr2[] = {4,48,3,0,1,1,5}
Output: 5 6 6 6 3
Your Task :
Complete the function countEleLessThanOrEqual() that takes two array arr1[], arr2[],  m, and n as input and returns an array containing the required results(the count of elements less than or equal to it in arr2 for each element in arr1 where ith output represents the count for ith element in arr1.)

Expected Time Complexity: O((m + n) * log n).
Expected Auxiliary Space: O(1).


*/


package Searching_And_Sorting;

import java.util.Arrays;

public class A27_Count_Elements_In_Two_Arrays {

	// T : O(n * log m)
	private static int[] find(int[] arr1, int[] arr2) {
		
		Arrays.sort(arr2);
		int[] ans = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++) {
			int key = arr1[i];
			
			// We need to optimize this helper O(log n) to O(1) time
			// count of elements those are less than or equal to key
			int cs = helper(key, arr1);
			// store that count ans array
			ans[i] = cs;
		}
		
		return ans;
	}
	
	// T : O(log n)
	private static int helper(int key, int[] arr) {
		// to find count of elements which are <= key
		int count = 0;
		
		int lo = 0;
		int hi = arr.length-1;
		
		while(lo <= hi) {
			int mid = (lo + hi)/2;
			
			if(arr[mid] <= key) {
				count += (mid-lo+1);
				lo = mid+1;
			}
			else {
				hi = mid-1;
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		int arr1[] = {1,2,3,4,7,9};
		int arr2[] = {0,1,2,1,1,4};
		
		int[]ans = find(arr1, arr2);
		
		for(int val : ans) {
			System.out.print(val + " ");
		}
	}

}
