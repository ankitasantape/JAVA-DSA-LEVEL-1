/*
1. You are given a graph.
2. You are required to find and print if the graph is cyclic.
Sample Input
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10
Sample Output
false

 */

package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class A10_Is_Graph_Cyclic {
	static class Pair{
    	String psf;
    	int vtx;
    	
    	public Pair( int vtx, String psf) {
    		
    		this.psf = psf;
    		this.vtx = vtx;
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

	      boolean[] visited = new boolean[graph.length];
	      
	      for(int i = 0; i < graph.length; i++) {
	    	  if(visited[i] == false) {
	    		boolean cyclic =  isCompCyclic(graph, visited, i);
	    		if(cyclic == true) {
	    			System.out.println(true);
	    			 return;
	    		}
	    		
	    	  }
	      }
	      System.out.println(false );
	   }

	private static boolean isCompCyclic(ArrayList<Edge>[] graph, boolean[] visited, int src) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src, src + ""));
		
        while(!q.isEmpty()) {
        	Pair rp = q.remove();
        	if(visited[rp.vtx] == false) {
        		visited[rp.vtx] = true;
//        		System.out.println(redge.vtx + "@" + redge.psf);
        		for(Edge e : graph[rp.vtx]) {
        			int nbr = e.nbr;
        			if(visited[nbr] == false) {
        				q.add(new Pair(nbr, rp.psf + nbr));
                       	
        			}
        		}
        	} else {
        		return true;
        	}
        }
        return false;
		
	}
}
