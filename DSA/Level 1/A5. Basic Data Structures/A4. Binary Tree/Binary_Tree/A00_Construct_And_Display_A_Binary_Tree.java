package Binary_Tree;

import java.util.Stack;
/*
 25 <- 50 -> 75
12 <- 25 -> 37
. <- 12 -> .
30 <- 37 -> .
. <- 30 -> .
62 <- 75 -> 87
. <- 62 -> 70
. <- 70 -> .
. <- 87 -> .
*/
public class A00_Construct_And_Display_A_Binary_Tree {

	public static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left,Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	public static class Pair {
		Node node;
		int state;
		
		Pair(Node node, int state){
			this.node = node;
			this.state = state;
		}
	}
	
//	public static void display(Node node) {
//		if(node == null) {
//			return;
//		}
//		String str = "";
//		str += node.left != null ? node.left.data + "" : "." ;
//		str += " <- " + node.data + " -> ";
//		str += node.right != null ? node.right.data + "" : "." ;
//		System.out.println(str);		
//		display(node.left);
//		display(node.right);
//	}
	
	
	public static void display(Node node) {
		if(node == null) {
			return;
		}
		String str = "";
		str += node.left != null ? node.left.data + "" : ".";
		str += " <- " + node.data + " -> ";
		str += node.right != null ? node.right.data + "" : ".";
		System.out.println(str);
		
		display(node.left);
		display(node.right);
	}
	
	public static Node construct(Integer[] arr) {
	  Stack<Pair> st = new Stack<>();
	  Node root = new Node(arr[0], null, null);
	  st.push(new Pair(root, 0));
	  
	  for(int i = 1; i < arr.length; i++) {
		  Pair tos = st.peek();
		  if(arr[i] == null ) {
			  tos.state++;
			  if(tos.state == 2) {
				  st.pop();
			  }
		  } else {
			  Node n = new Node(arr[i], null, null);
			  if(tos.state == 0) {
				  tos.node.left = n;
				  tos.state++;
			  } else {
				  tos.node.right = n;
				  st.pop();
			  }
			  st.push(new Pair(n, 0));
		  }
	   }
	   return root;
	}	
	
	public static void main(String[] args) {
		Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, 
				null, 70, null, null, 87, null, null };
		
//		Stack<Pair> st = new Stack<>();
//		Node rnode = new Node(arr[0], null, null);
//		int state = 1;
//		Pair rtp = new Pair(rnode, state);
//		st.push(rtp);
//		 int idx = 0;
//		 while(!st.isEmpty()) {
//			 Pair top = st.peek();
//			 if(top.state == 1) {
//				    idx++;
//					if(arr[idx] != null) {
//						top.node.left = new Node(arr[idx], null, null);
//						Pair lp = new Pair(top.node.left, 1);
//						st.push(lp);
//					} else {
//						top.node.left = null;
//					}
//					top.state += 1;
//				} else if(top.state == 2) {
//					idx++;
//					if(arr[idx] != null) {
//						top.node.right = new Node(arr[idx], null, null);
//						Pair rp = new Pair(top.node.right, 1);
//						st.push(rp);
//					} else {
//						top.node.right = null;
//					}
//					top.state += 1;
//				} else {
//					st.pop();
//				}
//		 }
	    Node root = construct(arr);		
		display(root);
	}

}
