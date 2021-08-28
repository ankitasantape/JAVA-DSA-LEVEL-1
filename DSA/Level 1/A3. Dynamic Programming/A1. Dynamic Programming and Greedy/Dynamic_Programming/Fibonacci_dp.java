package Dynamic_Programming;

import java.util.Scanner;
/*
 1. You are given a number n.
2. You are required to print the nth element of fibonnaci sequence.

Note -> Notice precisely how we have defined the fibonnaci sequence
0th element -> 0
1st element -> 1
2nd element -> 1
3rd element -> 2
4th element -> 3
5th element -> 5
6th element -> 8
Input Format
A number n
Output Format
A number representing the nth element of fibonnaci sequence
Sample Input
10
Sample Output
55
 */
public class Fibonacci_dp {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fibonacci(n));
		 int dp[] = new int[n + 1];
	    System.out.println(fibonacciRec(n, dp));

		sc.close();
	}

	public static int fibonacci(int n) {
		if (n == 1 || n == 0) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static int fibonacci2(int n) {
		if (n == 1 || n == 0) {
			return n;
		} 
		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);
		int fn = fnm1 + fnm2;
		return fn;
	}
	
	public static int fibonacciRec(int n, int dp[]){
	       if( n == 0 || n == 1){
	           return n;
	       }
	       // to check whether the ans is already calculated or not?
	       if (dp[n] != 0){
	           return dp[n];
	       }
	       
	       int fnm1 = fibonacciRec(n-1, dp);
	       int fnm2 = fibonacciRec(n-2, dp);
	       int fn = fnm1 + fnm2;
	       dp[n] = fn;
	       return fn;
	        
	}
	
	


}
