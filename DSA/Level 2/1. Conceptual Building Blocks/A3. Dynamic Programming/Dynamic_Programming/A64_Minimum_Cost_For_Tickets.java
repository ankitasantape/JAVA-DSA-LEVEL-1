/*
1. You are going on a vacation for a year, you've decided certain days for travelling in the city, given to you as a strictly increasing array from day 1....365
 2. There are 3 kinds of passes you can take in this city for transport: 
     a) A single day pass, cost of which is in an array at cost[0]
     b) A week's pass, cost of which  is in an array at cost[1]
     c) A month's pass, cost of which  is in an array at cost[2]
 3. Find and return minimum amount it'll cost you for travelling in the city according to the given days
 4. Input and output is handled for you
 5. It is a functional problem ,please do not modify main()
 
Constraints
array contains strictly increasing positive integers
 1<=Days.length <=365
 1<=Days[i]<=365
Sample Input
9
2 3 8 9 10 11 12 14 27
1 5 25
Sample Output
8

*/

package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class A64_Minimum_Cost_For_Tickets {
  
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] days = new int[n];
		for (int i = 0; i < n; i++) {
			days[i] = scn.nextInt();
		}
		int[] costs = new int[3];
		for (int i = 0; i < 3; i++) {
			costs[i] = scn.nextInt();
		}
		Arrays.sort(days);
		System.out.println(mincostTickets(days, costs));
		scn.close();
	}
	// -----------------------------------------------------
	// This is a functional problem. Only this function has to be written.
	// This function takes as input 2 integer arrays
	// It should return the required output

	public static int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[400];
		Arrays.fill(dp, -1);
//		return rec(days[0], costs, days, dp);
		return tab( costs, days);
	}
	private static int tab( int[] costs, int[] days) {
		int[] dp = new int[400];
		
		for(int cday = 399; cday >= 0; cday--) {
			if( cday > days[days.length - 1] ) {
				dp[cday] = 0;
				continue;
			}
			int ans = (int)1e8;
			if( will_I_TravelToday(cday, days) ) {
				ans = dp[cday + 1] + costs[0];
				
				ans = Math.min(ans, dp[cday + 7] + costs[1] );
				
				ans = Math.min(ans, dp[cday + 30] + costs[2] );
				dp[cday] = ans;
			} else {
				dp[cday] = dp[cday + 1];
			}
			
		}
		return dp[1];
	}
	private static int rec(int cday, int[] costs, int[] days, int[] dp) {
		
		if(cday > days[days.length - 1]) {
			dp[cday] = 0;
			return 0;
		}
		if(dp[cday] != -1) {
			return dp[cday];
		}
		int ans = (int)1e8; // 10^8
		if ( will_I_TravelToday(cday, days) ) {
			ans = rec(cday + 1, costs, days, dp) + costs[0];
			
			ans = Math.min(ans, rec(cday + 7, costs, days, dp) + costs[1]);
			
			ans = Math.min(ans, rec(cday + 30, costs, days, dp) + costs[2]);
		} else {
			// if i don't want to travel further
			return rec(cday + 1, costs, days, dp);
		}
		dp[cday] = ans;
		return ans;
	}
	private static boolean will_I_TravelToday(int cday, int[] days) {
		for(int i = 0; i < days.length; i++) {
			if (days[i] == cday) {
				return true;
			}
		}
		return false;
	}
}
