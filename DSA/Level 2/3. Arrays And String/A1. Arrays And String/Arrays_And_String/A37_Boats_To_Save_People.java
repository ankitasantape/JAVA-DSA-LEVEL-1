/*

Leetcode 881:  https://leetcode.com/problems/boats-to-save-people/

You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)


people : [ 2, 6, 7, 7, 8, 8, 9, 10, 11 ], limit = 14

Optimized Approach:
Step1 -> Sort the array

Step2 -> Make a two pointer Iteration and manage the count.
     

*/

package Arrays_And_String;

import java.util.Arrays;

public class A37_Boats_To_Save_People {

	
    public static int numRescueBoats(int[] people, int limit) {
		int count = 0;
		Arrays.sort(people);
		
		int left = 0;
		int right = people.length-1;
		while(left <= right) {
			int sum = people[left] + people[right];
			if(sum <= limit) {
				count++;
				left++;
				right--;
			} else {
				count++;
				right--;
			}
		}
    	
    	return count;
         
    }
	
	public static void main(String[] args) {
		
		int[] people = { 2, 6, 7, 7, 8, 8, 9, 10, 11};
		int limit = 14; // Ans : 6
		
		int result = numRescueBoats(people, limit);
		System.out.println(result);
	}

}
