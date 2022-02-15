/*

1. You are given a number n, representing the number of opening brackets ( and closing brackets )
2. You are required to find the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets
e.g.
for 1, answer is 1 -> ()
for 2, answer is 2 -> ()(), (())
for 3, asnwer is 5 -> ()()(), () (()), (())(), (()()), ((()))
Input Format
A number n
Output Format
A number representing the number of ways in which you can arrange the brackets if the closing brackets should never exceed opening brackets

Constraints
0 <= n <= 15
Sample Input
4
Sample Output
14

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A18_Count_Brackets {
    
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    
	    // Approach 1
	    int dp[] = new int[n + 1];
	    dp[0] = 1;
	    dp[1] = 1;
	    for (int i = 2; i < dp.length; i++) {
	      for (int j = 0; j < i; j++) {
	        dp[i] += dp[j] * dp[i - j - 1];
	      }
	    }

	    System.out.println(dp[n]);
	    
	    int dp1[] = new int[n + 1];
        dp1[0] = 1;
        dp1[1] = 1;
        // Approach 2
        for (int i = 2; i <= n; i++) {
        	int inside = i - 1;
        	int outside = 0;
        	
        	while ( inside >= 0 ) {
                dp1[i] += dp1[inside] * dp1[outside];      		
        		
        		inside--;
        		outside++;
        	}
        } 
        System.out.println(dp1[n]);
	    
	    
	    sc.close();
	}

}
