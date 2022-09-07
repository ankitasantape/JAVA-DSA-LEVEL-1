/*

Leetcode 891 : https://leetcode.com/problems/sum-of-subsequence-widths/#:~:text=Sum%20of%20Subsequence%20Widths%20The%20width%20of%20a,large%2C%20return%20it%20modulo%2010%209%20%2B%207.

The width of a sequence is the difference between the maximum and minimum elements in the sequence.

Given an array of integers nums, return the sum of the widths of all the non-empty subsequences of nums. Since the answer may be very large, return it modulo 109 + 7.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7]. 

Example 1:

Input: nums = [2,1,3]
Output: 6
Explanation: The subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
The sum of these widths is 6.

Example 2:

Input: nums = [2]
Output: 0
 
Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105


*/

package Arrays_And_String;

import java.util.Arrays;

public class A48_Sum_Of_Subsequences_Width {

    public static int sumSubseqWidths(int[] nums) {
        // claim -> sort the arr
    	// one element ek bar a times min ki tarah work krta hai and
    	// same element ek bar b times max ki tarah work krta hai
    	// we have [1, 2, 3, 4] aur hume pata lagana hai ki 2 kitni bar min tarah work krega aur 2 kitani bar max ki tarah work krega
    	// Agar hum 2 pe aaye aur hume 2 ko min ki tarah behave krana hai to jo bhi subsequences aayenge to 2 ko uska start banana padega qki yaha pe next part me usaki badi value
    	
    	Arrays.sort(nums);
    	long lans = 0;
    	long mod = 1000000007;
    	int n = nums.length;
    	long[] pow = new long[n];
    	pow[0] = 1;
    	for(int i = 1; i < n; i++) {
    		pow[i] = (pow[i - 1] * 2) % mod;
    	}
    	for(int i = 0; i < n; i++) {
    		lans = (lans + nums[i] * (pow[i] - pow[n-i-1])) % mod;
    	}
    	
    	return (int)lans;
    }
	
	public static void main(String[] args) {
		
		int[] nums = {2, 1, 3};
		int sum = sumSubseqWidths(nums);
		System.out.println(sum);
		
	}

}
