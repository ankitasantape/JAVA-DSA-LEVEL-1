/*

Link: https://leetcode.com/problems/median-of-two-sorted-arrays/

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

*/

package Searching_And_Sorting;

public class A17_Median_Of_Two_Sorted_Array {

	// T : O(m + n)
    public static double findMedianSortedArrays(int[] a, int[] b) {
         
    	
    	int res[] = new int[a.length + b.length];
    	int i = 0;
    	int j = 0;
    	int k = 0;
    	
    	while( i < a.length && j < b.length ) {
    		if( a[i] <= b[j] ) {
    			res[k] = a[i];
    			i++;
    			k++;
    		
    		} else {
    			res[k] = b[j];
    			j++;
    			k++;
    		}
    	}
    	
    	while( i < a.length ) {
    		res[k] = a[i];
			i++;
			k++;
    	}
    	
    	while( j < b.length ) {
    		res[k] = b[j];
    		j++;
    		k++;
    	}
    	
    	int mid = res.length/2;
    	
    	double median = 0.0;
    	
    	if( res.length%2 == 0 ) {
    		median = ( res[mid] + res[mid-1] )/2;
    	
    	} else {
    		median = res[mid];
    	}
    	return median;
    }
	
	public static void main(String[] args) {
		
		int[] a = {1, 3};
		int[] b = {2};   // ans: 2.0
		
		System.out.println( findMedianSortedArrays(a, b) );
	}

}
