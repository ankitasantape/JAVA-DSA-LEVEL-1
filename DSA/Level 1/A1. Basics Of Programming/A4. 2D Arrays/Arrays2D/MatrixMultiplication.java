package Arrays2D;

import java.util.Scanner;
/*
 1. You are given a number n1, representing the number of rows of 1st matrix.
2. You are given a number m1, representing the number of columns of 1st matrix.
3. You are given n1*m1 numbers, representing elements of 2d array a1.
4. You are given a number n2, representing the number of rows of 2nd matrix.
5. You are given a number m2, representing the number of columns of 2nd matrix.
6. You are given n2*m2 numbers, representing elements of 2d array a2.
7. If the two arrays representing two matrices of dimensions n1 * m1 and n2 * m2 can be multiplied, display the contents of prd array as specified in output Format.
8. If the two arrays can't be multiplied, print "Invalid input".
Input Format
A number n1
A number m1
e11
e12..
e21
e22..
.. n1 * m1 number of elements of array a1
A number n2
A number m2
e11'
e12'..
e21'
e22'..
.. n2 * m2 number of elements of array a2
Output Format
e11' e12' e13' ..
e21' e22' e23' ..
.. elements of prd array
Sample Input
2
3
10
0
0
0
20
0
3
4
1
0
1
0
0
1
1
2
1
1
0
0
Sample Output
10 0 10 0
0 20 20 40
 */
public class MatrixMultiplication {

	public static void main(String[] args) {
		  
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int m1 = sc.nextInt();
		int mat1[][] = new int[n1][m1];
		
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < m1; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}
		
		int n2 = sc.nextInt();
		int m2 = sc.nextInt();
		int mat2[][] = new int[n2][m2];
		
		for (int i = 0; i < n2; i++) {
			for (int j = 0; j < m2; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}
		
		matrixMultipication(mat1,n1,m1,mat2,n2,m2);
		
		sc.close();
	}

	private static void matrixMultipication(int[][] mat1, int n1, int m1, int[][] mat2, int n2, int m2) {
		
		if (m1 != n2) {
			System.out.println("Invalid input");
		}
		
		int res[][] = new int[n1][m2];
		
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++ ) {
				for (int k = 0; k < m1; k++) {
					res[i][j] += mat1[i][k] * mat2[k][j];
				}
			}
		}
		display(res);
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
