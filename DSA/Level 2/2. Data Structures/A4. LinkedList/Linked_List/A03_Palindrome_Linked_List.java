/*
Given a singly linked list of Integers, determine it is a palindrome or not.
Input Format
1->2->3->4->3->2->1->null
1->2->3->4->2->1->null
Output Format
true
false

Constraints
0 <= N <= 10^6
Sample Input
10
5
1
4
6
9
9
6
4
1
5
Sample Output
true

*/

package Linked_List;

import java.util.Scanner;

public class A03_Palindrome_Linked_List {
    
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

    public static boolean isPalindrome(ListNode head) {
        ListNode mid = midNode(head);
        ListNode sh = mid.next; // second half head of LL
        mid.next = null;
        
        ListNode t1 = head;
        ListNode t2 = reverse(sh);
        
        while(t2 != null) {
        	if( t1.val != t2.val ) {
        		return false;
        	}
        	t1 = t1.next;
        	t2 = t2.next;
        }
        return true;
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

        System.out.println(isPalindrome(dummy.next));
        scn.close();
    }
}
