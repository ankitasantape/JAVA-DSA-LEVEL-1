/*
Leetcode 410: https://leetcode.com/problems/split-array-largest-sum/

Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
Example 2:

Input: nums = [1,2,3,4,5], m = 2
Output: 9
Example 3:

Input: nums = [1,4,4], m = 3
Output: 4

*/ 

package Searching_And_Sorting;

public class A22_Split_Array_Largest_Sum_G1 {

    public static int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        
        for(int val : nums) {
        	sum += val;
        	max = Math.max(max, val);
        }
    	
    	if(m == nums.length) {
    		return max;
    	}
    	
    	int lo = max;
    	int hi = sum;
    	int ans = 0;
    	
    	while(lo <= hi) {
    		int mid = lo + (hi - lo)/2;
    		
    		if( isPossible(nums, mid, m) == true ) {
    			ans = mid;
    			hi = mid - 1;
    		
    		} else {
    			lo = mid + 1;
    		}
    	}
    	
    	return ans;
    }
	
	private static boolean isPossible(int[] nums, int mid, int m) {
		int sa = 1;
		int sum = 0;
		
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			
			if( sum > mid ) {
				sa++;
				sum = nums[i];
			}
		}
		
		return sa <= m;
	}

	public static void main(String[] args) {
		int[] arr = {7,2,5,10,8};
		int m = 2;
		System.out.println( splitArray(arr, m) );
	}

}
