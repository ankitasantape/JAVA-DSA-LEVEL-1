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

import Linked_List.A15_Intersection_Node_In_Two_LL_Using_Difference_Method.ListNode;

public class A16_Intersection_Node_In_Two_LL_Using_Floyd_Cycle_Method {
    
	public static Scanner scn = new Scanner(System.in);

	public static class ListNode {
		int val = 0;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
		if( headA == null || headB == null ) {
			return null;
		}
		
		ListNode tailA = headA;
		
		while( tailA.next != null ) {
			tailA = tailA.next;
		}
		
		tailA.next = headB;
		
		ListNode ans = CycleNode(headA);
		
        tailA.next = null;
        
		return ans;
	}
	
	public static ListNode CycleNode(ListNode head) {
    	if( head == null || head.next == null ) {
			return head;
		}
        ListNode fast = head;
        ListNode slow = head;
        while ( fast.next != null && fast.next.next != null ) {
        	
        	fast = fast.next.next;
        	slow = slow.next;
        	
        	if( slow == fast ) {
        		break;
        	}
        }
        if( slow != fast ) {
        	return null;
        }
        
        slow = head;
        while( slow != fast ) {
        	slow = slow.next;
        	fast = fast.next;
        }
        
		return fast;
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
