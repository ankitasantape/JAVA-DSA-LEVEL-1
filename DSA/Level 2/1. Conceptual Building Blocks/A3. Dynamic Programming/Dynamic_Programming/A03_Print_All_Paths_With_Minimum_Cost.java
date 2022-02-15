/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
7. You are required to traverse through the matrix and print the cost of the path which is least costly.
8. Also, you have to print all the paths with minimum cost.
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
23
HVVHHVHVHV
HVVHHVHHVV

*/

package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A03_Print_All_Paths_With_Minimum_Cost {
     
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
	      
	      for(int i = dp.length - 1; i >= 0; i--) {
	    	  for(int j = dp[0].length - 1; j >= 0; j--) {
	    		  // if last row and col then put as it is value of arr[i][j] into dp[i][j]
	    		  if ( i == dp.length - 1 && j == dp[0].length - 1) {
	    			  dp[i][j] = arr[i][j];
	    		  } else if ( i == dp.length - 1 ){
	    			  dp[i][j] = dp[i][j + 1] + arr[i][j];
	    		  } else if ( j == dp[0].length - 1 ) {
	    			  dp[i][j] = dp[i + 1][j] + arr[i][j];
	    		  } else {
	    			  dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j]; 
	    		  }
	    	  }
	      }
	      System.out.println(dp[0][0]);
	      
	      ArrayDeque<Pair> queue = new ArrayDeque<>();
	      queue.add(new Pair( "", 0, 0 ));
	      while(queue.size() != 0) {
	    	  Pair rp = queue.removeFirst();
	    	  
	    	  if (rp.i == dp.length - 1 && rp.j == dp[0].length - 1) {
	    		  System.out.println(rp.psf);
	    	  } else if ( rp.i == dp.length - 1) {
	    		  queue.add(new Pair( rp.psf + "H", rp.i, rp.j + 1 ));
	    	  } else if ( rp.j == dp[0].length - 1 ) {
	    		  queue.add(new Pair( rp.psf + "V", rp.i + 1, rp.j ));
	    	  } else {
	    		  // horizontal small value
	    		  if ( dp[rp.i][rp.j + 1] < dp[rp.i + 1][rp.j] ) {
	    			  queue.add(new Pair( rp.psf + "H", rp.i, rp.j + 1 ));
	    		 // vertical small value
	    		  }  else if ( dp[rp.i][rp.j + 1] > dp[rp.i + 1][rp.j] ) {
	    			  queue.add(new Pair( rp.psf + "V", rp.i + 1, rp.j ));
	    		  } else {
	    			  queue.add(new Pair( rp.psf + "V", rp.i + 1, rp.j ));
	    			  queue.add(new Pair( rp.psf + "H", rp.i, rp.j + 1 ));
	    			 
	    		  }
	    	  }
	      }
	      
	      
	   }
}
