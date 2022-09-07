/*
 * Approach: 
 1. Scan both arrays simultaneously
 2. Compare element of both of the array and print the smaller value.
 3. Increment the counter of the array with the smaller value.
 4. After smaller array is completed. Print out the remaining elements of the larger array.
 
 * This 2 arrays are sorted array
 a1 -> 1 2 2 3 4
 a2 -> 1 1 3 5
 Union AL -> 1 2 3 4 5
 
 Approach 1:
 Brute Force:
 1. Merge both the sorted array
 2. Sort the array
 3. Then find the unique elements only
 
 T : O(n + m).log(n + m)
 
 Approach 2:
 Use HashSet
 
 Approach 3:
 T : O(n + m)
 
 Kind of merge sort, but here we will take only element if two of them both are similar.
 
 
 
 */


package Searching_And_Sorting;

import java.util.*;

public class A02_Union_Of_Two_Sorted_Arrays {

	public static void main(String[] args) {
		int[] a1 = {1,1,1,2,2,7,9,9};
		int[] a2 = {1,1,3,3,7,8,8,8};
		// Ans: 1 2 3 7 8 9
		
		ArrayList<Integer> list = union(a1, a2);
		System.out.println(list);
	}

	private static ArrayList<Integer> union(int[] a1, int[] a2) {

		ArrayList<Integer> list = new ArrayList<>();
		
		int i = 0;
		int j = 0;
		
		while( i < a1.length && j < a2.length ) {
			if( a1[i] == a2[j] ) {
				if( list.size() > 0 && list.get(list.size()-1) != a1[i] ) {
					list.add(a1[i]);
				
				} else if( list.size() == 0 ){
					list.add(a1[i]);
				}
				i++;
				j++;
			
			} else if( a1[i] < a2[j] ) {
				if( list.size() > 0 && list.get(list.size()-1) != a1[i] ) {
					list.add(a1[i]);
				
				} else if( list.size() == 0 ) {
					list.add(a1[i]);
				}
				
				i++;
			
			} else {
				if( list.size() > 0 && list.get(list.size()-1) != a2[j] ) {
					list.add(a2[j]);
				
				} else if( list.size() == 0 ) {
					list.add(a2[j]);
				}
				
				j++;
			}
		}
		
		while( i < a1.length ) {
			if( list.size() > 0 && list.get(list.size()-1) != a1[i] ) {
				list.add(a1[i]);
			}
			i++;
		}
			
		while( j < a2.length ) {
			if( list.size() > 0 && list.get(list.size()-1) != a2[j] ) {
				list.add(a2[j]);
			}
			j++;
		}
		
		return list;
	}

}
