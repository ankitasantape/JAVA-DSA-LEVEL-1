package Dynamic_Programming_Category4;

import java.util.Scanner;

/*
 1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed a single transaction.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
Sample Input
9
11
6
7
19
4
1
6
18
4
Sample Output
30
 */
public class Buy_And_Sell_Stocks_2_Transaction_Allowed {
     
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(buy_and_sell_2_transaction(n, arr));
		sc.close();
	}

	public static int buy_and_sell_2_transaction(int n, int arr[]) {
		int minsf = arr[0];
		int maxsf = arr[n-1];
		
		int dp1[] = new int[n];
		int dp2[] = new int[n];
		
//		dp1[i] -> Maximum profit bt doing at most 1 transaction till ith index
		for(int i = 1; i < n; i++) {
			minsf = Math.min(minsf, arr[i]);
			dp1[i] = Math.max(dp1[i - 1], arr[i] - minsf);
		}
		
//		dp1[i] -> Maximum profit bt doing at most 1 transaction from ith index to last index
		for(int i = n-2; i >= 0; i--) {
			maxsf = Math.max(maxsf, arr[i]);
			dp2[i] = Math.max(dp2[i + 1], maxsf - arr[i]  );
		}
		
		int maxprofit = 0;
		for (int i = 0; i < n; i++) {
			maxprofit = Math.max(maxprofit, dp1[i] + dp2[i]);
		}
		
		return maxprofit;
	}
	
//	public static int buy_and_sell_2_transaction(int n, int arr[]) {
//		 int max_so_far[] = new int[n];
//		 int max = Integer.MIN_VALUE;
//		 
//		 for(int i = n-1; i >= 0; i--) {
//			 if(arr[i] > max) {
//				  max = arr[i];
//				  
//			 }
//			 max_so_far[i] = max;
//		 }
//		 
//		 int min_so_far[] = new int[n];
//		 int min = Integer.MAX_VALUE;
//		 for(int i = 0; i <= n; i++) {
//			 if(arr[i] < min) {
//				  min = arr[i];
//				  
//			 }
//			 min_so_far[i] = min;
//		 }
//		 
//		 int dp1[] = new int[n];
//		 int maxsofar = Integer.MIN_VALUE;
//		 for(int i = 0; i < n; i++) {
//			 dp1[i] = Math.max(maxsofar, max_so_far[i] - arr[i]);
//		 }
//		 
//		 int dp2[] = new int[n];
//		 int minsofar = Integer.MAX_VALUE;
//		 for(int i = 0; i < n; i++) {
//			 dp2[i] = Math.min(minsofar, min_so_far[i] - arr[i]);
//		 }
//
//		
//	}
}
