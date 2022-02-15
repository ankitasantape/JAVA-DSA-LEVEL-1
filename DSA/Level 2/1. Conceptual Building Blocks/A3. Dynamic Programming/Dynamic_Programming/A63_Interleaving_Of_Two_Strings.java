/*
1. You are given three strings - s1, s2 and s3.
2. You have to find whether s3 is formed by interleaving of s1 and s2.
3. s3 is interleaving if it contains all characters of s1 and s2, and order of all characters in individual string is preserved.
Input Format
String s1
String s2
String s3
Output Format
true/false

Constraints
1 <= s1.length() <= 100
1 <= s2.length() <= 100
1 <= s3.length() <= 200
Sample Input
aabcc
dbbca
aadbbcbcac
Sample Output
true

Sample Input
xy
x
xxy
Sample Output
true

Sample Input
yx
x
xxy
Sample Output
false

Sample Input
abababababababababababababababababababababababababababababababababababababababababababababababababbb
babababababababababababababababababababababababababababababababababababababababababababababababaaaba
abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb
Sample Output
false

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A63_Interleaving_Of_Two_Strings {
   
	public static boolean solution(String s1, String s2, String s3) {
	      if( s1.length() + s2.length() != s3.length()  ){
	          return false;
	      }
	      boolean[][] dp = new boolean[s1.length()+1][s2.length() +1];
	      for(int i = 0; i < dp.length; i++){
	          for(int j = 0; j < dp[0].length; j++){
	              if(i == 0 && j == 0){
	                  dp[i][j] = true;
	              } else if( i == 0 ){
	                  dp[i][j] = s2.charAt(j-1) == s3.charAt(i + j - 1) ? dp[i][j-1] : false;
	              } else if( j == 0){
	                  dp[i][j] = s1.charAt(i-1) == s3.charAt(i + j - 1) ? dp[i-1][j] : false;
	              } else {
	                  char cin1 = s1.charAt(i-1);
	                  char cin2 = s2.charAt(j-1);
	                  char cin3 = s3.charAt(i+j-1);
	                  if( cin1 == cin3 && cin2 == cin3 ){
	                      dp[i][j] = dp[i-1][j] || dp[i][j-1];
	                  } else if(cin1 == cin3){
	                      dp[i][j] = dp[i-1][j];
	                  } else if(cin2 == cin3){
	                      dp[i][j] = dp[i][j-1];
	                  }
	              }
	          }
	      }
	      return dp[dp.length - 1][dp[0].length - 1];
	  }

	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    String s1 = scn.nextLine();
	    String s2 = scn.nextLine();
	    String s3 = scn.nextLine();
	    System.out.println(solution(s1, s2, s3));
	    scn.close();
	  }
}
