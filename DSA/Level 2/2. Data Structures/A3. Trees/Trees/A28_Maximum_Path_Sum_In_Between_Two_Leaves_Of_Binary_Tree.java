/*
1. You are given a partially written function to solve.
2. You are required to complete the body of maxPathSum function. The function is expected to return Integer value depending upon maximum leaf-to-leaf paths sum.
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Sample Input
7
1
2
-1
-1
3
-1
-1
Sample Output
6

*/

package Trees;

import java.util.*;

public class A28_Maximum_Path_Sum_In_Between_Two_Leaves_Of_Binary_Tree {
   
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
		int n2l; // node to leaf 
		int l2l; // leaf to leaf
		Pair(int n2l, int l2l){
			this.n2l = n2l;
			this.l2l = l2l;
		}
	}
	
	public static Pair solve(TreeNode node) {
		
		if( node == null ) {
			return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
		}
		
		if( node.left == null && node.right == null ){
		    return new Pair(node.val, Integer.MIN_VALUE);
		}
		
		Pair lp = solve(node.left);
		Pair rp = solve(node.right);
		
		int nc = Integer.MIN_VALUE;
		
		if( node.left != null && node.right != null ) {
			nc = lp.n2l + node.val + rp.n2l;
		}
		
		
		int n2l = max(lp.n2l, rp.n2l) + node.val;
		int l2l = max(lp.l2l, rp.l2l, nc); 
		return new Pair(n2l, l2l);
	}
	
	// var-args -> var args javascript me hota hai like that
	// es function ke help se hum 3, 4, 5,,, kitne bhi logo ka max nikal sakte hai
	public static int max(int... arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static int maxPathSum(TreeNode root) {
		Pair bp = solve(root);
		//GFG Note: Here Leaf node is a node which is connected to exactly one different node.
		// becoz of this node we are adding this 2 line
		if((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
			return Math.max(bp.n2l, bp.l2l);
		}
		return bp.l2l;
	}

	// input_Section=================================================

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
		System.out.println(maxPathSum(root));
	}

	public static void main(String[] args) {
		solve();
	}
}
