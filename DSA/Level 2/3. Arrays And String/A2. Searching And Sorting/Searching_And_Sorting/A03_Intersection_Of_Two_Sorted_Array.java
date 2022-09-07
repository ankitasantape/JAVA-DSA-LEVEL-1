/*

Scan both arrays simultaneously
Compare element of both of the arrays.
If both of the values are the same, print it.
Else, increment the counter of the array with smaller element.

*/


package Searching_And_Sorting;

import java.util.ArrayList;

public class A03_Intersection_Of_Two_Sorted_Array {

	public static void main(String[] args) {
		int[] a1 = {1,1,1,2,2,7,9,9};
		int[] a2 = {1,1,3,3,7,8,8,8};
		// Ans: 1 7
		
		ArrayList<Integer> list = intersection(a1, a2);
		System.out.println(list);
	}

	private static ArrayList<Integer> intersection(int[] a1, int[] a2) {

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
				
				i++;
			
			} else {
				
				j++;
			}
		}
		
		return list;
	}


}
