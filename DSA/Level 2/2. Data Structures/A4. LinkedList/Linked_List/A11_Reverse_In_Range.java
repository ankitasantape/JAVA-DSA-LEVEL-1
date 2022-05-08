/*
1. Given a singly linklist, Reverse a linkedlist from position starting position to end position.
2. Do it in one-pass. without using any extra space.
3. Indexing start from numeric 1.
Input Format
8->8->14->1->10->12->null 
3
5
Output Format
8->8->10->1->14->12->null
Constraints
1 <= size Of LinkedList <= 10^6
1 <= starting Position, ending Position <= 10^6
Sample Input
6
8 8 14 1 10 12 
3
5
Sample Output
8 8 10 1 14 12 

*/

package Linked_List;

import java.util.Scanner;

public class A11_Reverse_In_Range {

	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	
	public static ListNode reverseInRange(ListNode head, int n, int m) {
		
		ListNode dh = new ListNode(-1);
		ListNode dt = dh;
		ListNode left = head;
		
		ListNode prevLeft = dh;
		int i = 1;
		while( i < n ) {
			prevLeft.next = left;
			prevLeft = left;
		    left = left.next;
			i++;
		}
        
		// reverse
		return null;
		
		
		
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
		int sz = scn.nextInt();
		ListNode h1 = createList(sz);

		int m = scn.nextInt();
		int n = scn.nextInt();

		h1 = reverseInRange(h1, m, n);
		printList(h1);
	}

}
