/*
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 
Constraints:

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 104
All integers in nums1 and nums2 are unique.
All the integers of nums1 also appear in nums2.

*/
package Stack;

import java.util.HashMap;
import java.util.Stack;

public class A05_Next_Greater_Element_I {

	public static void main(String[] args) {
		int[] nums = {1, 3, 4, 2};
		int[] query = {4, 1, 2};
		int[] ans = nextGreaterElement(query, nums);
		for(int nge : ans) {
			System.out.print(nge);
		}
		
	}
	public static int[] nextGreaterElement(int[] query, int[] nums) {
		int nge[] = nextGreaterElementToRight(nums);
		HashMap<Integer, Integer> map = new HashMap<>();
		// nums -> key, nge -> value
		
		for (int i=0; i < nums.length; i++) {
			map.put(nums[i], nge[i]);
		}
		int[] ans = new int[query.length]; 
		for(int i = 0; i < query.length; i++) {
			ans[i] = map.get(query[i]);
		}
		return ans;
	}

	private static int[] nextGreaterElementToRight(int[] arr) {
		int n = arr.length;
		int[] nge = new int[n];
		Stack<Integer> st = new Stack<>();
		nge[n-1] = -1;
		st.push(arr[n-1]);
		for(int i = n-2; i >= 0; i--) {
			while(st.size() != 0 && st.peek() <= arr[i] ) {
				st.pop();
			}
		    if( st.size() == 0 ) {
		    	nge[i] = -1;
		    } else {
		    	nge[i] = st.peek();
		    }
		    st.push(arr[i]); 		
		}
		return nge;
	}
}
