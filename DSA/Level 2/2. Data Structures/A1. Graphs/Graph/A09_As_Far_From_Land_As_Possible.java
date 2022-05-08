/*
Given an n*n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
Input Format
First line contains an integer n.
Each of next n lines contain n numbers containing either 0 or 1.
Output Format
Print a 2d matrix where each box contains distance to its nearest 0.
Constraints
1<= n <= 1000
Sample Input
3
0 0 0
0 1 1
1 1 1
Sample Output
2

*/

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A09_As_Far_From_Land_As_Possible {
	private static class Pair {
		int i;
		int j;
		int dist;

		Pair(int i, int j, int dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
	}

	private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

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

		System.out.println(maxDistance(arr));

	}

	public static int maxDistance(int[][] grid) {
		int n = grid.length;
        int m = grid[0].length;
        
        int[][] ans = new int[n][m];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
       	 for(int j = 0; j < m; j++) {
       		 if(grid[i][j] != 1) {
       			 ans[i][j] = -1; // not solved yet
       		 }
       		 else {
       			 q.add(new Pair(i, j, 0));
       		 }
       	 }
        }
		int max = -1;
		//bfs
       while(q.size() > 0) {
       	 Pair rem = q.remove();
       	 
       	 for(int k = 0; k < 4; k++) {
       		 int ni = rem.i + dirs[k][0];
       		 int nj = rem.j + dirs[k][1];
       		 
       		 if(ni >= 0 && ni < n && nj >= 0 && nj < m && ans[ni][nj] == -1) {
       			 q.add(new Pair(ni, nj, rem.dist + 1));
       			 ans[ni][nj] = rem.dist + 1;
       			 max = Math.max(max, ans[ni][nj]);
       		 }
       	 }
        }
	    return max;
	}
}
