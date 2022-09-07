/*
Link: https://practice.geeksforgeeks.org/problems/counts-zeros-xor-pairs0349/1

Given an array A[] of size N. Find the number of pairs (i, j) such that
Ai XOR Aj = 0, and 1 ≤ i < j ≤ N.

Example 1:

Input : arr[ ] = {1, 3, 4, 1, 4}
Output : 2
Explanation:
Index( 0, 3 ) and (2 , 4 ) are only pairs 
whose xors is zero so count is 2.

Example 2:

Input : arr[ ] = {2, 2, 2} 
Output :  3

 

Your Task:
This is a function problem. The input is already taken care of by the driver code. You only need to complete the function calculate() that takes an array (arr), sizeOfArray (n), and return the count of Zeros Xor's Pairs. The driver code takes care of the printing.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(1).



*/

package Searching_And_Sorting;

import java.util.*;

public class A28_Count_Zeros_Xor_Pairs {

	public static int countPairs(int[] arr) {
		
		HashMap<Integer, Integer> fmap = new HashMap<>();
		
		for(int val : arr) {
			fmap.put(val, fmap.getOrDefault(val, 0) + 1);
		}
		
		int count = 0;
		for(int key : fmap.keySet()) {
			int val = fmap.get(key);
			count += ((val-1)*val)/2; // sum of 'n' natural number = (n*(n-1))/2
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int arr[ ] = {1, 3, 4, 1, 4}; // Ans: 2
		System.out.println( countPairs(arr) );
	}

}
