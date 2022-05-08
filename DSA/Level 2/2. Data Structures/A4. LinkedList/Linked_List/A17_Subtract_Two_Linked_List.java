/*
1. You are give two single linkedlist of digits. 
2. The most significant digit comes first and each of their nodes contain a single digit. Subtract the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
4. any list can be larger in term of number.
Input Format
1->2->3->4->5->6->7->null
7->8->9->null
Output Format
1->2->3->3->7->7->8->null
Constraints
0 <= N <= 10^6
Sample Input
6
1 8 0 5 4 6 
1
1 
Sample Output
1 8 0 5 4 5

Sample Input
8
1 3 0 0 3 2 0 2 
5
6 6 2 4 8 
Sample Output
1 2 9 3 6 9 5 4

Sample Input
8
1 4 7 4 1 8 8 7 
58
7 4 7 4 1 6 4 1 2 7 7 8 6 3 1 3 5 8 4 0 6 6 2 4 6 6 4 0 1 4 7 5 7 3 1 0 4 6 2 2 4 0 7 8 5 0 1 5 7 1 1 8 6 3 8 8 6 3 
Sample Output

*/

package Linked_List;

import java.util.Scanner;

public class A17_Subtract_Two_Linked_List {
   
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	 public static ListNode reverse(ListNode node){
	      ListNode prev = null;
	      while( node != null ){
	          ListNode nn = node.next;
	          node.next = prev;
	          
	          prev = node;
	          node = nn;
	      }
	      return prev;
	  }

	  public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
	        if( l2 == null ) {
	        	return l1;
	        }
	        if( l1 == null ) {
	        	l2.val = -l2.val;
	        	return l2;
	        }
	        ListNode h1 = reverse(l1);
			ListNode h2 = reverse(l2);
			
			ListNode head = new ListNode(-1);
			ListNode itr = head;
			int cy = 0;
			
			while( h1 != null ) {
				int diff =  h1.val - (h2!= null ? h2.val : 0 ) + cy;
			    if( diff < 0 ){
			        diff = diff + 10;
			        cy = -1;
			    } else {
			        cy = 0;
			    }
				
				itr.next = new ListNode(diff);
				itr = itr.next;		
				
			    h1 = h1.next;
				
			    // length of h2 is less
				if( h2 != null ) {
				    h2 = h2.next;
				}	
			}
			return reverse(head.next); 
	  }

	// InFput_code===================================================

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode makeList(int n) {
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while (n-- > 0) {
			prev.next = new ListNode(scn.nextInt());
			prev = prev.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode head1 = makeList(scn.nextInt());
		ListNode head2 = makeList(scn.nextInt());

		ListNode ans = subtractTwoNumbers(head1, head2);
		printList(ans);
	}
}
