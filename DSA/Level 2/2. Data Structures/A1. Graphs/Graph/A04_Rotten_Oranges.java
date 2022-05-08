/*
You are given an m * n matrix containing 0, 1 or 2 , where 0 represents an empty cell, 1 represents a fresh orange, 2 represents rotten orange. Every hour, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Print the minimum number of hours that must elapse until no cell has a fresh orange.

In case if all the oranges can't become rotten print -1
Input Format
First line contains two integers m and n.
Each of next m line contains n integers 0,1 or 2.
Output Format
Print minimum hours.
Constraints
1 <= m,n <= 1000
Sample Input
3 3
2 1 1
1 1 0
0 1 1
Sample Output
4


*/

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A04_Rotten_Oranges {
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}

		System.out.println(orangesRotting(arr));

	}

	public static class Pair {
		int i; // row
		int j; // col
		int t; // t time in sec

		Pair(){
			
		}
		
		Pair(int i, int j, int t) {
			this.i = i;
			this.j = j;
			this.t = t;
		}

	}

	public static int orangesRotting(int[][] grid) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		int fo = 0; // count of fresh oranges
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if( grid[i][j] == 2 ) {
					q.add(new Pair(i, j, 0));
				}
				else if( grid[i][j] == 1 ){
					fo++;
				}
			}
		}
		int time = 0;
		int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
		// apply pure BFS
		
		while( q.size() != 0 ) {
			// remove
			Pair rem = q.remove();
			time = Math.max(time, rem.t);
			
			// add unvisited and mark them as well
			for(int k = 0; k < 4; k++) {
				int ni = rem.i + dir[k][0];
				int nj = rem.j + dir[k][1];
				
				if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1) {
					q.add(new Pair(ni, nj, rem.t + 1));
					grid[ni][nj] = 2;
					fo--;
				}
			}
		}
		
		if(fo == 0) {
			return time;
		}
		
		return -1;

	}
}
