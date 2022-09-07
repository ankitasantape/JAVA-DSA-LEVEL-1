/*

https://leetcode.com/problems/find-k-closest-elements/

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]

Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]

3 aise elements batane hai jo 45 ke sbse jyada closed hai, means arr ke elements me aur 45 me jo gap hai na wo less hona chahiye
x = 45, k = 3

arr : 10 20 30 40 50 60

x = 45
a = 60
b = 30

|a-x| = 15
|b-x| = 15 , then choose that element whose value is less than between a & b (a < b)


*/


package Searching_And_Sorting;

import java.util.*;

public class A07_Find_K_Closest_Elements {

	public static class Pair implements Comparable<Pair>{
		int val;
		int gap;
		
		Pair(){
			
		}
		
		Pair(int val, int gap){
			this.val = val;
			this.gap = gap;
		}
		
		public int compareTo(Pair o) {
			// we want PQ in ascending order valuewise, but gapwise it should be in descending order. 
			// We will consider small those who have small gap
			if( this.gap == o.gap ) {
				// those have less value usako hum 'k' ke closed samzenge
				return this.val - o.val; // result -ve means this.val is less than other.val -> means valuewise ascending  
			
			} else {
				return this.gap - o.gap; // 
			}
		}
	}
	
	// T : O(nlogk + klogk) 
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
	       ArrayList<Integer> list = new ArrayList<>();
	       // max heap -> storing the pair of value with maximum gap
	       // we will get first pair having max gap & val
	       PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
	       
	       for(int i = 0; i < arr.length; i++) {
	    	   //  gap
	    	   int gap = Math.abs(arr[i] - x);
	    	   // first, we will put first k elements in 
	    	   if ( pq.size() < k ) {
	    		    pq.add(new Pair(arr[i], gap));
	    	   
	    	   } else {
	    	   	   // we want element in ascending order 
	    		   if( pq.peek().gap > gap ) {
	    			    // those value have max gap -> we will remove them 
	    			   // so, we will keep only those who have min gap     
	    			   pq.remove();
	    			   // add new pair
	    			   pq.add(new Pair(arr[i], gap));
	    		   }
	    	   }
	       }
	       
	       while(pq.size() > 0) {
	    	   Pair rem = pq.remove();
	    	   list.add(rem.val);
	       }
	       // to make list in ascending order
	       Collections.sort(list);
	       
	       return list;
	}
	
	public static void main(String[] args) {
		 int[] arr = {1,2,3,4,5};
		 int k = 4;
		 int x = -1;
		 
		 List<Integer> list = findClosestElements(arr, k, x);
		 System.out.println(list);
	}

}
