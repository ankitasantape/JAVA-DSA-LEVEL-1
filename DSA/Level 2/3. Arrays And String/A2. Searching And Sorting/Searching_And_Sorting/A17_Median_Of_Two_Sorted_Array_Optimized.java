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

public class A17_Median_Of_Two_Sorted_Array_Optimized {

	/*
	   a[left] < b[right]
	   b[left] < a[right]
	   
	 */
	
    public static double findMedianSortedArrays(int[] a, int[] b) {
        if( a.length > b.length ) {
        	int[] temp = a;
        	a = b;
        	b = temp;
        }
    	
    	int lo = 0;
    	int hi = a.length;
    	int te = a.length + b.length; // 14
    	
    	while( lo <= hi ) {
    		int mid = (lo + hi)/2; // 7
    		
    		int alefti = mid-1; // 6
    		int arighti = mid; // 
    		int blefti = ((te + 1)/2 - mid) - 1; // 14/2 = 7 - 3 = 4 - 1 = 3
    		int brighti =  blefti + 1;
    		
    		int aleftVal = (alefti == 0) ? Integer.MIN_VALUE : a[alefti];
    		int arightVal = (arighti == a.length) ? Integer.MAX_VALUE : a[arighti];
    		int bleftVal = (blefti == 0) ? Integer.MIN_VALUE : b[blefti];
    		int brightVal = (brighti == b.length) ? Integer.MAX_VALUE : b[brighti];
    		
    		if( aleftVal <= brightVal && bleftVal < arightVal ) {
    			double median = 0.0;
    			
    			
    			if( te%2 == 0 ) {
    				
    				int lmax = Math.max(aleftVal, bleftVal);
        			int rmin = Math.min(arightVal, brightVal);
        			System.out.println( lmax + " " + rmin );
        			
    			    median = (lmax + rmin)/2.0;
    			
    			} else {
    				median = Math.max(aleftVal, bleftVal);
    			}
    			return median;
    		
    		} else if( aleftVal > brightVal ) {
    			hi = mid - 1;
    		
    		} else if( bleftVal > arightVal ) {
    			lo = mid + 1;
    		}
    		
    	}
    	 
    	return 0.0;
    }
	
	public static void main(String[] args) {
//		int[] a = {3, 4};
//		int[] b = {2};   // ans: 2.0
		
        int[] a = {3, 5, 7, 10, 15};
		
		int[] b = {2, 4, 12};
		
		 //For even, merged arr : 2 3 4 5 7 10 12 15 => (5+7)/2 = 6, median = 6.0
		
		//For odd, merged arr: 2 3 4 => 3, median = 3.0
		
		System.out.println( findMedianSortedArrays(a, b) );
	}

}
