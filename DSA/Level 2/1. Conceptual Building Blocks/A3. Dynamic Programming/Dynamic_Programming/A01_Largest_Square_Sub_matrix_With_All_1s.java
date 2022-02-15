/*
1. You are given a matrix of 0's and 1's.
2. You have to find the maximum size square sub-matrix with all 1's.
Input Format
A number N, which represents number of rows in matrix
A number M, which represents number of columns in matrix
arr1
arr2...N*M numbers
Output Format

Constraints
1 <= N,M <= 100
0<= arr[i][j] <= 1
Sample Input
5 6
0 1 0 1 0 1 
1 0 1 0 1 0 
0 1 1 1 1 0 
0 0 1 1 1 0 
1 1 1 1 1 1
Sample Output
3

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A01_Largest_Square_Sub_matrix_With_All_1s {
   
	public static int solution(int[][] arr) {
		int dp[][] = new int[arr.length][arr[0].length];
		int ans = 0;
		for(int i = dp.length - 1; i >= 0; i--) {
			for(int j = dp[0].length - 1; j >= 0; j--) {
				if(i == dp.length-1 && j == dp[0].length-1) {
					dp[i][j] = arr[i][j];
				} else if(i == dp.length-1) {
					dp[i][j] = arr[i][j];
				} else if(j == dp[0].length-1) {
					dp[i][j] = arr[i][j];
				} else {
					if(arr[i][j] == 0) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
						
						if(dp[i][j] > ans) {
							ans = dp[i][j];
						}
					}		
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(solution(arr));
		scn.close();
	}
}
