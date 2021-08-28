package Dynamic_Programming;

import java.util.Scanner;

/*
 1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  You can of-course fewer number of steps in the move.
4. You are required to print the number of minimum moves in which you can reach the top of 
     staircase.
Note -> If there is no path through the staircase print null.
Input Format
A number n
.. n more elements
Output Format
A number representing the number of ways to climb the stairs from 0 to top.
Sample Input
10
3
3
0
2
1
2
4
2
0
0
Sample Output
4

Sample Input:
10
3 2 4 2 0 2 3 1 2 2
Sample Output:
4
 */
public class Climb_Stairs_With_Minimum_Moves {

	 public static void main(String[] args) throws Exception {
		 Scanner sc= new Scanner(System.in);
         int n = sc.nextInt();
         int a[] = new int[n];
         for(int i = 0; i < n; i++) {
      	   a[i] = sc.nextInt();
         }
         System.out.println(climb_stairs_with_minimum_jump_dp(a));
         System.out.println(climb_stairs_with_minimum_jump_dp_2(n,a));
         System.out.println(climb_stairs_with_minimum_jump_dp_3(n,a));
         sc.close();  
	 }

	private static int climb_stairs_with_minimum_jump_dp(int[] arr) {
		int n = arr.length;
		int dp[] = new int[n];
		dp[n-1] = 0;  // destination - tak 1 way hota hai ki move hi na kro
		
	    for(int i = arr.length - 2; i >= 0; i-- ) {
	    	int min = Integer.MAX_VALUE - 1;
	        for(int jump = 1; jump <= arr[i]; jump++ ) {
	        	if(i + jump < arr.length) {
	        	   min = Math.min(min, dp[jump + i]);
	        	}
	        }
	        dp[i] = min + 1;
	        
	    }
	    for(int i = 0; i < dp.length; i++) {
	    	System.out.print(dp[i] + " ");
	    }
	    System.out.println();
	    return dp[0];
	}
	
	private static int climb_stairs_with_minimum_jump_dp_2(int n,int[] arr) {
		Integer dp[] = new Integer[n];
		
		dp[n-1] = 0;
		
		for(int i = n-2; i >= 0; i--){
		    int min = Integer.MAX_VALUE-1;
		    for(int j = 1; j <= arr[i] && (i + j) < dp.length; j++){
		        min = Math.min(min, dp[i+j]);
		    }
		    dp[i] = min + 1;
		}
		 for(int i = 0; i < dp.length; i++) {
	    	System.out.print(dp[i] + " ");
	    }
	    System.out.println();
		return dp[0];
	}
	
//	this code successfully, submitted, but little bit logically not correct becoz we are taking n+1 size of dp which is not required
//	so, we should use dp of n size
	private static int climb_stairs_with_minimum_jump_dp_3(int n,int[] arr) {
		Integer dp[] = new Integer[n+1];
		
		dp[n] = 0;
		
		for(int i = n-1; i >= 0; i--){
		    int min = Integer.MAX_VALUE-1;
		    for(int j = 1; j <= arr[i] && (i + j) < dp.length; j++){
		        min = Math.min(min, dp[i+j]);
		    }
		    dp[i] = min + 1;
		}
		 for(int i = 0; i < dp.length; i++) {
	    	System.out.print(dp[i] + " ");
	    }
	    System.out.println();
		return dp[0];
	}

}
