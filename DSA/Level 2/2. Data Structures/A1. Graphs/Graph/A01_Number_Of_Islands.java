/*

1. You are given a 2d array where 0's represent land and 1's represent water. 
     Assume every cell is linked to it's north, east, west and south cell.
2. You are required to find and count the number of islands.

Constraints
None
Sample Input
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0
Sample Output
3

*/

package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A01_Number_Of_Islands {
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[m][n];

		for (int i = 0; i < arr.length; i++) {
			String parts = br.readLine();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
			}
		}

		// write your code here
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == 0) {
					dfs(arr, i, j);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
//  Time Complexity: O(m * n)
	static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}}; // tldr
	
	public static void dfs(int[][] grid, int i, int j) {
		grid[i][j] = 1;
		
		for(int k = 0; k < 4; k++) {
			int ni = i + dir[k][0];
			int nj = j + dir[k][1];
			
			if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 0) {
				dfs(grid, ni, nj);
			}
		}
	}
	
	
	
}
