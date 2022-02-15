/*
1. Pepcoder is wishing to give offerings to all the temples along a mountain range. 
2. The temples are located in a row at different heights.
3. You have to find the minimum number of offerings such that these conditions are fulfilled - 
    -> If two adjacent temples are at different heights, then the temple which is situated at greater height should receive more offerings.
    -> If two adjacent temples are at the same height, then their offerings relative to each other does not matter.
Input Format
A number N, which represents number of temples.
An array of positive integers, where every element of array represents height of temple from ground level.  
Output Format

Constraints
1 <= N <= 10^8
1 <= arr[i] <= 10^3
Sample Input
6
1 3 2 5 2 1
Sample Output
10

Sample Input
11
165 647 1117 743 1060 357 1053 816 387 924 281
Sample Output
19

*/
package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class A41_Temple_Offerings {
   
	public static int totaloffering(int[] height) {
		int left[] = new int[height.length];
		Arrays.fill(left, 1);
		
		for(int i = 1; i < left.length; i++) {
			if(height[i-1] < height[i]) {
				left[i] = left[i-1] + 1;
			}
		}
		
		int right[] = new int[height.length];
		Arrays.fill(right, 1);
		for(int i = height.length-2; i >= 0; i--) {
			if(height[i+1] < height[i]) {
				right[i] = right[i+1] + 1;
			} 
		}
		int max = 0;
		for(int i = 0; i < height.length; i++) {
			max += Math.max(left[i], right[i]);
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int height[] = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = scn.nextInt();
		}
		System.out.println(totaloffering(height));
		scn.close();
	}
}
