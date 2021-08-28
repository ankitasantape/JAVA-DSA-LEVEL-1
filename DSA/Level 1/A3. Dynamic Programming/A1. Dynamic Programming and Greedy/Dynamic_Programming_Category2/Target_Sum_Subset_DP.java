package Dynamic_Programming_Category2;

import java.util.Scanner;

/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add 
     up to "tar" or not.
Input Format
A number n
n1
n2
.. n number of elements
A number target
Output Format
true or false as required
Sample Input
5
4
2
7
1
3
10
Sample Output
true

Sample Input
14
4
6
0
18
12
4
17
5
5
4
17
1
20
14
3
Sample Output
true

*/
public class Target_Sum_Subset_DP {

	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
       	    a[i] = sc.nextInt();
       	}
        int target = sc.nextInt();
        System.out.println(target_sum_subset_dp(a, n, target));
        Boolean dp[][] = new Boolean[n][target + 1];
        System.out.println(tss_memo(a, 0, target, dp));
        sc.close();  
    }

	public static boolean tss_memo(int []a, int idx, int target, Boolean [][] dp) {
		if(target == 0) {
			return true;
		}
		
		if(idx >= a.length || target < 0) {
			return false;
		}
		
		if(dp[idx][target] != null) {
			return dp[idx][target];
		}
		
		boolean f1 = tss_memo(a, idx + 1, target, dp);
		boolean f2 = tss_memo(a, idx + 1, target - a[idx], dp);
		boolean ans = f1 || f2;
		dp[idx][target] = ans;
		return ans;
		
	}
	private static boolean target_sum_subset_dp(int[] a, int n, int target) {
		
		boolean dp[][] = new boolean[n+1][target+1];
		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= target; j++) {
				if(i == 0 && j == 0) {
					dp[i][j] = true;
				} else if(j == 0) {
					dp[i][j] = true;
				} else if(i == 0 && j > 0) {
					dp[i][j] = false;
				} else {
//					If player want to do batting
					if(dp[i - 1][j] == true) {
						dp[i][j] = true;
					} else {
//						if player don't want to do batting
						int val = a[i - 1];
						if (j >= val) { 
							if (dp[i - 1][j - val] == true) {
								dp[i][j] = true;
							}
							
						} 
					}
				}
			}
		}
//		for(int i = 0; i < dp.length; i++) {
//			for(int j = 0; j < dp[0].length; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		return dp[n][target];
		
	}
}
