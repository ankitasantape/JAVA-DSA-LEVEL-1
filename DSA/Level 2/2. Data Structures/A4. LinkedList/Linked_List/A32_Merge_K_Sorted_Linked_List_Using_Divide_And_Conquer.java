/*
You are given an array of k linked-lists, each linked-list is sorted in increasing order.
Merge all the linkedlists into one sorted linkedlist and return it.
Input Format
3 sorted linkedlist :
{
    0->0->0->null,
    0->0->1->1->1->2->2->4->null,
    0->0->0->0->5->5->6->null
}
Output Format
after merging them : 
0->0->0->0->0->0->0->0->0->1->1->1->2->2->4->5->5->6->null
Constraints
0 <= k <= 10^5
0 <= size of linkedlist <= 1000
Sample Input
3
3
0 0 0 
8
0 0 1 1 1 2 2 4 
7
0 0 0 0 5 5 6 
Sample Output
0 0 0 0 0 0 0 0 0 1 1 1 2 2 4 5 5 6 

*/

package Linked_List;

import java.util.Scanner;

public class A32_Merge_K_Sorted_Linked_List_Using_Divide_And_Conquer {
   
	public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode merge2SortedLL(ListNode l1, ListNode l2) {
    	ListNode dh = new ListNode(-1);
    	ListNode dt = dh;
    	
    	ListNode t1 = l1;
    	ListNode t2 = l2;
    	
    	while(t1 != null && t2 != null) {
    		if( t1.val <= t2.val ) {
    			dt.next = t1;
    			dt = t1;
    			t1 = t1.next;
    		}
    		else {
    			dt.next = t2;
    			dt = t2;
    			t2  =t2.next;
    		}
    	}
    	if( t1 == null ) {
    		dt.next = t2;
    	}
    	else {
    		dt.next = t1;
    	}
    	return dh.next;
    }
    
    public static ListNode mergeKLists(ListNode[] lists, int si, int ei) {
    	if( si > ei ) {
    		return null;
    	}
    	if(si == ei) {
    		return lists[si];
    	}
    	int mid = (si + ei) / 2;
    	
    	ListNode l1 = mergeKLists(lists, si, mid);
    	ListNode l2 = mergeKLists(lists, mid + 1, ei);
    	
    	return merge2SortedLL(l1, l2);
    }
    
    public static ListNode mergeKLists(ListNode[] lists) {
    	if( lists.length == 0 ) {
    		return null;
    	}
    	return mergeKLists(lists, 0, lists.length-1);
  
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}
