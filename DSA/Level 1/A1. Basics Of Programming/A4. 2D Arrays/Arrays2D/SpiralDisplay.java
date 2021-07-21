package Arrays2D;

/*
 1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a.
4. You are required to traverse and print the contents of the 2d array in form of a spiral.
Sample Input
3
5
11 12 13 14 15
21 22 23 24 25
31 32 33 34 35
Sample Output
11 21 31 32 33 34 35 25 15 14 13 12 22 23 24
 */
import java.util.Scanner;

public class SpiralDisplay {

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
		
		int cmin = 0, rmin = 0;
		int rmax = n-1, cmax = m-1;
		int counter = 0;
		
		while ( counter < n * m ) {
//			left boundry
			for (int row = rmin; row <= rmax; row++) {
				System.out.println(mat[row][cmin]);
				counter++;
			}
			cmin++;
//			bottom boundry
			for (int col = cmin; col <= cmax; col++) {
				System.out.println(mat[rmax][col]);
				counter++;
			}
			rmax--;
//			right boundry
			if (counter < n * m) {
				for (int row = rmax; row >= rmin; row--) {
					System.out.println(mat[row][cmax]);
					counter++;
				}
			}
			cmax--;
//			top boundry
			if (counter < n * m) {
				for (int col = cmax; col >= cmin; col--) {
					System.out.println(mat[rmin][col]);
					counter++;
				}
			}
			rmin++;
			
		}
		sc.close();
	}

}
