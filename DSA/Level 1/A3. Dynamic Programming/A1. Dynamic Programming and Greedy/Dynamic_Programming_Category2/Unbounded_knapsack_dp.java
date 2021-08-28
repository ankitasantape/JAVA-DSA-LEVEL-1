package Dynamic_Programming_Category2;

import java.util.Scanner;

/*
 1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
    overflowing it's capacity.
Note -> Each item can be taken any number of times. You are allowed to put the same item again 
                  and again.
Input Format
A number n
v1 v2 .. n number of elements
w1 w2 .. n number of elements
A number cap
Output Format
A number representing the maximum value that can be created in the bag without overflowing it's capacity
Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
100
 */
public class Unbounded_knapsack_dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int value[] = new int[n];
		for(int i = 0; i < n; i++) {
			value[i] = sc.nextInt();
		}
		int weight[] = new int[n];
		for(int i = 0; i < n; i++) {
			weight[i] = sc.nextInt();
		}
		int cap = sc.nextInt();
        System.out.println(unbounded_knapsack_dp(n, value, weight, cap));
        sc.close();
	}

	private static int unbounded_knapsack_dp(int n, int[] value, int[] weight, int cap) {
		
		int dp[] = new int[cap+1];
//		base case
		dp[0] = 0;
//		iterative solution
		for(int c = 0; c <= cap; c++) {
			int max = 0;
			for(int j = 0; j < n; j++) {
				if(weight[j] <= c) {
					int idx = c - weight[j];
					dp[c] = dp[idx] + value[j];
					if(dp[c] > max) {
						max = dp[c];
					}
				}
			}
			dp[c] = max ;
		}
		
		return dp[cap];
	}
	
	
	

}
