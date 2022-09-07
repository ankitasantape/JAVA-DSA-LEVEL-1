/*
Leetcode 41: https://leetcode.com/problems/first-missing-positive/

Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

Example 1:
Input: nums = [1,2,0]
Output: 3

Example 2:
Input: nums = [3,4,-1,1]
Output: 2

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1


Approach 3:

 * Mark elements which are out of Range and manage presence of '1'
   Mark -> 1 and presence 
   boolean one = false/true
   
 * Map the Elements with Index. Cuurently all the elements are in Range.
  
    
 Range
 |
  ----> length => n
  1 <= element <= n
   /              \
 If any number     all present then
 is absent then    n+1 is answer
 that is answer



*/


package Arrays_And_String;

public class A41_First_Missing_Positive {

	// T : O(3n) -> O(n)
    public static int firstMissingPositive(int[] nums) {
    	// step 1. Mark elements which are out of Range and manage presence of '1'
    	boolean one = false;
    	int n = nums.length;
    	for(int i = 0; i < nums.length; i++) {
    		if( nums[i] == 1 ) {
    			one = true;	
    		}
    		
    		if( nums[i] < 1 || n < nums[i] ) {
    			nums[i] = 1;
    		}
    	}
    	
    	if( one == false ) {
    		// one == false means we didn't get one
    		return 1;
    	}
    	// step 2. Map elements with index
    	for(int i = 0; i < n; i++) {
    		int indx = Math.abs(nums[i]);
    		nums[indx - 1] = -Math.abs(nums[indx - 1]);
    	}
    	
    	// step 3. Find out missing integer
    	for(int i = 0; i < n; i++) {
    		// element is +ve that means (indx + 1) is missing from array
    		if( nums[i] < 0 ) {
    			return i + 1;
    		}
    	}
        
        return n + 1;
        
    }
	
	public static void main(String[] args) {
		
		int[] arr = {7,8,9,11,12};
		
		int ans = firstMissingPositive(arr);
		System.out.println(ans);
	}

}
