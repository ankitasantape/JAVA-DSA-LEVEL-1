/*
1. Given a Binary Tree, print Vertical Order of it. 
2. For each node at position (row, col), its left and right 
   children will be at positions (row + 1, col - 1) and (row + 1, col + 1) 
   respectively. The root of the tree is at (0, 0).
3. The vertical order traversal of a binary tree is a list of top-to-bottom 
   orderings for each column index starting from the leftmost column and ending 
   on the rightmost column. There may be multiple nodes in the same row and same 
   column. In such a case, sort these nodes by their values.

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

public class A14_Vertical_Order_Traversal_Of_A_BinaryTree_II {
    
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static class Pair implements Comparable<Pair>{
		int x;
		int y;
		TreeNode node;
		
		Pair(){
			
		}
		
		Pair(TreeNode node, int x, int y){
			this.node = node;
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Pair o) {
			if( this.y != o.y) {
				return this.y - o.y;
			} 
			else if( this.x != o.x ) {
				return this.x - o.x;
			}
			else {
				return this.node.val - o.node.val;
			}
		}
	}
	
	static int sx; // smallest x
    static int lx; // largest x
    private static void helper(TreeNode root, int x) {
		if( root == null ) {
			return;
		}
    	sx = Math.min(sx, x);
    	lx = Math.max(lx, x);
    	
    	helper(root.left, x - 1);
    	helper(root.right, x + 1);
	}
	
	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		sx = Integer.MAX_VALUE;
		lx = Integer.MIN_VALUE;
		helper(root, 0);
		int w = lx - sx + 1;
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < w; i++) {
			ans.add(new ArrayList<>());
		}
		// we are shifting origin to left so do -(-sx) = sx
		pq.add(new Pair(root, -sx, 0));
		
		while(pq.size() > 0) {
			// remove
			Pair rem = pq.remove();
			
			// work
			ans.get(rem.x).add(rem.node.val);
			
			// add children
			if(rem.node.left != null) {
				pq.add(new Pair(rem.node.left, rem.x - 1, rem.y + 1));
			}
			if(rem.node.right != null) {
				pq.add(new Pair(rem.node.right, rem.x + 1, rem.y + 1));
			}
		}
		
		return ans;
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
