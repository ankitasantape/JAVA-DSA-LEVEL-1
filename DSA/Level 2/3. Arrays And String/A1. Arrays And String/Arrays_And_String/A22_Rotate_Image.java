/*
Link: https://leetcode.com/problems/rotate-image/

You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Input: matrix = 
[[1,2,3],
 [4,5,6],
 [7,8,9]]
Output: 
[[7,4,1],
 [8,5,2],
 [9,6,3]]

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


*/

package Arrays_And_String;

public class A22_Rotate_Image {

    private static void transpose(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
    private static void reflect(int[][] matrix) {
		
    	int n = matrix.length;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n/2; j++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[i][n - j - 1];
    			matrix[i][n - j - 1] = temp;
    		}
    	}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		
		transpose(matrix);
		reflect(matrix);
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
