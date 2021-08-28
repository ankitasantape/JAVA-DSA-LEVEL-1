package Dynamic_Programming;

import java.util.Scanner;

/*
 1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from 
     any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
An integer representing Maximum gold available.
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
33
 */
public class Goldmine {
    
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println(goldmine_dp(a, n, m));

		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, goldmine_rec(a, i, 0));
		}
		System.out.println(max);

		int dp[][] = new int[n][m];
		max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, goldmine_rec(a, i, 0));
		}

		System.out.println(goldmine_memo(a, n, m, dp));
		sc.close();
	 }
	
	private static int goldmine_rec(int[][] a, int sr, int sc) {
//		negative base case
		if(sr < 0 || sr >= a.length) {
			return Integer.MIN_VALUE;
		}
//		positive base case
		if(sc == a[0].length - 1) {
			return a[sr][sc];
		}
		
		int f1 = goldmine_rec(a, sr + 1, sc + 1);
		int f2 = goldmine_rec(a, sr, sc + 1);
		int f3 = goldmine_rec(a, sr - 1, sc + 1);
		int max = Math.max(Math.max(f2, f3),f1) + a[sr][sc];
		
		return max;
	}
	
	private static int goldmine_memo(int[][] a, int sr, int sc, int dp[][]) {
		if(sr < 0 || sr >= a.length) {
			return Integer.MIN_VALUE;
		}
//		positive base case
		if(sc == a[0].length - 1) {
			dp[sr][sc] = a[sr][sc];
			return dp[sr][sc];
		}
		
		if(dp[sr][sc] != 0) {
			return dp[sr][sc];
		}
		
		int f1 = goldmine_rec(a, sr + 1, sc + 1);
		int f2 = goldmine_rec(a, sr, sc + 1);
		int f3 = goldmine_rec(a, sr - 1, sc + 1);
		int max = Math.max(Math.max(f2, f3),f1) + a[sr][sc];
		dp[sr][sc] = max;
		return max;
	}	
	private static int goldmine_dp(int[][] a, int n, int m) {
		
        int dp[][] = new int[n][m];
		
		for(int j = m-1; j >= 0; j--) {
			for(int i = 0; i < n; i++) {
				if(j == m-1) {
					dp[i][j] = a[i][j];
				} else if(i == 0) {
					dp[i][j] = Math.max(dp[i][j+1], dp[i + 1][j + 1]) + a[i][j];
				} else if(i == n-1) {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j + 1]) + a[i][j];
				} else {
					dp[i][j] = Math.max(Math.max(dp[i+1][j + 1], dp[i - 1][j + 1]), dp[i][j + 1]) + a[i][j];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			if ( dp[i][0] > max) {
				max = dp[i][0];
			}
		}
//		System.out.println(max);
//		for(int i = 0; i < n; i++) {
//		   for(int j = 0; j < m; j++) {
//			   System.out.print(dp[i][j] + " ");
//		   }
//		   System.out.println();
//	    }
		return max;
	}
}
