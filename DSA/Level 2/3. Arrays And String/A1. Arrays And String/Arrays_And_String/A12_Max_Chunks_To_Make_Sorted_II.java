/*
Link: https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

You are given an integer array arr.
We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. 
After concatenating them, the result should equal the sorted array.
Return the largest number of chunks we can make to sort the array.

Example 1:
Input: arr = [5,4,3,2,1]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.

Example 2:
Input: arr = [2,1,3,4,4]
Output: 4
Explanation:
We can split into two chunks, such as [2, 1], [3, 4, 4].
However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.


arr    30 10 20 40 60 50 75 70
    
left   30 30 30 40 60 60 75 75 75 --> 0 to i ] max --> lmax[i]
max     

right  10 10 20 40 50 50 70 70 100 --> i to arr.length ] min --> min[i]
max  


left max ka min 30 pe khatam hota hai aur right max ka min 40 pe khatam ho rha hai, that means 
0,1,2 tak ke index ka jo maximum hai na 30, wo aage se lekar end tak ke minimum se bhi min hai. 
   
   ( lmax[i] <= rmin[i+1] ) --> ChunkCount++
   
Approach1:   
Step1: LeftMax
Step2: RightMin
Step3: Chunk Count 
  
Approach2:
Step1: RightMin
Step2: Generate LeftMax and count chunks
Step3: ( lmax[i] <= rmin[i+1] ) --> ChunkCount++
          
  

left   30 30 30 ] 40 60 60 75 75 75 --> 0 to i ] max --> lmax[i]
max     

right  10 10 20 [ 40 50 50 70 70 100 --> i to arr.length ] min --> min[i]
min  


*/

package Arrays_And_String;

public class A12_Max_Chunks_To_Make_Sorted_II {

    public static int maxChunksToSorted(int[] arr) {
		
    	// 1. generate right min
    	int[] rmin = new int[arr.length + 1];
    	
    	rmin[arr.length] = Integer.MAX_VALUE;
    	for(int i = arr.length - 1; i >= 0; i--) {
    		rmin[i] = Math.min(rmin[i + 1], arr[i]);
    	}
    	
    	
    	// 2. iterate on array and manage left max as well as count chunks
    	int lmax = Integer.MIN_VALUE;
    	int count = 0;
    	
    	for(int i = 0; i < arr.length; i++) {
    		lmax = Math.max(lmax, arr[i]);
    		if(lmax <= rmin[i + 1]) {
    			count++;
    		}
    	}
    	
    	return count;
        
    }
	
	public static void main(String[] args) {
		
		int[] arr = {2,1,3,4,4};
		System.out.println( maxChunksToSorted(arr) );
	}

}
