/*

1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) Length of "Longest Increasing Subsequence"(LIS).
    3.2) All "Longest Increasing Subsequence(s)"(LIS).
NOTE: Checkout sample question/solution video inorder to have more insight.
Input Format
A number N (representing "NUMBER OF ELEMENTS").
ELE1 ,ELE2 ,ELE3 ,ELE4 .... ELEn (N space separated numbers represnting numbers).
Output Format
1) A number representing Length of "Longest Increasing Subsequence"(LIS).
2) Strings representing "Longest Increasing Subsequence(s)"(LIS).

Constraints
1 <= N <= 100
1 <= ELE <= 1000
Sample Input
10
10 22 9 33 21 50 41 60 80 1
Sample Output
6
10 -> 22 -> 33 -> 41 -> 60 -> 80
10 -> 22 -> 33 -> 50 -> 60 -> 80

Sample Input
10
10 22 43 33 21 50 41 60 59 3
Sample Output
5
10 -> 22 -> 33 -> 41 -> 60
10 -> 22 -> 33 -> 50 -> 60
10 -> 22 -> 43 -> 50 -> 60
10 -> 22 -> 33 -> 41 -> 59
10 -> 22 -> 33 -> 50 -> 59
10 -> 22 -> 43 -> 50 -> 59

*/

package Dynamic_Programming;

import java.util.ArrayDeque;
import java.util.Scanner;

public class A09_Print_All_Longest_Increasing_Subsequences {
    
	public static class Pair {
		int l;
		int i;
		int v;
		String psf;

		Pair(int l, int i, int v, String psf) {
			this.l = l;
			this.i = i;
			this.v = v;
			this.psf = psf;
		}
	}
	
	public static void solution(int[] arr) {
		int[] dp = new int[arr.length];
		int omax = 0; // overall max
		int omi = 0;  // overall max value's index
		// LIS
		for(int i = 0; i < arr.length; i++) {
			int max = 0;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					 max = Math.max(max, dp[j]); 
				}
			}
			dp[i] = max + 1;
			if(dp[i] > omax) {
				omax = dp[i];
				omi = i;
			}
		}
		System.out.println(omax);
		
		// Time Complexity of LIS = O(n^2) 
		
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		// LIS kisi ek hi index pe end nhi ho rahi bulki multiple index pe LIS end ho rha isiliye wo sabhi indexes queue me dal diye
		for(int i = 0; i < dp.length; i++) {
			if(dp[i] == omax) {
				queue.add(new Pair(omax, i, arr[i], arr[i] + ""));
			}
		}
//		queue.add(new Pair(omax, omi, arr[omi], arr[omi] + "" ));
		
		while( queue.size() > 0 ) {
			Pair rp = queue.removeFirst();
			
			if(rp.l == 1) {
				System.out.println(rp.psf);
			}
			
			for (int j = rp.i - 1; j >= 0; j--) {
				if( dp[j] == rp.l - 1 &&  arr[j] <= rp.v ) {
					queue.add(new Pair(dp[j], j, arr[j], arr[j] + " -> " + rp.psf));	
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		solution(arr);

		scn.close();
	}
}
