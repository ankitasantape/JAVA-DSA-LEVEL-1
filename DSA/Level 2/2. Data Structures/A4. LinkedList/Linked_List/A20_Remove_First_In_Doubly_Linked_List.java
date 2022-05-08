/*
1. You are given a partially written DoublyLinkedList class.
2. You are required to complete the body of removeFirst function. This function is supposed to add an element to the front of LinkedList. 
3. If size of list is zero then return "ListIsEmpty: -1". 
4. You are required to update head, tail and size as required.
5. Input and Output is managed for you. Just update the code in removeFirst function.
Constraints
0 <= N <= 10^6
Sample Input
addFirst 4
addFirst 4
addLast 5
addFirst 7
addLast 1
removeFirst
removeFirst
removeFirst
removeFirst
removeFirst
removeFirst
stop
Sample Output
7
4
4
5
1
ListIsEmpty: -1
[]

*/

package Linked_List;

import java.util.Scanner;

public class A20_Remove_First_In_Doubly_Linked_List {
    
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

		// Exceptions========================================

		private boolean ListIsEmptyException() {
			if (this.size == 0) {
				System.out.print("ListIsEmpty: ");
				return true;
			}
			return false;
		}

		// AddFunctions======================================

		private void addFirstNode(Node node) {
			if (this.size == 0)
				this.head = this.tail = node;
			else {
				node.next = this.head;
				this.head.prev = node;
				this.head = node;
			}
			this.size++;
		}

		public void addFirst(int val) {
			Node node = new Node(val);
			addFirstNode(node);
		}

		private void addLastNode(Node node) {
			if (this.size == 0)
				this.head = this.tail = node;
			else {
				this.tail.next = node;
				node.prev = this.tail;
				this.tail = node;
			}
			this.size++;
		}

		public void addLast(int val) {
			Node node = new Node(val);
			addLastNode(node);
		}

		// RemoveFunctions======================================

		public int removeFirst() {
            
			if (ListIsEmptyException() == true ) {
				return -1;
			} 
			int val = head.data;
			if(size == 1) {
				head = tail = null;
			} 
			else {
			    Node hn = head.next;
			    head.next = null;
			    hn.prev = null;
			    head = hn;
			}
			size--;
			return val;
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
			else if (s[0].equals("addLast"))
				dll.addLast(Integer.parseInt(s[1]));
			else if (s[0].equals("removeFirst"))
				System.out.println(dll.removeFirst());

			str = scn.nextLine();
		}

		System.out.println(dll);
	}
}
