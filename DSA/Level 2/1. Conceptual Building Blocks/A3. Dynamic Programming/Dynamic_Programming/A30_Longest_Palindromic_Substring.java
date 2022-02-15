/*
1. You are given a string str.
2. You are required to print the length of longest of palindromic substrings in string str.
Input Format
A string str
Output Format
A number representing the length of longest of palindromic substrings in string str.

Constraints
0 <= str.length <= 10
Sample Input
abccbc
Sample Output
4

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A30_Longest_Palindromic_Substring {
     
	 public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
         String str = sc.next();
         boolean[][] dp = new boolean[str.length()][str.length()];
         int llen = 0; // longest length
         for (int g = 0; g < str.length(); g++) {
         	for (int i = 0, j = g; j < str.length(); j++, i++) {
         		 if (g == 0) {
         			 dp[i][j] = true;
         			llen++;
         		 } else if(g == 1) {
         			 if (str.charAt(i) == str.charAt(j)) {
         				 dp[i][j] = true;
         				llen++;
         			 } else {
         				 dp[i][j] = false;
         			 }
         		 } else {
         			 if (str.charAt(i) == str.charAt(j) && dp[i+1][j-1]) {
         				 dp[i][j] = true;
         				llen++;
         			 } else {
         				 dp[i][j] = false;
         			 }
         		 }
         		if (dp[i][j]) {
             		llen = g + 1;
             	}
         	}
         }
         System.out.println(llen);
         sc.close();
	 }
}
