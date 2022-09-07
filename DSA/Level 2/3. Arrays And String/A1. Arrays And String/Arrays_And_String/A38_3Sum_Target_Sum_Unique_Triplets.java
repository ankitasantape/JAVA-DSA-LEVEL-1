/*

Leetcode 15 : https://leetcode.com/problems/3sum/

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.



*/

package Arrays_And_String;

import java.util.*;


public class A38_3Sum_Target_Sum_Unique_Triplets {

	public static List<List<Integer>> threeSum(int[] nums, int targ) {
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		
		if ( n < 3 ) {
			return res;
		}
		
		Arrays.sort(nums);
		
		for(int i = 0; i <= n - 3; i++) {
			if( i != 0 && nums[i] == nums[i - 1]) continue;
			
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
		
		int[] arr = {-1,0,1,2,-1,-4};
		int target = 0;
		
		List<List<Integer>> res = threeSum(arr, target);
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
