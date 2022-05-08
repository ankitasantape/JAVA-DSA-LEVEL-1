/*
You are given an m * n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell. A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
Input Format
First line contains two integers m and n.
Each of next m line contains n integers 0 or 1.
Output Format
Print number of enclaves

Constraints
1 <= m,n <= 1000
Sample Input
4 4
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0
Sample Output
3

*/

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A03_Number_Of_Enclaves {
   
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] st = br.readLine().split(" ");
		int m = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);

		int[][] arr = new int[m][n];

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}

		System.out.println(numEnclaves(arr));

	}
//  Time Complexity: O(m * n)
	public static int numEnclaves(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				// boundry's wale 1 ko 0 kr do
				// boundry's wale 1 pe dfs laga do
				if((i == 0 || i == arr.length-1 || j == 0 || j == arr[0].length-1) && arr[i][j] == 1) {
					dfs(arr, i, j);
				}
			}
		}
		
		// remaining ones in the grid are enclaves
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 1) {
					count++;
				}
			}
		}
		
		return count;
	}

	private static void dfs(int[][] arr, int i, int j) {
		if( i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0 ) {
			return;
		}
		
		arr[i][j] = 0;
		//top
		dfs(arr, i-1, j);
		
		//left
		dfs(arr, i, j-1);
		
		//down
		dfs(arr, i+1, j);
		
		//right
		dfs(arr, i, j+1);
	
	}
}
