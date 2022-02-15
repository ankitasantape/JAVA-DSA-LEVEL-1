/*
1. You are given a number N.
2. You have to find the minimum number of squares that sum to N.
3. You can always represent a number as a sum of squares of other numbers.
   For eg -> In worst case N can be represented as (1*1) + (1*1) + (1*1)..... N times.
Input Format
An integer N
Output Format

Constraints
1 <= N <= 10^5
Sample Input
35
Sample Output
3
*/

package Dynamic_Programming;

import java.util.Scanner;

public class A14_Perfect_Square {
     
	public static int solution(int n){
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			
			for(int j = 1; j * j <= i; j++) {
				int rem = i - j * j;
				if( dp[rem] < min ) {
					min = dp[rem];
				}
			}
			dp[i] = min + 1;
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
