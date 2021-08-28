package Dynamic_Programming_Category3;

import java.util.Scanner;

/*
 1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34
Input Format
A number n
A number k
Output Format
A number representing the number of ways in which these elements can be partitioned in k non-empty subsets.
Constraints
0 <= n <= 20
0 <= k <= n
Sample Input
4
3
Sample Output
6
 */
public class Partition_Into_Subsets {
	public static long partitionKSubset(int n, int k, long dp[][]) {
		
		if (n == 0 || k == 0) {
			return 0;
		}
//		if ( k == 1 ) {
//			return 1;
//		}
//		this case given in constraints so we need not to check this condition
//		if ( n < k ) {
//			return 0;
//		}
		if (n == k ) {
			return 1;
		}
		
		if(dp[n][k] != 0) {
			return dp[n][k];
		}
		
		long ans = k * partitionKSubset(n - 1, k, dp) + partitionKSubset(n - 1, k - 1, dp);
		dp[n][k] = ans;
		
		return ans;
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long dp[][] = new long[n+1][k+1];
        long res = partitionKSubset(n, k, dp);
        System.out.println(res);
        scn.close();
    }
}
