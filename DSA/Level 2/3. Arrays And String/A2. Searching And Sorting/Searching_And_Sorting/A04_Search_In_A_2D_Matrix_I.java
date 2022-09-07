// Leetcode - 74: https://leetcode.com/problems/search-a-2d-matrix/
/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Approach:

We will use 2 level binary search.
1. To find potential row.
2. To find target in this potential row.

*/

package Searching_And_Sorting;

public class A04_Search_In_A_2D_Matrix_I {

	public static void main(String[] args) {
		int[][] mat = {{1,3,5,7},
		               {10,11,16,20},
		               {23,30,34,60}};
		
		int target = 3;
			
		System.out.println( searchMatrix(mat, target) );
	}

	// T : O(log (m*n))
    public static boolean searchMatrix(int[][] matrix, int target) {
    	int row = binarySearchRowSelect(matrix, target);
    	
    	boolean found = binarySearch(matrix, row, target);
		return found;
    }
    
    //  T : O(log m) , m - number of rows
	private static int binarySearchRowSelect(int[][] matrix, int target) {
		int n = matrix.length;
        int m = matrix[0].length;
    	int lo = 0;
        int hi = n-1;
        
        while(lo <= hi) {
        	int mid = (lo + hi)/2;
        	
        	if( matrix[mid][0] <= target && target <= matrix[mid][m-1] ) {
        		return mid; // pr -> potential row
        		
        	} else if( target < matrix[mid][0] ) {
        		hi = mid-1;
        	
        	} else {
        		lo = mid+1;
        	}
        }
        return -1;
	}

	// T : O(log n) , n - number of columns
	private static boolean binarySearch(int[][] matrix, int row, int tar) {
	    int lo = 0;
	    int hi = matrix[0].length-1;
		
		while(lo <= hi) {
			int mid = (lo + hi)/2;
			
			if( matrix[row][mid] == tar ) {
				return true;
		
			} else if( tar < matrix[row][mid] ) {
				hi = mid-1;
			
			} else {
				lo = mid+1;
			}
			
		}
		return false;
	}
}
