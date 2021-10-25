/*
 1. You are given a graph.
2. You are required to find and print if the graph is bipartite

Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually 
               exclusive and exhaustive vertices such that all edges are across sets.
Output Format
true if the graph is bipartite, false otherwise
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
Sample Output
false
 */

package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;

public class A11_Is_Graph_Bipartite {
	static class Pair{
    	String psf;
    	int vtx;
    	int level;
    	public Pair( int vtx, String psf, int level) {	
    		this.psf = psf;
    		this.vtx = vtx;
    		this.level = level;
    	}
    } 
//	Approch 2
	static class CPair{
		int vtx;
		int level;
		CPair(int vtx, int level){
			this.vtx = vtx;
			this.level = level;
		}
	}
	static class Edge {
	      int src;
	      int nbr;
	      int wt;

	      Edge(int src, int nbr, int wt) {
	         this.src = src;
	         this.nbr = nbr;
	         this.wt = wt;
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
	         int wt = Integer.parseInt(parts[2]);
	         graph[v1].add(new Edge(v1, v2, wt));
	         graph[v2].add(new Edge(v2, v1, wt));
	      }

	      // write your code here
          int[] visited = new int[graph.length];
	      Arrays.fill(visited, -1);
	      for(int i = 0; i < graph.length; i++) {
	    	  if(visited[i] == -1) {
	    		boolean isB =  isCompBipartt(graph, visited, i);
	    		if(isB == false) {
	    			System.out.println(false);
	    			return;
	    		} 
	    	  }
	      }
	      System.out.println(true);
//	      Approach 2
	      boolean[] visit = new boolean[graph.length];
	      for(int i = 0; i < graph.length; i++) {
	    	  if(visit[i] == false) {
	    		  boolean isCompBipartite = isCompBipartite(graph, i, visit);
	    		  if(isCompBipartite == false) {
	    			  System.out.println(false);
	    			  return;
	    		  }
	    	  }
	      }
	      System.out.println(true);
	   }

	private static boolean isCompBipartite(ArrayList<Edge>[] graph, int src, boolean[] visit) {
		HashMap<Integer, Integer> map = new HashMap<>(); // to store information of old level 
		Queue<CPair> q = new ArrayDeque<>();
		q.add(new CPair(src, 0));
		 
		while(q.size() != 0) {
			CPair rp = q.remove();
			if(visit[rp.vtx] == true) {
//				if already visited then cycle is present
				if(rp.level != map.get(rp.vtx)) {
					return false;
				}
			} else {
				visit[rp.vtx] = true;
				map.put(rp.vtx, rp.level);
				for(Edge e : graph[rp.vtx]) {
					int nbr = e.nbr;
					if(visit[nbr] == false) {
						q.add(new CPair(nbr, rp.level + 1));
					}
				}
			}
		}
		return true;
	}

	private static boolean isCompBipartt(ArrayList<Edge>[] graph, int[] visited, int src) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src, src + "", 0));
		
        while(!q.isEmpty()) {
        	Pair rp = q.remove();
        	if(visited[rp.vtx] != -1) {
        		if(rp.level != visited[rp.vtx]) {
        			return false;
        		}
        		
        	} else {
                visited[rp.vtx] = rp.level; 
        		
        	}
        	for(Edge e : graph[rp.vtx]) {
    			int nbr = e.nbr;
    			if(visited[nbr] == -1) {
    				q.add(new Pair(nbr, rp.psf + nbr, rp.level + 1)); 	
    			}
    		}
        }
        
        return true;	
	}
	
//	Approach 2 
}
