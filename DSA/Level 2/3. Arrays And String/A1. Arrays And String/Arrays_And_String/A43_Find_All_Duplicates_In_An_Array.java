/*

1. Given an integer array nums of length n where all the integers of nums are in the range [1, n].
2. Each integer appears once or twice, return an array of all the integers that appears twice.
3. You must write an algorithm that runs in O(n) time and uses only constant extra space.
Input Format
Input is Managed for you
1. nums = [4,3,2,7,8,2,3,1]
2. nums = [1]
Output Format
Output is Managed for you
1. [2,3]
2. [], Empty

Constraints
1. n == nums.length
2. 1 <= n <= 100000
3. 1 <= nums[i] <= n
4. Each element in nums appears once or twice.
Sample Input
8
4 3 2 7 8 2 3 1
Sample Output
2 3 

Method 1. T : O(n^2)
# Select an element and check if it is present more than one time
  and this element is now for answer add this in ans.
  
Method 2. T : O(n log n)
# Sort the array. O(n log n)
# Travel and find duplicate elements.

Method 3. -> Optimised Approach
# Travel and mark the index means which we get the element 
val == Index
Index = abs( nums[i] ) - 1
Marker

idx :  0     1     2     3     4     5     6     7
arr :  4     3     2     7     8     2     3     1
      -4    -3    -2    -7                -3    -1
      
Index: 3  2  1  6  7  1  2  0

Result -> 2, 3      


1. Find index and mark its presence
2. If already marked that means duplicasy encounter. 
   Add that duplicate element in answer.

   Index = abs ( nums[i] ) - 1;
   val = nums[Index]
   if(  val < 0 ) {
     // duplicacy 
   
   } else {
     // mark it
   

   }

*/

package Arrays_And_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A43_Find_All_Duplicates_In_An_Array {

	public static List<Integer> findDuplicates(int[] nums){
		
		List<Integer> res = new ArrayList<>();
		
		for(int i = 0; i < nums.length; i++) {
			int indx = Math.abs( nums[i] ) - 1;
			int val = nums[indx];
			
			if(  val < 0 ) {
				// duplicasy occured
				res.add(indx + 1);
				
			} else {
				// mark it
				nums[indx] *= -1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
		List<Integer> res = findDuplicates(arr);
		
		Collections.sort(res);
		for(int val : res) {
			System.out.print(val + " ");
		}
	}
}
