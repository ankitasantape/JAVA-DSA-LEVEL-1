/*
1. You are required to complete the code of our Priority Queue class using the heap data structure. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Here is the list of functions that you are supposed to complete:
    2.1. add -> Should accept new data.
    2.2. remove -> Should remove and return smallest value, if available or print 
     "Underflow" otherwise and return -1.
     2.3. peek -> Should return smallest value, if available or print "Underflow" 
     otherwise and return -1.
     2.4. size -> Should return the number of elements available.
3. Input and Output is managed for you.
Sample Input
add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit
Sample Output
10
10
10
20
20
30
30
40
40
50

Sample Input
add 10
remove
peek
add 30
remove
peek
peek
add 20
add 50
peek
add 40
remove
peek
remove
peek
remove
peek
add 60
peek
quit
Sample Output
10
Underflow
30
Underflow
Underflow
20
20
40
40
50
50
Underflow
60
*/
package HashMap_And_Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class A08_PriorityQueue_Using_Heap {

	public static class PriorityQueue {
		ArrayList<Integer> data;

		public PriorityQueue() {
			data = new ArrayList<>();
		}
//         constructor --> O(n)
		public PriorityQueue(int[] arr) {
			data = new ArrayList<>();
			for(int i = 0; i < arr.length; i++) {
				data.add(arr[i]);
			}
//			To maintain downhepify
			for(int i = (data.size()-2)/2; i >= 0; i--) {
				downheapify(i);
			}
		}
		
		public void add(int val) {
			data.add(val);
			upheapify(data.size() - 1);
		}

		public void upheapify(int ci) {
			if (ci == 0) {
				return;
			}
			int pi = (ci - 1) / 2;
			if (data.get(pi) > data.get(ci)) {
				swap(ci, pi);
				upheapify(pi);
			}
		}

		public void swap(int i, int j) {
			int ith = data.get(i);
			int jth = data.get(j);
			data.set(i, jth);
			data.set(j, ith);
		}
//      TC : O(log n)
		public int remove() {
			if (data.size() == 0) {
				System.out.println("Underflow");
				return -1;
			}
			swap(0, data.size() - 1);
			int rn = data.remove(data.size() - 1);
			downheapify(0);
			return rn;

		}

		public void downheapify(int pi) {
			int lci = 2 * pi + 1;
			int rci = 2 * pi + 2;

			int minidx = pi;
			if (lci < data.size() && data.get(lci) < data.get(minidx)) {
				minidx = lci;
			}
			if (rci < data.size() && data.get(rci) < data.get(minidx)) {
				minidx = rci;
			}
			if (minidx != pi) {
				swap(pi, minidx);
				downheapify(minidx);
			}
		}

		public int peek() {
			if (data.size() == 0) {
				System.out.println("Underflow");
				return -1;
			}
			return data.get(0);
		}

		public int size() {
			return data.size();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = {12,34,56,21,43,5,67,90,-5,76,87};
		PriorityQueue qu = new PriorityQueue(arr);
		
//		
//		PriorityQueue qu = new PriorityQueue();
//
//		String str = br.readLine();
//		while (str.equals("quit") == false) {
//			if (str.startsWith("add")) {
//				int val = Integer.parseInt(str.split(" ")[1]);
//				qu.add(val);
//			} else if (str.startsWith("remove")) {
//				int val = qu.remove();
//				if (val != -1) {
//					System.out.println(val);
//				}
//			} else if (str.startsWith("peek")) {
//				int val = qu.peek();
//				if (val != -1) {
//					System.out.println(val);
//				}
//			} else if (str.startsWith("size")) {
//				System.out.println(qu.size());
//			}
//			str = br.readLine();
//		}
	}
}
