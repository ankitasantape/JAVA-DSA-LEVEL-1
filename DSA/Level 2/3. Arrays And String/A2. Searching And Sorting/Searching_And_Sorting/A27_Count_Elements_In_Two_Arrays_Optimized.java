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

public class A27_Count_Elements_In_Two_Arrays_Optimized {

	// T : O(n * log m)
	private static int[] find(int[] arr1, int[] arr2) {

		int max1 = 0;
		int max2 = 0;
		
		for(int val : arr1) {
			max1 = Math.max(max1, val);
		}
		
		for(int val : arr2) {
			max2 = Math.max(max2, val);
		}
		
		int omax = Math.max(max1, max2);
		
		// pre-processing
		int[] farr = new int[100000];

		for(int i = 0; i < arr2.length; i++) {
			
			farr[arr2[i]]++;
		}
		
		int[] psa = new int[farr.length];
		psa[0] = farr[0];
		
		for(int i = 1; i <= omax; i++) {
			psa[i] = psa[i-1] + farr[i];
		}
		
		int[] ans = new int[arr1.length];
		
		for(int i = 0; i < arr1.length; i++) {
			int key = arr1[i];
			ans[i] = psa[key]; // In O(1) we'll get the count of elements less than or equal to key 
		}
		
		return ans;
	}

	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 7, 9 };
		int arr2[] = { 0, 1, 2, 1, 1, 4 }; // ans: 4 5 5 6 6 6

		int[] ans = find(arr1, arr2);

		for (int val : ans) {
			System.out.print(val + " ");
		}
	}

}
