/*
1. Imagine you have a special keyboard with the following keys - 
   Key 1 : Print 'X' on the screen.
   key 2 : Select screen.
   Key 3 : Copy selection to buffer.
   Key 4 : Print buffer on screen appending to what has already been printed.
2. You are given a number N, which represents the number of times the keyboard is pressed.
3. You have to find the maximum number of 'X' that can be produced by pressing the N number of keys.
Input Format
A number N
Output Format

Constraints
1 <= N <= 100
Sample Input
3
Sample Output
3
*/

package Dynamic_Programming;

import java.util.Scanner;

public class A07_4_Key_Keyboard {
    
	public static int solution(int n) {
		 int[] dp = new int[n+1];
		 
		 for(int i = 1; i <= n; i++){
		     if(i <= 6){
		       dp[i] = i;  
		     } else {
		           dp[i] = i;
		           for(int j = 1; j <= i-3; j++){
		               dp[i] = Math.max(dp[i],  dp[j] + dp[j] * (i - j - 2));
		            }
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
