/*
https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/

Consider an array arr of distinct numbers sorted in increasing order. 
Given that this array has been rotated (clockwise) k number of times. 
Given such an array, find the value of k.

Input: arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation: Initial array must be {2, 3, 6, 12, 15, 18}. We get the given array after rotating the initial array twice.

Input: arr[] = {7, 9, 11, 12, 5}
Output: 4

Input: arr[] = {7, 9, 11, 12, 15};
Output: 0


Approach: 
Divide this array in two part: part-I & part-II
Let's see this array
                        |
          4  5  6  7  8 | 0  1  2
          0  1  2  3  4 | 5  6  7
                        | this idx -> 5 will be the ans for k
                          this 5 means the 5 elements on left side and that is the value of k

Constraints: k will always be smaller than length of array

*/

package Searching_And_Sorting;

public class A16_Find_Rotation_Count {

	// T : O(log n)
	public static int countRotations(int[] arr) {
		
		int lo = 0;
		int hi = arr.length-1;
		
		
		if( arr[lo] <= arr[hi] ) {
			// array is not rotated at all
			return 0;
		}
		
		while( lo <= hi ) {
			int mid = (lo + hi)/2;
			
			if( arr[mid] > arr[mid+1] ) {
				return mid+1;
			}
			else if( arr[mid-1] > arr[mid] ) {
				return mid;
			}
			// if it is already sorted then discard
			else if( arr[lo] <= arr[mid]  ) {
				lo = mid+1;
			} 
			else if( arr[mid] <= arr[hi] ) {
				hi = mid-1;
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		// int arr[] = {15, 18, 2, 3, 6, 12}; // ans: 2
		
		int[] arr = {4, 5, 6, 7, 8, 0, 1, 2}; // ans: 5
		
		System.out.println( countRotations(arr) );
	}

}
