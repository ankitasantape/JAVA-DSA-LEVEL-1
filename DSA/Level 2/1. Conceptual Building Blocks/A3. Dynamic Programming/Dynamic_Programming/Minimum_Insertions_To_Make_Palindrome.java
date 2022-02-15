/*
1. You are given a string(str).
2. You have to find the minimum number of characters to be inserted to convert it to a palindrome.
Input Format
A string
Output Format
Constraints
1 <= length of s1 <= 10000
Sample Input
pepperatcoding
Sample Output
10
*/

package Dynamic_Programming;

import java.util.Scanner;

public class Minimum_Insertions_To_Make_Palindrome {
   
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int n = str.length();
		 int[][] dp = new int[n][n];
         for (int g = 0; g < n; g++) {
      	   for (int i = 0, j = g; j < n; i++, j++) {
      		   if (g == 0) {
      			   dp[i][j] = 1;
      		   } else if (g == 1) {
      			   if (str.charAt(i) == str.charAt(j)) {
      				   dp[i][j] = 2;
      			   } else {
      				   dp[i][j] = 1;
      			   }
      		   } else {
      			   if( str.charAt(i) == str.charAt(j) ) {
      				   dp[i][j] = 2 + dp[i + 1][j - 1];
      			   } else {
      				   dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
      			   }
      		   }
      	   }
         }
         System.out.println(str.length() - dp[0][n-1]);
         
         scn.close();
	 }
	
}
