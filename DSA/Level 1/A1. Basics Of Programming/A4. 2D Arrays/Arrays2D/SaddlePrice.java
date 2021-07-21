package Arrays2D;

import java.util.Scanner;

/*
 * 1. You are given a square matrix of size 'n'. You are given n*n elements of the square matrix. 
2. You are required to find the saddle price of the given matrix and print the saddle price. 
3. The saddle price is defined as the least price in the row but the maximum price in the column of the matrix.
Input Format
A number n
e11
e12..
e21
e22..
.. n * n number of elements of array a
Output Format
Saddle point of the matrix if available or "Invalid input" if no saddle point is there.

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
41
 */

public class SaddlePrice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mat[][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		saddlePrice(mat,n,n);
		printSaddlePrice(mat, n, n);
		sc.close();
	}

	private static void saddlePrice(int[][] mat, int n, int m) {
		
		for(int row = 0; row < n; row++) {
//			1. Find min of every row and 
			int min = mat[row][0]; 
//			   also its column no
			int coln_minele = 0;
			for(int col = 1; col < m; col++) {
				
				if(mat[row][col] < min) {
					min = mat[row][col];
					coln_minele = col; 
				}
			}
//			2. Verification
			boolean flag = true;
			for(int k = 0; k < n; k++) {
				if (mat[k][coln_minele] > min) {
					flag = false;
					break;
				}
			}
			
			if(flag == true) {
				System.out.println(min);
				return;
			}
		}
		System.out.println("Invalid input");
	}
	
	 public static void printSaddlePrice(int mat[][], int n, int m){
	        
	        for(int row = 0; row < n; row++){
	            // 1. find min element in the row and it's corresponding column
	            // initially, assume first element in row as minimum
	            int min = mat[row][0];
	            int colno = 0;
	            
	            for(int col = 1; col < m; col++){
	                if(mat[row][col] < min){
	                    min = mat[row][col];
	                    colno  = col;
	                }
	            }
	            // 2. Verification - verify that does the min element is max element in column or not
	            boolean flag = true;
	            for(int k = 0; k < n; k++){
	                if(mat[k][colno] > min){
	                    flag = false;
	                    break;
	                }
	            }
	            
	            if (flag == true){
	                System.out.println(min);
	                return;
	            }
	        }
	        System.out.println("Invalid input");
	    }

}
