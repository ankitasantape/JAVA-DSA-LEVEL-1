/*

Link: https://leetcode.com/problems/sort-array-by-parity/

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:

Input: nums = [0]
Output: [0]


   segment1            segment2             segment3   
|----------------|-----------------------|----------------|
  (all even no.) |     (all odd no.)     |    unsolved
                 j                       i
                 
 j -> first odd number
 i -> first unsolved number                    


*/


package Arrays_And_String;

public class A16_Sort_Array_By_Parity {

    public static int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
    	
    	int i = 0; // first unsolved
    	int j = 0; // first odd
    	
    	// first condition is free for first element
    	
    	while(i < n) {
    		if( nums[i] % 2 == 0 ) {
    			// even -> swap, i++, j++
    			int temp = nums[i];
    			nums[i] = nums[j];
    			nums[j] = temp;

    			i++;
    			j++;
    		} else {
    			// odd -> i++
    			i++;
    		}
    	}
    	
    	return nums;
    }
	
	public static void main(String[] args) {
		int[] arr = {3,1,2,4};
		
		arr = sortArrayByParity(arr);
		
		for(int num : arr) {
			System.out.print(num + " ");
		}
	}

}
