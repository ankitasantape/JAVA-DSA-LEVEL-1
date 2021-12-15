/*
1. You are given n number of domino shaped bipolar magnets.
2. You have to place these magnets in M*N following the conditions.
3. Conditions are -
   a. Each box of 1*2 or 2*1 can contain a magnet or can be empty.
   b. Empty box can be represented by X's and magnets are represented by + and 
    - sign.
   c. Digits along left and top side of the board represents the number of + in 
    corresponding rows and columns.
   d. Digits along right and bottom of the board represents the number of - in 
    corresponding rows and columns.
    e. -1 denotes that the corresponding row and column can have any number of 
    +  and - signs.
    f. No two adjacent cell can have the same sign.


Note -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number M
A number N
M*N characters containing only 'L', 'R', 'T' and 'B'.
(For 1*2 box 'L' represents left end and 'R' represents the right end)
(For 2*1 box 'T' represents top end and 'B' represents the right end)
N integers representing count of '+' along the top edge.
M integers representing count of '+' along the left edge.
M integers representing count of '-' along the right edge.
N integers representing count of '-' along the bottom edge.
Output Format

Constraints
2 <= M <= 10
2 <= N <= 10
Both M and N are not odd.
Sample Input
5 6
LRLRTT
LRLRBB
TTTTLR
BBBBTT
LRLRBB
1 -1 -1 2 1 -1
2 3 -1 -1 -1
-1 -1 -1 1 -1
2 -1 -1 2 -1 3
Sample Output
+ - + - X - 
- + - + X + 
X X + - + - 
X X - + X + 
- + X X X - 

*/

package Recursion_Backtracking;

import java.util.Arrays;
import java.util.Scanner;

// Not asked in OA and Interview
public class A43_Magnets {
    
	public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, char[][] ans,
			int row, int col) {

		if(col == arr[0].length) {
			col = 0;
			row++;
		}
		if(row == arr.length) {
			// agar sign(+ve) jyada hai expected no of sign se to isItSafe me check krte hai
			// agar sign(-ve) kam hai expected no of sign se to isAnsValid me check krenge
			
			if(isAnsValid(ans, top, left, right, bottom) == true) {
				return true;
			}
			return false;
		}
//		System.out.println(row + " " + col);
//		print(ans);
		if(arr[row][col] == 'L') {
			if ( isItSafe(ans, top, left, right, bottom, row, col, '+') && isItSafe(ans, top, left, right, bottom, row, col + 1, '-')) {
				ans[row][col] = '+';
				ans[row][col + 1] = '-';
				if( solution(arr, top, left, right, bottom, ans, row, col + 2) == true) {
					return true;
				}
				ans[row][col] = 'X';
				ans[row][col + 1] = 'X';
			}
			
            if ( isItSafe(ans, top, left, right, bottom, row, col, '-') && isItSafe(ans, top, left, right, bottom, row, col + 1, '+')) {
            	ans[row][col] = '-';
				ans[row][col + 1] = '+';
				if( solution(arr, top, left, right, bottom, ans, row, col + 2) == true) {
					return true;
				}
				ans[row][col] = 'X';
				ans[row][col + 1] = 'X';
			}
            
		}else if(arr[row][col] == 'T') {
            if ( isItSafe(ans, top, left, right, bottom, row, col, '+') && isItSafe(ans, top, left, right, bottom, row + 1, col, '-')) {
            	ans[row][col] = '+';
				ans[row + 1][col] = '-';
				if(solution(arr, top, left, right, bottom, ans, row, col + 1) == true) {
					return true;
				}
				ans[row][col] = 'X';
				ans[row + 1][col] = 'X';
			}
            
            if ( isItSafe(ans, top, left, right, bottom, row, col, '-') && isItSafe(ans, top, left, right, bottom, row + 1, col, '+')) {
            	ans[row][col] = '-';
            	ans[row + 1][col] = '+';
				if(solution(arr, top, left, right, bottom, ans, row, col + 1) == true) {
					return true;
				}
				ans[row][col] = 'X';
				ans[row + 1][col] = 'X';
			}
		}

		// no ki call
		boolean f2 = solution(arr, top, left, right, bottom, ans, row, col + 1);
		if (f2 == true) {
			return true;
		}
		return false;
	}

	private static boolean isAnsValid(char[][] ans, int[] top, int[] left, int[] right, int[] bottom) {
		
		// top
		// how many '+' sign should come in first row and column from 0 to m
		for(int i = 0; i < top.length; i++) {
			int cinc = countInCol(ans, top, '+', i);
			if(top[i] != -1 && top[i] != cinc) {
				return false;
			}
		}
		// left
		// how many '+' sign should come in first column and row from 0 to n
		for (int i = 0; i < left.length; i++) {
			int cinr = countInRow(ans, left, '+', i);
			if (left[i] != -1 && left[i] != cinr) {
				return false;
			}
		}
		// bottom
		// how many '-' sign should come in last row and col from 0 to m
		for (int i = 0; i < bottom.length; i++) {
			int cinc = countInCol(ans, bottom, '-', i);
			if (bottom[i] != -1 && bottom[i] != cinc) {
				return false;
			}
		}
		// right
		// how many '-' sign should come in last column and row from 0 to n
		for (int i = 0; i < right.length; i++) {
			int cinr = countInRow(ans, right, '-', i);
			if (right[i] != -1 && right[i] != cinr) {
				return false;
			}
		}
		return true;
	}

	private static boolean isItSafe(char[][] ans, int[] top, int[] left, int[] right, int[] bottom, int row, int col,
			char sign) {
		if( (col - 1 >= 0  && ans[row][col - 1] == sign ) 
				|| (row - 1 >= 0 && ans[row - 1][col] == sign) 
				|| (col + 1 < ans[0].length && ans[row][col + 1] == sign )) {
			return false;
		}
		if(sign == '+') {
			// count in row
			int cinr = countInRow(ans, left, sign, row);
			// count in col
			int cinc = countInCol(ans, top, sign, col); 
			
			if (left[row] != -1 && cinr >= left[row]) {
				return false;
			}
			
			if (top[col] != -1 && cinc >= top[col]) {
				return false;
			}
		
		} else {
			int cinr = countInRow(ans, right, sign, row);
			int cinc = countInCol(ans, bottom, sign, col);
			
			if (right[row] != -1 && cinr >= right[row]) {
				return false;
			}
			if (bottom[col] != -1 && cinc >= bottom[col]) {
				return false;
			}
		}
		
		return true;
	}

	private static int countInRow(char[][] ans, int[] arr, char sign, int rowno) {
		int counter = 0;
		for (int col = 0; col < ans[0].length; col++) {
			if(ans[rowno][col] == sign) {
				counter++;
			}
		}
		return counter;
	}
    private static int countInCol(char[][] ans, int[] arr, char sign, int colno) {
    	int counter = 0;
		for (int row = 0; row < ans.length; row++) {
			if(ans[row][colno] == sign) {
				counter++;
			}
		}
		return counter;
	}

	public static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		char[][] arr = new char[m][n];
		for (int i = 0; i < arr.length; i++) {
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int[] top = new int[n];
		for (int i = 0; i < n; i++) {
			top[i] = scn.nextInt();
		}
		int[] left = new int[m];
		for (int i = 0; i < m; i++) {
			left[i] = scn.nextInt();
		}
		int[] right = new int[m];
		for (int i = 0; i < m; i++) {
			right[i] = scn.nextInt();
		}
		int[] bottom = new int[n];
		for (int i = 0; i < n; i++) {
			bottom[i] = scn.nextInt();
		}
		char[][] ans = new char[m][n];
		for(char[] a: ans) {
			Arrays.fill(a, 'X');
		}
        boolean isValid = solution(arr, top, left, right, bottom, ans, 0, 0);
        if( isValid == true ) {
        	print(ans);
        } else {
        	System.out.println("No Solution");
        }
		
		scn.close();
	}
}
