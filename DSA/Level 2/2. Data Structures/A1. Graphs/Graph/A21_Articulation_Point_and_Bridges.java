/*
A vertex in an undirected graph is an articluation point iff removing it disconnects the graph. You have to find the number of articulation point in the given graph.
Input Format
First line contains two integers V and E.
Each of next E line contains two integer u and v denoting an edge betwwen vertex u and v.
Output Format
Print the number of articulation point

Constraints
1 <= number of vertices(V) <= 1000
1 <= number of Edges(E) <= V*(V-1)/2;
Sample Input
5 5
1 2
1 3
3 2
3 4
5 4
Sample Output
2

*/

package Graph;

import java.util.*;

public class A21_Articulation_Point_and_Bridges {
    
	static int[] disc;
    static int[] low;
    static boolean[] ap;
    static int time = 0;
    static int osc = 0; // original source count

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtx = scn.nextInt();
        int edges = scn.nextInt();

        int temp = edges;

        ArrayList < Integer > [] graph = new ArrayList[vtx];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList < > ();
        }

        while (temp-- > 0) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            u--;
            v--;

            graph[u].add(v);
            graph[v].add(u);
        }

        disc = new int[vtx];
        low = new int[vtx];
        ap = new boolean[vtx];
        time = 0;
        osc = 0;

        boolean[] vis = new boolean[vtx];
        articulation_point(graph, 0, -1, vis);

        int count = 0;
        for (int i = 0; i < vtx; i++) {
            if (ap[i] == true) {
                count++;
            }
        }
        System.out.println(count);
    }



    public static void articulation_point(ArrayList < Integer > [] graph, int src, int par, boolean[] vis) {
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
                articulation_point(graph, nbr, src, vis);
                low[src] = Math.min(low[src], low[nbr]);

                //to check articulation point
                if (par == -1) {
                    //src is original source
                    osc++;

                    if (osc > 1) {
                        ap[src] = true;
                    }
                } 
                else if (disc[src] <= low[nbr]) {
                    ap[src] = true;
                }

                //to check bridge
                if(disc[src] < low[nbr]) {
                    System.out.println(src + "---" + nbr);
                }
            }
        }
    }
}
