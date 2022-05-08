/*
 * 
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

import java.util.PriorityQueue;
import java.util.Scanner;

public class A33_Merge_K_Sorted_Linked_List_Using_Priority_Queue {
   
	public static Scanner scn = new Scanner(System.in);

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

   // T(n) : 2*(KN)*log(K) + K*log(K)
    // Time: O((KN)*log(K)), Space: O(K)
    public static ListNode mergeKLists(ListNode[] lists) {
    	PriorityQueue<ListNode> pq = new PriorityQueue<>(
    	    (a,b) -> {
    	    	return a.val - b.val;
    	    }		
        );
    	
    	// T(n): K*log(K) Agar hum khudaki PQ banate to hum ye work O(K) me kr pate 
    	for(ListNode list : lists) {
    		if( list != null ) {
    			pq.add(list);
    		}
    	}
    	
    	ListNode dh = new ListNode(-1);
    	ListNode dt = dh;
    	
    	// T(n): 2*(KN)*log(K)
    	while(pq.size() != 0) { // K*N
    		ListNode remnode = pq.remove(); // log(K)
    		
    		dt.next = remnode;
    		dt = dt.next;
    		remnode = remnode.next;
    		
    		if( remnode != null ) {
    			pq.add(remnode); // log(K)  
    		}
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list);
        printList(head);
    }
}
