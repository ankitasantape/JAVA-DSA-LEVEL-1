/*
1. Given a Binary Tree, print Vertical Order of it. 
Constraints
0 <= Number of Nodes <= 10^5
-1000 <= value of Node data <= 1000
Sample Input
15
1
1
-1
1
1
-1
1
-1
-1
1
-1
-1
1
-1
-1
Sample Output
0 -> 1 1 
1 -> 1 1 1 
2 -> 1 1 

*/

package Trees;

import java.util.*;

import Trees.A12_Width_Of_Shadow_Of_BinaryTree.TreeNode;

public class A13_Vertical_Order_Traversal_Of_A_BT_Without_Hashmap {
   
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static class Pair{
		TreeNode node;
		int x;
		
		Pair(){
			
		}
		Pair(TreeNode node, int x){
			this.node = node;
			this.x = x;
		}
	}

	static int sx; // smallest x
    static int lx; // largest x
    
    // Without using HashMap
	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
		sx = Integer.MAX_VALUE;
	    lx = Integer.MIN_VALUE;
	    // to print arrlist in ordered manner need sx and lx
	 	helper(root, 0);
		
	 	// pehle width ki size ki array anslist me dal denge
	 	int width = lx - sx + 1;
	 	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	 	
	 	for(int i = 0; i < width; i++) {
	 		ans.add(new ArrayList<>());
	 	}
	 	
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(root, -sx)); // why -sx? -(-sx) = sx hume origin ko shift krna hai aur indexing +ve value se start krni hai isiliye hum absolute value le rahe hai
		
		while( q.size() != 0 ) {
			// remove
			Pair rem = q.remove();
			// work
			ans.get(rem.x).add(rem.node.val);
			
			// add children
			if(rem.node.left != null) {
				q.add(new Pair(rem.node.left, rem.x - 1));
			}
			
			if(rem.node.right != null) {
				q.add(new Pair(rem.node.right, rem.x + 1));
			}
		}
		
		return ans;
	}

    private static void helper(TreeNode root, int x) {
		if( root == null ) {
			return;
		}
    	sx = Math.min(sx, x);
    	lx = Math.max(lx, x);
    	
    	helper(root.left, x - 1);
    	helper(root.right, x + 1);
	}

	// input_section=================================================

	public static TreeNode createTree(int[] arr, int[] IDX) {
		if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
			IDX[0]++;
			return null;
		}
		TreeNode node = new TreeNode(arr[IDX[0]++]);
		node.left = createTree(arr, IDX);
		node.right = createTree(arr, IDX);

		return node;
	}

	public static void solve() {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		int[] IDX = new int[1];
		TreeNode root = createTree(arr, IDX);

		ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
		int idx = 0;
		for (ArrayList<Integer> i : ans) {
			System.out.print(idx++ + " -> ");
			for (Integer j : i)
				System.out.print(j + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		solve();
	}
}
