/*

Link: https://leetcode.com/problems/next-greater-element-iii/

Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. 
If no such positive integer exists, return -1.
Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.

Example 1:
Input: n = 12
Output: 21

Example 2:
Input: n = 21
Output: -1

*/

package Arrays_And_String;

public class A08_Next_Greater_Element_III {

	public static String nextGreaterElement(String str) {
		
		char[] arr = str.toCharArray();
		
		// 1. find first dip
		int i = arr.length - 2; // i = 2
		// decreasing elements
		// 1234
		while(i >= 0 && arr[i] >= arr[i+1]) {
			i--;
		}
		
		if(i == -1) {
			return "-1";
		}
		
		// 2. find just next greater than ith index element
		int k = arr.length - 1; // k = 3
		while(arr[i] >= arr[k]) {
			k--;
		}
		
		// 3. swap ith and kth element
		char temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;	
		// 1234 after swapping -> 1243
		
		// 4. concatenate from 0 to i index
		String res = "";
		for(int j = 0; j <= i; j++) {
			res += arr[j];
		}
		
		// 5. concatenate from (right to left) k to i + 1 index (in reverse order)
		for(int j = arr.length - 1; j > i; j--) {
			res += arr[j];
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println( nextGreaterElement("1234") ); // 1243
		
	}

}
