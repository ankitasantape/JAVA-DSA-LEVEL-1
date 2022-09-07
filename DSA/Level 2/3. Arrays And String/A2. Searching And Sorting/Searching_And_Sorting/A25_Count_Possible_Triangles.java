/*
Link: https://www.geeksforgeeks.org/find-number-of-triangles-possible/

Input: arr= {4, 6, 3, 7}
Output: 3
Explanation: There are three triangles 
possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. 
Note that {3, 4, 7} is not a possible triangle.  

Input: arr= {10, 21, 22, 100, 101, 200, 300}.
Output: 6

Explanation: There can be 6 possible triangles:
{10, 21, 22}, {21, 100, 101}, {22, 100, 101}, 
{10, 100, 101}, {100, 101, 200} and {101, 200, 300}


*/

package Searching_And_Sorting;

import java.util.Arrays;

public class A25_Count_Possible_Triangles {

	public static int findNumberOfTriangles(int arr[]) {
		 Arrays.sort(arr);
		 
		 int count = 0;
		 
		 for(int i = arr.length-1; i >= 2; i--) {
			 int l = 0;
			 int r = i-1;
			 
			 while(l < r) {
				 if(arr[l] + arr[r] > arr[i]) {
					 count += (r-l);
					 r--;
				 }
				 else {
					 l++;
				 }
			 }
		 }
		 return count;
	}
	
	public static void main(String[] args) {
		int[] arr = {4, 6, 3, 7}; // Ans: 3
		
		System.out.println( findNumberOfTriangles(arr) );
		
	}

}
