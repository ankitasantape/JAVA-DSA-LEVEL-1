/*
1. You are given a partially written DoublyLinkedList class.
2. You are required to complete the body of addFirst function. This function is supposed to add an element to the front of LinkedList. You are required to update head, tail and size as required.
3. Input and Output is managed for you. Just update the code in addFirst function.
Constraints
0 <= N <= 10^6
Sample Input
addFirst 10
addFirst 20
addFirst 30
stop
Sample Output
[30, 20, 10]

*/

package Linked_List;

import java.util.Scanner;

public class A18_Add_First_In_Doubly_Linked_List {
   
	public static class DoublyLinkedList {
		private class Node {
			int data = 0;
			Node prev = null;
			Node next = null;

			Node(int data) {
				this.data = data;
			}

		}

		private Node head = null;
		private Node tail = null;
		private int size = 0;

		public String toString() {
			StringBuilder sb = new StringBuilder();
			Node curr = this.head;
			sb.append("[");
			while (curr != null) {
				sb.append(curr.data);
				if (curr.next != null)
					sb.append(", ");
				curr = curr.next;
			}
			sb.append("]");

			return sb.toString();
		}

		public void addFirst(int val) {
               Node nn = new Node(val);
               
               if( size == 0 ) {
            	   head = nn;
            	   tail = nn;
               } else {
            	   nn.next = head;
            	   head.prev = nn;
            	   head = nn;
               }
               
               size++;
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		DoublyLinkedList dll = new DoublyLinkedList();

		String str = scn.nextLine();
		while (!str.equals("stop")) {
			String[] s = str.split(" ");
			if (s[0].equals("addFirst"))
				dll.addFirst(Integer.parseInt(s[1]));

			str = scn.nextLine();
		}
		System.out.println(dll);
	}
}
