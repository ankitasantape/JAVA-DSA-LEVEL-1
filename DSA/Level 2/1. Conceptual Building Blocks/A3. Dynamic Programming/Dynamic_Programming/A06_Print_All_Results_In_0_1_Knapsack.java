/*

1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
5. Also, you have to print the indices of items that should be selected to make maximum profit.
6. You have to print all such configurations.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
5
15 14 10 45 30
2 5 1 3 4
7
Sample Output
75
3 4 

Sample Input
12
35 42 31 0 1 40 29 28 40 38 40 2 
3 6 2 6 6 4 10 2 7 7 9 3 
9
Sample Output
106
0 2 5 

*/

package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A06_Print_All_Results_In_0_1_Knapsack {
	public static class Pair {
		int i;
		int j;
		String psf;

		public Pair(int i, int j, String psf) {
			this.i = i;
			this.j = j;
			this.psf = psf;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] values = new int[n];
		String str1 = br.readLine();
		for (int i = 0; i < n; i++) {
			values[i] = Integer.parseInt(str1.split(" ")[i]);
		}

		int[] wts = new int[n];
		String str2 = br.readLine();
		for (int i = 0; i < n; i++) {
			wts[i] = Integer.parseInt(str2.split(" ")[i]);
		}

		int cap = Integer.parseInt(br.readLine());

		int dp[][] = new int[n + 1][cap + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= cap; j++) {
				dp[i][j] = dp[i - 1][j];

				if (j >= wts[i - 1]) {
					dp[i][j] = Math.max(dp[i - 1][j - wts[i - 1]] + values[i - 1], dp[i - 1][j]);
				}
			}
		}

		int ans = dp[n][cap];
		System.out.println(ans);
		
		ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(n, cap, ""));
        
		while (queue.size() > 0) {
			Pair rp = queue.removeFirst();

			if (rp.i == 0 || rp.j == 0) {
				System.out.println(rp.psf);
			} else {

				if (rp.j - wts[rp.i - 1] >= 0) {
					int inc = dp[rp.i - 1][rp.j - wts[rp.i - 1]] + values[rp.i - 1];
					if (dp[rp.i][rp.j] == inc) {
						queue.add(new Pair(rp.i - 1, rp.j - wts[rp.i - 1], (rp.i - 1) + " " + rp.psf));
					}
				}
				int exc = dp[rp.i - 1][rp.j];
				if (dp[rp.i][rp.j] == exc) {
					queue.add(new Pair(rp.i - 1, rp.j, rp.psf));
				}
			}
		}
        
	}
}
