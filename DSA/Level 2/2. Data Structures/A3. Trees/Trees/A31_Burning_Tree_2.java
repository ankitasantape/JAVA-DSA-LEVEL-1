/*
1. Given a binary tree and target. 
2. Find the minimum time required to burn the complete binary tree if the target is set on fire. 
3. It is known that in 1 second all nodes connected to a given node get burned. That is, its left child, right child and parent.
Constraints
1. The number of nodes in the tree is in the range [1, 10000].
2. -1000 <= Node.val <= 1000
3. All the values Node.val are unique.
4. target is the value of one of the nodes in the tree.
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
2
Sample Output
2 
1 3 4 
6 
5 7 

*/

package Trees;

import java.util.*;


public class A31_Burning_Tree_2 {
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	static HashMap<Integer, ArrayList<Integer>> map;
	public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
		map = new HashMap<>();
		ArrayList<TreeNode> n2rp = nodeToRootPath(root, data);
		
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		int t = 0;
		TreeNode bn = null; // backlisted node
		
		for(int i=0; i < n2rp.size(); i++) {
			kdown(n2rp.get(i), t, bn);
			t++;
			bn = n2rp.get(i);
		}
		
		for(int key = 0; key < map.size(); key++) {
			ans.add(map.get(key));
		}
		
		return ans; 
	}
	private static void kdown(TreeNode node, int t, TreeNode bn) {
		if( node == null || node == bn ) {
			return;
		}
		
		ArrayList<Integer> list  = map.getOrDefault(t, new ArrayList<Integer>());
		list.add(node.val);
		map.put(t, list);
		
		kdown(node.left, t+1, bn);
		kdown(node.right, t+1, bn);
	}

	private static ArrayList<TreeNode> nodeToRootPath(TreeNode root, int target) {
		
		if( root == null ) {
			return new ArrayList<>();
		}
		if( root.val == target ) {
			ArrayList<TreeNode> list = new ArrayList<>();
			list.add(root);
			return list;
		}
		
		ArrayList<TreeNode> left_list = nodeToRootPath(root.left, target);
		if( left_list.size() != 0 ) {
			left_list.add(root);
			return left_list;
		}
		
		ArrayList<TreeNode> right_list = nodeToRootPath(root.right, target);
		if( right_list.size() != 0 ) {
			right_list.add(root);
			return right_list;
		}
		return new ArrayList<>();
	}


	// input_section=================================================

	public static TreeNode createTree(int[] arr, int[] IDX) {
		if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
			IDX[0]++;
			return null;
		}
		TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
		Treenode.left = createTree(arr, IDX);
		Treenode.right = createTree(arr, IDX);

		return Treenode;
	}

	public static void solve() {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		int[] IDX = new int[1];
		TreeNode root = createTree(arr, IDX);
		int fireNode = scn.nextInt();

		ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
		if (ans.size() == 0)
			System.out.println();
		for (ArrayList<Integer> ar : ans) {
			for (Integer ele : ar)
				System.out.print(ele + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		solve();
	}
}
