/*
1. You are given an array that contains only 0s, 1s, and 2s.
2. You have to find length of the longest subarray with equal number of 0s, 1s, and 2s.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing length of the longest subarray with equal number of 0s, 1s, and 2s.
Constraints
1 <= N <= 10^5
0 <= arr[i] <= 2
Sample Input
7
0 1 0 2 0 1 0
Sample Output
3

*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A13_Longest_Subarray_With_EqualNumber_Of_0s_1s_And_2s {

	public static int solution(int[] arr) {
		HashMap<String, Integer> map = new HashMap<>(); //(c0-c1)@(c1-c2) vs first index
		int c0 = 0;
		int c1 = 0;
		int c2 = 0;
		map.put("0@0", -1);
		int maxLength = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) {
				c0++;
			}
			else if(arr[i] == 1) {
				c1++;
			}
			else {
				c2++;
			}
			String state = (c0-c1) + "@" + (c1-c2);
			if(map.containsKey(state) == true) {
				int len = i - map.get(state);
				maxLength = Math.max(maxLength, len);
			} else {
				map.put(state, i);
			}
		}
		return maxLength;
    }
    
  
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
