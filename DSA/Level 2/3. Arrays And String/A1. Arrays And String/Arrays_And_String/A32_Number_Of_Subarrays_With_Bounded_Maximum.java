/*

Leetcode 795: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].

The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:
Input: nums = [2,1,4,3], left = 2, right = 3
Output: 3
Explanation: There are three subarrays that meet the 
requirements: [2], [2, 1], [3].

Example 2:
Input: nums = [2,9,2,5,6], left = 2, right = 8
Output: 7


*/

package Arrays_And_String;

public class A32_Number_Of_Subarrays_With_Bounded_Maximum {
    // T : O(n)
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int si = 0;
        int ei = 0;
        
        int n = nums.length;
        int ans = 0;
        int prevc = 0;
        
        while(ei < n) {
        	// nums[ei] is following this condition means nums[ei] is within a range
        	if(left <= nums[ei] && nums[ei] <= right) {
        		prevc = ei - si + 1;
        		// ans me prev index ka impact de rhe hai
        		ans += prevc;
        	} else if(nums[ei] < left) {
        		ans += prevc;
        	} else {
        		si = ei + 1;
        		prevc = 0;
        	}
        	ei++;
        }
    	return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,1,4,3};
		int left = 2;
		int right = 3; // Ans: 3
		
		System.out.println( numSubarrayBoundedMax(nums, left, right) );
	}

}
