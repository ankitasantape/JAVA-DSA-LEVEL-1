/*
1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can 
     kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and 
     print all safe configurations of n-queens

Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit 
               of question is.

Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique and not test you.
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
package Recursion_Backtracking;

import java.util.Scanner;

public class A12_N_Queens_Branch_And_Bound {

	public static void main(String[] args) throws Exception {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    boolean[][] board = new boolean[n][n];
	    //write your code here
	    boolean[] cols = new boolean[n];
	    boolean[] ndiag = new boolean[2 * n - 1];
	    boolean[] revdiag = new boolean[2 * n - 1];
	    solve(board, 0, cols, ndiag, revdiag, "");
	    scn.close();
	    
	 }

	private static void solve(boolean[][] board, int row, boolean[] cols, boolean[] ndiag, boolean[] revdiag,
			String asf) {
		if(row == board.length) {
			System.out.println(asf + ".");
			return;
		}
		for(int col = 0; col < board[0].length; col++) {
			if( cols[col] == false && ndiag[row + col] == false && revdiag[row - col + board.length - 1] == false ) {
				board[row][col] = true;
				cols[col] = true;
				ndiag[row + col] = true;
				revdiag[row - col + board.length - 1] = true;
				solve(board, row + 1, cols, ndiag, revdiag, asf + row + "-" + col+",");
				board[row][col] = false;
				cols[col] = false;
				ndiag[row + col] = false;
				revdiag[row - col + board.length - 1] = false;
			}
		}
		
	}
	
} 
