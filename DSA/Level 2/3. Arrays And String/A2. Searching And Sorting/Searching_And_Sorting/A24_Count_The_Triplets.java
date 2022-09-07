/*
Link: https://www.geeksforgeeks.org/count-of-triplets/

Given an array of distinct integers. 
The task is to count all the triplets such that sum of two elements equals the third element.

Sample Input
4
1 5 3 2
Sample Output
2

Sample Input
arr: 1 3 5 2 7 4
Sample Output
2

Triplet1: 1 3 4
Triplet2: 5 2 7


*/ 

package Searching_And_Sorting;

import java.util.Arrays;

public class A24_Count_The_Triplets {

	public static int countTriplets(int[]arr) {
	    Arrays.sort(arr);
	    
	    int count = 0;
	    
	    for(int i = arr.length-1; i >= 2; i--) {
	    	int l = 0;
	    	int r = i - 1;
	    	
	    	while( l < r ) {
	    		if( arr[l] + arr[r] == arr[i] ) {
	    			count++;
	    			l++;
	    			r--;
	    		
	    		} else if( arr[l] + arr[r] < arr[i] ) {
	    			l++;
	    			
	    		} else {
	    			r--;
	    		}
	    	}
	    }
	    return count;
		
    }
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 2};
		
		System.out.println( countTriplets(arr) );
	}

}
