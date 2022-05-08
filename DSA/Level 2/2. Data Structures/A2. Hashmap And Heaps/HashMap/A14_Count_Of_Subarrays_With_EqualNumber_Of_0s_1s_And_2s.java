/*
1. You are given an array that contains only 0s, 1s, and 2s.
2. You have to find the count of subarrays with equal number of 0s, 1s, and 2s.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing count of subarrays with an equal number of 0s, 1s, and 2s.
Constraints
A number representing the count of subarrays with equal number of 0s, 1s, and 2s.
Sample Input
7
0 1 0 2 0 1 0
Sample Output
2

*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A14_Count_Of_Subarrays_With_EqualNumber_Of_0s_1s_And_2s {

	public static int solution(int[] arr) {
		HashMap<String, Integer> map = new HashMap<>(); //(c0-c1)@(c1-c2) vs first index
		int c0 = 0;
		int c1 = 0;
		int c2 = 0;
		map.put("0@0", 1);  // (c1 - c0) "@" (c2 - c1)
		int maxCount = 0;
		
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
				int count =  map.get(state);
				maxCount += count;
				map.put(state, count + 1);
			}  else {
				map.put(state, 1);
			}
			
		}
		return maxCount;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
		scn.close();
	}

}
