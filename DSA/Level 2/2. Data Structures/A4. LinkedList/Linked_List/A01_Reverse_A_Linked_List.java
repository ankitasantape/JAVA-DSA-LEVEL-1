/*
You have given a pointer to the head node of a linked list, the task is to reverse the linked list. 
We need to reverse the list by changing the links between nodes.
Input Format
1->2->3->4->5->6->7->null
Output Format
7->6->5->4->3->2->1->null
Constraints
0 <= N <= 10^6
Sample Input
7
1 2 3 4 5 6 7
Sample Output
7 6 5 4 3 2 1

*/

package Linked_List;

import java.util.Scanner;

public class A01_Reverse_A_Linked_List {

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode reverse(ListNode head) {
		if (head.next == null) {
			return head;
		}
		ListNode prev = null;
		while (head != null) {
			ListNode newnode = head.next;
			head.next = prev;

			prev = head;
			head = newnode;
		}
		return prev;
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

		ListNode head = reverse(dummy.next);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		scn.close();
	}

}
