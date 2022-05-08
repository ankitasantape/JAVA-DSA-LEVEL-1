/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 
Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109

*/

package Stack;

import java.util.Stack;

public class A17_132_Pattern {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		System.out.println( find132pattern(arr) );
	}
    
    public static boolean find132pattern(int[] nums) {
    	int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        for(int i = 1; i < n; i++) {
        	min[i] = Math.min(min[i-1], nums[i]);
        }
        Stack<Integer> st = new Stack<>();
        boolean found = false;
        for(int j = n-1; j >= 0; j--) {
        	
        	while(st.size() != 0 && min[j] >= st.peek() ) {
        		st.pop();
        	}
        	if( st.size() != 0 && st.peek() < nums[j] ) {
        		found = true;
        		break;
        	}
        	st.push(nums[j]);
        }
        return found;
    }
}
