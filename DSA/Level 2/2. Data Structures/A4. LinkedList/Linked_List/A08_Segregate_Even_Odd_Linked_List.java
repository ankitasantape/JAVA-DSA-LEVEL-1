/*
Given a singly linklist, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.
Input Format
1->7->2->6->3->5->4->null
Output Format
2->6->4->1->7->3->5->null
Constraints
0 <= N <= 10^6
Sample Input
4
0
6
7
5
Sample Output
0 6 7 5 

*/

package Linked_List;

import java.util.Scanner;

public class A08_Segregate_Even_Odd_Linked_List {

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode segregateEvenOdd(ListNode head) {
		ListNode dhe = new ListNode(-1); // even head
		ListNode dte = dhe; // even tail

		ListNode dho = new ListNode(-1);
		ListNode dto = dho;

		ListNode temp = head;

		while (temp != null) {
			if (temp.val % 2 == 0) {
				dte.next = temp;
				dte = temp;

			} else {
				dto.next = temp;
				dto = temp;
			}

			temp = temp.next;

		}

		dte.next = dho.next;
		dto.next = null;

		return dhe.next;
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

		ListNode head = segregateEvenOdd(dummy.next);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		scn.close();
	}

}
