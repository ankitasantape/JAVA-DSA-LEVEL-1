/*

Leetcode 18 : https://leetcode.com/problems/4sum/

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:
Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

*/

package Arrays_And_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class A39_4Sum_Target_Sum_With_Unique_Quadruple {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
         List<List<Integer>> res = new ArrayList<>();
         int n = nums.length;
         if(n < 4) {
        	 return res;
         }
         
         Arrays.sort(nums);
         
         for(int i = 0; i <= n - 4; i++) {
        	 if( i != 0 && nums[i] == nums[i - 1] ) {
        		 continue;
        	 }
        	 
        	 int val1 = nums[i];
        	 List<List<Integer>> subRes = threeSum(nums, target - val1, i + 1);
        	 
        	 for(List<Integer> list : subRes) {
        		 list.add(val1);
        		 res.add(list);
        	 }
         }
         return res;
    }
	
    public static List<List<Integer>> threeSum(int[] nums, int targ, int si) {
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		
		if ( n - si < 3 ) {
			return res;
		}
		
		Arrays.sort(nums);
		
		for(int i = si; i <= n - 3; i++) {
			if( i != si && nums[i] == nums[i - 1]) continue;
			
			int val1 = nums[i];
			int target = targ - val1;
			List<List<Integer>> subRes = twoSum(nums, i + 1, n-1, target);
			
			/*
			  // target = t - val1
			  { 
			       {2, 7}, {3, 9}, {4, 5}, .. 
			  }
			  
			  // impact of val1 in these pairs, target = t
			
			  { 
			       { 2, 7, val1 }, { 3, 9, val1 }, { 4, 5, val1 }, .. 
			  }
			  
			*/
			
			for(List<Integer> list : subRes) {
				list.add(val1);
				res.add(list);
			}	
		}
		
		return res;
	}
	
	private static List<List<Integer>> twoSum(int[] nums, int si, int ei, int target) {
		List<List<Integer>> res = new ArrayList<>();
		int left = si;
		int right = ei;
		
		while(left < right) {
			if(left != si && nums[left] == nums[left - 1]) { 
				left++;
				continue;
			}
			
			int sum = nums[left] + nums[right];
			
			if(sum == target) {
				List<Integer> subres = new ArrayList<>();
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
		int[] arr = {1,0,-1,0,-2,2};
		int target = 0;
		
		List<List<Integer>> res = fourSum(arr, target);
		ArrayList<String> finalResult = new ArrayList<>();
		
		for (List<Integer> list : res) {
			Collections.sort(list);
			String ans = "";
			for (int val : list) {
				ans += val + " , ";
			}
			finalResult.add(ans);
		}
		Collections.sort(finalResult);
		for (String str : finalResult) {
			System.out.println("[ " + str + " ]");
		}
	}

}
