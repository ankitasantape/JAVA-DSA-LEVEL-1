/*
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
     Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens
     Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
               Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique, bit manipulation 
               and not test you.
Input Format
A number n
Output Format
Safe configurations of queens as suggested in sample output
Constraints
1 <= n <= 10
Sample Input
4
Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A18_N_Queens_Using_Bit {
   
	public static void solution(boolean[][] board, int row, int cols, int ndiag, int rdiag, String asf) {
		if( row == board.length ) {
			System.out.println(asf + ".");
			return;
		}
		for(int col = 0; col < board.length; col++) {
			if( board[row][col] == false &&
				((cols & (1 << col)) == 0) && 
				 ((ndiag & (1 << (row + col))) == 0) && 
				 ((rdiag & (1 << (row - col + board.length - 1))) == 0)
				) {
				board[row][col] = true;
				cols ^= (1 << col);
				ndiag ^= (1 << (row + col));
				rdiag ^= (1 << (row - col + board.length - 1));
				solution(board, row + 1, cols, ndiag, rdiag, asf + row + "-" + col +", ");
				board[row][col] = false;
				cols ^= (1 << col);
				ndiag ^= (1 << (row + col));
				rdiag ^= (1 << (row - col + board.length - 1));
			}
		}
	}

	public static void solution_2(boolean[][] chess, int i, int cols, int ndiag, int rdiag, String asf) {
		if( i == chess.length ) {
			System.out.println(asf + ".");
			return;
		}
		for(int j = 0; j < chess.length; j++) {
			if( chess[i][j] == false &&
				((cols & (1 << j)) == 0) && 
				 ((ndiag & (1 << (i + j))) == 0) && 
				 ((rdiag & (1 << (i - j + chess.length - 1))) == 0)
				) {
				chess[i][j] = true;
				cols |= (1 << j);
				ndiag |= (1 << (i + j));
				rdiag |= (1 << (i - j + chess.length - 1));
				solution_2(chess, i + 1, cols, ndiag, rdiag, asf + i + "-" + j +", ");
				chess[i][j] = false;
				cols &= ~(1 << j);
				ndiag &= ~(1 << (i + j));
				rdiag &= ~(1 << (i - j + chess.length - 1));
			}
		} 
		
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		boolean[][] board = new boolean[n][n];
		int cols = 0;
		int ndiag = 0;
		int rdiag = 0;
		solution(board, 0, cols, ndiag, rdiag, "");
		scn.close();
	}
}
