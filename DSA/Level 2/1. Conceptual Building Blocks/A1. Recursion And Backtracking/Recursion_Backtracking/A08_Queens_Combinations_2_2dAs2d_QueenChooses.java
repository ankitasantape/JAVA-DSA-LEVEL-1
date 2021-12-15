/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
     n * n chess-board. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
Constraints
1 <= n <= 5
Sample Input
2
Sample Output
q	q	
-	-	

q	-	
q	-	

q	-	
-	q	

-	q	
q	-	

-	q	
-	q	

-	-	
q	q	
*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A08_Queens_Combinations_2_2dAs2d_QueenChooses {
    
	public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int pos_of_prev_qrow, int pos_of_prev_qcol) {
		if(qpsf == tq) {
			for(int i = 0; i < chess.length; i++) {
				for(int j = 0; j < chess.length; j++) {
					if(chess[i][j] == false) {
						System.out.print("-\t");
					} else {
						System.out.print("q\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
//		to place queen in same row and pending column
		for (int col = pos_of_prev_qcol + 1; col < chess.length; col++) {
			chess[pos_of_prev_qrow][col] = true;
			queensCombinations(qpsf + 1, tq, chess, pos_of_prev_qrow, col);
			chess[pos_of_prev_qrow][col] = false;
		}
		
//		explore remaining rows
		for(int row = pos_of_prev_qrow + 1; row < chess.length; row++) {
			for(int col = 0; col < chess.length; col++) {
				chess[row][col] = true;
				queensCombinations(qpsf + 1, tq, chess, row, col);
				chess[row][col] = false;
			}
		}
	}
	public static void queensCombinations_2(int qpsf, int tq, boolean[][] chess, int i, int j) {
		if(qpsf == tq) {
			for(int row = 0; row < chess.length; row++) {
				for(int col = 0; col < chess.length; col++) {
					if(chess[row][col] == false) {
						System.out.print("-\t");
					} else {
						System.out.print("q\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		for(int row = i; row < chess.length; row++ ) {
			for(int col = ( row == i ) ? j + 1 : 0; col < chess.length; col++ ) {	
				chess[row][col] = true;
				queensCombinations_2(qpsf + 1, tq, chess, row, col);
				chess[row][col] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] chess = new boolean[n][n];

		queensCombinations(0, n, chess, 0, -1); // 0,-1 represents position of last queen -> 0,-1 invalid pos but we will update it later
	    System.out.println("***************************");
	    queensCombinations_2(0, n, chess, 0, -1);
	}
}
