/*

1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
Input Format
A number N
arr1
arr2.. N integers
Output Format

Constraints
2 <= N <= 1000
1 <= arr[i] <= 500
Sample Input
3
1
2
3
Sample Output
6

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A21_Matrix_Chain_Multiplication {

	public static int mcm_recur(int[] arr, int si, int ei) {
		if (si > ei) {
			return 0;
		}
		if (si == ei) {
			return 0;
		}
		int min = Integer.MAX_VALUE;

		for (int cp = si + 1; cp < ei; cp++) {
			int left = mcm_recur(arr, si, cp);
			int right = mcm_recur(arr, cp, ei);
     		min = Math.min(min, left + right + arr[si] * arr[cp] * arr[ei]);
		}

		return min;
	}

	public static int mcm(int[] arr) {
		int dp[][] = new int[arr.length - 1][arr.length - 1];
		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 0;
				} else if (g == 1) {
					dp[i][j] = arr[i] * arr[j] * arr[j + 1];
				} else {
					int min = Integer.MAX_VALUE;

					for (int k = i; k < j; k++) {
//					dp -> i, k left half and k + 1, j right half
//				    arr -> i * k + 1 right half, k + 1 * j + 1 right half		
						int lcost = dp[i][k];
						int rcost = dp[k + 1][j];
						int mcost = arr[i] * arr[k + 1] * arr[j + 1];
						int totalcost = lcost + rcost + mcost;

						min = Math.min(min, totalcost);
					}

					dp[i][j] = min;
				}
			}
		}

		return dp[0][dp.length - 1];
	}

	public static int mcm_2(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];

		for (int g = 2; g < arr.length; g++) {
			for (int si = 0, ei = g; ei < arr.length; si++, ei++) {
				int min = Integer.MAX_VALUE;
				for (int cp = si + 1; cp < ei; cp++) {
					min = Math.min(min, dp[si][cp] + dp[cp][ei] + arr[si] * arr[cp] * arr[ei]);
				}
				dp[si][ei] = min;
			}
		}
		return dp[0][arr.length];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println("Recursive Solution: " + mcm_recur(arr, 0, n - 1));
		System.out.println("DP Solution: " + mcm(arr));

		scn.close();
	}

}
