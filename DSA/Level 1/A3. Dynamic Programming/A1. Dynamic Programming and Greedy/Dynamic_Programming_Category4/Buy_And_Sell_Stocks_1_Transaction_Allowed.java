package Dynamic_Programming_Category4;

import java.util.Scanner;

/*
 1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.
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
17

Sample Input :
9
9 3 3 19 12 2 8 15 6
Sample Output :

 */
public class Buy_And_Sell_Stocks_1_Transaction_Allowed {
    
	 public static void main(String[] args) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int arr[] = new int[n];
	        for(int i = 0; i < n; i++) {
	        	arr[i] = sc.nextInt();
	        }
	        System.out.println(buy_and_sell_1_transaction(n,arr));
	        sc.close();
	  }
	 
	 public static int buy_and_sell_1_transaction(int n, int arr[]) {
		 
		 int prices[] = new int[n];
		 int max = Integer.MIN_VALUE;
		 
		 for(int i = n-1; i >= 0; i--) {
			 if(arr[i] > max) {
				  max = arr[i];
				  
			 }
			 prices[i] = max;
		 }
		 int ans = 0;
//		 agar koi transaction nhi kiya to maxPro = 0 hi rahega
		 int maxPro = 0;
		 for(int i = 0; i < n; i++) {
			 maxPro = prices[i] - arr[i];
			 if(maxPro > ans) {
				 ans = maxPro;
			 }
		 }
		 
//		 for(int i = 0; i < n; i++) {
//			 System.out.print(prices[i] +" ");
//		 }
		 return ans;
	 }
}
