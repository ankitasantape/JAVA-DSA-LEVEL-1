/*

*Important*
Link: https://www.geeksforgeeks.org/allocate-minimum-number-pages/

*/ 

package Searching_And_Sorting;

public class A21_Allocate_Minimum_Number_Of_Pages_G1 {

	// T : O(N * log( M - max )) , 
	// N - number of different books
	// max - denotes the maximum number of pages from all the books
	// M - denotes the sum of number of pages of all different books
    private static int findPages(int[] arr, int n, int m) {
		
    	// return -1 if no. of books is less than no. of students 
    	if( n < m ) {
    		return -1;
    	}
    	
    	int sum = 0;
    	int max = 0;
    	
    	// count total number of pages
    	for(int val : arr) {
    		sum += val;
    		max = Math.max(val, max);
    	}
    	
    	// initialize low as max pages(minimum answer possible) and 
    	// end as total pages(maximum answer possible)
    	int lo = max;
    	int hi = sum;
    	int ans = 0;
    	
    	// traverse until start <= end
    	while( lo <= hi ) {
    		
    		// check if it is possible to distribute 
    		// books by using mid is current minimum
    		int mid = lo + (hi-lo)/2;
    		
    		if( isPossible(arr, mid, m) == true ) {
    			// update result to current distribution
    			// as it's the best we have found till now.
    			ans = mid;
    			
    			// as we are finding minimum so,
    			hi = mid - 1;
    		
    		} else {
    			// if not possible, means pages should be
    			// increased, so update low = mid + 1
    			lo = mid + 1;
    		}
    	}
    	
    	// at-last return minimum no. of pages
		return ans;
	}

	
	private static boolean isPossible(int[] arr, int mid, int m) {
		int st = 1;
		int sum = 0;
		
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			
			if(sum > mid) {
				st++; // increment student count
				
				sum += arr[i]; // update curr_sum
			}
		}
		return st <= m;
	}


	public static void main(String[] args) {
        int arr[] = {12, 34, 67, 90};  //Number of pages in books
        
        int m = 2;  //No. of students
      
        // Ans: 113
        System.out.println("Minimum number of pages = " + findPages(arr, arr.length, m));
	}

	
}
