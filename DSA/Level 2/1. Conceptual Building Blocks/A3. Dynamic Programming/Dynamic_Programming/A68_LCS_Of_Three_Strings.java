/*
1. You are given three strings s1, s2 and s3.
2. You have to find the longest common sub-sequence in the given strings.
Input Format
3 Strings s1, s2 and s3.
Constraints
1 < length of strings <= 100
Sample Input
pepforpepcoders
pepcoding
opepper
Sample Output
3
*/

package Dynamic_Programming;

import java.util.Scanner;

public class A68_LCS_Of_Three_Strings {
    
	public static void solution(String str1, String str2, String str3) {
		int n1 = str1.length();
		int n2 = str2.length();
		int n3 = str3.length();
		int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];
		for(int i = 0; i <= n1; i++) {
			for(int j = 0; j <= n2; j++) {
				for(int k = 0; k <= n3; k++) {
					if(i == 0 || j == 0 || k == 0) {
						dp[i][j][k] = 0;
					} else if(str1.charAt(i-1) == str2.charAt(j-1) && 
							str1.charAt(i-1) == str3.charAt(k-1)) {
						 dp[i][j][k] = dp[i-1][j-1][k-1] + 1; 
					} else {
						dp[i][j][k] = Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k], dp[i][j][k-1]));
					}
				}
			}
		}
		System.out.println(dp[n1][n2][n3]);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str1 = scn.next();
		String str2 = scn.next();
		String str3 = scn.next();
		solution(str1,str2,str3);
		scn.close();
	}

}
