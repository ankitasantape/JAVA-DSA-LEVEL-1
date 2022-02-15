/*
1. You are given two integers N and K. N represents the number of eggs and K represents the number of floors in a building.
2. You have to find the minimum number of attempts you need in order to find the critical floor in the worst case while using the best strategy.
3. The critical floor is defined as the lowest floor from which you drop an egg and it doesn't break. 
4. There are certain which you have to follow -
   a. All eggs are identical.
   b. An egg that survives a fall can be used again.
   c. A broken egg can't be used again.
   d. If the egg doesn't break at a certain floor, it will not break at any floor below.
   e. If the egg breaks at a certain floor, it will break at any floor above.
Input Format
Two integers N and K
Output Format

Constraints
1 <= N <= 100
1 <= k <= 50
Sample Input
3
10
Sample Output
4

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A52_Egg_Drop {
   
	public static int eggDropTab(int n, int k){
		int dp[][] = new int[n+1][k+1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 0; j < dp[0].length; j++) {
				if (i == 1) {
					dp[i][j] = j;
				} else if(j == 1){
				    dp[i][j] = 1;
				} else {
					int min = Integer.MAX_VALUE;
					int max = Integer.MIN_VALUE;
					for (int sij = 0, rej = j-1; sij < j && rej >= 0; sij++, rej--) {
						// dp[i][rej] -> egg survives
						// dp[i-1][sij] -> egg breaks
						max =Math.max(dp[i-1][sij], dp[i][rej]);
						min = Math.min(min, max);
					}
					dp[i][j] = min + 1;
				}
			}
		}
		
		return dp[n][k];
	} 

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//n -> number of eggs and k -> number of floors
		int n = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(SuperEggDropRec(k,n));
		System.out.println(SuperEggDropMemo(k, n, new int[k + 1][n + 1]));
		System.out.println(SuperEggDropTab(k,n));
		System.out.println(eggDropTab(n,k));
		System.out.println(eggDropTab_Optimized(n,k));
		scn.close();
	}

	private static int eggDropTab_Optimized(int n, int k) {
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				int esurvive = dp[i - 1][j];
				int ebreak = dp[i - 1][j - 1];
				dp[i][j] = esurvive + ebreak + 1;
				if (dp[i][j] >= n) {
					return i;
				}
			}
		}
		return 0;
	}

	private static int SuperEggDropRec(int k, int n) {
		if (n == 1 || k == 1) {
			return n;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int esurvive = SuperEggDropRec(k, n - i);
			int ebreak = SuperEggDropRec(k - 1, i - 1);
			int worst = Math.max(esurvive, ebreak);
			ans = Math.min(ans, worst);
		}
		return ans + 1;
	}
	private static int SuperEggDropMemo(int k, int n, int[][] dp) {
		if (n == 1 || k == 1) {
			return n;
		}
		if( dp[k][n] != 0 ) {
			return dp[k][n];
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int esurvive = SuperEggDropMemo(k, n - i, dp);
			int ebreak = SuperEggDropMemo(k - 1, i - 1, dp);
			int worst = Math.max(esurvive, ebreak);
			ans = Math.min(ans, worst);
		}
		dp[k][n] = ans + 1;
		return ans + 1;
	}
	public static int SuperEggDropTab(int n, int k){
		int dp[][] = new int[k+1][n+1];
		for(int i = 1; i < dp.length; i++) {
			for(int j = 1; j < dp[0].length; j++) {
				if( i == 1 || j == 1 ) {
					dp[i][j] = j;
					continue;
				}
				// cut point strategy
				int ans = Integer.MAX_VALUE;
				for(int l = 1; l <= j; l++) {
						int esurvive = dp[i][j - l];
						int ebreak = dp[i - 1][l - 1];
						int worst = Math.max(esurvive, ebreak);
						ans = Math.min(ans, worst);
				} 
				dp[i][j] = ans + 1;
			}
		}
		
		return dp[k][n];
	} 
}
