/*
Implement LRU(Least Recently Used Cache), Task is to complete implementations of put(),get().
1. capacity : capacity of the cache will be provided as input.
2. put(key,value) : add the key-value pair to the Cache & override if the pair is already present in cache;
3. get(key) : get the value associated with the key, return "-1" incase key-value pair doesn't exists

NOTE : Watch Question video to get better understanding of problem.
Example  : 
    Input : Start 3
            put 1 10
            put 2 20
            put 3 30
            get 1
            put 1 15
            get 1
            get 2
            put 4 40
            get 3
            get 4
            Stop
            
            
    Output : 10
             15
             20
             -1
             40
Constraints
1 <= cap <= 2000
0 <= key <= 100000
0 <= val <= 100000
Sample Input
start 3
put 1 10
put 2 20
put 3 30
put 4 40
get 1
stop
Sample Output
-1             
             
*/

package Linked_List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class A31_LRU_Cache {
    
	public static class LRU {
		// Node class as data member
		public static class Node{
			int key;
			int value;
			Node prev;
			Node next;
			
			Node(){
				
			}
			
			Node(int key, int value){
				this.key = key;
				this.value = value;
				this.prev = this.next = null; 
			}
		}
		
		// DLL
		Node head = null;
		Node tail = null;
		int size = 0;
		int cap = 0;
		
		//Hashmap
		HashMap<Integer, Node> map;
		
		LRU(int capacity) {
              cap = capacity;
              map = new HashMap<>();
		}

		public int get(int key) {
            if( map.containsKey(key) == true ) {
            	Node n = map.get(key);
            	
            	// make 'n' most recent
            	removeNode(n);
            	addLastNode(n);
            	return n.value;
            }
            else {
            	return -1;
            }
		}

		public void put(int key, int value) {
             if(map.containsKey(key) == true) {
            	 Node n = map.get(key);
            	 n.value = value;
            	 
            	// make 'n' most recent
             	removeNode(n);
             	addLastNode(n);
             } 
             else {
            	 Node n = new Node(key, value);
            	 addLastNode(n);
            	 map.put(key, n);
            	 
            	 if(size > cap) {
            		 // remove least recent node
            		 int rmk = head.key; // remove key
            		 removeFirst();
            		 map.remove(rmk);
            	 }
             }
		}

		private void removeFirst() {
			if( size == 0) {
				return;
			}
			else if(size == 1) {
				head = head.next;
			}
			else {
				Node nh = head.next;
				head.next = null;
				nh.prev = null;
				head = nh;
			}
			size--;
			
		}

		private void addLastNode(Node nn) {
			if(size == 0) {
				head = tail = nn;
			} 
			else {
				tail.next = nn;
				nn.prev = tail;
				tail = nn;
			}
			size++;
		}

		private void removeNode(Node c) {
			if( size == 0 ) {
				return;
			} 
			else if( c == head ) {
				removeFirst();
			}
			else if( c == tail ) {
				removeLast();
			}
			else {
				Node p = c.prev;
				Node n = c.next;
				
				p.next = n;
				n.prev = p;
				
				c.next = c.prev = null;
				
				size--;
				
			}
		}

		private void removeLast() {
			if( size == 0) {
				return;
			}
			else if(size == 1) {
				head = tail = null;
			}
			else {
				Node tp = tail.prev;
				tp.next = null;
				tail.prev = null;
				tail = tp;
			}
			size--;	
			
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		LRU obj = new LRU(Integer.parseInt(str.split(" ")[1]));

		while (true) {
			str = br.readLine();
			String inp[] = str.split(" ");
			if (inp.length == 1) {
				break;
			} else if (inp.length == 2) {
				System.out.println(obj.get(Integer.parseInt(inp[1])));
			} else if (inp.length == 3) {
				obj.put(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
			}
		}
	}
}
