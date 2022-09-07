/*
Leetcode 33 - https://leetcode.com/problems/search-in-rotated-sorted-array/


Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

Part-I

Jab pivot right hand side wale part me aa rha hai that
means low to mid ka array sorted hai
lo----------mid---pi-----hi

Jab pivot left hand side wale part me aa rha hai that 
means mid to high ka array sorted hai
lo---pi-----mid----------hi

You have to take a decision -> which part you want to discard and which one want to keep

*/


package Searching_And_Sorting;

public class A14_Search_In_Rotated_Sorted_Array {

	// T : O(log n)
    public static int search(int[] nums, int target) {
    	int lo = 0;
    	int hi = nums.length-1;
    	
    	while( lo <= hi ) {
    		int mid = (lo + hi)/2;
    		
    		if( nums[mid] == target ) {
    			return mid;
    		
    			// check if low to mid is sorted or not, becoz dono me se koi ek part to pakka sorted hoga
    		} else if( nums[lo] <= nums[mid] ) {
    			// lo to mid part is sorted
    			if( nums[lo] <= target && target < nums[mid] ) {
    		        hi = mid-1;
    			} else {
    			    lo = mid+1;
    			}
    			
    			// check if mid to high is sorted or not, becoz dono me se koi ek part to pakka sorted hoga
    		} else if( nums[mid] <= nums[hi] ){
    			// mid to hi part is sorted 
    			if( nums[mid] < target && target <= nums[hi] ) {
    		        lo = mid+1;
    			} else {
    			    hi = mid-1;
    			}
    		}
    		
    	}
    			
        return -1;
    }
	
	public static void main(String[] args) {
		
		int[] arr = { 4,5,6,7,0,1,2 };
		int tar = 0;
		int ans = search(arr, tar);
		System.out.println(ans);
		
	}

}
