/*

Link: https://leetcode.com/problems/partition-array-into-disjoint-intervals/

Given an integer array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.

Test cases are generated such that partitioning exists.

Example 1:
Input: nums = [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]

Example 2:
Input: nums = [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]
 

*/


package Arrays_And_String;

public class A13_Partition_Array_Into_Disjoint_Intervals {

	// Used Chain Technique
	// S : O(n)
	public static int partitionDisjoint(int[] nums) {
		int rightMin[] = new int[nums.length+1];
		rightMin[nums.length] = Integer.MAX_VALUE;
		
		for(int i = nums.length-1; i >= 0; i--) {
			rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
		}
		
		// 2. Maintain leftmax and figureout the partition index
		
		int leftmax = Integer.MIN_VALUE;
		int ans = 0;
		
		for(int i = 0; i < nums.length; i++) {
			leftmax = Math.max(leftmax, nums[i]);
			if( leftmax < rightMin[i + 1] ) {
				ans = i;
				break;
			}
		}
		
		return ans + 1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,0,6,12}; // Ans: 4
		System.out.println( partitionDisjoint(arr) );
	}

}
