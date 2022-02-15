/*
1. You are given a number N.
2. You have to find Nth ugly number.
3. Ugly number is defined as the number whose prime factors are only 2,3 and 5.  
4. First eleven ugly numbers are -> 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15.

Assumption -> 1 is the first ugly number.
Input Format
A number N
Output Format
A number representing Nth ugly number.

Constraints
1 <= N <= 10^4
Sample Input
4
Sample Output
4
*/
package Dynamic_Programming;

import java.util.Scanner;

public class A39_Ugly_Number {
    
	public static int solution(int n) {
         
		int[] dp = new int[n+1];
		int p2 = 1;
		int p3 = 1;
		int p5 = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int ansp2 = dp[p2] * 2;
			int ansp3 = dp[p3] * 3;
			int ansp5 = dp[p5] * 5;
			int min = Math.min(ansp3, Math.min(ansp2, ansp5));
			dp[i] = min;
			if(ansp2 == min) {
				p2++;
			}
			if(ansp3 == min) {
				p3++;
			}
			if(ansp5 == min) {
				p5++;
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
