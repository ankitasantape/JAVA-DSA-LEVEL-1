/*

Link: https://leetcode.com/problems/maximum-product-of-three-numbers/

Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6

*/

package Arrays_And_String;

public class A15_Maximum_Product_Of_Three_Numbers {

    public static int maximumProduct(int[] nums) {
        
    	int max1 = Integer.MIN_VALUE;
    	int max2 = max1;
    	int max3 = max1;
    	
    	int min1 = Integer.MAX_VALUE;
    	int min2 = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < nums.length; i++) {
    		
    		int val = nums[i];
    		
    		// max check
    		if( val >= max1 ) {	
    			max3 = max2;
    			max2 = max1;
    			max1 = val;
    			
    		} else if( val >= max2 ) {
    			max3 = max2;
    			max2 = val;
    		
    		} else if( val >= max3 ) {
    			max3 = val;
    		}
    		
    		// min check
    		if( val <= min1 ) {
    			min2 = min1;
    			min1 = val;
    		
    		} else if( val <= min2 ) {
    			min2 = val;
    		}
    	}
    	
    	// 2. compare
    	return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4}; //  Ans: 24
		
		int prod = maximumProduct(arr);
		
		System.out.println(prod);
	}

}
