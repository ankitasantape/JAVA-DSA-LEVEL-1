package Graph;

import java.util.ArrayList;

public class A00_Constructor {
//    public static class Edge{
//    	int src;
//    	int nbr;
//    	int wt;
//    	
//    	public Edge(int src, int nbr, int wt) {
//    		this.src = src;
//    		this.nbr = nbr;
//    		this.wt = wt;
//    	}
//    }
//    public static void main(String[] args) {
//    	ArrayList<Edge>[] graph = new ArrayList[7];
//        for(int i = 0 ; i < graph.length; i++){
//            graph[i] = new ArrayList<>();
//        }
//        
//        graph[0].add(new Edge(0, 1, 10));
//        graph[0].add(new Edge(0, 3, 40));
//        
//        graph[1].add(new Edge(1, 0, 10));
//        graph[1].add(new Edge(1, 2, 10));
//        
//        graph[2].add(new Edge(2, 1, 10));
//        graph[2].add(new Edge(2, 3, 10));
//        
//        graph[3].add(new Edge(3, 0, 40));
//        graph[3].add(new Edge(3, 2, 10));
//        graph[3].add(new Edge(3, 4, 3));
//        
//        graph[4].add(new Edge(4, 3, 3));
//        graph[4].add(new Edge(4, 5, 3));
//        graph[4].add(new Edge(4, 6, 7));
//        
//        graph[5].add(new Edge(5, 4, 3));
//        graph[5].add(new Edge(5, 6, 2));
//        
//        graph[6].add(new Edge(6, 4, 7));
//        graph[6].add(new Edge(6, 5, 2));
//        
//        for(int i = 0; i < graph.length; i++) {
//        	System.out.print(i);
//        	for(Edge e : graph[i]) {
//        		
//        	}
//        }
//	}
	
	public static class Edge{
		int src;
		int dest;
		int edgwt;
		
		public Edge(int src, int dest, int edgwt) {
			this.src = src;
			this.dest = dest;
			this.edgwt = edgwt;
		}
	}
	
	public static void main(String[] args) {
//		first create 1d array which will be called graph
//		this graph will store an ArrayList of edges(src, dest, edgwt)
		ArrayList<Edge> graph[] = new ArrayList[7];
		
		for(int i = 0; i < 7; i++) {
			graph[i] = new ArrayList<Edge>( );
		}
		
//		At vertex 0, edge from src = 0 to dest = 1 with weight = 10 
		graph[0].add(new Edge(0, 1, 10));
		graph[0].add(new Edge(0, 3, 40));
//		at vertex 1
		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 2, 10));
//		at vertex 2
		graph[2].add(new Edge(2, 1, 10));
		graph[2].add(new Edge(2, 3, 10));
//		at vertex 3
		graph[3].add(new Edge(3, 0, 40));
		graph[3].add(new Edge(3, 2, 10));
		graph[3].add(new Edge(3, 4, 3));
//		at vertex 4
		graph[4].add(new Edge(4, 3, 3));
		graph[4].add(new Edge(4, 5, 3));
		graph[4].add(new Edge(4, 6, 7));
//		at vertex 5
		graph[5].add(new Edge(5, 4, 3));
		graph[5].add(new Edge(5, 6, 2));
//		at vertex 6
		graph[6].add(new Edge(6, 4, 7));
		graph[6].add(new Edge(6, 5, 2));
		
		for(int i = 0; i < 7; i++) {
			int sal = graph[i].size();
			for(int j = 0; j < sal; j++) {
				Edge e = graph[i].get(j);
				System.out.println("Src: " + e.src + " Dest: "+ e.dest + " Weight : "+ e.edgwt);
			}
			System.out.println();
		}
	}
}
