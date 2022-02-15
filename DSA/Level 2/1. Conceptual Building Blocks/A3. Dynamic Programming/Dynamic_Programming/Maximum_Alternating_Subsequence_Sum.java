/*
The alternating sum of a 0-indexed array is defined as the sum of the elements at even indices minus the sum of the elements at odd indices.

For example, the alternating sum of [4,2,5,3] is (4 + 5) - (2 + 3) = 4.
Given an array nums, return the maximum alternating sum of any subsequence of nums (after reindexing the elements of the subsequence).

A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the remaining elements' relative order. For example, [2,7,4] is a subsequence of [4,2,3,7,2,1,4] (the underlined elements), while [2,4,2] is not.

Example 1:

Input: nums = [4,2,5,3]
Output: 7
Explanation: It is optimal to choose the subsequence [4,2,5] with alternating sum (4 + 5) - 2 = 7.
Example 2:

Input: nums = [5,6,7,8]
Output: 8
Explanation: It is optimal to choose the subsequence [8] with alternating sum 8.
Example 3:

Input: nums = [6,2,1,2,4,5]
Output: 10
Explanation: It is optimal to choose the subsequence [6,1,5] with alternating sum (6 + 5) - 1 = 10.
 
Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105

*/

package Dynamic_Programming;

import java.util.*;

public class Maximum_Alternating_Subsequence_Sum {
    
    public static long maxAlternatingSum(int[] nums) {
        long[][] memo = new long[nums.length][2];
        for (long[] e : memo) {
        	Arrays.fill(e, -1);
        }
    	return rec(nums, 0, 0, memo);
    }
    
    private static long tab(int[] nums) {
    	int n = nums.length;
		long[] endEven = new long[n];
		long[] endOdd = new long[n];
		endEven[0] = (long)nums[0];
		for (int i = 1; i < n; i++) {
			// ab tak ke max subsequences me jo odd pe khatam ho rahe usame current element add krenge which is at odd position
			endEven[i] = Math.max(endEven[i-1], endOdd[i-1] + (long)nums[i]);
			// ab tak ke max subsequences me jo even pe khatam ho rahe usame se current element remove kr denge which is at odd position
			endOdd[i] = Math.max(endOdd[i-1], endEven[i-1] - (long)nums[i]);
		}
		return Math.max(endEven[n-1], endOdd[n-1]);
	}

	private static long rec(int[] nums, int idx, int p, long[][] memo) {
		if(idx >= nums.length) {
			return 0;
		}
		
		if(memo[idx][p] != -1) {
			return memo[idx][p];
		}
		
		long ans = 0;
		// choose element
		if(p == 0) {
			ans = rec(nums, idx + 1, 1, memo) + nums[idx];
		} else {
			ans = rec(nums, idx + 1, 0, memo) - nums[idx];
		}
		ans = Math.max(ans, rec(nums, idx + 1, p, memo));
		memo[idx][p] = ans;
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] =sc.nextInt();
		}
		System.out.println( maxAlternatingSum(arr) );
		System.out.println( tab(arr) );
		System.out.println( tab_O1(arr) );
		sc.close();
	}

	private static long tab_O1(int[] nums) {
		int n = nums.length;
		long endEven = 0;
		long endOdd = 0;
		endEven = (long)nums[0];
		for (int i = 1; i < n; i++) {
			long curr = (long)nums[i];
			// ab tak ke max subsequences me jo odd pe khatam ho rahe usame current element add krenge which is at odd position
			endEven = Math.max(endEven, endOdd + curr);
			// ab tak ke max subsequences me jo even pe khatam ho rahe usame se current element remove kr denge which is at odd position
			endOdd = Math.max(endOdd, endEven - curr);
		}
		return Math.max(endEven, endOdd);
	}
}
