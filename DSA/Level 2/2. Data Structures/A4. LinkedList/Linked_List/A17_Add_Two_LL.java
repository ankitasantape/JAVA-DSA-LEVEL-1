/*
1. You are give two single linkedlist of digits. 
2. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
3. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input Format
1->2->3->4->5->6->7->null
7->8->9->null
Output Format
1->2->3->5->3->5->6->null
Constraints
0 <= N <= 10^6
Sample Input
6
6 1 3 2 4 0 
2
3 5 
Sample Output
6 1 3 2 7 5 

*/

package Linked_List;

import java.util.Scanner;

public class A17_Add_Two_LL {
   
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		
		while( head != null ) {
			ListNode currKaNext = head.next;
			
			head.next = prev;
			
			prev = head;
			head = currKaNext;
		}
		return prev;
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode h1 = reverse(l1);
		ListNode h2 = reverse(l2);
		
		ListNode head = new ListNode(-1);
		ListNode itr = head;
		int cy = 0;
		
		while( h1 != null || h2 != null | cy != 0 ) {
			int sum = (h1 != null ? h1.val : 0) + (h2 != null ? h2.val : 0) + cy;
			int q = sum / 10;
			int r = sum % 10;
			
			itr.next = new ListNode(r);
			cy = q;
			
			itr = itr.next;
			if( h1 != null ) {
			    h1 = h1.next;
			}
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

		ListNode ans = addTwoNumbers(head1, head2);
		printList(ans);
	}

}
