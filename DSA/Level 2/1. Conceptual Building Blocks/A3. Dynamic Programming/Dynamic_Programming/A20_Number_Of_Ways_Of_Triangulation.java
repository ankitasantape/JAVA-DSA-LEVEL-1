/*
1. You are given a number N, which represents the number of sides in a polygon.
2. You have to find the total number of ways in which the given polygon can be triangulated.
Input Format
A number N
Output Format
A number representing number of ways of traingulating a N-sided polygon.

Constraints
1 <= N <= 15
Sample Input
5
Sample Output
5
 
*/
package Dynamic_Programming;

import java.util.Scanner;

public class A20_Number_Of_Ways_Of_Triangulation {
     
	public static int solution(int n){
		 
		 n = n - 2; // triangulation of n is catalan of n-2
		  
		 int dp[] = new int[n + 1];
		 dp[0] = 1;
		 dp[1] = 1;
		 
		 for (int i = 2; i <= n; i++){
		     int left = i - 1;
		     int right = 0;
		     
		     while(left >= 0) {
		    	 dp[i] += dp[left] * dp[right];
		    	 
		    	 left--;
		    	 right++;
		     }
		 }
		
		return dp[n];
	 }
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
		scn.close();
	}
}
