/*
1. You are given a number n, representing the number of elements.
2. You are required to find the number of Binary Search Trees you can create using the elements.
Input Format
A number n
Output Format
A number representing the number of Binary Search Trees you can create using the elements.
Constraints
0 <= n <= 15
Sample Input
4
Sample Output
14
*/

package Dynamic_Programming;

import java.util.Scanner;

public class A16_Number_Of_Bsts {
     
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++){
        	
        	int l = 0;
        	int r = i - 1;
        	
            while (l <= i - 1) {
            	dp[i] += dp[l] * dp[r];
            	
            	l++;
            	r--;
            }
        }
        
        System.out.println(dp[n]);
        sc.close();
	}

}
