package Dynamic_Programming_Category4;

import java.util.Scanner;

public class Buy_And_Sell_Stocks_With_K_Days_Cooldown_and_Fee {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int fee = sc.nextInt();
		System.out.println(buy_and_sell_stock_with_k_days_cooldown_and_fee(n, arr, k, fee));
		sc.close();
	}

	private static int buy_and_sell_stock_with_k_days_cooldown_and_fee(int n, int[] arr, int k, int fee) {
		int buy[] = new int[n];
		int sell[] = new int[n];
		buy[0] = -arr[0];
		sell[0] = 0;
		for (int i = 1; i < n; i++) {
//			 becoz of k days for cooldown --> that's why we're taking sell price before (k+1) days  
			buy[i] = Math.max(buy[i - 1], sell[i - (k + 1)] - arr[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + arr[i]- fee);
		}
		return sell[n - 1];
	}
	
}
