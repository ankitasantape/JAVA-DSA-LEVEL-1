package Arrays2D;

/*
 * 1. You are given a number n, representing the number of rows and number of columns.
2. You are given n*n numbers, representing elements of 2d array a.
3. You are required to rotate the matrix by 90 degree clockwise and then display the contents using display function.
*Note - you are required to do it in-place i.e. no extra space should be used to achieve it .*
Input Format
A number n
e11
e12..
e21
e22..
.. n * n number of elements
Output Format
output is taken care of by display function
Sample Input
4
11
12
13
14
21
22
23
24
31
32
33
34
41
42
43
44
Sample Output
41 31 21 11
42 32 22 12
43 33 23 13
44 34 24 14

 */

import java.util.Scanner;

public class RotateMatrixBy90Degree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mat[][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		rotateMatrixBy90Degree(mat,n,n);
		sc.close();
	}

	private static void rotateMatrixBy90Degree(int[][] mat, int n, int m) {
		TransposeOfAMat(mat,n,m);
		swapColumn(mat,n,m);
		display(mat);
	}

	private static void swapColumn(int[][] mat, int n, int m) {
		  int cmin = 0, cmax = m-1;
		  while(cmin < cmax) {
			  for(int row = 0; row < n; row++) {
				  int temp = mat[row][cmin];
				  mat[row][cmin] = mat[row][cmax];
				  mat[row][cmax] = temp;
				  
				  
			  }
			  cmin++;
			  cmax--;
		  }
	}

	private static void TransposeOfAMat(int[][] mat, int n, int m) {
		for(int row = 0; row < n; row++) {
			for (int col = row; col < m; col++) {
				if(row != col) {
					int temp = mat[row][col];
					mat[row][col] = mat[col][row];
					mat[col][row] = temp;
				}
			}
		}
	}

	public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
