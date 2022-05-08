/*
In a given 2D binary array grid, there are two islands. Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
Return the smallest number of 0s that must be flipped. (It is guaranteed that the answer is at least 1.)
Input Format
First line contains an integer n.
Each of next n lines contain n numbers containing either 0 or 1.
Output Format
Return the smallest number of 0s that must be flipped.
Constraints
1<= n <= 1000
Sample Input
3
0 1 0
0 0 0
1 1 1
Sample Output
1

*/

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A07_Shortest_Bridge {
  
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] st = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}

		System.out.println(shortestBridge(arr));
	}
	
	public static class Pair{
		int i;
		int j;
		int level;
		
		Pair(){
			
		}
		Pair(int i, int j, int level){
			this.i = i;
			this.j = j;
			this.level = level;
		}
	}

	public static int shortestBridge(int[][] grid) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		boolean flag = true;
		
		for(int i=0; i < grid.length && flag; i++) {
			for(int j=0; j < grid[0].length && flag; j++) {
				if(grid[i][j] == 1) {
					dfs(grid, i, j, q);
					flag = false;
				}
			}
		}
		
		int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
		
		while(q.size() > 0) {
			Pair rem = q.remove();
			
			for(int k = 0; k < 4; k++) {
				int ni = rem.i + dir[k][0];
				int nj = rem.j + dir[k][1];
				
				if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length) {
					 if(grid[ni][nj] == 0) {
						 q.add(new Pair(ni, nj, rem.level + 1));  
						 grid[ni][nj] = 2;
					 }
					 else if(grid[ni][nj] == 1) {
						 return rem.level;
					 }
				}
			}
		}
		return -1;
	}

	private static void dfs(int[][] grid, int i, int j, ArrayDeque<Pair> q) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
			return;
		}
		
		grid[i][j] = 2;
		q.add(new Pair(i, j, 0));
		
		
		dfs(grid, i-1, j, q);
		dfs(grid, i, j-1, q);
		dfs(grid, i+1, j, q);
		dfs(grid, i, j+1, q);
	}
}
