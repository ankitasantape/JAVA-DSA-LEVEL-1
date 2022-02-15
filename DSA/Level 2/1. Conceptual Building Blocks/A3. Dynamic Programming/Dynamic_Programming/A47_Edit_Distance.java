/*
1. You are given two strings s1 and s2.
2. You have to find the minimum number of operations needed to convert s1 to s2.
   Operations allowed are - 
   Insert - You can insert any character in s1.
   Remove - You can remove any character in s1.
   Replace - You can replace any character in s1 with any other character.
Input Format
Two strings s1 and s2
Output Format

Constraints
1 <= length of s1,s2 <= 100
Sample Input
pepperatcoding
pepcoding
Sample Output
5

Sample Input
hellobye
abcdefgh
Sample Output
8

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A47_Edit_Distance {
   
    public static int solution(String str1, String str2) {
		
    	int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    	for (int i = 0; i < dp.length; i++) {
    		for (int j = 0; j < dp[0].length; j++) {
    			if(i == 0 && j == 0) {
    				dp[i][j] = 0;
    			} else if(i == 0) {
    				dp[i][j] = j;
    			} else if(j == 0) {
    				dp[i][j] = i;
    			} else {
    				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
    					dp[i][j] = dp[i - 1][j - 1];
    				} else {
    					int delete = dp[i - 1][j];
    					int replace = dp[i - 1][j - 1];
    					int insert = dp[i][j - 1];
    					dp[i][j] = Math.min(replace, Math.min(delete, insert)) + 1;
    				}
    			}
    		}
    	}
    	return dp[dp.length-1][dp[0].length-1];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = 0;
				} else if(i == 0) {
					dp[i][j] = i;
				} else if(j == 0) {
					dp[i][j] = j;
				}
			}
		}
		System.out.println(rec_solution(s1,s2, 1, 1, dp));
		System.out.println(solution(s1,s2));
		scn.close();
	}

	private static int rec_solution(String s1, String s2, int i, int j, int[][] dp) {
		if(i == dp.length || j == dp.length) {
			return 0;
		}

		if(dp[i][j] != 0) {
			return dp[i][j];
		}
		int c1 = s1.charAt(i-1);
		int c2 = s2.charAt(j-1);
		
		int ans = 0;
		if(c1 == c2) {
		    ans = rec_solution(s1, s2, i+1, j+1, dp);
		} else {
			int replace = rec_solution(s1, s2, i+1, j+1, dp);
			int insert = rec_solution(s1, s2, i, j+1, dp);
			int delete = rec_solution(s1, s2, i+1, j, dp);
			ans = Math.min(replace, Math.min(insert, delete)) + 1;
		}
		dp[i][j] = ans;
		return ans;
	}
}
