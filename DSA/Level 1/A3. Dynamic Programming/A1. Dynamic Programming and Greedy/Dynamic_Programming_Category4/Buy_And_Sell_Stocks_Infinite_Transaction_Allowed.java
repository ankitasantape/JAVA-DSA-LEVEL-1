package Dynamic_Programming_Category4;

import java.util.Scanner;

/*
 1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions.
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
public class Buy_And_Sell_Stocks_Infinite_Transaction_Allowed {

	 public static void main(String[] args) throws Exception {
		 Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(buy_and_sell_Infinite_transaction(n, arr));
			System.out.println(buy_and_sell_Infinite_transaction2(n, arr));
			sc.close();
	 }

	 private static int buy_and_sell_Infinite_transaction2(int n, int[] arr) {
		 int buy[] = new int[n];
		 int sell[] = new int[n];
		 buy[0] = -arr[0];
		 sell[0] = 0;
		 for(int i = 1; i < n; i++) {
			 buy[i] = Math.max(buy[i - 1], sell[i - 1] - arr[i]);
			 sell[i] = Math.max(sell[i - 1], buy[i - 1] + arr[i]);
		 }
		 return sell[n-1];
	 } 
	 
	private static int buy_and_sell_Infinite_transaction(int n, int[] arr) {
		int profit = 0;
		for(int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				profit += arr[i] - arr[i-1];
			}
		}
		return profit;
	}
}
