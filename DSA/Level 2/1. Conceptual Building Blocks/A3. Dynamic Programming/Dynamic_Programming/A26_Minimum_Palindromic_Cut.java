/*
1. You are given a string.
2. You have to find the minimum number of cuts required to convert the given string into palindromic partitions.
3. Partitioning of the string is a palindromic partitioning if every substring of the partition is a palindrome.
Input Format
A string
Output Format

Constraints
1 <= length of string <= 10^4
Sample Input
abccbc
Sample Output
2

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A26_Minimum_Palindromic_Cut {
     
	// Approach 1 : Time Complexity : O(n^3)
	public static int minPalindromicCut1(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++ ) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					if( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}
			}
		}
		
		int[][] storage = new int[s.length()][s.length()];
		
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < storage.length; i++, j++ ) {
				if (g == 0) {
					storage[i][j] = 0;
				} else if (g == 1) {
					storage[i][j] = s.charAt(i) == s.charAt(j) ? 0 : 1;
				} else {
					if( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
						storage[i][j] = 0;
					} else {
						int min = Integer.MAX_VALUE;
						for (int k = i; k < j; k++) {
							int left = storage[i][k];
							int right = storage[k + 1][j];
							
							if(left + right + 1 < min) {
								min = left + right + 1;
							}
						}
						storage[i][j] = min;
					}
				}
			}
		}
		return storage[0][s.length() - 1];
		
	}
	
	public static int minPalindromicCut2(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++ ) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					if( s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}
			}
		}
		
		int[] storage = new int[s.length()];
		
		storage[0] = 0;
		
		for (int j = 1; j < s.length(); j++) {
			// agar whole string palindromic hai to need not check min cut directly store 0
			if (dp[0][j]) {
				storage[j] = 0;
			} else {
				int min = Integer.MAX_VALUE;
				for (int i = j; i >= 1; i--) {
					if (dp[i][j]) {
						if (storage[i - 1] < min) {
							min = storage[i - 1];
						}
					}
				}

				storage[j] = min + 1;
			}
		}
		
		return storage[s.length() - 1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut1(str));
		scn.close();
	}
}
