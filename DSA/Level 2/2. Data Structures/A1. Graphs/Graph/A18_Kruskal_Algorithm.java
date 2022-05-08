/*
There are n vertices and there are edges in between some of the vertices. Find the sum  of edge weight of minimum spanning tree.
Input Format
First line contains number of vertices.
Second line contains number of edges.
Each of next E lines contain 3 number u and v and c denoting an edge between u and v with weight c.
Output Format
print the sum of edge weight of MST.
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
import java.util.Arrays;

public class A18_Kruskal_Algorithm {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());

		int[][] edges = new int[e][3];
		for (int i = 0; i < e; i++) {
			String[] st = br.readLine().split(" ");
			edges[i][0] = Integer.parseInt(st[0]);
			edges[i][1] = Integer.parseInt(st[1]);
			edges[i][2] = Integer.parseInt(st[2]);
		}

		System.out.println(minCostToSupplyWater(v, edges));
	}

	static int[] parent;
	static int[] rank;

	public static class Pair implements Comparable<Pair> {
		int u;
		int v;
		int wt;

		Pair(int u, int v, int wt) {
			this.u = u;
			this.v = v;
			this.wt = wt;
		}

		@Override
		public int compareTo(Pair o) {
			return this.wt - o.wt;
		}
	}

	public static int find(int x) {
		if( parent[x] == x ) {
			return x;
		}
		int sl = find(parent[x]);
		parent[x] = sl; // path compression
		return sl;
	}
	
	public static boolean union(int u, int v) {
		int sl1 = find(u);
		int sl2 = find(v);
		
		if( sl1 != sl2 ) {
			// merging 
			if( rank[sl1] < rank[sl2] ) {
				parent[sl1] = sl2;
			}
			else if( rank[sl2] < rank[sl1] ) {
				parent[sl2] = sl1;
			}
			else {
				parent[sl1] = sl2;
				rank[sl2]++;
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int minCostToSupplyWater(int n, int[][] pipes) {
          Arrays.sort(pipes, (a,b) -> {
        	  // -ve -> a < b
        	  // +ve -> a > b
        	  // 0   -> a == b;
        	  return a[2] - b[2]; 
          });
          
          parent = new int[n];
          rank = new int[n];
          
          for(int i = 0; i < n; i++) {
        	  parent[i] = i;
        	  rank[i] = 0;
          }
          
          int mincost = 0;
          for(int i = 0; i < pipes.length; i++) {
        	  int u = pipes[i][0];
        	  int v = pipes[i][1];
        	  int wt = pipes[i][2];
        	  
        	  if( union(u, v) == true ) {
        		  // u, v edge is used for creating mst
        		  mincost += wt;
        	  }
          }
          return mincost;
	}
}
