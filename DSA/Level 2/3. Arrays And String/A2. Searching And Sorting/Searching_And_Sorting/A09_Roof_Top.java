/*
GFG: https://www.geeksforgeeks.org/roof-top/

Given heights of consecutive buildings, find the maximum number of consecutive steps one can put forward such that he gain a increase in altitude while going from roof of one building to next adjacent one. 
Examples : 
 

Input : arr[] = {1, 2, 2, 3, 2}
Output : 1
Explanation :
Maximum consecutive steps from 1 to 2 OR  2 to 3.

Input : arr[] = {1, 2, 3, 4}
Output : 3

initialize count = 0
initialize maximum = 0
    if arr[i]>a[i-1]
then count increment
    else
maximum = max(maximum, count)

at the end maximum=max(maximum, count)

*/

package Searching_And_Sorting;

public class A09_Roof_Top {

	public static void main(String[] args) {
		
		int[] arr = {1,4,5,3,2,5,7,9};
		int ans = findMaxSteps(arr);
		System.out.println(ans);
	}

	private static int findMaxSteps(int[] arr) {
		int maxSteps = Integer.MIN_VALUE;
		int count = 0;
		
		for(int i = 0; i < arr.length-1; i++) {
			if( arr[i] < arr[i+1] ) {
				count++;
			}
			else {
				if( count > maxSteps ) {
					maxSteps = count;
				}
				// reset count once the got broke
				count = 0;
			}
		}
		if( count > maxSteps ) {
			maxSteps = count;
		}
		
		return maxSteps;
	}

}
