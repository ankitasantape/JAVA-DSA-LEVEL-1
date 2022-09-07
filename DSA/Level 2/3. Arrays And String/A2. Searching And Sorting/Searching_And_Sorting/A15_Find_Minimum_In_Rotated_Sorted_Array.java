/*
Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

 Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.                 
     
Input: nums = [5,1,2,3,4]
Output: 1     

                5  1  2  3  4
                lo    m     hi   
                
                  
                  
                     | 
arr:   4  5  6  7  8 | 0  1  3
 					 |
                   segregate
   
Imagine this array in 2 parts
Part-I  : Left part
Part-II : Right part                   
    
Who is the smallest one?
First element of right part is the smallest one. 
So, hume apne searching ko part-II ke taraf approach krna chahiye  
means hume every time aisa krna chahiye ki humari search hume humesha part-II ki taraf lekar jaye.                
                   
1. There is one more property of part-II's first element jo ki array me pade kisi aur element ke pas nhi hai. 
So, ye ek aisa element hai ki wo apne left me pade bande se small hai, isake bad aisa koi element nhi hai ki wo element usake left me pade bande se small ho. 4 < 5 < 6 < 7 < 8 > 0 < 1 < 3                    
   
2. There is one more property of part-I's last element jo ki array me pade kisi aur element ke pas nhi hai. 
So, ye ek aisa element hai ki wo apne right me pade bande se greater hai, isake bad aisa koi element nhi hai ki wo element usake right me pade bande se greater ho. 4 < 5 < 6 < 7 < 8 > 0 < 1 < 3                    
                      
  
                   
                   
*/

package Searching_And_Sorting;

public class A15_Find_Minimum_In_Rotated_Sorted_Array {

	// T : O(log n)
	public static int findMin(int[] nums) {
	      int lo = 0;
	      int hi = nums.length-1;
	      

	      // if the last element is greater than the first element then there is no rotation.
	      // e.g. 1 < 2 < 3 < 4 < 5 < 7. Already sorted array.
	      // Hence the smallest element is first element. A[0]
	      if( nums[lo] < nums[hi] ) {
	    	  return nums[hi];
	      }
	      
	      
	      while( lo <= hi ) {
				int mid = (lo + hi) / 2;

				// if the mid element is greater than its next element then mid+1 element is the
				// smallest
				// This point would be the point of change. From higher to lower value.
				// 8 > 0
				if (nums[mid] > nums[mid + 1]) {
					return nums[mid + 1];
				}
				// if the mid element is lesser than its previous element then mid element is
				// the smallest
				// nums[mid-1] -> is an element of left part means greatest one
				// nums[mid] -> is an element of right part means smallest one
				// 8 > 0
				// becoz of this( 5  1  2  3  4) test case we need to write this condition here(above)
				if (nums[mid - 1] > nums[mid]) {
					return nums[mid];

				}

				// if the mid elements value is greater than the 0th element this means
				// the least value is still somewhere to the right as we are still dealing with
				// elements
				// greater than nums[0]
				// becoz of this( 5  1  2  3  4) test case we need to write this condition here(below)
				else if (nums[lo] <= nums[mid]) {
					lo = mid + 1;

					// if nums[0] is greater than the mid value then this means the smallest value
					// is somewhere to
					// the left
				} else if (nums[mid] <= nums[hi]) {
					hi = mid - 1;
				}
	      }
	      
	      return -1;
	}
	
	public static void main(String[] args) {
		
		int[] arr = { 4,5,6,7,0,1,2 }; // output: 0
		System.out.println( findMin(arr) );
		
	}

}
