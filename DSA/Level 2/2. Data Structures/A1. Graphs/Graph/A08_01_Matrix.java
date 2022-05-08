/*
Given an m*n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Input Format
First line contains two integers n and m.
Each of next n lines contain m numbers containing either 0 or 1.
Output Format
print a 2d matrix where each box contains distance to its nearest 0.

Constraints
1<= n <= 1000
1<= e <= n*(n-1)/2
Sample Input
3 3
0 0 0
0 1 1
1 1 1
Sample Output
0 0 0 
0 1 1 
1 2 2 
*/

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A08_01_Matrix {
   
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

		int[][] ans = updateMatrix(arr);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static int[][] updateMatrix(int[][] matrix) {
         int n = matrix.length;
         int m = matrix[0].length;
         
         int[][] ans = new int[n][m];
         ArrayDeque<Pair> q = new ArrayDeque<>();
         
         for(int i = 0; i < n; i++) {
        	 for(int j = 0; j < m; j++) {
        		 if(matrix[i][j] != 0) {
        			 ans[i][j] = -1; // not solved yet
        		 }
        		 else {
        			 q.add(new Pair(i, j, 0));
        		 }
        	 }
         }
		
       
		//bfs
        while(q.size() > 0) {
        	 Pair rem = q.remove();
        	 
        	 for(int k = 0; k < 4; k++) {
        		 int ni = rem.i + dirs[k][0];
        		 int nj = rem.j + dirs[k][1];
        		 
        		 if(ni >= 0 && ni < n && nj >= 0 && nj < m && ans[ni][nj] == -1) {
        			 q.add(new Pair(ni, nj, rem.dist + 1));
        			 ans[ni][nj] = rem.dist + 1;
        		 }
        	 }
         }
	     return ans;
	}
}
