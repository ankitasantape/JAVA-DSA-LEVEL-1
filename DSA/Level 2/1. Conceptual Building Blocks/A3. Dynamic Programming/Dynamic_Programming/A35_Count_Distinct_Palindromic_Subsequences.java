/*
1. You are given a string.
2. You have to print the count of distinct and non-empty palindromic subsequences in the given string.
3. Two sequences s1 and s2 are distinct if here is some i, for which ith character in s1 and s2 are different.

Note -> String contains only lowercase letters.
          -> The answer will be in the integer range only.
Input Format
A String
Output Format
An Integer

Constraints
1 <= length of string <= 10000
Sample Input
bccb
Sample Output
6

Sample Input
abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadc
Sample Output
13238389

*/
package Dynamic_Programming;

import java.util.HashMap;
import java.util.Scanner;

public class A35_Count_Distinct_Palindromic_Subsequences {
    
	public static int solution(String str) {
		int[][] dp = new int[str.length()][str.length()];
		
		int[] prev = new int[str.length()];
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if (map.containsKey(ch) == false) {
				prev[i] = -1;
			} else {
				prev[i] = map.get(ch);
			}
			map.put(ch, i);
		}
		map.clear();
		int next[] = new int[str.length()];
		for (int i = str.length()-1; i >= 0; i--) {
			char ch = str.charAt(i);
			
			if (map.containsKey(ch) == false) {
				next[i] = -1;
			} else {
				next[i] = map.get(ch);
			}
			map.put(ch, i);
		}
		
	    for (int g = 0; g < str.length(); g++) {
	    	for (int i = 0, j = g; j < dp.length; i++, j++) {
	    		if (g == 0) {
	    			dp[i][j] = 1;
	    		} else if (g == 1) {
	    			dp[i][j] = 2;
	    		} else {
	    			char sc = str.charAt(i);
	    			char ec = str.charAt(j);
	    			if ( sc != ec ) {
	    				dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i+1][j-1];
	    			} else {
	    				int nis = next[i]; // next index of start
	    				int pie = prev[j]; // prev index of end
	    				
	    				if (nis > pie) {
	    					dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
	    				} else if(nis == pie) { 
	    					dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
	    				} else {
	    					dp[i][j] = 2 * dp[i + 1][j - 1] - dp[nis + 1][pie - 1];
	    				}
	    			}
	    		} 
	    	}
	    }
		return dp[0][str.length()-1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
		scn.close();
	}
}
