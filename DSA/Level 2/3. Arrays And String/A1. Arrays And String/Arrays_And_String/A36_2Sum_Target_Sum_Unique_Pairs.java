/*

Leetcode 1 : https://leetcode.com/problems/two-sum/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

*/

package Arrays_And_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A36_2Sum_Target_Sum_Unique_Pairs {

    public static List<List<Integer>> twoSum(int[] nums, int target) {
        
    	List<List<Integer>> res = new ArrayList<>();
    	int left = 0;
    	int right = nums.length-1;
    	Arrays.sort(nums);
    	
    	while(left < right) {
    		
    		if(left != 0 && nums[left] == nums[left - 1]) {
    			left++;
    			continue;
    		}
    		
    		int sum = nums[left] + nums[right];
    		
    		if(sum == target) {
    			List<Integer> subres = new ArrayList<>();
    			// pair found
    			subres.add(nums[left]);
    			subres.add(nums[right]);
    			
    			res.add(subres);
    			left++;
    			right--;
    		} else if(sum > target) {
    			right--;
    		} else {
    			left++;
    		}
    	}
    	
    	return res;
    }
	
	public static void main(String[] args) {
		
		int[] arr = {2, 2, 4, 3, 1, 6, 6, 7, 5, 9, 1, 8, 9};
		int tar = 10;
		
		List<List<Integer>> res = twoSum(arr, tar);
		for(List<Integer> list : res) {
			System.out.println("[ " + list.get(0) + " , " + list.get(1) + " ]");
		}
		/*
		    1, 9 -> 10
		    2, 8 -> 10
		    3, 7 -> 10
		    4, 6 -> 10
		
		 */
	}

}
