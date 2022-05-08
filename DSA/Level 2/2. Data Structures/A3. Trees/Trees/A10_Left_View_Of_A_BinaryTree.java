/*
1. Given a Binary Tree, print left view of it. 
2. Left view of a Binary Tree is set of nodes visible when tree is viewed from left side.

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
1
1
1
1
1
*/

package Trees;

import java.util.*;

import javax.swing.RootPaneContainer;

public class A10_Left_View_Of_A_BinaryTree {
    
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	// Using BFS
	public static ArrayList<Integer> leftView(TreeNode root) {
		
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayDeque<TreeNode> q = new ArrayDeque<>();
		
		if( root == null ) {
			return ans;
		}
		
		q.add(root);
		
		while(q.size() != 0) {
			int csize = q.size();
			int fn = -1;
			
			while( csize != 0 ) {
				// remove
				TreeNode rem = q.remove();
				if( fn == -1 ) {
					fn = rem.val;
				}
				// work
				csize--;
				
				// add children
				if(rem.left != null) {
					q.add(rem.left);
				}
				
				if(rem.right != null) {
					q.add(rem.right);
				}
			}
			ans.add(fn);
		}
		
		
		return ans;

	}

	// Using DFS
	public static ArrayList<Integer> leftView_DFS(TreeNode root) {
		ArrayList<Integer> lv = new ArrayList<>();
		
		helper(root, 0, lv);
		return lv;
	}
	
	private static void helper(TreeNode root, int lev, ArrayList<Integer> lv) {
		if( root == null ) {
			return;
		}
		if( lev == lv.size() ) {
			lv.add(root.val);
		}
		
		helper(root.left, lev + 1, lv);
		helper(root.right, lev + 1, lv);
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

		ArrayList<Integer> ans = leftView(root);
		for (Integer i : ans)
			System.out.println(i);
	}

	public static void main(String[] args) {
		solve();
	}
}
