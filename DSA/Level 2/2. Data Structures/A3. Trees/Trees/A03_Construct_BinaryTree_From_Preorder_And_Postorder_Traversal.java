/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PreOrder and PostOrder Traversal.
3. you will be given two arrays representing a valid PostOrder & PreOrder of a Binary Tree. Program is required to create a unique Binary Tree.
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid PreOrder and PostOrder traversals.
Sample Input
7
1 3 2 5 7 6 4
4 2 1 3 6 5 7
Sample Output
2 -> 4 <- 6
1 -> 2 <- 3
. -> 1 <- .
. -> 3 <- .
5 -> 6 <- 7
. -> 5 <- .
. -> 7 <- .


*/

package Trees;

import java.util.Scanner;

public class A03_Construct_BinaryTree_From_Preorder_And_Postorder_Traversal {

	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static TreeNode constructFromPrePost(int[] pre, int[] post) {
		int n = pre.length;
		return helper(pre, post, 0, n-1, 0, n-1);
	}
	
	private static TreeNode helper(int[] preorder, int[] postorder, int prs, int pre, int pos, int poe) {
		// if there is no people then return
		if( prs > pre ) {
			return null;
		}
		
		// we need two people, if not then return single people 
		if( pre == prs ) {
			return new TreeNode(preorder[prs]);
		}
		// we are handling two element at the same time, one element is at prs and second element is at prs + 1
		TreeNode root = new TreeNode(preorder[prs]);
		int idx = -1;
		int val = preorder[prs + 1];
		for(int i = pos; i <= poe; i++) {
			if( postorder[i] == val ) {
				idx = i;
				break;
			}
		}
		int colse = idx - pos + 1;
		root.left = helper(preorder, postorder, prs + 1, prs + colse, pos, idx);
		root.right = helper(preorder, postorder, prs + colse + 1, pre, idx + 1, poe - 1);
		
		return root;
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
		int[] post = new int[n];
		for (int i = 0; i < n; i++)
			post[i] = scn.nextInt();

		int[] pre = new int[n];
		for (int i = 0; i < n; i++)
			pre[i] = scn.nextInt();

		TreeNode root = constructFromPrePost(pre, post);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}
}
