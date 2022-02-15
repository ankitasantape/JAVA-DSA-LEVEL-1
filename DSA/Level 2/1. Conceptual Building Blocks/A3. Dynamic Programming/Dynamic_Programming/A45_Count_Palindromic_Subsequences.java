/*
1. You are given a string str.
2. You are required to print the count of palindromic subsequences in string str.
Input Format
A string str
Output Format
A number representing the count of palindromic subsequences in string str.

Constraints
0 <= str.length <= 10
Sample Input
ccbbgd
Sample Output
8


*/

package Dynamic_Programming;

import java.util.Scanner;

public class A45_Count_Palindromic_Subsequences {
   
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        int[][] dp = new int[str.length()][str.length()];
        for (int g = 0; g < str.length(); g++) {
        	for (int i = 0, j = g; j < str.length(); j++, i++) {
        		 if (g == 0) {
        			 dp[i][j] = 1;
        		 } else if(g == 1) {
        			 dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
        		 } else {
        			 if (str.charAt(i) == str.charAt(j)) {
        				 dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1;
        			 } else {
        				 dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
        			 }
        		 }
        	}
        }
        System.out.println(dp[0][str.length()-1]);
        sc.close();
    }
}
