/*
There are n cities and there are roads in between some of the cities. Somehow all the roads are damaged simultaneously. We have to repair the roads to connect the cities again. There is a fixed cost to repair a particular road. Find out the minimum cost to connect all the cities by repairing roads.
Input Format
First line contains number of cities.
Second line contains number of edges roads.
Each of next E lines contain 3 number u and v and c denoting a road between u and v with cost c to repair.
Output Format
print the minimum cost.
Constraints
1<= n <= 1000
1<= e <= n*(n-1)/2
Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
Sample Output
38

*/

package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class A05_Minimum_Cost_To_Connect_All_Cities {
   
	static class Edge implements Comparable<Edge> {
		int v;
		int wt;

		Edge(int nbr, int wt) {
			this.v = nbr;
			this.wt = wt;
		}

		@Override
		public int compareTo(Edge o) {
			return this.wt - o.wt;
		}
	}
	
	public static int prims(ArrayList<ArrayList<Edge>> graph) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[graph.size()];
		
		pq.add(new Edge(0, 0));
		int mincost = 0;
		
		while(pq.size() > 0) {
			//remove
			Edge rem = pq.remove();
			
			//mark*
			if(visited[rem.v] == true) {
				continue;
			}
			visited[rem.v] = true;
			//work
			mincost += rem.wt;
			
			//add unvisited nbr
			for(Edge edge : graph.get(rem.v)) {
				int nbr = edge.v;
				int wt = edge.wt;
				
				if(visited[nbr] == false) {
					pq.add(new Edge(nbr, wt));
				}
			}
		}
		return mincost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int vtces = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < vtces; i++) {
			graph.add(new ArrayList<>());
		}

		int edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph.get(v1).add(new Edge(v2, wt));
			graph.get(v2).add(new Edge(v1, wt));
		}
		System.out.println(prims(graph));
	}
}
