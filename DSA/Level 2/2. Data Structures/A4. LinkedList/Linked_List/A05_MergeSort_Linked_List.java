/*
Given the head of a linked list, return the list after sorting it in increasing order.
Time Complexity : O(nlogn)
Space Complexity : constant space 
Input Format
1->7->2->6->3->5->4->null
Output Format
1->2->3->4->5->6->7->null
Constraints
0 <= N <= 10^6
Sample Input
4
0
6
7
5
Sample Output
0 5 6 7 

*/

package Linked_List;

import java.util.Scanner;

public class A05_MergeSort_Linked_List {
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode midNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static ListNode mergeSort(ListNode head) {
		 if( head == null || head.next == null ) {
			 // there is only one node and one node is always sorted
			 return head;
		 }
	      ListNode mid = midNode(head);
	      ListNode shead = mid.next; // second half head
	      mid.next = null;
	      
	      ListNode lefthead = mergeSort(head);
	      ListNode righthead = mergeSort(shead);
	      ListNode reshead = mergeTwoLists(lefthead, righthead);
	        
	      return reshead;  
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode t1 = l1;
		ListNode t2 = l2;
		ListNode dh = new ListNode(-1);
		ListNode dt = dh;

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

		ListNode head = mergeSort(h1);
		printList(head);
	}
}
