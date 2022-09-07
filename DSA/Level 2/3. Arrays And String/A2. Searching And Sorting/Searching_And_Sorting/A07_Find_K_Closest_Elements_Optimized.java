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

public class A07_Find_K_Closest_Elements_Optimized {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4;
		int x = 3;

		List<Integer> list = findClosestElements(arr, k, x);
		System.out.println(list);

	}

	// T : O(log n + k log k)
	private static List<Integer> findClosestElements(int[] arr, int k, int x) {
		int lo = 0;
		int hi = arr.length-1;
		int mid = 0;
		
		// To find x apply binary search
		// T : O(log n)
		while(lo <= hi) {
			mid = (lo + hi)/2;
			
			if( arr[mid] == x ) {
				break;
			
			} else if( x < arr[mid] ) {
				hi = mid - 1;
			
			} else {
				lo = mid + 1;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		int r = mid; // right
		int l = mid-1; // left
		
		// Find k elements
		// T : O(k)
		while( l >= 0 && r < arr.length && k > 0 ) {
			
			if( Math.abs(arr[l] - x) <= Math.abs(arr[r] - x) ) {
				list.add(arr[l]);
				l--;
				
			} else {
				list.add(arr[r]);
				r++;	
			}
			k--;
		}
		
		while( k > 0 && l >= 0 ) {
			list.add(arr[l]);
			l--;
			k--;
		}
		
		while( k > 0 && r < arr.length ) {
			list.add(arr[r]);
			r++;
			k--;
		}
		
		// T : O(log k) --> sorting
		Collections.sort(list);
		
		return list;
	}

}
