/* 

Link: https://leetcode.com/problems/max-chunks-to-make-sorted/

You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. 
After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.

Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.

Input: arr = [1,0,2,4,3,5]
Output: 4

Input: arr = [3,0,1,2,5,4,8,6,7]
Output: 3


*/
 

package Arrays_And_String;

public class A11_Max_Chunks_To_Make_Sorted {

	/*  idx ->  0  1  2  3  4  5  6  7  8
	    arr ->  3  0  1  2  5  4  8  6  7
	    Chaining technique :
	    
	             chunk1     chunk2  chunk3 
	    idx ->  0  1  2  3 | 4  5 | 6  7  8   
	    arr ->  3  0  1  2 | 5  4 | 8  6  7
	    max =   3  3  3  3 | 5  5 | 8  8  8
	    
chunk count = 0          1 |    2 |       3
	
	*/ 
    public static int maxChunksToSorted(int[] arr) {
        
    	int max = 0;
    	int count = 0; // chunks count
    	
    	// yha pe is question me range[ 0 to n-1 ] tak ke hi elements 
    	// every element ki maximum pohoch check krni hai, maximum pohoch kaha tak hai wo check krni hai
    	for(int i = 0; i < arr.length; i++) {
    		max = Math.max(arr[i], max);
    		
    		if(i == max) {
    			count++;
    		}
    	}
    	
    	return count;
    }
	
	public static void main(String[] args) {
		int[] arr = {3,0,1,2,5,4,8,6,7};
		System.out.println( maxChunksToSorted(arr) );
	}

}
