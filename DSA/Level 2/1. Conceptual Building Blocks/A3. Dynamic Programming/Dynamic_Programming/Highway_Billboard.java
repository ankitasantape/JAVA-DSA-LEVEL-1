/*
1. You are given a number M representing length of highway(range).
2. You are given a number N representing number of bill boards.
3. You are given N space separated numbers representing (P)position of bill-boards.
4. You are given N space separated numbers representing (R)revenue corresponding to each (P)position.
5. You are given a number T such that bill-boards can only be placed after specific distance(T).
6. Find the maximum revenue that can be generated.
Input Format
A number M(length of highway)
A number N(number of bill boards)
P1 ,P2 ,P3 ,P4 ,P5 .... Pn (placement of N bill-boards)
R1 ,R2 ,R3 ,R4 ,R5 .... Rn (revenue from each bill-board)
A number T (neccessary distance b/w two bill-board)
Output Format
Find the maximum revenue that can be generated.

Constraints
1 <= M <= 100000
1 <= N <= 50000
1 <= Pi <= M
1 <= Ri <= 100
1 <= T
Sample Input
20
5
6 7 12 14 15
5 8 5 3 1
5
Sample Output
11

*/

package Dynamic_Programming;

import java.util.Scanner;

public class Highway_Billboard {
   
	// Approach - 1
	// Time Complexity : O(n^2)
	public static int solution1(int m , int[] x, int[] rev, int t) {
        
		int[] dp = new int[x.length];
		int ans = 0;
		
		dp[0] = rev[0];
		for (int i = 1; i < x.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				int dist = x[i] - x[j];
				if( dist > t ) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + rev[i];
			ans = Math.max(ans, dp[i]);
		}
		
        return ans;
    }
	
	// Approach - 2
	// Time Complexity : O(n^2)
	public static int solution2(int m , int[] x, int[] rev, int t) {
	
		return 0;
	}
	
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution1(m, x, revenue, t));
        scn.close();
    }
}
