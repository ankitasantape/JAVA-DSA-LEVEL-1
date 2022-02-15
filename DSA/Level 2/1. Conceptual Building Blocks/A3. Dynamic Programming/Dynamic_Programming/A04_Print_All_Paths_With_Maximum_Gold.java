/*

 1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
8. Also, you have to print all paths with maximum gold.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000
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
4 d3 d1 d2 d3 d1 
 
*/

package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A04_Print_All_Paths_With_Maximum_Gold {
     
	private static class Pair {
		String psf;
		int i;
		int j;

		public Pair(String psf, int i, int j) {
			this.psf = psf;
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(str.split(" ")[j]);
			}
		}
		
		int dp[][] = new int[arr.length][arr[0].length];
		
		for(int j = arr[0].length - 1; j >= 0; j--) {
			for(int i = 0; i < arr.length; i++) {
				if(j == arr[0].length - 1) {
					dp[i][j] = arr[i][j];
				}  else if(i == 0) {
					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
				}  else if(i == arr.length - 1) {
					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
				} else {
					dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
				}
			}
		}
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
        	max = Math.max(max, dp[i][0]);
        }
        System.out.println(max);
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        for (int i = 0; i < dp.length; i++) {
        	if(dp[i][0] == max) {
        		queue.add(new Pair(i + "", i, 0));
        	}
        }
        
        while (queue.size() != 0) {
        	Pair rp = queue.removeFirst();
        	
        	if(rp.j == arr[0].length - 1) {
        		System.out.println(rp.psf);
        	} else if (rp.i == 0) { // first row
        		int g = Math.max(dp[rp.i][rp.j + 1], dp[rp.i + 1][rp.j + 1]);
                
        		if(g == dp[rp.i][rp.j + 1]) {
        			queue.add(new Pair(rp.psf + " d2", rp.i, rp.j + 1));
        		}
        		
        		if(g == dp[rp.i + 1][rp.j + 1]) {
        			queue.add(new Pair(rp.psf + " d3", rp.i + 1, rp.j + 1));
        		}
        		
        	} else if (rp.i == arr.length - 1) { // last row
                int g = Math.max(dp[rp.i][rp.j + 1], dp[rp.i - 1][rp.j + 1]);
                
        		if(g == dp[rp.i][rp.j + 1]) {
        			queue.add(new Pair(rp.psf + " d2", rp.i, rp.j + 1));
        		}
        		
        		if(g == dp[rp.i - 1][rp.j + 1]) {
        			queue.add(new Pair(rp.psf + " d1", rp.i - 1, rp.j + 1));
        		}
        		
        	} else {
                int g = Math.max(dp[rp.i][rp.j + 1], Math.max( dp[rp.i - 1][rp.j + 1], dp[rp.i + 1][rp.j + 1]));
                
                if(g == dp[rp.i - 1][rp.j + 1]) {
        			queue.add(new Pair(rp.psf + " d1", rp.i - 1, rp.j + 1));
        		}
                
        		if(g == dp[rp.i][rp.j + 1]) {
        			queue.add(new Pair(rp.psf + " d2", rp.i, rp.j + 1));
        		}
        		
        		if(g == dp[rp.i + 1][rp.j + 1]) {
        			queue.add(new Pair(rp.psf + " d3", rp.i + 1, rp.j + 1));
        		}
        	}
        	
        }
	}
	
}
