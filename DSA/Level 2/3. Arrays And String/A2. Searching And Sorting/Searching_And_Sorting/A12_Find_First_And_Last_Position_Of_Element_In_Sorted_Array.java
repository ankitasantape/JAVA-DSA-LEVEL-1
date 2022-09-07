// Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


*/

package Searching_And_Sorting;

public class A12_Find_First_And_Last_Position_Of_Element_In_Sorted_Array {

    public static int[] searchRange(int[] nums, int target) {
         int[] res = new int[2];
         res[0] = firstPosition(nums, target);
         res[1] = lastPosition(nums, target);
         return res;
    }
    
    private static int lastPosition(int[] nums, int target) {
		int lastpos = -1;
		int lo = 0;
		int hi = nums.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;

			if (nums[mid] == target) {
				lastpos = mid;
				 // after getting lastIndex still we want to continue our search in the right part array
   			    // becoz our target's last position lie on right side of an array 
   			
				lo = mid + 1;

			} else if (target < nums[mid]) {
				hi = mid - 1;

			} else {
				lo = mid + 1;
			}
		}
		return lastpos;
	}

	public static int firstPosition(int[] nums, int target) {
    	 int firstpos = -1;
    	 int lo = 0;
    	 int hi = nums.length-1;
    	 
    	 while(lo <= hi) {
    		 int mid = (lo + hi)/2;
    		 
    		 if( nums[mid] == target ) {
    			 firstpos = mid;
    			  // after getting firstIndex still we want to continue our search in the left part array
    			 // becoz our target's first position lie on left side of an array 
    			 hi = mid-1;
    		
    		 } else if( target < nums[mid] ) {
    			 hi = mid-1;
    		 
    		 } else {
    			 lo = mid+1;
    		 } 
    	 }
    	 return firstpos;
    }
	
	public static void main(String[] args) {
//		int[] arr = {5,7,7,8,8,10};
//		int tar = 8; // 3, 4
		
		int[] arr = {5,7,7,8,8,10};
		int tar = 6; // -1, -1
		
		int[] res = searchRange(arr, tar);
		for(int num : res) {
			System.out.println(num);
		}
	}

}
