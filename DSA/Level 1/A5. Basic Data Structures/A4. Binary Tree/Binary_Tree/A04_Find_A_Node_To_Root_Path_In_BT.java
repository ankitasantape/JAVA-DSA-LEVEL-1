/*
1. You are given a partially written BinaryTree class.
2. You are given an element.
3. You are required to complete the body of find and nodeToRoot function. The functions are expected to 
    3.1. find -> return true or false depending on if the data is found in binary tree.
    3.2. nodeToRoot -> returns the path from node (corresponding to data) to root in 
    form of an arraylist (root being the last element)
4. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
30
Sample Output
true
[30, 37, 25, 50]

*/
package Binary_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class A04_Find_A_Node_To_Root_Path_In_BT {

	public static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public static class Pair {
		Node node;
		int state;

		Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}

	public static Node construct(Integer[] arr) {
		Node root = new Node(arr[0], null, null);
		Pair rtp = new Pair(root, 1);

		Stack<Pair> st = new Stack<>();
		st.push(rtp);

		int idx = 0;
		while (st.size() > 0) {
			Pair top = st.peek();
			if (top.state == 1) {
				idx++;
				if (arr[idx] != null) {
					top.node.left = new Node(arr[idx], null, null);
					Pair lp = new Pair(top.node.left, 1);
					st.push(lp);
				} else {
					top.node.left = null;
				}

				top.state++;
			} else if (top.state == 2) {
				idx++;
				if (arr[idx] != null) {
					top.node.right = new Node(arr[idx], null, null);
					Pair rp = new Pair(top.node.right, 1);
					st.push(rp);
				} else {
					top.node.right = null;
				}

				top.state++;
			} else {
				st.pop();
			}
		}

		return root;
	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data + "";
		System.out.println(str);

		display(node.left);
		display(node.right);
	}
    
//	static ArrayList<Integer> path = new ArrayList<>();
//	public static boolean find(Node node, int data) {
//		if (node == null) {
//			return false;
//		}
//		if(node.data == data) {
//			path.add(node.data);
//			return true;
//		}
//		boolean lhs = find(node.left, data);
//		if (lhs == true) {
//			path.add(node.data);
//			return true;
//		}
//		
//		boolean rhs = find(node.right, data);
//		if (rhs == true) {
//			path.add(node.data);
//			return true;
//		}
//		return false;
//	}
	
	public static boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		if(node.data == data) {
			return true;
		}
		boolean lhs = find(node.left, data);
		if (lhs == true) {
			return true;
		}
		
		boolean rhs = find(node.right, data);
		if (rhs == true) {
			return true;
		}
		return false;
	}
	
//	Optimized code hai ye code half tak hi chalega 
	public static ArrayList<Integer> nodeToRootPath(Node node, int data){
		if(node == null) {
			return new ArrayList<Integer>(); 
		}
		if(node.data == data) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(node.data);
			return path;
		}
		ArrayList<Integer> leftpath = nodeToRootPath(node.left, data);
		if(leftpath.size() > 0) {
			leftpath.add(node.data);
			return leftpath;
		}
		ArrayList<Integer> rightpath = nodeToRootPath(node.right, data);
		if(rightpath.size() > 0) {
			rightpath.add(node.data);
			return rightpath;
		}
		
		return new ArrayList<Integer>();
	}	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		String[] values = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			if (values[i].equals("n") == false) {
				arr[i] = Integer.parseInt(values[i]);
			} else {
				arr[i] = null;
			}
		}

		int data = Integer.parseInt(br.readLine());

		Node root = construct(arr);
		boolean found = find(root, data);
		System.out.println(found);
		ArrayList<Integer> path = nodeToRootPath(root, data);
		System.out.println(path);
	}

}
