/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

Constraints
1: 1 <= nums.length <= 10^4
2: -10^9 <= nums[i] <= 10^9

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input
3
1
2
1

Sample Output
3
2
-1
2

*/

package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A06_Next_Greater_Element_II {

	public static int[] nextGreaterElementII(int[] nums) {
		int n = nums.length;
		
		// this is the first iteration in this operation we have to just push greater element and pop the smaller element
		Stack<Integer> st  =new Stack<>();
		
		for(int i = n-2; i >= 0; i--) {
			while(st.size() != 0 && st.peek() <= nums[i] ){
				st.pop();
			} 	
			st.push(nums[i]);
		}
		
		int[] nge = new int[n];
		for(int i = n-1; i >= 0; i--) {
			while(st.size() != 0 && st.peek() <= nums[i] ){
				st.pop();
			} 
			if( st.size() == 0 ) {
				nge[i] = -1;
			} else {
				nge[i] = st.peek();
			}
			st.push(nums[i]);
		}
		return nge;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(read.readLine());
		}

		int ans[] = nextGreaterElementII(nums);

		n = ans.length;

		System.out.println(n);
		for (int e : ans) {
			System.out.println(e);
		}
	}
}
