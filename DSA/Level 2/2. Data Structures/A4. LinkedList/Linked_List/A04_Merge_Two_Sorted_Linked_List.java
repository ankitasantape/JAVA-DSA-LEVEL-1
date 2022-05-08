/*
1. Merge two sorted linkedlists and return head of a sorted linkedlist. The list should be made by splicing together the nodes of the first two lists
2. Both list are sorted in increasing order.
Input Format
1->2->6->7->15->24->null
-1->0->6->17->25->null
Output Format
-1->0->1->2->6->6->7->15->17->24->25->null

Constraints
0 <= size of linkedlist <= 10^6
Sample Input
2
1 5 
4
1 3 6 10 
Sample Output
1 1 3 5 6 10 

*/

package Linked_List;

import java.util.Scanner;

public class A04_Merge_Two_Sorted_Linked_List {
   
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		return mergeTwoListsHelper1(l1, l2);
	}

	public static ListNode mergeTwoListsHelper1(ListNode l1, ListNode l2) {
		ListNode t1 = l1;
		ListNode t2 = l2;
		ListNode l3;
		ListNode t3;

		if (t1.val <= t2.val) {
			l3 = t1;
			t3 = t1;
			t1 = t1.next;

		} else {
			l3 = t2;
			t3 = t2;
			t2 = t2.next;
		}

		while (t1 != null && t2 != null) {
			if (t1.val <= t2.val) {
				t3.next = t1;
				t3 = t1;
				t1 = t1.next;
			} else {
				t3.next = t2;
				t3 = t2;
				t2 = t2.next;
			}
		}

		if (t1 == null && t2 == null) {
			return l3;
		} else if (t1 == null) {
			t3.next = t2;

		} else {
			t3.next = t1;
		}
		return l3;
	}
	// Using dummy node
	public static ListNode mergeTwoListsHelper2(ListNode l1, ListNode l2) {
		ListNode dh = new ListNode(-1);
		ListNode dt = dh;
		
		ListNode t1 = l1;
		ListNode t2 = l2;

		while (t1 != null && t2 != null) {
			if (t1.val <= t2.val) {
				dt.next = t1;
				dt = t1;
				t1 = t1.next;
			} else {
				dt.next = t2;
				dt = t2;
				t2 = t2.next;
			}
		}

		if (t1 == null) {
			dt.next = t2;

		} else {
			dt.next = t1;
		}
		return dh.next;
	}

	public static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public static ListNode createList(int n) {
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		while (n-- > 0) {
			prev.next = new ListNode(scn.nextInt());
			prev = prev.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		int n = scn.nextInt();
		ListNode h1 = createList(n);
		int m = scn.nextInt();
		ListNode h2 = createList(m);

		ListNode head = mergeTwoLists(h1, h2);
		printList(head);
	}
}
