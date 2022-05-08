/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PreOrder and InOrder Traversal.
3. you will be given two arrays representing a valid PreOrder & InOrder of a Binary Tree. Program is required to create a unique Binary Tree.
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid InOrder & PreOrder traversals.
Sample Input
7
4 2 1 3 6 5 7
1 2 3 4 5 6 7
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

public class A02_Construct_BinaryTree_From_Preorder_And_Inorder_Traversal {
     
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		return buildTreeHelper(preorder, inorder, 0, n-1, 0, n-1);
	}
	
	public static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int ps, int pe, int is, int ie){
		
		if( ps > pe ) {
			return null;
		}
		
        TreeNode root = new TreeNode(preorder[ps]);
        
        int idx = -1;
        for(int i=is; i <= ie; i++) {
        	if( inorder[i] == root.val ) {
        		idx = i;
        		break;
        	}
        }
        
        int colse = idx - is;
		
		root.left = buildTreeHelper(preorder, inorder, ps + 1, ps + colse, is, idx - 1);
		root.right = buildTreeHelper(preorder, inorder, ps + colse + 1, pe, (idx + 1), ie);
		
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
		int[] pre = new int[n];
		for (int i = 0; i < n; i++)
			pre[i] = scn.nextInt();

		int[] in = new int[n];
		for (int i = 0; i < n; i++)
			in[i] = scn.nextInt();

		TreeNode root = buildTree(pre, in);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}
}
