/*
1. Pepcoder arranged some glasses in the form of pascal triangle.
2. Capacity of each glass is 1 litre. If you pour K amount of water in a glass, it will retain 1 litre and
   rest of it gets equally distributed in left bottom glass and right bottom glass.
3. If pepcoder pours K litres of water in the topmost glass, you have to find out the amount of water in Cth glass of Rth row.

Assumption -> There are enough glasses in the triangle till no glass overflows.
Input Format
A number K representing amount of water poured in topmost glass.
Two numbers R and C
Output Format
A number representing the amount of water present in Cth glass of Rth row.
Constraints
1 <= K <= 500
1 <= R,C <= K
Sample Input
3
1
0
Sample Output
1.0

Sample Input
3
1
1
Sample Output
1.0

Sample Input
25
7
5
Sample Output
0.34375
*/

package Dynamic_Programming;

import java.util.*;

public class A61_Find_Water_In_Glass {
   
	public static double solution1(int k, int r, int c) {
		double[][]dp = new double[k + 1][k + 1];
	    dp[0][0] = k;
	    for (int i = 0; i < dp.length; i++) {
	      for (int j = 0; j <= i; j++) {
	        if (dp[i][j] > 1.0) {
	          double spare = dp[i][j] - 1.0;
	          dp[i][j] = 1.0;
	          dp[i + 1][j] += spare / 2.0;
	          dp[i + 1][j + 1] += spare / 2.0;
	        }
	      }
	    }
	    return dp[r][c];
	}
	public static double solution2(int k, int r, int c) {
		double[][]dp = new double[r + 1][r + 1];
	    dp[0][0] = k;
	    for (int i = 0; i < dp.length; i++) {
	      for (int j = 0; j <= i; j++) {
	        if (dp[i][j] > 1.0) {
	          double spare = dp[i][j] - 1.0;
	          dp[i][j] = 1.0;
	          if(i + 1 < dp.length) {
	               dp[i + 1][j] += spare / 2.0;
	          }
	          if(i+1 < dp.length && j+1 < dp[0].length) {
	               dp[i + 1][j + 1] += spare / 2.0;
	          }
	        }
	      }
	    }
	    return dp[r][c];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int r = scn.nextInt();
		int c = scn.nextInt();
		System.out.println(solution1(k, r, c));
		System.out.println(solution2(k, r, c));
		scn.close();
	}

}
