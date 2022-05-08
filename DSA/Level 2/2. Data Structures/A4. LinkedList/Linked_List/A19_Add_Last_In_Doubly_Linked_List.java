/*
1. You are given a partially written DoublyLinkedList class.
2. You are required to complete the body of addLast function. This function is supposed to add an element to the front of LinkedList. You are required to update head, tail and size as required.
3. Input and Output is managed for you. Just update the code in addLast function.
Constraints
0 <= N <= 10^6
Sample Input
addFirst 4
addFirst 4
addLast 5
addFirst 7
addLast 1
stop
Sample Output
[7, 4, 4, 5, 1]

*/

package Linked_List;

import java.util.Scanner;

public class A19_Add_Last_In_Doubly_Linked_List {
     
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

		public void addLast(int val) {
			Node nn = new Node(val);
			
			if( size == 0 ) {
				head = nn;
				tail = nn;
			} else {
			    tail.next = nn;
			    nn.prev = tail;
			    tail = nn;
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
			else if (s[0].equals("addLast"))
				dll.addLast(Integer.parseInt(s[1]));

			str = scn.nextLine();
		}

		System.out.println(dll);
	}
}
