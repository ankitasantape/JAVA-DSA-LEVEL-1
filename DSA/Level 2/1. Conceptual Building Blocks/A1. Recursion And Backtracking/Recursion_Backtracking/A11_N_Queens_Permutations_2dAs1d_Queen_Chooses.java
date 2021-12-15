/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens (distinct) can be 
     placed on the n * n chess-board. 
3. No queen shall be able to kill another.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
Output Format

Constraints
1 <= n <= 5
Sample Input
4
Sample Output
-	q1	-	-	
-	-	-	q2	
q3	-	-	-	
-	-	q4	-	

-	q1	-	-	
-	-	-	q2	
q4	-	-	-	
-	-	q3	-	

-	q1	-	-	
-	-	-	q3	
q2	-	-	-	
-	-	q4	-	

-	q1	-	-	
-	-	-	q4	
q2	-	-	-	
-	-	q3	-	

-	q1	-	-	
-	-	-	q3	
q4	-	-	-	
-	-	q2	-	

-	q1	-	-	
-	-	-	q4	
q3	-	-	-	
-	-	q2	-	

-	-	q1	-	
q2	-	-	-	
-	-	-	q3	
-	q4	-	-	

-	-	q1	-	
q2	-	-	-	
-	-	-	q4	
-	q3	-	-	

-	-	q1	-	
q3	-	-	-	
-	-	-	q2	
-	q4	-	-	

-	-	q1	-	
q4	-	-	-	
-	-	-	q2	
-	q3	-	-	

-	-	q1	-	
q3	-	-	-	
-	-	-	q4	
-	q2	-	-	

-	-	q1	-	
q4	-	-	-	
-	-	-	q3	
-	q2	-	-	

-	-	q2	-	
q1	-	-	-	
-	-	-	q3	
-	q4	-	-	

-	-	q2	-	
q1	-	-	-	
-	-	-	q4	
-	q3	-	-	

-	-	q3	-	
q1	-	-	-	
-	-	-	q2	
-	q4	-	-	

-	-	q4	-	
q1	-	-	-	
-	-	-	q2	
-	q3	-	-	

-	-	q3	-	
q1	-	-	-	
-	-	-	q4	
-	q2	-	-	

-	-	q4	-	
q1	-	-	-	
-	-	-	q3	
-	q2	-	-	

-	q2	-	-	
-	-	-	q1	
q3	-	-	-	
-	-	q4	-	

-	q2	-	-	
-	-	-	q1	
q4	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q1	
q2	-	-	-	
-	-	q4	-	

-	q4	-	-	
-	-	-	q1	
q2	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q1	
q4	-	-	-	
-	-	q2	-	

-	q4	-	-	
-	-	-	q1	
q3	-	-	-	
-	-	q2	-	

-	q2	-	-	
-	-	-	q3	
q1	-	-	-	
-	-	q4	-	

-	q2	-	-	
-	-	-	q4	
q1	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q2	
q1	-	-	-	
-	-	q4	-	

-	q4	-	-	
-	-	-	q2	
q1	-	-	-	
-	-	q3	-	

-	q3	-	-	
-	-	-	q4	
q1	-	-	-	
-	-	q2	-	

-	q4	-	-	
-	-	-	q3	
q1	-	-	-	
-	-	q2	-	

-	-	q2	-	
q3	-	-	-	
-	-	-	q1	
-	q4	-	-	

-	-	q2	-	
q4	-	-	-	
-	-	-	q1	
-	q3	-	-	

-	-	q3	-	
q2	-	-	-	
-	-	-	q1	
-	q4	-	-	

-	-	q4	-	
q2	-	-	-	
-	-	-	q1	
-	q3	-	-	

-	-	q3	-	
q4	-	-	-	
-	-	-	q1	
-	q2	-	-	

-	-	q4	-	
q3	-	-	-	
-	-	-	q1	
-	q2	-	-	

-	-	q2	-	
q3	-	-	-	
-	-	-	q4	
-	q1	-	-	

-	-	q2	-	
q4	-	-	-	
-	-	-	q3	
-	q1	-	-	

-	-	q3	-	
q2	-	-	-	
-	-	-	q4	
-	q1	-	-	

-	-	q4	-	
q2	-	-	-	
-	-	-	q3	
-	q1	-	-	

-	-	q3	-	
q4	-	-	-	
-	-	-	q2	
-	q1	-	-	

-	-	q4	-	
q3	-	-	-	
-	-	-	q2	
-	q1	-	-	

-	q2	-	-	
-	-	-	q3	
q4	-	-	-	
-	-	q1	-	

-	q2	-	-	
-	-	-	q4	
q3	-	-	-	
-	-	q1	-	

-	q3	-	-	
-	-	-	q2	
q4	-	-	-	
-	-	q1	-	

-	q4	-	-	
-	-	-	q2	
q3	-	-	-	
-	-	q1	-	

-	q3	-	-	
-	-	-	q4	
q2	-	-	-	
-	-	q1	-	

-	q4	-	-	
-	-	-	q3	
q2	-	-	-	
-	-	q1	-	
 */
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A11_N_Queens_Permutations_2dAs1d_Queen_Chooses {
	public static boolean IsQueenSafe(int[][] chess, int row, int col) {
//		top
		for(int i = row, j = col; i >= 0; i--) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
//		bottom
		for(int i = row, j = col; i < chess.length; i++) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
//		left
		for(int i = row, j = col; j >= 0; j--) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
//		right
		for(int i = row, j = col; j < chess.length; j++) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
//		top-left
		for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
//		top-right
		for(int i = row, j = col; i >= 0 && j < chess.length; i--, j++) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
//		bottom-left
		for(int i = row, j = col; i < chess.length && j >= 0; i++, j--) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
//		bottom-right
		for(int i = row, j = col; i < chess.length && j < chess.length; i++, j++) {
			if(chess[i][j] > 0) {
				return false;
			}
		}
		return true;
	}

	public static void nqueens(int qpsf, int tq, int[][] chess) {
		// write your code here
		if(qpsf == tq) {
			for(int i = 0; i < chess.length; i++) {
				for(int j = 0; j < chess.length; j++) {
					if(chess[i][j] > 0) {
						System.out.print("q" + chess[i][j] +"\t");
					} else {
						System.out.print("-\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		
		for(int i = 0; i < chess.length * chess.length; i++) {
			int row = i / chess.length;
			int col = i % chess.length;
			if(chess[row][col] == 0 && IsQueenSafe(chess, row, col)) {
				chess[row][col] = qpsf + 1;
				nqueens(qpsf + 1, tq, chess);
				chess[row][col] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] chess = new int[n][n];

		nqueens(0, n, chess);
	}
	
}
