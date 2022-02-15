/*
1. You are given an array(arr) of length N which represents N number of balloons.
2. Each balloon is painted with a number on it.
3. You have to collect maximum coins by bursting all the balloons.
4. If you burst a balloon with index i, you will get (arr[i-1] * arr[i] * arr[i+1]) number of coins.
5. If arr[i-1] and arr[i+1] don't exist, then you may assume their value as 1.
Input Format
A number N
a1
a2.. N integers
Output Format

Constraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
1
2
3
Sample Output
12

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A22_Burst_Balloons {
	public static int solution(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];
		for(int g = 0; g < dp.length; g++) {
			for(int i = 0, j = g; j < dp.length; i++, j++) {
					int max = Integer.MIN_VALUE;
					
					for (int k = i; k <= j; k++) {
//					dp -> i, k left half and k + 1, j right half
//				    arr -> i * k + 1 right half, k + 1 * j + 1 right half		
						 int left = k == i ? 0 : dp[i][k - 1];
						 int right = k == j ? 0 : dp[k + 1][j];
						 int val = ( i == 0 ? 1 : arr[i - 1] ) * arr[k] *  ( j == arr.length - 1 ? 1 : arr[j + 1]);
						 
						 max = left + right + val > max ? left + right + val : max;
					}
					
					dp[i][j] = max;
				
			}
		}
		return dp[0][arr.length - 1];
	}
	
	public static int solution_2(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];
		for(int g = 0; g < dp.length; g++) {
			for(int si = 0, ei = g; ei < dp.length; si++, ei++) {
				if (g == 0) {
					dp[si][ei] = (si >= 1 ? arr[si - 1] : 1) * arr[si] * (si + 1 < arr.length ? arr[si + 1] : 1 );
				} else {
					int max = Integer.MIN_VALUE;
					for (int cp = si; cp <= ei; cp++) {
						int lans = cp - 1 >= 0 ? dp[si][cp - 1] : 0;
						int rans = cp + 1 < arr.length ? dp[cp + 1][ei] : 0;
						int cc = (si >= 1 ? arr[si - 1] : 1) * arr[cp] * (ei + 1 < arr.length? arr[ei + 1] : 1);
						max = Math.max(max, lans + rans + cc);
					}
					dp[si][ei] = max;
				}
				
			}
		}
		return dp[0][arr.length - 1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
		scn.close();
	}
}
