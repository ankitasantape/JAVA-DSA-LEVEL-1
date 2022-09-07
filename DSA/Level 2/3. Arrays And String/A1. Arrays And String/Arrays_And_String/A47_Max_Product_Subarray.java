/*
Leetcode 152: https://leetcode.com/problems/maximum-product-subarray/

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 
Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

*/


package Arrays_And_String;

public class A47_Max_Product_Subarray {

    public static int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int cprod = 1;
        for(int i = 0; i < nums.length; i++) {
        	cprod *= nums[i];
        	ans = Math.max(ans, cprod);
        	// cprod 0 means currVal zero
        	if(cprod == 0) {
        		cprod = 1;
        	}
        }
        
        cprod = 1;
        for(int i = nums.length-1; i >= 0; i--) {
        	cprod *= nums[i];
        	ans = Math.max(ans, cprod);
        	if(cprod == 0) {
        		cprod = 1;
        	}
        }
        
        return ans;
    }
	
	public static void main(String[] args) {
		
		int[] nums = {2, 3, -2, 4};
		int largestProd = maxProduct(nums);
		System.out.println(largestProd);
	}

}
