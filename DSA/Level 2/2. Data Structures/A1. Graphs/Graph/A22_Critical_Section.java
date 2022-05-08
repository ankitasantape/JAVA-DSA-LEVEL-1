/*
An edge in an undirected graph is a Bridge iff removing it disconnects the graph. You have to print all the Bridges of the given graph.
Input Format
First line contains two integers V and E.
Each of next E line contains two integer u and v denoting an edge between vertex u and v.
Output Format
Print all the bridges.
Constraints
1 <= number of vertices(V) <= 1000
1 <= number of Edges(E) <= V*(V-1)/2;
Sample Input
5 5
0 1
0 2
2 1
2 3
4 3
Sample Output
[[3, 4], [2, 3]]

*/

package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A22_Critical_Section {

	static int[]disc;
	static int[]low;
	static boolean[]ap;
	static int time = 0;
    
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<Integer>[]graph = new ArrayList[n];
        
        for(int i=0; i < n;i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i < connections.size();i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        List<List<Integer>>ans = new ArrayList<>();
        boolean[]vis = new boolean[n];
        
        disc = new int[n];
        low = new int[n];
        ap = new boolean[n];
        time = 0;
        
        bridge(graph,0,-1,vis,ans);
        
        return ans;
    }
    
    
    
    public static void bridge(ArrayList < Integer > [] graph, int src, int par, boolean[] vis,List<List<Integer>>ans) {
        disc[src] = low[src] = time;
        vis[src] = true;
        time++;

        for (int nbr: graph[src]) {
            if (nbr == par) {
                //do nothing
            } 
            else if (vis[nbr] == true) {
                //nbr is visited
                low[src] = Math.min(low[src], disc[nbr]);
            } 
            else if (vis[nbr] == false) {
                bridge(graph, nbr, src, vis, ans);
                low[src] = Math.min(low[src], low[nbr]);

                //to check bridge
                if(disc[src] < low[nbr]) {
                   ArrayList<Integer>list= new ArrayList<>();
                    list.add(src);
                    list.add(nbr);
                    ans.add(list);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);
        List<List<Integer>> edges = new ArrayList<>();


        for (int i = 0; i < e; i++) {
          edges.add(new ArrayList<>());
          st = br.readLine().split(" ");
          edges.get(i).add(Integer.parseInt(st[0]));
          edges.get(i).add(Integer.parseInt(st[1]));
        }

        System.out.println(criticalConnections(n, edges));

      }

}
