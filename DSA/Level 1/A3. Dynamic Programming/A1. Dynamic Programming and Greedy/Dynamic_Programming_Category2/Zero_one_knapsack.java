package Dynamic_Programming_Category2;

import java.util.Scanner;

/*
 1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
     overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
               again and again.
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
75
 */
public class Zero_one_knapsack {
    
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int value[] = new int[n];
	    for (int i = 0; i < n; i++) {
	      value[i] = sc.nextInt();
	    }
	    int weight[] = new int[n];
	    for (int i = 0; i < n; i++) {
	      weight[i] = sc.nextInt();
	    }
	    int cap = sc.nextInt();
	    System.out.println(zero_one_knapsack_rec(n,value, weight, cap));
	    
	    Integer dp[][] = new Integer[n+1][cap+1];
	    System.out.println(zero_one_knapsack_memo(n, value, weight, cap, dp));
	    System.out.println(zero_one_knapsack_dp(n, value, weight, cap));
	    sc.close();
	  }

	private static int zero_one_knapsack_dp(int n, int[] value, int[] weight, int cap) {
		 int dp[][] = new int[n+1][cap+1];
		 for(int i = 1; i <= n; i++) {
			 for(int j = 1; j <= cap; j++) {
				 
					 if(weight[i-1] > j) {
						 dp[i][j] = dp[i-1][j];
					 } else {
					 dp[i][j] = Math.max(dp[i-1][j], value[i-1] + dp[i-1][j - weight[i-1]] ); 
					 }
			 }
		 }
		 return dp[n][cap];
	}

	private static int zero_one_knapsack_memo(int n, int[] value, int[] weight, int cap, Integer[][] dp) {
		
		if(n <= 0 || cap <= 0) {
       	   return 0;
        }
		
		if(dp[n][cap] != null) {
			return dp[n][cap];
		}
        
        if(weight[n-1] > cap) {
       	   return zero_one_knapsack_memo(n-1, value, weight, cap, dp);
        }
		 int f1 = value[n-1] +  zero_one_knapsack_memo(n-1, value, weight, cap - weight[n-1], dp);	
		 int f2 = zero_one_knapsack_memo(n-1, value, weight, cap, dp);	
		 
		 int maxCap = Math.max(f1, f2);
		 dp[n][cap] = maxCap;
		 return maxCap;
	}

	private static int zero_one_knapsack_rec(int n,int[] value, int[] weight, int cap) {
		 
         if(n == 0 || cap <= 0) {
        	 return 0;
         }
         
         if(weight[n-1] > cap) {
        	 return zero_one_knapsack_rec(n-1, value, weight, cap);
         }
		 int f1 = value[n-1 ] +  zero_one_knapsack_rec(n-1, value, weight, cap - weight[n-1]);	
		 int f2 = zero_one_knapsack_rec(n-1, value, weight, cap);	
		 
		 int maxCap = Math.max(f1, f2);
		 return maxCap;
	  }
	  
	  
}
