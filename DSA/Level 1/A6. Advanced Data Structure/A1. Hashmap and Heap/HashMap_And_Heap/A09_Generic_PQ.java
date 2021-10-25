package HashMap_And_Heap;

import java.util.*;

public class A09_Generic_PQ {

	public static class Pair implements Comparable<Pair> {
		String name;
		int ht;
		int marks;

		public Pair(String name, int ht, int marks) {
			this.name = name;
			this.ht = ht;
			this.marks = marks;
		}

//		if child.marks( refers to this.marks) < parent.marks( refers to other.marks) then 
//		this.marks - other.marks = -ve means child < parent this violet HOP prop so do swap & upheapify and at peek we will get min value first
		
		public int compareTo(Pair o) {
			return this.marks - o.marks; // increasing order
		}
	}

	public static class MyPriorityQueue<T> {
		ArrayList<T> data;
		Comparator<T> comp;

		public MyPriorityQueue() {
			data = new ArrayList<>();
			comp = null;
		}

		public MyPriorityQueue(Comparator comp) {
			data = new ArrayList<>();
			this.comp = comp;
		}

		public void add(T val) {
			data.add(val);
			upheapify(data.size() - 1);
		}

		public void upheapify(int ci) {
			if (ci == 0) {
				return;
			}

			int pi = (ci - 1) / 2;
			if (isSmaller(ci, pi) == true) {
				swap(ci, pi);
				upheapify(pi);
			}
		}

		// i - > ci and j -> pi
		public boolean isSmaller(int i, int j) {
			if (comp == null) {
//	        	comparable me typecast krenge
				Comparable ith = (Comparable) data.get(i);
				Comparable jth = (Comparable) data.get(j);
				if (ith.compareTo(jth) < 0) {
					return true;
				} else {
					return false;
				}
			} else {
//	        	comparator ke basis pe sort honge
				T ith = data.get(i);
				T jth = data.get(j);
				if (comp.compare(ith, jth) < 0) {
					return true;
				} else {
					return false;
				}
			}
		}

		public void swap(int i, int j) {
			T ith = data.get(i);
			T jth = data.get(j);
			data.set(i, jth);
			data.set(j, ith);
		}

		public T remove() {
			if (data.size() == 0) {
				System.out.println("Underflow");
				return null;
			}
			swap(0, data.size() - 1);
			T rv = data.remove(data.size() - 1);

			downheapify(0);
			return rv;
		}

		public void downheapify(int pi) {
			int lci = 2 * pi + 1;
			int rci = 2 * pi + 2;

			int minidx = pi;
			if (lci < data.size() && isSmaller(lci, minidx) == true) {
				minidx = lci;
			}

			if (rci < data.size() && isSmaller(rci, minidx) == true) {
				minidx = rci;
			}

			if (minidx != pi) {
				swap(pi, minidx);
				downheapify(minidx);
			}
		}

		public T peek() {
			if (data.size() == 0) {
				System.out.println("Underflow");
				return null;
			} else {
				return data.get(0);
			}
		}

		public int size() {
			return data.size();
		}
	}
//    Comparator implementation by creating new class
	public static class PairHeightComp implements Comparator<Pair> {
		public int compare(Pair o1, Pair o2) {
			return o1.ht - o2.ht; // increasing order
		}
	}
	
	public static class PairMarksComp implements Comparator<Pair> {
		public int compare(Pair o1, Pair o2) {
			return o1.marks - o2.marks; // increasing order
		}
	}

	public static void main(String[] args) throws Exception {
//		if you don't pass anything inside PQ then it will sort on the basis of comparable
		MyPriorityQueue<Pair> mpq = new MyPriorityQueue<>();

		mpq.add(new Pair("A", 161, 80));
		mpq.add(new Pair("B", 180, 90));
		mpq.add(new Pair("C", 100, 94));
		mpq.add(new Pair("D", 171, 82));
		mpq.add(new Pair("E", 174, 96));
		mpq.add(new Pair("F", 101, 100));
		System.out.println("On the basis of marks using comparable: ");
		while (mpq.size() != 0) {
			Pair rp = mpq.remove();
			System.out.println(rp.name + " -> " + rp.marks);
		}
//      pass class PairComp which sort elements on the basis of comparator
//		sort on the basis of height
		System.out.println("On the basis of marks using comparator: ");
		MyPriorityQueue<Pair> mpq1 = new MyPriorityQueue<>(new PairMarksComp());
		mpq1.add(new Pair("A", 161, 80));
		mpq1.add(new Pair("B", 180, 90));
		mpq1.add(new Pair("C", 100, 94));
		mpq1.add(new Pair("D", 171, 82));
		mpq1.add(new Pair("E", 174, 96));
		mpq1.add(new Pair("F", 101, 100));

		while (mpq1.size() != 0) {
			Pair rp = mpq1.remove();
			System.out.println(rp.name + " -> " + rp.marks);
		}
//		sort on the basis of marks
		System.out.println("On the basis of height using comparator: ");
		MyPriorityQueue<Pair> mpq2 = new MyPriorityQueue<>(new PairHeightComp());
		mpq2.add(new Pair("A", 161, 80));
		mpq2.add(new Pair("B", 180, 90));
		mpq2.add(new Pair("C", 100, 94));
		mpq2.add(new Pair("D", 171, 82));
		mpq2.add(new Pair("E", 174, 96));
		mpq2.add(new Pair("F", 101, 100));

		while (mpq2.size() != 0) {
			Pair rp = mpq2.remove();
			System.out.println(rp.name + " -> " + rp.ht);
		}
	}
}
