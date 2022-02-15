/*
Alice and Bob take turns playing a game, with Alice starting first.

There are n stones arranged in a row. On each player's turn, they can remove either the leftmost stone or the rightmost stone from the row and receive points equal to the sum of the remaining stones' values in the row. The winner is the one with the higher score when there are no stones left to remove.

Bob found that he will always lose this game (poor Bob, he always loses), so he decided to minimize the score's difference. Alice's goal is to maximize the difference in the score.

Given an array of integers stones where stones[i] represents the value of the ith stone from the left, return the difference in Alice and Bob's score if they both play optimally.

Example 1:

Input: stones = [5,3,1,4,2]
Output: 6
Explanation: 
- Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, stones = [5,3,1,4].
- Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [3,1,4].
- Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,4].
- Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
- Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
The score difference is 18 - 12 = 6.
Example 2:

Input: stones = [7,90,5,1,100,10,10,2]
Output: 122
 
Constraints:

n == stones.length
2 <= n <= 1000
1 <= stones[i] <= 1000

*/

package Dynamic_Programming;

import java.util.Scanner;

public class Stone_Game_VII {
    
    public static int stoneGameVII(int[] stones, int[] psum) {
        int n = stones.length;
        int[][] memo = new int[n][n];
        return rec(stones, 0, n-1, psum, memo);
    	
    }
	
	private static int rec(int[] stones, int i, int j, int[] psum, int[][] memo) {
		if(i >= j) return 0;
		
		if(i+1 == j) {
			return Math.max(stones[i], stones[j]);
		}
		
		if(memo[i][j] != 0) {
			return memo[i][j];
		}
		
		// ith
		int scoreI = psum[j] - psum[i] - rec(stones, i+1, j, psum, memo);
		int scoreJ = psum[j-1] - (i == 0 ? 0 : psum[i-1])  - rec(stones, i, j-1, psum, memo);
		memo[i][j] = Math.max(scoreI, scoreJ);
		return Math.max( scoreI, scoreJ );
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		psum = new int[n];
		psum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			psum[i] = psum[i - 1] + arr[i];
		}
		stoneGameVII(arr, psum);
		System.out.println( tab(arr, psum) );
		sc.close();
	}
	public static int[] psum;
	private static int tab(int[] stones, int[] psum) {
	
		int n = stones.length;
		int[][] dp = new int[n][n];
		for (int i = n-1; i>=0; i--) {
			for (int j = 0; j < n; j++) {
				if (i >= j) {
					dp[i][j] = 0;
				} else if(i+1 == j) {
					dp[i][j] = Math.max(stones[i], stones[j]);
				} else {
					int scoreI = psum[j] - psum[i] - dp[i+1][j];
					int scoreJ = psum[j-1] - (i == 0 ? 0 : psum[i-1]) - dp[i][j-1];
					
					dp[i][j] = Math.max(scoreI, scoreJ);
				}
			}
		}
		return dp[0][n-1];
	}

}
