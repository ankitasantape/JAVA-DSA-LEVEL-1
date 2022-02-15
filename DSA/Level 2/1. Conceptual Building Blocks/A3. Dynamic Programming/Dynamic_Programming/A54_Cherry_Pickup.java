/*
1. You are given a number N, which represents the rows and columns of a 2-D matrix.
2. Matrix contains only three values - 
   a. Cell is empty.
   b. Cell contains a cherry.
   c. Cell contains a thorn and you can not pass through this cell.
3. You have to find the maximum number of cherries that you can collect following these rules :
   a. You have to start from (0,0) and travel till (N-1,N-1) by moving right or down, 
    one step at a time.
   b. After reaching (N-1,N-1), you have to come back to (0,0) by moving left or up, 
    one step at a time.   

Note -> If there is no valid path between the top-left cell and bottom-right cell, then no cherries can be collected.
Input Format
A number N
arr1
arr2... (N*N numbers).
Output Format

Constraints
1 <= N <= 50
Cells can have only three values 0,1 and -1.
Sample Input
3
0 
1 
-1
1 
0
-1
1 
1  
1
Sample Output
5

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A54_Cherry_Pickup {
   
	public static int maxcc = 0;
	
	// can we reduce this space of 4d array
	public static int Solution(int r1, int c1, int r2, int c2, int[][] arr, int[][][][] dp) {
		if (r1 >= arr.length || r2 >= arr.length || c2 >= arr[0].length || c1 >= arr[0].length || arr[r1][c1] == -1 || arr[r2][c2] == -1) {
			return Integer.MIN_VALUE;
		}
		// if p1 and p2 reach destination
		if(r1 == arr.length -1  && c1 == arr[0].length - 1) {
			return arr[r1][c1];
		}
		
		if(dp[r1][c1][r2][c2] != 0) {
			return dp[r1][c1][r2][c2];
		}
		
        int cherries = 0;
        if(r1 == r2 && c1 == c2) {
        	cherries += arr[r1][c1];
        } else {
        	cherries += arr[r1][c1] + arr[r2][c2];
        }
        
        // explore four ways
        int f1 = Solution(r1, c1 + 1, r2, c2 + 1, arr, dp); // h, h
        int f2 = Solution(r1 + 1, c1, r2, c2 + 1, arr, dp); // v, h
        int f3 = Solution(r1 + 1, c1, r2 + 1, c2, arr, dp); // v, v
        int f4 = Solution(r1, c1 + 1, r2 + 1, c2, arr, dp); // h, v

        cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
        dp[r1][c1][r2][c2] = cherries;
        
		return cherries;
	}
	
	public static void solution_Backtrack(int row, int col, int[][] arr, int ccsf) {
		if(row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] == -1) {
			return ;
		}
		
		if(row == arr.length-1 && col == arr[0].length-1) {
			solution_Backtrack_helper(row, col, arr, ccsf);
		}
		
		int cherries = arr[row][col];
		arr[row][col] = 0;
		solution_Backtrack(row, col + 1, arr, ccsf + cherries);
		solution_Backtrack(row + 1, col, arr, ccsf + cherries);
		arr[row][col] = cherries;
	}
	
    public static void solution_Backtrack_helper(int row, int col, int[][] arr, int ccsf) {
    	if(row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] == -1) {
			return ;
		}
		
		if(row == 0 && col == 0) {
			maxcc = Math.max(maxcc, ccsf);
			return;
		}
		
		int cherries = arr[row][col];
		arr[row][col] = 0;
		solution_Backtrack_helper(row, col - 1, arr, ccsf + cherries);
		solution_Backtrack_helper(row - 1, col, arr, ccsf + cherries);
		arr[row][col] = cherries;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0 ; j < n; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		solution_Backtrack(0, 0, arr, 0);
		System.out.println(maxcc);
		int ans = Math.max(0,Solution(0, 0, 0, 0, arr, new int[n][n][n][n]));
		System.out.println(ans);
		int ans2 = Math.max(0,Solution2(0, 0, 0, arr, new int[n][n][n]));
		System.out.println(ans2);
		int ans3 = Math.max(0,Solution3(arr));
		System.out.println(ans3);
		scn.close();
	}

	private static int Solution3(int[][] arr) {
		int n = arr.length;
		int[][][] dp = new int[n][n][n];
		
		int cherries = 0;
		for(int r1 = 0, r2 = 0; r1 < dp.length && r2 < dp.length; r1++, r2++) {
			for(int c1 = 0, c2 = r1 + c1 - r2; c1 < dp[0].length && c2 < dp[0].length; c1++, c2++) {
				if( arr[r1][c1] == -1 || arr[r2][c2] == -1 ) {
					dp[r1][c1][r2] = 0;
				} else if(r1 == arr.length - 1  && c1 == arr[0].length - 1) {
					dp[r1][c1][r2] = arr[r1][c1];
				} else {
					if (r1 == r2 && c1 == c2) {
						cherries += arr[r1][c1];
					} else {
						cherries += arr[r1][c1] + arr[r2][c2];
					}

					int f1 = dp[r1][c1 + 1][r2]; // h, h
					int f2 = dp[r1 + 1][c1][r2]; // v, h
					int f3 = dp[r1 + 1][c1][r2 + 1]; // v, v
					int f4 = dp[r1][c1 + 1][r2 + 1]; // h, v
					cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
					dp[r1][c1][r2] = cherries;
				}
			}
		}
		return cherries;
	}

	private static int Solution2(int r1, int c1, int r2, int[][] arr, int[][][] dp) {
		int c2 = r1 + c1 - r2;
		if (r1 >= arr.length || r2 >= arr.length || c2 >= arr[0].length || c1 >= arr[0].length || arr[r1][c1] == -1 || arr[r2][c2] == -1) {
			return Integer.MIN_VALUE;
		}
		// if p1 and p2 reach destination
		if(r1 == arr.length - 1  && c1 == arr[0].length - 1) {
			return arr[r1][c1];
		}
		
		if(dp[r1][c1][r2] != 0) {
			return dp[r1][c1][r2];
		}
		
        int cherries = 0;
        if(r1 == r2 && c1 == c2) {
        	cherries += arr[r1][c1];
        } else {
        	cherries += arr[r1][c1] + arr[r2][c2];
        }
        
        // explore four ways
        int f1 = Solution2(r1, c1 + 1, r2, arr, dp); // h, h
        int f2 = Solution2(r1 + 1, c1, r2, arr, dp); // v, h
        int f3 = Solution2(r1 + 1, c1, r2 + 1, arr, dp); // v, v
        int f4 = Solution2(r1, c1 + 1, r2 + 1, arr, dp); // h, v

        cherries += Math.max(Math.max(f1, f2), Math.max(f3, f4));
        dp[r1][c1][r2] = cherries;
        
		return cherries;
	}
	
	
}
