/*
You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [xi, yi] indicates that there is an edge between nodes xi and yi in the graph.
Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
Input Format
First line contains an integer n.
Each of next n lines contain 2 numbers denoting a bidirectional edge between them.
Output Format
Print the edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.
Constraints
1<= n <= 10000
number of edge = number of vertices
Sample Input
3
1 2
1 3
2 3
Sample Output
2 3

*/

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A17_Redundant_Connection {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);

		int[][] pos = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = br.readLine().split(" ");
			pos[i][0] = Integer.parseInt(st[0]);
			pos[i][1] = Integer.parseInt(st[1]);
		}

		int[] ans = findRedundantConnection(pos);
		System.out.println(ans[0] + " " + ans[1]);
	}

	public static int[] findRedundantConnection(int[][] edges) {
		int n = edges.length;

		parent = new int[n + 1];
		rank = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];

			if (union(u, v) == false) {
				int[] arr = { u, v };
				return arr;
			}
		}

		int[] arr = { 0, 0 };
		return arr;
	}

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

	public static boolean union(int u, int v) {
		int sl1 = find(u);
		int sl2 = find(v);

		if (sl1 != sl2) {
			// merging
			if (rank[sl1] < rank[sl2]) {
				parent[sl1] = sl2;
			} else if (rank[sl2] < rank[sl1]) {
				parent[sl2] = sl1;
			} else {
				parent[sl1] = sl2;
				rank[sl2]++;
			}
			return true;
		} else {
			return false;
		}
   }
}
