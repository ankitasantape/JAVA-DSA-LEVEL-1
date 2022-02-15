/*
1. You are given a string containing only 0's and 1's.
2. You have to find the length of substring which is having maximum difference of number of 0s and number of 1s i.e (Number of 0's - Number of 1's).
3. If there are all 1's present in the given string, then print '-1'.
Input Format
A Binary String
Output Format
A number 
Constraints
1 <= length of string <= 10^5
Sample Input
11000010001
Sample Output
6
*/
package Dynamic_Programming;

import java.util.Scanner;

public class A33_Maximum_Difference_Of_Zeroes_And_Ones_In_Binary_String {
   
	public static int solution(String str) {
		int dp[] = new int[str.length()];
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '1') {
				dp[i] = -1;
			}
			else {
				dp[i] = 1;
			}
		}
		int ans = kadanes(dp);
		return ans;
	}
	public static int kadanes(int[] arr) {
		int prev = arr[0];
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			prev = Math.max(prev + arr[i], arr[i]);
			max = Math.max(max, prev);
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String string = scn.next();
		System.out.println(solution(string));
		scn.close();
	}
}
