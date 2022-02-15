/*
1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
    3.2) all configurations of "MINIMUM JUMPS".
NOTE: Checkout sample question/solution video inorder to have more insight.
Input Format
A number N (representing "NUMBER OF ELEMENTS").
ELE1 ,ELE2 ,ELE3 ,ELE4 .... ELEn (N space separated numbers represnting numbers).
Output Format
1) A number representing "MINIMUM JUMPS" need from 0th step to (n-1)th step.
2) Strings representing configurations of "MINIMUM JUMPS".

Constraints
1 <= N <= 100
1 <= ELE <= 1000
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
4
0 -> 3 -> 5 -> 6 -> 9 .
0 -> 3 -> 5 -> 7 -> 9 .

*/
package Dynamic_Programming;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class A02_Print_All_Paths_With_Minimum_Jumps {

	public static class Pair {
		int idx;
		int step;
		int jump;
		String psf;

		Pair(int idx, int step, int jump, String psf) {
			this.idx = idx;
			this.step = step;
			this.jump = jump;
			this.psf = psf;
		}
	}

	public static class Pair1 {
		int idx;
		String psf;

		public Pair1(int idx, String psf) {
			this.idx = idx;
			this.psf = psf;
		}
	}

	public static void Solution1(int arr[]) {
		Integer dp[] = new Integer[arr.length + 1];
		dp[arr.length - 1] = 0;

		for (int i = arr.length - 2; i >= 0; i--) {
			int steps = arr[i];
			if (arr[i] != 0) {
				int min = Integer.MAX_VALUE;
				for (int j = 1; j <= steps && i + j < arr.length; j++) {
					if (dp[i + j] != null) {
						min = Math.min(dp[i + j], min);
					}
				}
				if (min != Integer.MAX_VALUE) {
					dp[i] = min + 1;
				}
			}
		}
		System.out.println(dp[0]);
		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(0, arr[0], dp[0], 0 + ""));

		while (queue.size() > 0) {
			Pair rp = queue.removeFirst();

			if (rp.jump == 0) {
				System.out.println(rp.psf + " .");
			}
			// add children of rp
			for (int j = 1; j <= rp.step && rp.idx + j < arr.length; j++) {
				int ci = rp.idx + j;

				if (dp[ci] != null && dp[ci] == rp.jump - 1) {
					queue.add(new Pair(ci, arr[ci], dp[ci], rp.psf + " -> " + ci));
				}
			}
		}
	}

	public static void Solution2(int arr[]) {
		int n = arr.length;
		Integer dp[] = new Integer[n];
		dp[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] != 0) {
				int min = Integer.MAX_VALUE;
				for (int j = 1; (i + j) < n && j <= arr[i]; j++) {
					if (dp[i + j] != null) {
						min = Math.min(min, dp[i + j]);
					}
				}
				if (min != Integer.MAX_VALUE) {
					dp[i] = min + 1;
				}
			}
		}
		System.out.println(dp[0]);

		Queue<Pair1> pq = new ArrayDeque<>();
		pq.add(new Pair1(0, 0 + ""));

		while (pq.size() != 0) {
			Pair1 rp = pq.remove();

			if (rp.idx == n - 1) {
				System.out.println(rp.psf + " .");

			}

			for (int j = 1; (rp.idx + j) < n && j <= arr[rp.idx]; j++) {
				if (dp[rp.idx] != null && dp[rp.idx + j] != null && dp[rp.idx + j] == dp[rp.idx] - 1) {
					pq.add(new Pair1(rp.idx + j, rp.psf + " -> " + (rp.idx + j)));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		Solution1(arr);
		Solution2(arr);
		scn.close();
	}
}
