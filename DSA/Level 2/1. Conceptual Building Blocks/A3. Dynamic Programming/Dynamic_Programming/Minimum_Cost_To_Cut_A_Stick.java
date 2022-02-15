/*
Given a wooden stick of length n units. The stick is labelled from 0 to n. 
For example, a stick of length 6 is labelled as follows:

Given an integer array cuts where cuts[i] denotes a position you should 
perform a cut at.

You should perform the cuts in order, you can change the order of the cuts 
as you wish.

The cost of one cut is the length of the stick to be cut, the total cost is 
the sum of costs of all cuts. When you cut a stick, it will be split into 
two smaller sticks (i.e. the sum of their lengths is the length of the stick
before the cut). Please refer to the first example for a better explanation.

Return the minimum total cost of the cuts.
Input: n = 7, cuts = [1,3,4,5]
Output: 16
Explanation: Using cuts order = [1, 3, 4, 5] as in the input leads to the 
following scenario:
The first cut is done to a rod of length 7 so the cost is 7. The second 
cut is done to a rod of length 6 (i.e. the second part of the first cut), 
the third is done to a rod of length 4 and the last cut is to a rod of 
length 3. The total cost is 7 + 6 + 4 + 3 = 20.
Rearranging the cuts to be [3, 5, 1, 4] for example will lead to a 
scenario with total cost = 16 
(as shown in the example photo 7 + 4 + 3 + 2 = 16).

Input: n = 9, cuts = [5,6,1,4,2]
Output: 22
Explanation: If you try the given cuts ordering the cost will be 25.
There are much ordering with total cost <= 25, 
for example, the order [4, 6, 5, 2, 1] has total cost = 22 which 
is the minimum possible. 

Constraints:

2 <= n <= 106
1 <= cuts.length <= min(n - 1, 100)
1 <= cuts[i] <= n - 1
All the integers in cuts array are distinct.

Sample Input
7
1 3 4 5
Sample Output
16

Sample Input
9
5 6 1 4 2
Sample Output
22

*/

package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum_Cost_To_Cut_A_Stick {
    int len = 0;
	public int minCost(int n, int[] cuts) {
		Arrays.sort(cuts);
		len = n;
		int l = cuts.length;
		return rec(n, 0, cuts.length, cuts, new int[l+1][l+1]);
	}
	private int rec(int n, int si, int ei, int[] cuts, int[][] dp) {
		if (si >= ei) {
			return 0;
		}
		if(dp[si][ei] != 0) {
			return dp[si][ei];
		}
		int ans = (int)1e8;
		for (int cut = si; cut < ei; cut++) {
			int le = si == 0 ? 0 : cuts[si-1];
			int re = ei == cuts.length ? len : cuts[ei];
			
			int cost = re - le;
			
			int left = rec(le, si, cut, cuts, dp);
			int right = rec(re, cut + 1, ei, cuts, dp);
			
			int myAns = left + cost + right;
			
			ans = Math.min(myAns, ans);
		}
		dp[si][ei] = ans;
		return ans;
	}
	public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(minCost(n, arr));
		sc.close();
	}
}
