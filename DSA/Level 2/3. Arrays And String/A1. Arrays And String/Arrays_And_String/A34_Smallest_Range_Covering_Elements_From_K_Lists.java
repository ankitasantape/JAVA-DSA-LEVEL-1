/*

Leetcode 632: https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/

You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.

We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

Example 1:
Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
Output: [20,24]
Explanation: 
List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
List 2: [0, 9, 12, 20], 20 is in range [20,24].
List 3: [5, 18, 22, 30], 22 is in range [20,24].

Example 2:
Input: nums = [[1,2,3],[1,2,3],[1,2,3]]
Output: [1,1]

*/

package Arrays_And_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class A34_Smallest_Range_Covering_Elements_From_K_Lists {

    public static int[] smallestRange(List<List<Integer>> nums) {
		
    	int[] res = {-100000, 100000};
    	int k = nums.size();
    	int max = Integer.MIN_VALUE;
    	PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
    	
    	for(int i = 0; i < k; i++) {
    		int mol = nums.get(i).get(0);
    		int[] tba = {mol, 0, i}; // to be 
    		// 0th - minimum element of the list
    		// 1th - index of element from the list
    		// 2nd - index of list in nums
    		max = Math.max(max, mol);
    		pq.add(tba);
    	}
    	
    	while(true) {
    		int[] min = pq.poll();
    		if(res[1] - res[0] > max-min[0]) {
    			res[0] = min[0];
    			res[1] = max;
    		}
    		min[1]++;
    		List<Integer> cl = nums.get(min[2]);
    		if( min[1] == cl.size() ) {
    			break;
    		} else {
    			min[0] = cl.get(min[1]);
    			max = Math.max(max, cl.get(min[1]));
    			pq.add(min);
    		}
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		
		List<List<Integer>> list = new ArrayList<>();
		list.add( Arrays.asList(4,10,15,24,26) );	
		list.add( Arrays.asList(0,9,12,20));
		list.add(Arrays.asList(5,18,22,30));		                   
				                    
		int[] nums = smallestRange(list);
		
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}

}
