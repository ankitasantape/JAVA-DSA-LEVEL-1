/*
Given a Directed Graph, find a Mother Vertex in the Graph (if present). 
A Mother Vertex is a vertex through which we can reach all the other vertices of the Graph.
Input Format
First line contains two space separated integers,N and M. Then M lines follow, each line has 2 space separated integers ai and bi.
Output Format
Print the mother vertex if present else print -1.

Constraints
1<= N <= 10000
1<= M <= (N*(N-1))/2
1<= ai, bi <= N
Sample Input
4 3
1 2
2 3
3 4
Sample Output
1
*/

package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A10_Mother_Vertex {
    
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(findMotherVertex(n, graph));
	}
	
    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj){
		boolean[] visited = new boolean[V];	
		Stack<Integer> st = new Stack<>();
		
		for(int i = 0; i < V; i++) {
			if(visited[i] == false) {
				dfs(adj, i, visited, st);
			}
		}
		
		int pmv = st.peek(); // potential mother vertex
		visited = new boolean[V];
		
		dfs(adj, pmv, visited);
		
		for(int i = 0; i < V; i++) {
			if(visited[i] == false) {
				return -1;
			}
		}
		
		return pmv;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, Stack<Integer> st) {
		// dfs me aate hi pehale src ko visited mark kara do
		visited[src] = true;
		
		// aur ab nbrs pe call laga do 
		for(int nbr : adj.get(src) ) {
			if(visited[nbr] == false) {
				dfs(adj, nbr, visited, st);
			}
		}
		
		st.push(src);
	}
	private static void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited) {
		// dfs me aate hi pehale src ko visited mark kara do
		visited[src] = true;

		// aur ab nbrs pe call laga do
		for (int nbr : adj.get(src)) {
			if (visited[nbr] == false) {
				dfs(adj, nbr, visited);
			}
		}
	}
	
}
