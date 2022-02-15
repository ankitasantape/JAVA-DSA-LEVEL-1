/*
1. You are given a string str.
2. You are required to print the length of longest palindromic subsequence of string str.
Input Format
A string str
Output Format
A number representing the length of longest palindromic subsequence of string str.
Constraints
0 <= str.length <= 10
Sample Input
abcgackbc
Sample Output
5

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A44_Longest_Palindromic_Subsequences {
     
	 public static void main(String[] args) throws Exception {
           Scanner sc = new Scanner(System.in);
           String str = sc.next();
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
           System.out.println(dp[0][n-1]);
           // recursive
           System.out.println( solution(str, 0, n-1) );
           sc.close();
	 }
	 // Recursive
	 public static int solution(String str, int si, int ei){
         if(si > ei){
             return 0;
         }
         if(ei == si){
             return 1;
         }
        
        if( str.charAt(si) == str.charAt(ei) ){
          return 2 + solution(str, si+1, ei-1 );
        } else {
            int a1 = solution(str, si+1, ei);
            int a2 = solution(str, si, ei-1);
          return Math.max(a1, a2);    
        }
    }
}
