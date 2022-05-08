/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given InOrder Traversal.
3. you will be given an array representing a valid InOrder of a Binary Search Tree. Program is required to create a unique Balanced Binary Search Tree.
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid InOrder traversal.
Sample Input
7
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

public class A05_Construct_BST_From_Inorder_Traversal {
  
	public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        return helper(inOrder, 0, inOrder.length-1);
    }

    private static TreeNode helper(int[] arr, int lo, int hi) {
    	if( lo > hi ) {
    		return null;
    	}
		int mid = (lo + hi) / 2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = helper(arr, lo, mid-1);
		root.right = helper(arr, mid+1, hi);
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
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromInOrder(in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
