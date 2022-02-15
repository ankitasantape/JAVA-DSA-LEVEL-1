/*

1. You are given a number n, representing the number of upstrokes / and number of downstrokes .
2. You are required to find the number of valleys and mountains you can create using strokes.
Note -> At no point should we go below the sea-level. (number of downstrokes should never be more than number of upstrokes).
Input Format
A number n
Output Format
A number representing the number of valleys and mountains you can create using strokes.
Constraints
0 <= n <= 15
Sample Input
4
Sample Output
14

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A17_Count_Of_Valleys_And_Mountains {
    
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp1[] = new int[n + 1];
        dp1[0] = 1;
        dp1[1] = 1;
        // Approach 1
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
        
        // Approach 2 - Code of Catalan Number
        int dp2[] = new int[n + 1];
        dp2[0] = 1;
        dp2[1] = 1;
        for(int i = 2; i < dp2.length; i++){
            for(int j = 0; j < i; j++){
                dp2[i] += dp2[j] * dp2[i - j - 1];
            }
        }
        System.out.println(dp2[n]);
        
        sc.close();
	}
}
