package Dynamic_Programming_Category3;

import java.util.Scanner;

/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
A number representing the maximum sum of a subsequence with no adjacent elements.
Sample Input
	6
	5
	10
	10
	100
	5
	6
Sample Output
116


### This code executes the test cases of "House Robber" in Leetcode. So can use this code for "House Robber"

*/	
public class Maximum_Sum_Non_Adjacent_Elements {
   
	public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int arr[] = new int[n];
         for(int i = 0; i < n; i++) {
        	 arr[i] = sc.nextInt();
         }
         maximum_sum_non_adjacent_elements(n, arr);
         sc.close();
    }

	private static void maximum_sum_non_adjacent_elements(int n, int[] arr) {
//		we have two choices either include arr[0] or exclude 
		int include = arr[0];
		int exclude = 0;
		
		for(int i = 1; i < arr.length; i++) {
			int new_include = exclude + arr[i];
			int new_exclude = Math.max(exclude,include);
			
			include = new_include;
			exclude = new_exclude;
		}
		System.out.println(Math.max(include, exclude));
	}
 	
}
