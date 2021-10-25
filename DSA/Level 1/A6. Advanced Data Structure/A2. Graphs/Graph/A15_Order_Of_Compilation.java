/*
 1. You are given a directed acyclic graph. The vertices represent tasks and edges represent 
    dependencies between tasks.
2. You are required to find and print the order in which tasks could be done. The task that should be 
    done at last should be printed first and the task which should be done first should be printed last. 
    This is called topological sort. Check out the question video for details.

Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort if 
                                    for all directed edges uv, u appears before v in the graph
                                    Sample Input
7
7
0 1
1 2
2 3
0 3
4 5
5 6
4 6
Sample Output
4
5
6
0
1
2
3
 */

package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class A15_Order_Of_Compilation {
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
	      }
	      // write your code here
	      boolean[] visited = new boolean[vtces];
	      Stack<Integer> st = new Stack<>();
	      for(int i = 0; i < graph.length; i++) {
	    	  if(visited[i] == false) {
	    		  topological(graph, i, visited, st);
	    	  }
	      }
	      while(st.size() > 0) {
	    	  System.out.println(st.pop());
	      } 
	   }
	   public static void topological(ArrayList<Edge>[] graph,int src, boolean[] visited, Stack<Integer> st ) {
			visited[src] = true;
			for(Edge e : graph[src]) {
				int nbr = e.nbr;
				if(visited[nbr] == false) {
					topological(graph, nbr, visited, st);	
				}
			}
			st.push(src);
		}
		
}
