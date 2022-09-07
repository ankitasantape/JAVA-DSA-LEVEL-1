/*

Leetcode 1007 : https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/#:~:text=1007.%20Minimum%20Domino%20Rotations%20For%20Equal%20Row%20In,that%20tops%20%5Bi%5D%20and%20bottoms%20%5Bi%5D%20swap%20values.

In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
If it cannot be done, return -1.

Example 1:
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:
Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal. 

*/


package Arrays_And_String;

public class A35_Minimum_Domino_Rotations_For_Equal_Row {

	// T : O(n)
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        
    	int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
    	int num1 = tops[0];
    	int num2 = bottoms[0];
    	
    	for(int i = 0; i < tops.length; i++) {
    		// for num1
    		if(count1 != Integer.MAX_VALUE) {
    		   if(tops[i] == num1) {
    			    // nothing to do
    		   } else if(bottoms[i] == num1) {
    			    // count1 -> no. of swapping required to make top array as num1
        		    count1++; 
    		    } else {
    		    	count1 = Integer.MAX_VALUE;
    		    }
    		} 
    		
    		
    		// for num2
    		if( count2 != Integer.MAX_VALUE ) {
    		   if(bottoms[i] == num1) {
    			    // nothing to do
    		   } else if(tops[i] == num1) {
    			    // count2 -> no. of swapping required to make bottom array as num1
    			    count2++; 
    		    } else {
    		    	count2 = Integer.MAX_VALUE;
    		    }
    		}
    		
    		// for num3
    		if( count3 != Integer.MAX_VALUE ) {
     		   if(bottoms[i] == num2) {
     			    // nothing to do
     		   } else if(tops[i] == num2) {
     			   // count3 -> no. of swapping required to make bottom array as num3
     	    	    count3++; 
     		    } else {
     		    	count3 = Integer.MAX_VALUE;
     		    }
     		}
     		
    		// count4 -> no. of swapping required to make bottom array as num4
    		if( count4 != Integer.MAX_VALUE ) {
      		   if(tops[i] == num2) {
      			    // nothing to do
      		   } else if(bottoms[i] == num2) {
      			   // count3 -> no. of swapping required to make bottom array as num3
      	    	    count4++; 
      		    } else {
      		    	count4 = Integer.MAX_VALUE;
      		    }
      		}
    	}
    	
    	int res = Math.min(Math.min(count1, count2), Math.min(count3, count4));
    	return res == Integer.MAX_VALUE ? -1 : res;
    }
	
	public static void main(String[] args) {
		
		int[] tops = {2,1,2,4,2,2};
		
		int[] bottoms = {5,2,6,2,3,2};
		
		int result = minDominoRotations(tops, bottoms);
		
		System.out.println(result);
	}

}
