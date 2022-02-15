/*
1. You are given a N*N chessboard and the starting position of the knight in the chessboard.
2. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
3. You have to find the probability of knight to remain in the chessboard after exactly k number of moves.

Note -> The knight continues moving until it has made exactly K moves or has moved off the chessboard.
Input Format
A number N
A number K
Two numbers r and c(starting row and column position of knight in the chessboard).
Output Format

Constraints
1 <= N <= 25
0 <= K <= 100
0 <= r,c <= N-1
Sample Input
3
2
0
0
Sample Output
0.0625

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A55_Probability_Of_Knight_In_The_Chessboard {
   
	public static boolean isValid(int ni, int nj, int n) {
		if (ni >= 0 && nj >= 0 && ni < n && nj < n) {
			return true;
		} else {
			return false;
		}
	}
	
	// Time Complexity : O(n^2 . K)
	public static void solution(int r, int c, int n, int k) {
		double curr[][] = new double[n][n];
		double next[][] = new double[n][n];
		
		curr[r][c] = 1;
		
		for(int m = 1; m <= k; m++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(curr[i][j] != 0) {
						int ni = 0;
						int nj = 0;
						
						ni = i - 2;
						nj = j + 1;
						if(isValid(ni, nj, n)) {
							next[ni][nj] += curr[i][j] / 8.0;
						}
						
						ni = i - 1;
						nj = j + 2;
						if(isValid(ni, nj, n)) {
							next[ni][nj] += curr[i][j] / 8.0;
						}
						
						ni = i + 1;
						nj = j + 2;
						if(isValid(ni, nj, n)) {
							next[ni][nj] += curr[i][j] / 8.0;
						}
						
						ni = i + 2;
						nj = j + 1;
						if(isValid(ni, nj, n)) {
							next[ni][nj] += curr[i][j] / 8.0;
						}
						
						ni = i + 2;
						nj = j - 1;
						if(isValid(ni, nj, n)) {
							next[ni][nj] += curr[i][j] / 8.0;
						}
						
						ni = i + 1;
						nj = j - 2;
						if(isValid(ni, nj, n)) {
							next[ni][nj] += curr[i][j] / 8.0;
						}
						
						ni = i - 1;
						nj = j - 2;
						if(isValid(ni, nj, n)) {
							next[ni][nj] += curr[i][j] / 8.0;
						}
						
						ni = i - 2;
						nj = j - 1;
						if(isValid(ni, nj, n)) {
							next[ni][nj] += curr[i][j] / 8.0;
						}
					}
				}
			}
			curr = next;
			next = new double[n][n];
		}
		
		double sum = 0;
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j++) {
				sum += curr[i][j];
			}
		}
		System.out.println(sum);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int r = scn.nextInt();
		int c = scn.nextInt();
		solution(r, c, n, k);
		solution1(r, c, n, k);
		scn.close();
	}

	private static void solution1(int r, int c, int n, int k) {
		
		int[][] moves = {{-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};
		double[][] prev = new double[n][n];
		double[][] curr = new double[n][n];
		prev[r][c] = 1.0;
		for(int l = 1; l <= k; l++){
		  for(int i = 0; i < n; i++){
		    for(int j = 0; j < n; j++){
		        if( prev[i][j] != 0 ){
		            for(int m = 0; m < 8; m++) {
		            	int ni = i + moves[m][0];
		            	int nj = j + moves[m][1];
		            	if(ni >= 0 && ni < n && nj >= 0 && nj < n) {
		            		curr[ni][nj] += prev[i][j] / 8.0;
		            	}
		            }
		        }
		    }
		}
		prev = curr;
		curr = new double[n][n];
	  }	
	  double sum = 0.0; 
	  for(int i = 0; i < n; i++){
	      for (int j = 0; j < n; j++){
	          sum += prev[i][j];
	      }
	  }
	  System.out.println(sum);
	}
}
