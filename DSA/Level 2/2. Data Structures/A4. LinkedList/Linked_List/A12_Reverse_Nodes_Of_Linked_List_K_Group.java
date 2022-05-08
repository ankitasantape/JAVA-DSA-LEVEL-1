/*
1. Given a singly linklist, reverse the nodes of a linked list k at a time and return its modified linkedlist.
2. If number of nodes in multiple of k then it will reverse otherwise it will add inn the end of linkedlist without any change.
Input Format
1->5->2->9->5->14->11->1->10->10->1->3->null
7
Output Format
11->14->5->9->2->5->1->10->10->1->3->null

Constraints
1 <= size Of LinkedList <= 10^6
0 <= k <= 10^6
Sample Input
12
1 5 2 9 5 14 11 1 10 10 1 3 
7
Sample Output
11 14 5 9 2 5 1 1 10 10 1 3 

*/

package Linked_List;

import java.util.Scanner;

public class A12_Reverse_Nodes_Of_Linked_List_K_Group {

	public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    static ListNode th = null; // temp head
    static ListNode tt = null; // temp tail
    public static void addFirst(ListNode node) {
    	if( th == null ) {
    		th = node;
    		tt = node;
    	} else {
    		node.next = th;
    		th = node;
    	}
    }

    public static ListNode reverseInKGroup(ListNode head, int k) {
    	
    	if( head == null || head.next == null || k == 0 ) {
    		return head;
    	}
    	
    	int len = length(head);
		ListNode oh = null; // original head
		ListNode ot = null; // original tail
		ListNode curr = head;
		
		while( len >= k ) {
			int tempK = k;
			while( tempK-- > 0 ) {
				ListNode forw = curr.next;
				curr.next = null;
				addFirst(curr);
				curr = forw;
			}
			if( oh == null ) {
				oh = th;
				ot = tt;
			} else {
				ot.next = th;
				ot = tt;
			}
			th = null;
			tt = null;
			len -= k;
		}
		
		ot.next = curr;
		
        return oh;
    }

    public static int length(ListNode head) {
    	int len = 0;
    	while(head != null) {
    		head = head.next;
    		len++;
    	}
    	return len;
    }
    
    
    public static ListNode reverse(ListNode node, int k)
    {
    	ListNode dummy = new ListNode(-1);
        dummy.next = node;
        int i = 0;
        int len = length(node);
        ListNode prev = dummy;
        ListNode previtr = dummy;
        ListNode temp = node;
        ListNode itr = node;
        
        while( len >= k ){
            
            while( i < k ){
            	ListNode nn = itr.next;
                itr.next = previtr;
                
                previtr = itr;
                itr = nn;
                i++;
            } 
            prev.next = previtr;
            temp.next = itr;
            len = len - k;
            i = 0;
            
            prev = temp;
            previtr = temp;
            temp  = itr;
        }
        
        if( len < k ){
            while( itr != null ){
            	ListNode nn = itr.next;
               itr.next = previtr;
                
               previtr = itr;
               itr = nn;
            }
        }
        prev.next = previtr;
        temp.next = itr;
        
        return dummy.next;
        
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }

}
