/*
1. You are given two arrays - 
     The first array(keys), which is sorted and has distinct integers, represents search keys.
   Second one(freq) represents frequency counts, where freq[i] is the number of searches to keys[i].
2. A binary search tree is constructed containing all keys and the total cost of searches is minimum. 
3. The cost of a BST node is the level of that node multiplied by its frequency.
4. You have to find the minimum cost of all searches.
Input Format
A number N
a1
a2.. N integers
b1
b2.. N numbers
Output Format

Constraints
1 <= N <= 1000
1 <= keys[i],freq[i] <= 1000
Sample Input
9
1
3
4
5
6
7
8
9
11
3
6
4
8
7
3
7
4
7
Sample Output
125

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A25_Optimal_Binary_Search_Tree {
	
	private static int optimalbstRec(int[] keys, int[] frequency, int si, int  ei, int[] pSum) {
		if (si > ei) {
			return 0;
		}
		if ( si == ei ) {
			return frequency[si]; 
		}
		int ans = Integer.MAX_VALUE;
		int fsum = pSum[ei] - (si == 0 ? 0 :pSum[si - 1]);
		
		for(int cp = si; cp <= ei; cp++) {
			int left = optimalbstRec(keys, frequency, si, cp - 1, pSum);
			int right = optimalbstRec(keys, frequency, cp + 1, ei, pSum);
			ans = Math.min(ans, left + right + fsum);
		}
		return ans;
	}
	
	private static int optimalbstMemo(int[] keys, int[] frequency, int si, int  ei, int[] pSum, int[][] dp) {
		if (si > ei) {
			return 0;
		}
		if ( si == ei ) {
			return frequency[si]; 
		}
		int ans = Integer.MAX_VALUE;
		int fsum = pSum[ei] - (si == 0 ? 0 :pSum[si - 1]);
		if(dp[si][ei] != 0) {
			return dp[si][ei];
		}
		
		for(int cp = si; cp <= ei; cp++) {
			int left = optimalbstRec(keys, frequency, si, cp - 1, pSum);
			int right = optimalbstRec(keys, frequency, cp + 1, ei, pSum);
			ans = Math.min(ans, left + right + fsum);
		}
		dp[si][ei] = ans;
		return ans;
	}
	
	private static void optimalbst(int[] keys, int[] frequency, int n) {
		int[][] dp = new int[n][n];
		
//		prefix sum array
		int psa[] = new int[n];
		psa[0] = frequency[0];
		for(int i = 1; i < n; i++) {
			psa[i] = psa[i - 1] + frequency[i];
		}
		for (int g = 0; g < n; g++) {
			for (int i = 0, j = g; j < n; i++, j++) {
				if (g == 0) {
					dp[i][j] = frequency[i];
				} else if(g == 1) {
					int f1 = frequency[i];
					int f2 = frequency[j];
					dp[i][j] = Math.min(f1 + 2 * f2, f2 + 2 * f1);
				} else {
					int min = Integer.MAX_VALUE;
					int fs = 0; // frequency sum
//					for (int x = i; x <= j; x++) {
//						fs += frequency[x];
//					}
					
					fs = psa[j] - (i == 0 ? 0 : psa[i-1]);
					
					for (int k = i; k <= j; k++) {
						int left = k == i ? 0 : dp[i][k - 1];
						int right = k == j ? 0 : dp[k + 1][j];
						
						if(left + right + fs < min) {
							min = left + right + fs;
						}
					}
					
					dp[i][j] = min;
				}
			}
		}
		System.out.println(dp[0][n - 1]);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] keys = new int[n];
		int[] frequency = new int[n];
		for (int i = 0; i < n; i++) {
			keys[i] = scn.nextInt();
		}
		int[] pSum = new int[n];
		for (int i = 0; i < n; i++) {
			frequency[i] = scn.nextInt();
			if(i == 0) {
				pSum[i] = frequency[i];
			} else {
				pSum[i] = pSum[i - 1] + frequency[i];
			}
		}
		
		System.out.println("Recursive: " + optimalbstRec(keys, frequency, 0, n-1, pSum));
		System.out.println("Memoization: " + optimalbstMemo(keys, frequency, 0, n-1, pSum, new int[n][n]));
		System.out.print("DP: ");
		optimalbst(keys, frequency, n);
		scn.close();
	}
}
