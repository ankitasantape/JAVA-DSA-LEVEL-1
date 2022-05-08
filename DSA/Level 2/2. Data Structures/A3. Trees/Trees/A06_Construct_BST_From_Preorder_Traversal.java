/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given PreOrder Traversal.
3. you will be given an array representing a valid PreOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid PreOrder traversal.
Sample Input
6
3 2 1 6 5 7
Sample Output
2 -> 3 <- 6
1 -> 2 <- .
. -> 1 <- .
5 -> 6 <- 7
. -> 5 <- .
. -> 7 <- .

*/

package Trees;

import java.util.Scanner;

public class A06_Construct_BST_From_Preorder_Traversal {
   
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	static int i = 0; // idx
	public static TreeNode bstFromPreorder(int[] preorder) {
		 i = 0;
		return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
    
	// lr - left range, rr - right range
	private static TreeNode helper(int[] preorder, int lr, int rr) {
	
		if ( i >= preorder.length || preorder[i] < lr || preorder[i] > rr) {
			return null;
		} else {

			TreeNode node = new TreeNode(preorder[i]);
			i++;
			node.left = helper(preorder, lr, node.val);
			
			node.right = helper(preorder, node.val, rr);
			
			return node;
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
		int[] pre = new int[n];
		for (int i = 0; i < n; i++)
			pre[i] = scn.nextInt();

		TreeNode root = bstFromPreorder(pre);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}
}
