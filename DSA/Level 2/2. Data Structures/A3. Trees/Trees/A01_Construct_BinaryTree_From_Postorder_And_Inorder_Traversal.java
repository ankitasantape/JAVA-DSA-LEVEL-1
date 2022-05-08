/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PostOrder and InOrder Traversal.
3. you will be given two arrays representing a valid PostOrder & InOrder of a Binary Tree. Program is required to create a unique Binary Tree.
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid InOrder & PostOrder traversals.
Sample Input
7
1 3 2 5 7 6 4
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

public class A01_Construct_BinaryTree_From_Postorder_And_Inorder_Traversal {
   
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		int n = inorder.length;
		return buildTreeHelper(inorder, postorder, 0, n-1, 0, n-1);
	}
	
	public static TreeNode buildTreeHelper(int[] inorder, int[] postorder, int ps, int pe, int is, int ie){
		
		if( ps > pe ) {
			return null;
		}
		
        TreeNode root = new TreeNode(postorder[pe]);
        
        int idx = -1;
        for(int i=is; i <= ie; i++) {
        	if( inorder[i] == root.val ) {
        		idx = i;
        		break;
        	}
        }
        
        int colse = idx - is;
		
		root.left = buildTreeHelper(inorder, postorder, ps, ps + colse - 1, is, idx - 1);
		root.right = buildTreeHelper(inorder, postorder, ps + colse, pe - 1, (idx + 1), ie);
		
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

		int[] in = new int[n];
		for (int i = 0; i < n; i++)
			in[i] = scn.nextInt();

		TreeNode root = buildTree(in, post);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}
}
