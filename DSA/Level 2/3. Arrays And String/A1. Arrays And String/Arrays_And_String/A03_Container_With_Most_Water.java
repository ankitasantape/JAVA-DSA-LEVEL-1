/*
https://leetcode.com/problems/container-with-most-water/

You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1


*/


package Arrays_And_String;

public class A03_Container_With_Most_Water {

    public static int maxArea(int[] height) {
	     int i = 0;
	     int j = height.length-1;
	     
	     int water = 0;
	     
	     while(i < j) {
	    	 int w = j - i;
	    	 int h = Math.min(height[i], height[j]);
	    	 
	    	 water = Math.max(water, h * w);
	    	 
	    	 if( height[i] < height[j] ) {
	    		 i++;
	    	 
	    	 } else {
	    		 j--;
	    	 }
	     }
	     
	     return water;
	}
	
	public static void main(String[] args) {
		int[] heights = {1,8,6,2,5,4,8,3,7}; // 49
		System.out.println( maxArea(heights) );
	}

}
