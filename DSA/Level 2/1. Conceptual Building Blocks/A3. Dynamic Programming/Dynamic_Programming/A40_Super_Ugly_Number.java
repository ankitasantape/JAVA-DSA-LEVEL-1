/*
1. You are given an array(arr) of size k which contains prime numbers in ascending order, and an integer N.
2. You have to find Nth super ugly number.
3. Super ugly number is defined as the number whose prime factors are elements of the given array.

Assumption -> 1 is the first super ugly number.
Input Format
A number K
arr1
arr2.. K prime numbers in ascending order
A number N
Output Format
A number representing Nth super ugly number.

Constraints
1 <= K <= 100
1 <= arr[i] <= 1000
1 <= N <= 10^6
Sample Input
4
3 5 7 11
13
Sample Output
45
*/
package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class A40_Super_Ugly_Number {
   
	public static int solution(int[] primes, int n) {
		int[] dp = new int[n+1];
		int[] pointers = new int[primes.length];
		Arrays.fill(pointers, 1);
		dp[1] = 1;

		for (int j = 2; j <= n; j++) {
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < primes.length; i++) {
				min = Math.min(min, primes[i] * dp[pointers[i]] );	
			}
			dp[j] = min;
			for(int i = 0; i < primes.length; i++) {
				if( primes[i] * dp[pointers[i]] == min ) {
					pointers[i]++;
				}
			}
		}
		
		return dp[n];

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		int[] primes = new int[k];
		for (int i = 0; i < k; i++) {
			primes[i] = scn.nextInt();
		}
		int n = scn.nextInt();
		System.out.println(solution(primes, n));
		scn.close();
	}
}
