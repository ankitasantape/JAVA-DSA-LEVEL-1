/*
1. You are given an array(arr) of integers.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least one element.
Input Format
A number N
a1
a2.. N integers
Output Format
A number representing maximum subarray sum in the given array.

Constraints
1 <= N <= 10000
-2^31 <= arr[i] <= 2^31 - 1 
Sample Input
3
1
2
3
Sample Output
6
*/
package Dynamic_Programming;

import java.util.Scanner;

public class A31_Kadanes_Algorithm {
    
	  public static int solution(int[] arr) {
	      int n = arr.length;
	      int dp[] = new int[n];
	      dp[0] = arr[0];
	      int max = arr[0];
	      for (int i = 1; i < n; i++){
	          dp[i] = Math.max( dp[i - 1] + arr[i] , arr[i]);
	          max = Math.max(max, dp[i]);
	      }
	      return max;
	  }
	  
	  public static int solution1(int[] arr) {
	     
	      int csum = arr[0];
	      int msum = arr[0];
	      for (int i = 1; i < arr.length; i++){
	          if ( csum >= 0 ) {
	        	  csum += arr[i];
	          } else {
	        	  csum = arr[i];
	          }
	          if (csum > msum) {
	        	  msum = csum;
	          }
	      }
	      return msum;
	  }

	  public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < arr.length; i++) {
	      arr[i] = scn.nextInt();
	    }
	    System.out.println(solution(arr));
	    System.out.println(solution1(arr));
	    scn.close();
	  }
}
