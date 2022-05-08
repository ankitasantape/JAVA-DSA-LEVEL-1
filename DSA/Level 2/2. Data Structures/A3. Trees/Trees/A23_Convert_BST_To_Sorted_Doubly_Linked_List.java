/*
1. Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.
2. The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
3. The order of nodes in DLL must be the same as in Inorder for the given Binary Search Tree. The first node of Inorder traversal (leftmost node in BST) must be the head node of the DLL. 
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Sample Input
7
1 2 3 4 5 6 7
Sample Output
1 2 3 4 5 6 7 

*/

package Trees;

import java.util.*;

public class A23_Convert_BST_To_Sorted_Doubly_Linked_List {
   
	public static Scanner scn = new Scanner(System.in);

	public static class Node {
		int val = 0;
		Node left = null;
		Node right = null;

		Node(int val) {
			this.val = val;
		}
	}

	public static Node prev;
	public static Node bToDLL(Node root) {
		Node dh = new Node(-1);
		prev = dh;
		
		helper(root);
		Node head = dh.right;
		Node tail = prev;
		
		// dll -> cdll
		head.left = tail;
		tail.right = head;
		
		return head;
	}

	private static void helper(Node curr) {
		if(curr == null) {
			return;
		}
		helper(curr.left);
		
		//work
		prev.right = curr;
		curr.left = prev;
		prev = curr;
		
		helper(curr.right);
	}

	// input_section=================================================

	public static void display(Node node) {
		Node head = node;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.right;
			if (node == head)
				break;
		}

	}

	public static Node constructFromInOrder_(int[] in, int si, int ei) {
		if (si > ei)
			return null;

		int mid = (si + ei) / 2;
		Node node = new Node(in[mid]);

		node.left = constructFromInOrder_(in, si, mid - 1);
		node.right = constructFromInOrder_(in, mid + 1, ei);

		return node;
	}

	public static Node constructFromInOrder(int[] inOrder) {
		int n = inOrder.length;
		return constructFromInOrder_(inOrder, 0, n - 1);
	}

	public static void solve() {
		int n = scn.nextInt();
		int[] in = new int[n];
		for (int i = 0; i < n; i++)
			in[i] = scn.nextInt();

		Node root = constructFromInOrder(in);
		root = bToDLL(root);
		display(root);
	}

	public static void main(String[] args) {
		solve();
	}
}
