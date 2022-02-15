/*
1. You are given two strings S1 and S2.
2. You have to find the number of unique ways in which you can transform S1 to S2.
3. Transformation can be achieved by removing 0 or more characters from S1, such that 
the sequence formed by the remaining characters of S1 is identical to S2.
Input Format
Two Strings S1 and S2
Output Format
A number representing the count of distinct transformations.
Constraints
1 <= length of strings S1 and S2 <= 1000
Sample Input
abcccdf
abccdf
Sample Output
3

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A57_Distinct_Transformations {
   
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(rec_solution(s1, s2, 0, 0));
		System.out.println(rec(s1, s2, 0, 0));
		int dp[][] = new int[s1.length()][s2.length()];
		for(int i = 0; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(memo_solution(s1, s2, 0, 0, dp));
		System.out.println(tab_solution(s1, s2));
		scn.close();
	}

	private static int rec(String s1, String s2, int i, int j) {
		if(j == s2.length()) {
			return 1;
		} 
		else if( i == s1.length()  ) {
			return 0;
		}
		
		char ch1 = s1.charAt(i);
		char ch2 = s2.charAt(j);
		int ans = 0;
		if(ch1 == ch2) {
			int r1r2 = rec(s1, s2, i+1, j+1);
			int r1s2 = rec(s1, s2, i+1, j);
			ans = r1r2 + r1s2 ;
		} else {
			int r1s2 = rec(s1, s2, i+1, j);
			ans = r1s2;
		}
		
		return ans;
	}

	private static int tab_solution(String s, String t) {
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		
		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if(i == dp.length-1) {
					dp[i][j] = 1;
				} else if(j == dp[0].length-1) {
					dp[i][j] = 0;
				} else {
					char c1 = t.charAt(i);
					char c2 = s.charAt(j);
					
					if(c1 != c2) {
						dp[i][j] = dp[i][j + 1];
					} else {
						dp[i][j] = dp[i][j + 1] + dp[i + 1][j + 1];
					}	
				}
			}
		}
		return dp[0][0];
	}

	private static int memo_solution(String s, String t, int si, int ti, int[][] dp) {
		if(si == s.length()) {
			// target abhibhi khatam nahi hua hai ut source khatam ho gaya hai 
			if(ti < t.length()) {
				return 0;
			} else {
				return 1;
			}
		} else if(ti == t.length()){
			return 1;
		}
		
		if(dp[si][ti] != -1) {
			return dp[si][ti];
		}
		
		char c1 = s.charAt(si);
		char c2 = t.charAt(ti);
		
		int tw = 0;
		if(c1 != c2) {
			tw = memo_solution(s, t, si + 1, ti, dp);
		} else {
			int tw1 = memo_solution(s, t, si + 1, ti, dp);
			int tw2 = memo_solution(s, t, si + 1, ti + 1, dp);
			tw = tw1 + tw2;
		}
		dp[si][ti] = tw;
		return tw;
	}

	private static int rec_solution(String s, String t, int si, int ti) {
		if(ti == t.length()){
			return 1;
		} 
		else if(si == s.length()) {
			// target abhibhi khatam nahi hua hai but source khatam ho gaya hai 
			return 0;
		}
		char c1 = s.charAt(si);
		char c2 = t.charAt(ti);
		
		int tw = 0;
		if(c1 != c2) {
			tw = rec_solution(s, t, si + 1, ti);
		} else {
			int tw1 = rec_solution(s, t, si + 1, ti);
			int tw2 = rec_solution(s, t, si + 1, ti + 1);
			tw = tw1 + tw2;
		}
		return tw;
	}
}
