/*
Link: https://leetcode.com/problems/product-of-array-except-self/

Given an integer array nums, return an array answer such that 

answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

*/


package Arrays_And_String;

public class A09_Product_Of_Array_Except_Itself {

    public static int[] productExceptSelf(int[] arr) {
         
    	// 1. right product array
    	int[] right = new int[arr.length];
    	int prod = 1;
    	
    	for(int i = arr.length - 1; i >= 0; i--) {
    		prod *= arr[i];
    		right[i] = prod;
    	}
    	
    	// 2. Make result with maintaining of left product
    	
    	prod = 1;
    	int[] res = new int[arr.length];
    	for(int i = 0; i < arr.length-1; i++) {
    		int lp = prod;
    		int rp = right[i + 1];
    		
    		res[i] = lp * rp;
    		
    		// left product will be stored in prod
    		prod *= arr[i];
    	}
    	
    	res[arr.length - 1] = prod;
    	
    	return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		
		int[] res = productExceptSelf(arr);
		
		for(int val : res) {
			System.out.print(val + " ");
		}
		
	}

}
