/*
1. Given the heads of two singly linked-lists headA and headB
2. Return the node at which the two lists intersect. 
3. If the two linked lists have no intersection, return null.

Constraints
0 <= N <= 10^6
Sample Input
4
14 12 8 7 
2
4
7 2 6 5 
Sample Output
8

*/

package Linked_List;

import java.util.Scanner;

import Linked_List.A14_Cycle_Node_In_Linked_List.ListNode;

public class A15_Intersection_Node_In_Two_LL_Using_Difference_Method {
   
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static int length(ListNode head) {
		int len = 0;
		while( head != null ) {
			head = head.next;
			len++;
		}
		return len;
	}
	
	public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
		
	          int size1 = length(headA);
	          int size2 = length(headB);
	          ListNode temp1 = headA;
	          ListNode temp2 = headB;
	          if(size1 > size2) {
	        	  for(int i = 0; i < (size1 - size2); i++) {
	        		  temp1 = temp1.next;
	        	  }
	          }else {  
	        	  for(int i = 0; i < (size2 - size1); i++) {
	        		  temp2 = temp2.next;
	        	  }
	          }
	          
	          while(temp1 != temp2) {
	        	  temp1 = temp1.next;
	        	  temp2 = temp2.next;
	          }
	          return temp1;
	}
	
	// Input_code===================================================

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

		int idx = scn.nextInt();

		ListNode head2 = makeList(scn.nextInt());

		if (idx >= 0) {
			ListNode curr = head1;
			while (idx-- > 0)
				curr = curr.next;

			ListNode prev = head2;
			while (prev.next != null)
				prev = prev.next;

			prev.next = curr;
		}

		ListNode ans = IntersectionNodeInTwoLL(head1, head2);
		System.out.println(ans != null ? ans.val : -1);
	}
}
