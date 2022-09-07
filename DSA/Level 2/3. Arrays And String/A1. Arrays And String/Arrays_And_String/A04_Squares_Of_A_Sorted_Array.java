/*
https://leetcode.com/problems/squares-of-a-sorted-array/

Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

*/

package Arrays_And_String;

public class A04_Squares_Of_A_Sorted_Array {

	// T : O(n)
    public static int[] sortedSquares(int[] nums) {
    	int n = nums.length;
        int i = 0;
        int j = nums.length-1;
        int idx = nums.length-1;
        
        int[] res = new int[n];
        
        while( i < j ) {
        	int val1 = nums[i]*nums[i];
        	int val2 = nums[j]*nums[j];
        	
        	if( val1 > val2 ) {
        		res[idx] = val1;
        		i++;
        	
        	} else {
        		res[idx] = val2;
        		j--;
        	}
        	idx--;
        }
    	
        return res;
    	
    }
	
	public static void main(String[] args) {
		
		int[] arr = {-4,-1,0,3,10};
		
		int[] res = sortedSquares(arr);
		
		for(int val : res) {
			System.out.print(val + " ");
		}
		
	}

}
