// Link: https://leetcode.com/problems/search-a-2d-matrix-ii/

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. 
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Approach: Divide & Conquer, Binary Search 
 
Choose anyone corner top-right corner or bottom-left corner
target = 13
r = 0, c = 4
while(){
     if( mat[r][c] == target ){
         return true;
     
     } else if( target < mat[r][c] ){
         c--; // discard cth column
         
     } else {
         r++;
     }  
}
 

*/


package Searching_And_Sorting;

public class A05_Search_In_A_2D_Matrix_II {

	public static void main(String[] args) {
		int[][] mat = {{1,4,7,11},
	               {2,5,8,12,19},
	               {3,6,9,16,22},
	               {10,13,14,17,24},
	               {18,21,23,26,30}};
	
	    int target = 20; // false
		
	    System.out.println( searchMatrix(mat, target) );
	}

	// T : O(n+m) 
	private static boolean searchMatrix(int[][] mat, int target) {
		
		int r = 0;
		int c = mat[0].length-1;
	
		while(c >= 0 && r < mat.length) {
			if( mat[r][c] == target ) {
				return true;
			
			} else if( target < mat[r][c] ) {
				c--;
			
			} else {
				r++;
			
			}
			
		}
		
		return false;
	}

}
