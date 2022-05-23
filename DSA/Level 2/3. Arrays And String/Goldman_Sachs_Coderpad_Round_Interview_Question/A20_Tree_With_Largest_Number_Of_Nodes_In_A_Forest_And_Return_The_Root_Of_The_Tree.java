package Goldman_Sachs_Coderpad_Round_Interview_Question;

import java.util.*;

public class A20_Tree_With_Largest_Number_Of_Nodes_In_A_Forest_And_Return_The_Root_Of_The_Tree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// number of vertex
		int n = sc.nextInt();
		
		// number of edges
		int e = sc.nextInt();
		
		int[][] edges = new int[n][n];
		for(int i = 0; i < e; i++) {
			int fv = sc.nextInt();
			int sv = sc.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		ArrayList<ArrayList<Integer>> LargestTrees = connectedComponents(edges);
		int largestTree = Integer.MIN_VALUE;
		for(ArrayList<Integer> tree : LargestTrees) {
			largestTree = Math.max(largestTree, tree.size());
		}
		System.out.println(largestTree);
	}

	private static ArrayList<ArrayList<Integer>> connectedComponents(int[][] edges) {
		boolean[] visited = new boolean[edges.length];
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		
		for(int i = 0; i < visited.length; i++) {
			if( !visited[i] ) {
				arrayList.add( treePath(edges, i, visited) );
			}
		}
		return arrayList;
	}

	private static ArrayList<Integer> treePath(int[][] edges, int src, boolean[] visited) {
		
		ArrayList<Integer> arr = new ArrayList<>(); 
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		visited[src] = true;
		
		while(!queue.isEmpty()) {
			
			int front = queue.remove();
			arr.add(front);
			for(int i = 0; i < edges.length; i++) {
				if( !visited[i] && edges[front][i] == 1 ) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		Collections.sort(arr);
		return arr;
	}

	

}
