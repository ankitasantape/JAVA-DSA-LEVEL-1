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
 
Example 3:
Input: nums = [7,3,9,5,10,1,15,16,19,14,30]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]
 
 
 

*/

package Arrays_And_String;

public class A13_Partition_Array_Into_Disjoint_Intervals_With_Optimized_Space {

 
	// Used Chain Technique
	// S : O(1)
	public static int partitionDisjoint(int[] nums) {
	      int leftmax = nums[0];
	      int greater = nums[0];
	      int ans = 0;
	      
	      for(int i = 1; i < nums.length; i++) {
	    	  if( nums[i] > greater ) {
	    		  greater = nums[i];
	    	  
	    	  } else if( nums[i] < leftmax ) {
	    		  leftmax = greater;
	    		  ans = i;
	    	  }
	      }
	      
	      return ans + 1;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,1,0,6,12}; // Ans: 4
		System.out.println( partitionDisjoint(arr) );
	}
}
