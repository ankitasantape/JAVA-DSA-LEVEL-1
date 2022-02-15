/*
1. You are given an array(arr) of integers and a number k.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least k elements.
Input Format
A number N
a1
a2.. N integers
A number K
Output Format
A number representing maximum subarray sum with subarray having at least K elements.
Constraints
1 <= N <= 10^5
1 <= arr[i] <= 10^5
1 <= K <= N
Sample Input
3
1
2
3
2
Sample Output
6

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A34_Maximum_Sum_Subarray_With_Atleast_K_Elements {
   
	public static int solution(int[] arr, int k) {
		 int n = arr.length;
	      int dp[] = new int[n];
	      
	      dp[0] = arr[0];
	      
	      for (int i = 1; i < n; i++){
	          dp[i] = Math.max( dp[i - 1] + arr[i] , arr[i]);
	      }
	      
	      int sum = 0;
	      for (int i = 0; i < k; i++) {
	    	  sum += arr[i];
	      }
	      int ans = sum;
	      
	      for (int i = k; i < arr.length; i++) {
	    	  sum = sum + arr[i] - arr[i - k];
	    	  ans = Math.max(ans, Math.max(sum, sum + dp[i - k]));
	      }
		return ans;
	}

	public static int solution1(int[] arr, int k) {
		 int n = arr.length;
		 int ans = Integer.MIN_VALUE;
		 
		 int[] maxSum = new int[n];
		
		 maxSum[0] = arr[0];
		 for (int i = 1; i < n; i++) {
			 maxSum[i] = Math.max(maxSum[i-1] + arr[i], maxSum[i-1]);
		 }
		 
		 int exactKsum = 0;
		 for(int i = 0; i < k; i++) {
			 exactKsum += arr[i];
		 }
		 if(exactKsum > ans) {
			 ans = exactKsum;
		 }
		 for(int i = k; i < arr.length; i++) {
			 exactKsum += arr[i] - arr[i - k];
			 if( exactKsum > ans) {
				 ans = exactKsum;
			 }
			 int morethanK = maxSum[i - k] + exactKsum;
			 if(morethanK > ans) {
				 ans = morethanK;
			 }
		 }
		 return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		System.out.println(solution(arr, k));
		System.out.println(solution1(arr, k));
		scn.close();
	}
}
