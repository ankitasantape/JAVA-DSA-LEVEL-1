/*
1. You are given an array of n integers.
2. You have to divide these n integers into 2 subsets such that the difference of sum of two subsets 
     is as minimum as possible.
3. If n is even, both set will contain exactly n/2 elements. If  is odd, one set will contain (n-1)/2 and 
    other set will contain (n+1)/2 elements.
3. If it is not possible to divide, then print "-1".

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
n integers 
Output Format

Constraints
1 <= n <= 20
1 <= arr[i] <= 100
Sample Input
6
1
2
3
4
5
6
Sample Output
[1, 3, 6] [2, 4, 5]

*/

package Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class A39_Tug_Of_War {
      
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
		System.out.println(ans);
		scn.close();
	}

	static int mindiff = Integer.MAX_VALUE;
	static String ans = "";

	public static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
			int soset2) {
		
		if(vidx == arr.length) {
			int delta = Math.abs(soset1 - soset2);
			if(delta < mindiff) {
				mindiff = delta;
				ans = set1 + " " + set2;
			}
			return;
		}
		
		// for even length, set1 and set2 will contain even number of element
		// for odd length, set1 will contain odd number of element and set2 will contain even number of element
		// for n = 7, possibility is one set can contain almost 4 elements and another set can contain 3 elements
		if (set1.size() < (arr.length + 1) / 2) {
			set1.add(arr[vidx]);
			solve(arr, vidx + 1, set1, set2, soset1 + arr[vidx], soset2);
			set1.remove( set1.size() - 1 );
		}
		
		if (set2.size() < (arr.length + 1) / 2) {
			set2.add(arr[vidx]);
			solve(arr, vidx + 1, set1, set2, soset1, soset2 + arr[vidx]);
			set2.remove( set2.size() - 1 );
		}
	}
}
