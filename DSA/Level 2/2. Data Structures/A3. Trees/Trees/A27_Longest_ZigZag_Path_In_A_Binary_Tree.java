/*
1. You are given a partially written function to solve.
2. Given a binary tree root, a ZigZag path for a binary tree is defined as follow:
    a. Choose any node in the binary tree and a direction (right or left).
    b. If the current direction is right then move to the right child of the current node otherwise move to the left child.
    c. Change the direction from right to left or right to left.
    d. Repeat the second and third step until you can't move in the tree.

3.Zigzag length is defined in terms of edges. (A single node has a length of 0).
4. Return the longest ZigZag path contained in that tree.
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
4


*/

package Trees;

import java.util.*;

public class A27_Longest_ZigZag_Path_In_A_Binary_Tree {
    
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
		int lzzp; // left zig-zag path (starting from node)
		int rzzp; // right zig-zag path (starting from node)
		int mzzp;
		
		Pair(){
			
		}
		
		Pair(int lzzp, int rzzp, int mzzp){
			this.lzzp = lzzp;
			this.rzzp = rzzp;
			this.mzzp = mzzp;
		}
	}
	
	public static Pair solve(TreeNode node) {
		if( node == null ) {
			return new Pair(-1, -1, 0);
		}
		Pair lp = solve(node.left);
		Pair rp = solve(node.right);
		int lzzp = 1 + lp.rzzp;
		int rzzp = 1 + rp.lzzp;
		int mzzp = max(lzzp, rzzp, lp.mzzp, rp.mzzp);
	    
		return new Pair(lzzp, rzzp, mzzp);
	}
    // var-args -> var args javascript me hota hai like that
	// es function ke help se hum 3, 4, 5,,, kitne bhi logo ka max nikal sakte hai 
	public static int max(int...arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if( arr[i] > max ) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static int longestZigZagPath(TreeNode root) {
		Pair bp = solve(root);
		return bp.mzzp;
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

		System.out.println(longestZigZagPath(root));
	}

	public static void main(String[] args) {
		solve();
	}
}
