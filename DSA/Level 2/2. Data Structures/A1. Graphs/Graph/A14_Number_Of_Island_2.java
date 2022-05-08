/*
Given an m*n matrix mat, Originally, the 2D matrix is all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid mat[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.You need to return an array of size K.
Input Format
First line contains three integers m and n and k.
Each of next k lines contain 2 numbers denoting row and col to change into 1.
Output Format
print number of island after each operation.
Constraints
1<= m,n <= 10000
1<= k <= 10^6
Sample Input
3 3 4
0 0
0 1
1 2
2 1
Sample Output
[1, 1, 2, 3]

*/




package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A14_Number_Of_Island_2 {

	public static int[] parent;
	public static int[] rank;

	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		int sl = find(parent[x]);
		parent[x] = sl;
		return sl;
	}

	public static List<Integer> numIslands2(int n, int m, int[][] operators) {
		parent = new int[n * m];
		rank = new int[n * m];
		int[][] mat = new int[n][m];
		List<Integer> ans = new ArrayList<>();

		for (int i = 0; i < n * m; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		int count = 0;
		int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

		for (int k = 0; k < operators.length; k++) {
			int i = operators[k][0];
			int j = operators[k][1];

			if (mat[i][j] == 1) {
				ans.add(count);
				continue;
			}

			mat[i][j] = 1;
			count++;

			for (int d = 0; d < 4; d++) {
				int ni = i + dir[d][0];
				int nj = j + dir[d][1];

				if (ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] == 1) {
					int s1 = find(i * m + j);
					int s2 = find(ni * m + nj);

					if (s1 != s2) {
						// merging
						if (rank[s1] < rank[s2]) {
							parent[s1] = s2;
						} else if (rank[s2] < rank[s1]) {
							parent[s2] = s1;
						} else {
							parent[s1] = s2;
							rank[s2]++;
						}
						count--;
					}
				}
			}

			ans.add(count);
		}

		return ans;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int m = Integer.parseInt(st[0]);
		int n = Integer.parseInt(st[1]);
		int q = Integer.parseInt(st[2]);

		int[][] pos = new int[q][2];
		for (int i = 0; i < q; i++) {
			st = br.readLine().split(" ");
			pos[i][0] = Integer.parseInt(st[0]);
			pos[i][1] = Integer.parseInt(st[1]);
		}

		System.out.println(numIslands2(m, n, pos));
	}

}
