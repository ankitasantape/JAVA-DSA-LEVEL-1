/*

Link: https://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-array/

Given a sorted array in which all elements appear twice (one after one) and one element appears only once. Find that element in O(log n) complexity.

Example: 

Input:   arr[] = {1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8}
Output:  4

Input:   arr[] = {1, 1, 3, 3, 4, 4, 5, 5, 7, 7, 8}
Output:  8


*/


package Searching_And_Sorting;

public class A34_Find_The_Element_That_Appears_Once_In_Sorted_Array {

	public static int findSingleElement(int arr[]) {
		
		int n = arr.length;
		
		if(n == 1) {
			return arr[0];
		}
		
		if(arr[0] != arr[1]) {
			return arr[0];
		}
		
		if(arr[n-1] != arr[n-2]) {
			return arr[n-1];
		}
		
		int lo = 0;
		int hi = arr.length-1;
		
		while(lo <= hi) {
			int mid = lo + (hi - lo)/2;
			
			if( arr[mid - 1] != arr[mid] && arr[mid] == arr[mid + 1]  ) {
				
			}
			else if( arr[mid - 1] == arr[mid] ) {
				// low to mid elements count
				int lc = mid - lo + 1;
				
				// if even count is there then
				// you are not going to get anything from low to mid
				// just start your searching on right side onwards
				if( lc % 2 == 0 ) {
					lo = mid + 1;
				}
				
			}
			else if( arr[mid] == arr[mid + 1] ) {
				
			}
		}
		return -1;
    }
	
	public static void main(String[] args) {
		
		int[] arr = { 1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8 };
		findSingleElement(arr);
		
	}

}
