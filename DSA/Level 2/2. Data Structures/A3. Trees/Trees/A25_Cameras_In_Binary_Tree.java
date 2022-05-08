/*
1. You are given a partially written function to solve.
2. You are required to complete the body of MinCamerasInBT_ function. The function is expected to return integer value representing minimum number of camera(s) required for the coverage of complete tree.
3.A camera is placed on any node will ensure coverage of parent-node as well as it's child-node(s), if any.
4. Input and Output is managed for you.
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
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
3

*/

package Trees;

import java.util.*;

public class A25_Cameras_In_Binary_Tree {
   
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static int cam = 0;
	
	public static int MinCamerasInBT(TreeNode root) {
		
		int rs = helper(root);
		
		if(rs == 0) {
			cam++;
		}
		return cam;
	}

	// 0 -> needs coverage
	// 1 -> camera
	// 2 -> covered
	private static int helper(TreeNode root) {
		if(root == null) {
			return 2; // i am already covered
		}
		
		int lci = helper(root.left); // left child indication
		int rci = helper(root.right); // right child indication
		
		if(lci == 0 || rci == 0) {
			cam++; // put a camera on node
			return 1;
		}
		else if(lci == 1 || rci == 1) {
			return 2; // node is covered
		}
		else {
			return 0; // i need coverage
		}
		
	}

	// input_Section_====================================================================

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
		System.out.println(MinCamerasInBT(root));

	}

	public static void main(String[] args) {
		solve();
	}
}
