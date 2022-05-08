/*
Given a singly linkedlist : l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln 
reorder it : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... 

for more information watch video.
Input Format
1->2->3->4->5->6->7->null
Output Format
1->7->2->6->3->5->4->null
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
5 5 1 1 4 4 6 6 9 9 

*/

package Linked_List;

import java.util.Scanner;

public class A06_Fold_Of_LL_Or_Reorder_List {
   
	public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
	
	public static ListNode midNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		
		while(head != null) {
			ListNode newnode = head.next;
			head.next = prev;
			
			prev = head;
			head = newnode;
		}
		return prev;
	}
	
    public static void fold(ListNode head) {

    	ListNode mid = midNode(head);
    	ListNode sh = reverse(mid.next);
    	mid.next = null;
    	
    	ListNode t1 = head;
    	ListNode t2 = sh;
    	
    	boolean flag = true;
    	ListNode dh = new ListNode(-1);
    	ListNode dt = dh;
    	
    	while( t1 != null || t2 != null) {
    		if( flag == true ) {
    			dt.next = t1;
    			dt = t1;
    			t1 = t1.next;
    			
    		} else {
    			dt.next = t2;
    			dt = t2;
    			t2 = t2.next;
    			
    		}
    		flag = !flag; // toggle 
    	}
    	
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
        fold(head);
        printList(head);
        scn.close();
    }
}
