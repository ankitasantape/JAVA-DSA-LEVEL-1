/*
Given a singly linkedlist : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... 
reorder it :  l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln
for more information watch video.
Input Format
1->7->2->6->3->5->4->null
Output Format
1->2->3->4->5->6->7->null
Constraints
0 <= N <= 10^6
Sample Input
9 5 1 1 4 4 6 6 9 9 
Sample Output
5 1 4 6 9 9 6 4 1 
 
*/

package Linked_List;

import java.util.Scanner;

public class A07_Unfold_Of_Linked_List {
   
	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void unfold(ListNode head) {
		// segregate
          ListNode dh1 = new ListNode(-1);
          ListNode dt1 = dh1;
          
          ListNode dh2 = new ListNode(-1);
          ListNode dt2 = dh2;
          
          int idx = 0;
          ListNode temp = head;
          
          while( temp != null ) {
        	  if( idx % 2 == 0 ) {
        		  dt1.next = temp;
        		  dt1 = temp;
        		  
        	  } else {
        		  dt2.next = temp;
        		  dt2 = temp;
        	  }
        	  
        	  temp = temp.next;
        	  idx++;
          }
          
          dt1.next = null;
          dt2.next = null;
          
          ListNode rhead = reverse(dh2.next); // reverse head
          
          // append
          dt1.next = rhead;
          
          
               
	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode newnode = head.next;
			head.next = prev;
			
			prev = head;
			head = newnode;
		}
		return prev;
	}

	static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while (n-- > 0) {
			prev.next = new ListNode(scn.nextInt());
			prev = prev.next;
		}

		ListNode head = dummy.next;
		unfold(head);
		printList(head);
		scn.close();
	}
}
