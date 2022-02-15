/*
1. You are given a string str1.
2. You are given another string str2.
3. You are required to print the length of longest common subsequence of two strings.
Input Format
A string str1
A string str2
Output Format
A number representing the length of longest common subsequence of two strings.

Constraints
0 <= str1.length <= 10
0 <= str2.length <= 10
Sample Input
abcd
aebd
Sample Output
3

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A43_Longest_Common_Subsequence {
     
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.nextLine();
		String s2 = scn.nextLine();
		
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = dp.length-2; i >= 0; i--) {
			for (int j = dp[0].length-2; j >= 0; j--) {
				char c1 = s1.charAt(i);
				char c2 = s2.charAt(j);
				
				if(c1 == c2) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		System.out.println(dp[0][0]);
		scn.close();
    }

}
