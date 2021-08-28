package Dynamic_Programming_Category4;

import java.util.Scanner;

/*
1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are give a number fee, representing the transaction fee for every transaction.
4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
A number fee
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions with transaction fee.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= fee <= 5
Sample Input
12
10
15
17
20
16
18
22
20
22
20
23
25
3
Sample Output
13

 */
public class Buy_And_Sell_Stocks_With_Transaction_Fee {
    
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			arr[i] = sc.nextInt();
		}
		int fee = sc.nextInt();
		System.out.println( buy_and_sell_stock_with_transaction_fee_allowed_infinite(n, arr, fee));
        sc.close();
    }

	private static int buy_and_sell_stock_with_transaction_fee_allowed_infinite(int n, int[] arr, int fee) {
		int buy[] = new int[n];
		 int sell[] = new int[n];
		 buy[0] = -arr[0];
		 sell[0] = 0;
		 for(int i = 1; i < n; i++) {
			 buy[i] = Math.max(buy[i - 1], sell[i - 1] - arr[i]);
//			 commission will be taken on every transaction so definitely profit will be reduced 
			 sell[i] = Math.max(sell[i - 1], buy[i - 1] + arr[i] - fee);
		 }
		 return sell[n-1];
	}
}
