/*
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the sum of elements of the increasing subsequence with maximum sum for the array.
Input Format
A number n
.. n more elements
Output Format
A number representing the sum of elements of the increasing subsequence with maximum sum for the array.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 100
Sample Input
10
10
22
9
33
21
50
41
60
80
1
Sample Output
255

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A10_Maximum_Sum_Increasing_Subsequence {
    
	public static void main(String[] args) throws Exception {
	      Scanner sc = new Scanner(System.in);
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      for(int i = 0; i < n; i++) {
	    	  arr[i] = sc.nextInt();
	      }
	      System.out.println( solution(arr) );
	      sc.close();
	}

	private static int solution(int[] arr) {
		
		int[] dp = new int[arr.length];
		// overall maxsum
		int omaxsum = Integer.MIN_VALUE;  
//		dp[0] = arr[0];
//		omaxsum = arr[0];
		// LIS
		for(int i = 0; i < arr.length; i++) {
			
			Integer maxsum = null;
			for(int j = 0; j < i; j++) {
				if (arr[j] <= arr[i]) {
					if (maxsum == null) {
						maxsum = dp[j];
					} else {
						maxsum = Math.max(maxsum, dp[j]);
					}
				}
			}
			if(maxsum == null) {
				dp[i] = arr[i];
			} else {
				dp[i] = maxsum + arr[i];
			}
			
			if(dp[i] > omaxsum) {
				omaxsum = dp[i];
				
			}
		}
		
		return omaxsum;	
	}
}
