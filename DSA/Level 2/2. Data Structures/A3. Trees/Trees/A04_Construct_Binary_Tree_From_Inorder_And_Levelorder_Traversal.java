/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from InOrder and LevelOrder Traversal.
3. you will be given two arrays representing a valid InOrder & LevelOrder of a Binary Tree. Program is required to create a unique Binary Tree.
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid InOrder and LevelOrder traversals.
Sample Input
9
2 7 15 12 6 9 5 11 4
12 7 5 6 11 2 15 4 9
Sample Output
7 -> 12 <- 5
2 -> 7 <- 15
. -> 2 <- .
. -> 15 <- .
6 -> 5 <- 11
. -> 6 <- 9
. -> 9 <- .
. -> 11 <- 4
. -> 4 <- .


*/

package Trees;

import java.util.HashMap;
import java.util.Scanner;

public class A04_Construct_Binary_Tree_From_Inorder_And_Levelorder_Traversal {

	public static Scanner scn = new Scanner(System.in);

	static class TreeNode {
		int val;
		TreeNode left = null, right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	static HashMap<Integer, Integer> map; // element Vs index
	public static TreeNode buildTree(int[] inorder, int[] levelOrder) {
		   map = new HashMap<>();
		  for(int i = 0; i < inorder.length; i++) {
			  map.put(inorder[i], i);
		  }
		  // inorder ko virtually chota kr rhe to uski indexes pass kr diye
	      return helper(inorder, levelOrder, 0, inorder.length-1);
   
    }

	private static TreeNode helper(int[] inorder, int[] levelOrder, int is, int ie) {
		
		if( is > ie ) {
			return null;
		}
		
		TreeNode root = new TreeNode(levelOrder[0]);
		int idx = map.get(root.val);
		int colse = idx - is;
		int corse = ie - idx;
		
		int[] llo = new int[colse];
		int[] rlo = new int[corse];
		
		segregate(llo, rlo, levelOrder, idx);
		
		root.left = helper(inorder, llo, is, idx - 1);
		root.right = helper(inorder, rlo, idx + 1, ie);
		
		return root;
	}

	private static void segregate(int[] llo, int[] rlo, int[] levelOrder, int idx) {
		int j = 0;
		int k = 0;
		for(int i = 1; i < levelOrder.length; i++) {
			if( map.get(levelOrder[i]) < idx ) {
				// belongs to left Subtree
				llo[j++] = levelOrder[i];
			} else {
				rlo[k++] = levelOrder[i];
			}
		}
	}

	// input_section=================================================

	public static void display(TreeNode node) {
		if (node == null)
			return;

		StringBuilder sb = new StringBuilder();
		sb.append((node.left != null ? node.left.val : "."));
		sb.append(" -> " + node.val + " <- ");
		sb.append((node.right != null ? node.right.val : "."));

		System.out.println(sb.toString());

		display(node.left);
		display(node.right);

	}

	public static void solve() {
		int n = scn.nextInt();

		int[] InOrder = new int[n];
		for (int i = 0; i < n; i++)
			InOrder[i] = scn.nextInt();

		int[] LevelOrder = new int[n];
		for (int i = 0; i < n; i++)
			LevelOrder[i] = scn.nextInt();

		TreeNode root = buildTree(InOrder, LevelOrder);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}

}
