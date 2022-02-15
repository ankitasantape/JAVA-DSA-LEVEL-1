/*
1. You are given two strings S1 and S2.
2. You are required to print the length of the longest common substring of two strings.
Input Format
2 strings S1 and S2
Output Format
A number representing the length of longest common substring of two strings.

Constraints
1 < length of strings S1 and S2 <= 200
Sample Input
abcdgh
acdghr
Sample Output
4
*/
package Dynamic_Programming;

import java.util.Scanner;

public class A46_Longest_Common_Substring {
    
	public static int solution(String s1, String s2){
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1) ) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} 
				
				if(dp[i][j] > max) {
					max = dp[i][j];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
		scn.close();
	}
}
