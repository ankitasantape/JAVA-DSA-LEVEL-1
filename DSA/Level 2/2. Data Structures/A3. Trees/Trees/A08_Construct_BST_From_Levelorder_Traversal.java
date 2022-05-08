/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given LevelOrder Traversal.
3. you will be given an array representing a valid LevelOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Valid LevelOrder traversal.
Sample Input
6
3 2 5 1 6 7
Sample Output
2 -> 3 <- 5
1 -> 2 <- .
. -> 1 <- .
. -> 5 <- 6
. -> 6 <- 7
. -> 7 <- .

*/

package Trees;

import java.util.*;

public class A08_Construct_BST_From_Levelorder_Traversal {

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
		int lr;
		int rr;
		TreeNode parent; // parent node
		Pair(){
			
		}
		
		Pair(int lr, int rr, TreeNode parent){
			this.lr = lr;
			this.rr = rr;
			this.parent = parent;
		}
	}

	public static TreeNode constructBSTFromLevelOrder(int[] arr) {
		int n = arr.length;
		
		TreeNode root = null;
		ArrayDeque<Pair> que = new ArrayDeque<>();
		
	    que.add(new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, null));
		int i = 0;
		
		while(i < n) {
			Pair rem = que.remove();
			
			if( arr[i] < rem.lr || arr[i] > rem.rr ) {
				// out of range
				continue;
			} 
			else {
				TreeNode child = new TreeNode(arr[i]);
				i++;
				
				if( rem.parent == null ) {
					root = child;
				}
				else if( child.val < rem.parent.val  ) {
					rem.parent.left = child;
				} 
				else {
					rem.parent.right = child;
				}
				
				Pair lp = new Pair(rem.lr , child.val , child );
				Pair rp = new Pair(child.val , rem.rr , child );
				
				que.add(lp);
				que.add(rp);	
			}
			
		}
		
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
		int[] level = new int[n];
		for (int i = 0; i < n; i++)
			level[i] = scn.nextInt();

		TreeNode root = constructBSTFromLevelOrder(level);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}
}
