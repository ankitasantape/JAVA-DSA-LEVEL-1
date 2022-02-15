/*
1. You are given an array(arr) of length N, where N is an even number.
2. The elements of the array represent N coins of values arr1,arr1...arrN.
3. You are playing a game against an opponent in an alternative way, where the opponent is equally smart.
4. In this game, a player selects either the first or the last coin from the row in every turn, removes it from the row permanently, and receives the value of the coin.
5. You have to find the maximum possible amount of money you can win if you make the first move.
Input Format
A number N
arr1
arr2...N numbers
Output Format

Constraints
2 <= N <= 1000
1 <= arr[i] <= 10^6
Sample Input
4
5
3
7
10
Sample Output
15

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A51_Optimal_Strategy_For_A_Game {
    
	public static void optimalStrategy(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n][n];
		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = arr[i];
				} else if(g == 1){
					dp[i][j] = Math.max(arr[i], arr[j]);
				} else{
					int val1 = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
				    int val2 = arr[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
				    
				    dp[i][j] = Math.max(val1, val2);
				}
				
			}
		}
		System.out.println(dp[0][n-1]);
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scn.nextInt();
		}
		optimalStrategy(a);
		System.out.println(optimalStrategy(a, 0, n-1,new int[n+1][n+1]));
		scn.close();
	}
	public static int optimalStrategy(int[] arr, int si, int ei, int dp[][]) {
	    if(si > ei){
	        return 0;
	    }
	    if(dp[si][ei] != 0){
	        return dp[si][ei];
	    }
	  int f1 = arr[si] + Math.min(optimalStrategy(arr, si + 2, ei,dp), optimalStrategy(arr,si+1, ei-1,dp));
	  int f2 = arr[ei] + Math.min(optimalStrategy(arr, si + 1, ei-1,dp), optimalStrategy(arr,si, ei-2,dp));
	  dp[si][ei] = Math.max(f1, f2);
	  return Math.max(f1, f2);
	}

}
