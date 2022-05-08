/*
1. Given a Binary Tree, print Diagonal order sum of it. 
Constraints
0 <= Number of Nodes <= 10^5
-1000 <= value of Node data <= 1000
Sample Input
15
4
2
1
-1
-1
3
-1
-1
6
5
-1
-1
7
-1
-1
Sample Output
17 10 1 

*/

package Trees;

import java.util.*;

import Trees.A18_Diagonal_Order_Of_A_Binary_Tree.TreeNode;

public class A20_Diagonal_Order_Sum_Of_A_Binary_Tree {
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
		ArrayDeque<TreeNode> q  = new ArrayDeque<>();
		q.add(root);
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		while( q.size() > 0 ) {
			int count = q.size();
			
			// to create dth diagonal
			int val = 0;
			while( count-- > 0 ) {
				TreeNode temp = q.remove();
				
				// work on temp's component
				while(temp != null) {
					val += temp.val;
					
					if(temp.left != null) {
						q.add(temp.left);
					}
					
					temp = temp.right;
				}
			}
			ans.add(val);
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

		ArrayList<Integer> ans = diagonalOrderSum(root);
		for (Integer j : ans)
			System.out.print(j + " ");

	}

	public static void main(String[] args) {
		solve();
	}
}
