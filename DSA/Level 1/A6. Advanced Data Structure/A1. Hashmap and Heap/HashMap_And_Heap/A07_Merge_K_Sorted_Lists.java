/*
 1. You are given a list of lists, where each list is sorted.
2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.
 Constraints
Space complextiy = O(k)
Time complexity = nlogk
where k is the number of lists and n is number of elements across all lists.
Sample Input
4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39
Sample Output
1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57 
 */
package HashMap_And_Heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class A07_Merge_K_Sorted_Lists {
	public static class Pair implements Comparable<Pair>{
		int data;
		int li;
		int di;
		Pair(int data,int li,int di){
			this.data = data;
			this.li = li;
			this.di = di;
		}
		public int compareTo(Pair o) {
			return this.data - o.data;
		}
	}
	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int li = 0; li < lists.size(); li++) {
        	ArrayList<Integer> list = lists.get(li);
        	pq.add(new Pair(list.get(0), li, 0));
        }
        while(pq.size() != 0) {
        	Pair rp = pq.remove();
        	rv.add(rp.data);
        	if(rp.di + 1 < lists.get(rp.li).size()) {
        		pq.add(new Pair( lists.get(rp.li).get(rp.di + 1), rp.li, rp.di + 1  ));
        	}
        }
		return rv;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> list = new ArrayList<>();

			int n = Integer.parseInt(br.readLine());
			String[] elements = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(elements[j]));
			}

			lists.add(list);
		}

		ArrayList<Integer> mlist = mergeKSortedLists(lists);
		for (int val : mlist) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}
