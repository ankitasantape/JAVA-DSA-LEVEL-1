/*
Link: https://www.geeksforgeeks.org/count-zeros-in-a-row-wise-and-column-wise-sorted-matrix/



*/

package Searching_And_Sorting;

public class A26_Count_Zeros_In_A_Sorted_Matrix {

	public static int countZeros(int[][] mat) {
		int n = mat.length;
		int i = 0;
		int j = n-1;
		
		int cz = 0;
		
		while(i < n && j >= 0) {
			if( mat[i][j] == 1 ) {
				j--;
			}
			else {
				// add number of zeroes in that row
				cz += (j+1);
				i++;
			}
		}
		
		return cz;
	}
	
	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 1 },
                { 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1 } };
		System.out.println( countZeros(mat) ); // Ans: 8
		
	}

}
