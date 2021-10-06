/*
1. You are given a partially written BST class.
2. You are given a value. You are required to print all pair of nodes which add up to the given value. Make sure all pairs print the smaller value first and avoid duplicacies. Make sure to print the pairs in increasing order. Use the question video to gain clarity.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
"smaller node" "larger node"
.. all pairs that add to target on separate lines
Sample Input
21
50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
100
Sample Output
25 75
30 70 
 */
package Binary_Search_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class A07_Target_Sum_Pair_In_BST {
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
//		approach 1
		System.out.println("-----Arrproach1--------------");
		travelAndPrint(root, root, data);
		System.out.println("-----Arrproach2--------------");
//		approach 2
		ArrayList<Integer> list = new ArrayList<>();
		tnf(root, list);

		int left = 0, right = list.size() - 1;
		while (left != right) {
			int sum = list.get(left) + list.get(right);
			if (sum < data) {
				left++;
			} else if (sum > data) {
				right--;
			} else {
				System.out.println(list.get(left) + " " + list.get(right));
				left++;
				right--;
			}
		}
//		approach 3
		System.out.println("-----Arrproach3--------------");
		bestApproach(root, data);
	}

//	Approach - 1
	private static void travelAndPrint(Node root, Node node, int tar) {
		if (node == null) {
			return;
		}
		travelAndPrint(root, node.left, tar);
//		find complement
		int comp = tar - node.data;
		if (node.data < comp) {
			if (find(root, comp) == true) {
				System.out.println(node.data + " " + comp);
			}
		}

		travelAndPrint(root, node.right, tar);
	}

	private static boolean find(Node root, int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		}
		if (data < root.data) {
			return find(root.left, data);
		} else if (data > root.data) {
			return find(root.right, data);
		}
		return false;
	}

//	Approach - 2
	public static void tnf(Node node, ArrayList<Integer> arr) {
		if (node == null) {
			return;
		}
		tnf(node.left, arr);
		arr.add(node.data);
		tnf(node.right, arr);
	}

//	Approach 3
	public static void bestApproach(Node node, int tar) {
//		left stack -> data will be stored in increasing order 
		Stack<Pair> ls = new Stack<>();
//		right stack -> data will be stored in decreasing order 
		Stack<Pair> rs = new Stack<>();
		
		ls.push(new Pair(node, 0));
		rs.push(new Pair(node, 0));
		
		Node left = getNextFromNormalInorder(ls);
		Node right = getNextFromReverseInorde(rs);
		while(left.data < right.data) {
			if(left.data + right.data < tar) {
				left = getNextFromNormalInorder(ls);
			} else if(left.data + right.data > tar) {
				right = getNextFromReverseInorde(rs);
			} else {
				System.out.println(left.data + " " + right.data);
				left = getNextFromNormalInorder(ls);
				right = getNextFromReverseInorde(rs);
			}
		}
		
	}

	

	private static Node getNextFromReverseInorde(Stack<Pair> st) {
		while(st.size() > 0) {
			Pair top = st.peek();
			if(top.state == 0) {
				if(top.node.right != null) {
					Pair rc = new Pair(top.node.right, 0);
					st.push(rc);
				}
				top.state++;
			} else if(top.state == 1) {
				if(top.node.left != null) {
					Pair lc = new Pair(top.node.left, 0);
					st.push(lc);
				}
				top.state++;
				return top.node;
			} else {
				st.pop();
			}
		}
		return null;
	}

	private static Node getNextFromNormalInorder(Stack<Pair> st) {
		while(st.size() > 0) {
			Pair top = st.peek();
			if(top.state == 0) {
				if(top.node.left != null) {
					Pair lc = new Pair(top.node.left, 0);
					st.push(lc);
				}
				top.state++;
			} else if(top.state == 1) {
				if(top.node.right != null) {
					Pair rc = new Pair(top.node.right, 0);
					st.push(rc);
				}
				top.state++;
				return top.node;
			} else {
				st.pop();
			}
		}
		return null;
	}

}
