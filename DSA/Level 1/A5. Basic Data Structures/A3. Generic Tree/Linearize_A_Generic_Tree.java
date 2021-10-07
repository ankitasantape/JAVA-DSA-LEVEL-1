

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 -> 20, .
20 -> 50, .
50 -> 60, .
60 -> 30, .
30 -> 70, .
70 -> 80, .
80 -> 110, .
110 -> 120, .
120 -> 90, .
90 -> 40, .
40 -> 100, .
100 -> .

 */

public class Linearize_A_Generic_Tree {

	  private static class Node {
	    int data;
	    ArrayList<Node> children = new ArrayList<>();
	  }

	  public static void display(Node node) {
	    String str = node.data + " -> ";
	    for (Node child : node.children) {
	      str += child.data + ", ";
	    }
	    str += ".";
	    System.out.println(str);

	    for (Node child : node.children) {
	      display(child);
	    }
	  }

	  public static Node construct(int[] arr) {
	    Node root = null;

	    Stack<Node> st = new Stack<>();
	    for (int i = 0; i < arr.length; i++) {
	         if (arr[i] == -1) {
	             st.pop();
	         } else {
	             Node t = new Node();
	             t.data = arr[i];

	            if (st.size() > 0) {
	                st.peek().children.add(t);
	            } else {
	               root = t;
	            }
		    st.push(t);
	         }
	    }

	    return root;
	  }
	
//     Linearize O(n^2) time complexity Solution
	  public static void linearize(Node node){
		  for (Node child : node.children) {
			  linearize(child);
		  }
		  while (node.children.size() > 1) {
			  Node lc = node.children.remove(node.children.size() - 1);
		      Node sl = node.children.get(node.children.size() - 1);
		      Node slt = getTail(sl);
		      slt.children.add(lc);
		  }
	     
	  }

	  private static Node getTail(Node node) {
               while(node.children.size() == 1) {
        	   node = node.children.get(0);
               }
               return node;
	  }

//	  Linearize Optimised O(n) time complexity Solution
	  public static Node linearize2(Node node){
		  if (node.children.size() == 0) {
			  return node;
		  }
//		  last node ki tail
		  Node lnkt = linearize2(node.children.get(node.children.size() - 1));
		  while (node.children.size() > 1) {
			  Node lc = node.children.remove(node.children.size() - 1);
		      Node sl = node.children.get(node.children.size() - 1);
		      Node slkt = linearize2(sl);
		      slkt.children.add(lc);
		  }
	      
	      return lnkt;
	  }
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    String[] values = br.readLine().split(" ");
	    for (int i = 0; i < n; i++) {
	      arr[i] = Integer.parseInt(values[i]);
	    }

	    Node root = construct(arr);
	    linearize(root);
	    linearize2(root);
	    display(root);
	  }

}
