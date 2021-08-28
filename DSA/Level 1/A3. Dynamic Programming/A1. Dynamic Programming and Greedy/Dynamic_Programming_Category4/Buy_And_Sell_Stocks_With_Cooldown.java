package Dynamic_Programming_Category4;

import java.util.Scanner;

/*
 1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
Input Format
A number n
.. n more elements
Output Format
A number representing the maximum profit you can make if you are allowed infinite transactions with cooldown of 1 day.
Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
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
Sample Output
19
 */
public class Buy_And_Sell_Stocks_With_Cooldown {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for( int i = 0; i < n; i++ ) {
			arr[i] = sc.nextInt();
		}
		System.out.println( buy_and_sell_stock_with_cooldown(n, arr));
		System.out.println( buy_and_sell_stock_with_cooldown_2(n, arr));
        sc.close();
    }
	
	private static int buy_and_sell_stock_with_cooldown(int n, int[] arr) {
		int buy[] = new int[n];
		 int sell[] = new int[n];
		 buy[0] = -arr[0];
		 sell[0] = 0;
		 for(int i = 1; i < n; i++) {
//			 becoz of 1 day for cooldown --> that's why we're taking sell price before 2 days  
			 if(i == 1) {
				 buy[i] = Math.max(buy[i - 1], - arr[i]); 
			 } else {
				 buy[i] = Math.max(buy[i - 1], sell[i - 2] - arr[i]);	 
			 }
			
			 sell[i] = Math.max(sell[i - 1], buy[i - 1] + arr[i]);
		  }
		 return sell[n-1];
	}

	private static int buy_and_sell_stock_with_cooldown_2(int n, int[] arr) {
		int buy[] = new int[n];
		 int sell[] = new int[n];
		 int cool[] = new int[n];
		 buy[0] = -arr[0];
		 sell[0] = 0;
		 cool[0] = 0;
		 for(int i = 1; i < n; i++) {
			 buy[i] = Math.max(buy[i - 1], cool[i - 1] - arr[i]);
			 sell[i] = Math.max(sell[i - 1], buy[i - 1] + arr[i]);
			 
			 cool[i] = sell[i - 1];
		 }
		 return sell[n-1];
	}
	
}
