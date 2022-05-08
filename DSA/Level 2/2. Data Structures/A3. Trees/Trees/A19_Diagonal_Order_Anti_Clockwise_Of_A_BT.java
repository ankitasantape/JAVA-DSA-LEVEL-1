/*
1. Given a Binary Tree, print Diagonal Order of it anti-clock wise. 
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

import Trees.A18_Diagonal_Order_Of_A_Binary_Tree.TreeNode;

public class A19_Diagonal_Order_Anti_Clockwise_Of_A_BT {
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
		ArrayDeque<TreeNode> q  = new ArrayDeque<>();
		q.add(root);
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		while( q.size() > 0 ) {
			int count = q.size();
			
			// to create dth diagonal
			ArrayList<Integer> list = new ArrayList<>();
			while( count-- > 0 ) {
				TreeNode temp = q.remove();
				
				// work on temp's component
				while(temp != null) {
					list.add(temp.val);
					
					if(temp.right != null) {
						q.add(temp.right);
					}
					
					temp = temp.left;
				}
			}
			ans.add(list);
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

		ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
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
