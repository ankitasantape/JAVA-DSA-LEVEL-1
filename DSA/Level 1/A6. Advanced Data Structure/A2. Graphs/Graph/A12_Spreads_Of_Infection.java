/*
1. You are given a graph, representing people and their connectivity.
2. You are also given a src person (who got infected) and time t.
3. You are required to find how many people will get infected in time t, if the infection spreads to neighbors of infected person in 1 unit of time.
Input Format
Input has been managed for you
Output Format
count of people infected by time t
Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
6
3
Sample Output
4
*/
package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class A12_Spreads_Of_Infection {

	static class Edge {
		int src;
		int nbr;

		Edge(int src, int nbr) {
			this.src = src;
			this.nbr = nbr;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			graph[v1].add(new Edge(v1, v2));
			graph[v2].add(new Edge(v2, v1));
		}

		int src = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());

		// write your code here
		int count = 0;

		ArrayDeque<Pair> queue = new ArrayDeque<>();
		queue.add(new Pair(src, 1));
		int[] visited = new int[vtces];
		while (queue.size() > 0) {
			Pair rem = queue.remove();

			if (visited[rem.v] > 0) {
				continue;
			}
			visited[rem.v] = rem.time;
			if (rem.time > t) {
				break;
			} else {
				count++;
			}

			for (Edge e : graph[rem.v]) {
				if (visited[e.nbr] == 0) {
					queue.add(new Pair(e.nbr, rem.time + 1));
				}
			}
		}

		System.out.println(count);
	}

	static class Pair {
		int v;
		int time;

		Pair(int v, int time) {
			this.v = v;
			this.time = time;
		}
	}
}
