/*
1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

Assumption -> The given Sudoku puzzle will have a single unique solution.
Input Format
9*9 integers ranging from 1 to 9.
0 represents an empty cell.
Output Format
You have to print the solved sudoku.

Constraints
0 <= arr[i][j] <= 9
Sample Input
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
Sample Output
3 1 6 5 7 8 4 9 2 
5 2 9 1 3 4 7 6 8 
4 8 7 6 2 9 5 3 1 
2 6 3 4 1 5 9 8 7 
9 7 4 8 6 3 1 2 5 
8 5 1 7 9 2 6 4 3 
1 3 8 9 4 7 2 5 6 
6 9 2 3 5 1 8 7 4 
7 4 5 2 8 6 3 1 9 
*/
package Recursion_Backtracking;

import java.util.Scanner;

public class A35_Solve_Sudoku {
   
	public static void display(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void solveSudoku(int[][] board, int i, int j) {
		
		if(i == board.length) {
			display(board);
			return;
		}
		
		int ni = 0;  // new row
		int nj = 0; // new col
		
		if(j == board[0].length - 1) {
			ni = i + 1;
			nj = 0;
		} else {
			ni = i;
			nj = j + 1;
		}
		
		if(board[i][j] != 0) {
			solveSudoku(board, ni, nj);
		} else {
//			po - possible options are from 1 to 9
			for(int po = 1; po <= 9; po++) {
				if(isValid(board, i, j, po) == true) {
					board[i][j] = po;
					solveSudoku(board, ni, nj);
					board[i][j] = 0;
				}
			}
		}
	}

	private static boolean isValid(int[][] board, int row, int col, int val) {
//		check whether the val is present in col
		for(int j = 0; j < board[0].length; j++) {
			if(board[row][j] == val) {
				return false;
			}
		}
		
//		check whether the val is present in row
		for(int j = 0; j < board.length; j++) {
			if(board[j][col] == val) {
				return false;
			}
		}
		
//		check whether the val is present in submatrix
		int smi = (row / 3) * 3;
		int smj = (col / 3) * 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
			if(board[smi + i][smj + j] == val) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		solveSudoku(arr, 0, 0);
		scn.close();
	}
}
