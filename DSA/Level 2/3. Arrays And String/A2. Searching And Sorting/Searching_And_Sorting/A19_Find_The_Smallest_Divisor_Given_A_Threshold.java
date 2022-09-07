/*
 
Link: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.

Example 1:

Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

Example 2:

Input: nums = [44,22,33,11,1], threshold = 5
Output: 44


*/

package Searching_And_Sorting;

// This question is also similar KOKO_Eating_bananas same concept only wording is different
public class A19_Find_The_Smallest_Divisor_Given_A_Threshold {

    public static int smallestDivisor(int[] nums, int threshold) {
        
    	int max = nums[0];
    	for(int num : nums) {
    		max = Math.max(max, num);
    	}
    	
    	if( threshold == nums.length ) {
    		return max;
    	}
    	
    	int lo = 1;
    	int hi = max;
    	int mdiv = Integer.MAX_VALUE; // minimum divisor
    	
    	while(lo <= hi) {
    		int div = lo + (hi - lo)/2;
    		
    		if( isPossible(nums, div, threshold) == true ) {
    			mdiv = div;
    			// lalach ki wajah se hum try krenge ki agar isase bhi chhota divisor mile 
    			// isiliye hume left me shift krenge search ko
    			hi = div - 1;
    		}
    		else {
    			lo = div + 1;
    		}
    	}
    	
    	return mdiv;
    }
	
	private static boolean isPossible(int[] nums, int div, int threshold) {
		int res = 0;
		
		for(int num : nums) {
			res += (int)Math.ceil(num*1.0/div);
		}
		
		return res <= threshold;
	}

	public static void main(String[] args) {
		
		int[] nums = {1,2,5,9};
	    int threshold = 6; // ans: 5
		
		System.out.println( smallestDivisor(nums, threshold)  );
	}

}
