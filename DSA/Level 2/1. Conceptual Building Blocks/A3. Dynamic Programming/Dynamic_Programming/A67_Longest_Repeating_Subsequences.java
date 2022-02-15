/*
1. You are given a string str.
2. You have to find the length of longest subsequence which is appearing twice in the string.
3. Every ith character in both the subsequences must have different indices in the original string.
Input Format
A string str
Output Format
A number representing the length of longest repeating subsequence.

Constraints
1 < length of strings str <= 2000
Sample Input
abcdgh
Sample Output
0

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A67_Longest_Repeating_Subsequences {
	
	public static int solution(String str){
		int[][] dp = new int[str.length() + 1][str.length() + 1];
		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = dp[0].length - 2; j >= 0; j--) {
				if( i != j && str.charAt(i) == str.charAt(j) ) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
		scn.close();
	}
}
