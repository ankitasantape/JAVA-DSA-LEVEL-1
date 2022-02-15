/*
1. You are given two strings s1 and s2.
2. A string can be represented as a binary tree by partitioning it to two non-empty substrings recursively.
3. If you choose any non-leaf node and swap its two children, then the string formed is the scramble of the original string.
4. You have to determine if s2 is a scrambled string of s1.
Input Format
2 strings s1 and s2
Output Format

Constraints
1 < length of strings <= 100
Sample Input
great
rgeat
Sample Output
true

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A58_Scramble_String_1 {
    // Brute Force Approach
	public static boolean isScrambleRec(String s1, String s2) {
		
		 if( s1.equals(s2) ){
	         return true;
	     } 
	     for (int cut = 0; cut < s1.length()-1; cut++){
	         boolean l1 = isScrambleRec( s1.substring( 0, cut + 1 ), s2.substring( 0, cut + 1)                );
	         boolean l2 = isScrambleRec( s1.substring( cut + 1    ), s2.substring( cut + 1)                   );
	         boolean r1 = isScrambleRec( s1.substring( 0, cut + 1 ), s2.substring( s2.length() - 1 - cut)     );
	         boolean r2 = isScrambleRec( s1.substring( cut + 1    ), s2.substring( 0, s2.length() - 1 - cut ) );
	         
	         if ( l1 && l2 || r1 && r2){ 
	             return true;
	         }
	     }
		
		 return false;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int n = s1.length();
		if(s1.length() != s2.length()) {
			System.out.println("false");
			return;
		}
		System.out.println(isScrambleRec(s1,s2));
		System.out.println(isScrambleRec2(s1,s2,0, s1.length() - 1, 0, s2.length() - 1));
		System.out.println(isScrambleMemo(s1,s2,0, 0, s1.length(), new Boolean[n][n][n + 1]));
		System.out.println(isScrambleTab(s1 , s2));
		scn.close();
	}

	private static boolean isScrambleTab(String s1, String s2) {
		int n = s1.length();
		boolean[][][] dp = new boolean[n][n][n + 1];
		
		for (int len = 1; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				for (int j = 0; j <= n - len; j++) {
					if (len == 1) {
						dp[i][j][len] = (s1.charAt(i) == s2.charAt(j));
					} else {
						for (int k = 1; k < len && !dp[i][j][len]; k++) {
							dp[i][j][len] = ((dp[i][j][k] && dp[i + k][j + k][len - k]) 
									|| (dp[i][j + len - k][k] && dp[i + k][j][len - k]));
						}
					}
				}
			}
		}
		return dp[0][0][n];
	}

	private static boolean isScrambleMemo(String s1, String s2, int si1, int si2, int len, Boolean[][][] dp) {
		if (s1.substring(si1, si1 + len).equals(s2.substring(si2, si2 + len))) {
			return true;
		}
		if(dp[si1][si2][len] != null) {
			return dp[si1][si2][len];
		}
		for (int cp = 1; cp < len; cp++) {
			if ((  isScrambleMemo(s1, s2, si1, si2, cp, dp) && isScrambleMemo(s1, s2, si1 + cp, si2 + cp, len - cp, dp) ) || 
			    (  isScrambleMemo(s1, s2, si1, si2 + len - cp, cp, dp) && isScrambleMemo(s1, s2, si1 + cp, si2, len - cp, dp))) {
				dp[si1][si2][len] = true;
				return true;
			}
		}
		dp[si1][si2][len] = false;
		return false;
	} 
    
	// Little Optimized Approach
	private static boolean isScrambleRec2(String s1, String s2, int si1, int ei1, int si2, int ei2) {
		if(s1.substring(si1, ei1 + 1).equals(s2.substring(si2, ei2 + 1))) {
			return true;
		}
		
		for(int cp = 0; cp < ei1 - si1; cp++) {
			if((    isScrambleRec2 (s1, s2, si1, si1 + cp, si2, si2 + cp) 
				&&  isScrambleRec2(s1, s2, si1 + cp + 1, ei1, si2 + cp + 1, ei2))
				||( isScrambleRec2 (s1, s2, si1, si1 + cp, ei2 - cp, ei2) 
				&&  isScrambleRec2( s1, s2, si1 + cp + 1, ei1, si2, ei2 - cp - 1))  ){
				
				return true;
			}
		}
		
		return false;
	}

	
}
