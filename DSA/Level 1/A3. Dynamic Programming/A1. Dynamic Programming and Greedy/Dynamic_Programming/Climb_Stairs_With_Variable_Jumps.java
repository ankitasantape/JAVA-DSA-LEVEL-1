package Dynamic_Programming;

import java.util.Scanner;

/*
1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  
     You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.
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
5

Sample Input
13
5
5
2
4
1
5
9
8
6
3
8
9
1
Sample Output
2044

 */
public class Climb_Stairs_With_Variable_Jumps {
     
	 public static void main(String[] args) throws Exception {
           Scanner sc= new Scanner(System.in);
           int n = sc.nextInt();
           int a[] = new int[n];
           for(int i = 0; i < n; i++) {
        	   a[i] = sc.nextInt();
           }
           int dp[] = new int[n + 1];
//	       System.out.println(climb_stairs_with_variable_jump(a, 0));
	       
//	       System.out.println(climb_stairs_with_variable_jump_Memo(a, 0, dp));
           
           System.out.println(climb_stairs_with_variable_jump_Tabu(a, 0, dp));
           sc.close();
	 }
	 
	 public static int climb_stairs_with_variable_jump(int arr[], int idx) {
		 if(idx == arr.length) {
			 return 1;
		 }
		 
		 if(idx > arr.length) {
			 return 0;
		 }
		 
		 int ans = 0;
		 for(int jump = 1; jump <= arr[idx]; jump++) {
			 ans += climb_stairs_with_variable_jump(arr, idx + jump);
		 }
		 
		 return ans;
	 }
	 
	 public static int climb_stairs_with_variable_jump_Memo(int arr[], int idx ,int dp[]) {
		 if(idx == arr.length) {
			 return 1;
		 }
		 
		 if(idx > arr.length) {
			 return 0;
		 }
		 
		 if (dp[idx] != 0) {
			 return dp[idx];
		 }
		 
		 int ans = 0;
		 for(int jump = 1; jump <= arr[idx]; jump++) {
			 ans += climb_stairs_with_variable_jump_Memo(arr, idx + jump, dp);
		  }
		 dp[idx] = ans;
		 return dp[idx];
	 }
	 
	 public static int climb_stairs_with_variable_jump_Tabu(int arr[], int idx ,int dp[]) {
	        dp[arr.length] = 1;  // destination - tak 1 way hota hai ki move hi na kro
	        
	        for(int i = arr.length - 1; i >= 0; i-- ) {
	        	for(int jump = 1; jump <= arr[i]; jump++ ) {
	        		if(i + jump <= arr.length) {
	        			dp[i] += dp[i + jump];
	        		}
	        	}
	        }
	        return dp[0];
	 }
	 
}
