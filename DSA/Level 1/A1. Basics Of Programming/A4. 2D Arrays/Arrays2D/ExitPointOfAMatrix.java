package Arrays2D;

import java.util.Scanner;

/*
 1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers (1's and 0's), representing elements of 2d array a.
4. Consider this array a maze and a player enters from top-left corner in east direction.
5. The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
6. You are required to print the indices in (row, col) format of the point from where you exit the matrix.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
row
col (of the point of exit)
Sample Input
4
4
0 0 1 0
1 0 0 0
0 0 0 0
1 0 1 0
Sample Output
1
3

Sample Input
4
4
0 0 0 1
0 0 0 0
1 0 0 0
1 0 0 1
Sample Output
2
3
 */

public class ExitPointOfAMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int mat[][] = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		exitPointOfAMatrix(mat, n, m);
		sc.close();
	}

	private static void exitPointOfAMatrix(int[][] mat, int n, int m) {
		int dir = 0;
		int row = 0, col = 0;
		
		while(true) {
			dir = (dir + mat[row][col]) % 4;
			
			if (dir == 0) { // east
//				System.out.println("East "+row +" "+ col );
				col++;
			} else if (dir == 1) { // south
//				System.out.println("South "+row +" "+ col );
				row++;
			} else if (dir == 2) { // west
//				System.out.println("West "+row +" "+ col );
				col--;
			} else if (dir == 3) { // north
//				System.out.println("North "+row +" "+ col );
				row--;
			}
			
//			base case
			if (row < 0) {
//				System.out.println(row );
				row++;
				break;
			} else if (col < 0) {
//				System.out.println(col );
				col++;
				break;
			} else if (row == n) {
//				System.out.println(row);
				row--;
				break;
			} else if (col == m) {
//				System.out.println(col );
				col--;
				break;
			}
		}
		
		System.out.println(row);
		System.out.println(col);
	}

}
