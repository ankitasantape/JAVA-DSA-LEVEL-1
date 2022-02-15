/*

1. You are given a number N.
2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
3. You have to find the number of ways in which these chords can be drawn.
Input Format
A number N
Output Format

Constraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
Sample Output
5

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A19_Circle_And_Chords {
    
	public static long NumberOfChords(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i < dp.length; i++) {

			int l = 0;
			int r = i - 1;

			while (l <= i - 1) {
				dp[i] += dp[l] * dp[r];

				l++;
				r--;
			}
		}

		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(NumberOfChords(n));
		scn.close();
	}
}
