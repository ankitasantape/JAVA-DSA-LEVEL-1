/*
1. You are given a string which represents digits of a number.
2. You have to create the maximum number by performing at-most k swap operations on its digits.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A string S and a number K
Output Format
A number

Constraints
1 <= length of S <= 30
1 <= K <= 10
Sample Input
1234567
4
Sample Output
7654321

*/

package Recursion_Backtracking;

import java.util.Scanner;

public class A42_Largest_Number_Possible_After_At_Most_K_Swaps {
   
	static String max;
	public static void findMaximum(String str, int k) {
		
		if(Integer.parseInt(str) > Integer.parseInt(max)) {
			max = str;
		}
		
		if(k == 0) {
			return;
		}
		
		for(int i = 0; i < str.length(); i++) {
			for(int j = i + 1; j < str.length(); j++) {
				if(str.charAt(j) > str.charAt(i)) {
					String swapped = swap(str, i, j);
					findMaximum(swapped, k - 1);
					
					// backtracking
//					str = swap(str, i, j);
//					findMaximum(str, k -1);
//					str = swap(str, i, j);
				}
			}
		}
	}
	private static String swap(String str, int i, int j) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		sb.setCharAt(i, str.charAt(j));
		sb.setCharAt(j, str.charAt(i));
		
//		char ith = str.charAt(i);
//		char jth = str.charAt(j);
//		
//		String left = str.substring(0, i);
//		String middle = str.substring(i + 1, j);
//		String right = str.substring(j + 1);
//		String swapped = left + jth + middle + ith + right;
		
		return sb.toString();
	}
	
//	Optimized Approach
	static String max2;
	public static void findMaximum2(String str, int k) {
	    if(k == 0) {
	    	 return;
	    }
		for(int i = 0; i < str.length(); i++) {
			int cd = Integer.parseInt(str.charAt(i) + "");
			int ld = cd;
			// find largest digit
			for(int j = i + 1; j < str.length(); j++) {
				if( Integer.parseInt(str.charAt(j) + "") > ld ) {
					ld = Integer.parseInt(str.charAt(j) + "");
				}
			}
			// swap largest digit with cd
			for(int j = i + 1; j < str.length(); j++) {
				String swapped = swap(str, i, j);
				if(cd != ld && isGreater(swapped, max2) == true ) {
					max2 = swapped;
				}
				findMaximum2(swapped, k - 1);
			}
		}
	
	}
	private static boolean isGreater(String s1, String s2) {
		for(int i = 0; i < s1.length(); i++) {
			int c1 = s1.charAt(i) - '0';
			int c2 = s2.charAt(i) - '0';
			if(c1 < c2) {
				return false;
			} else if(c1 == c2) {
				return false;
			}
		}
		return true;
	}
//	Optimized and easy to understand
	static String max3;
	public static void findMaximum3(String str, int k, int idx) {
	    if(idx == str.length() || k == 0) {
	    	 return;
	    }
		int cd = str.charAt(idx);
		int ld = cd;

		// find largest digit
		for (int j = idx + 1; j < str.length(); j++) {
			if (str.charAt(j) - '0' > ld) {
				ld = str.charAt(j) - '0';
			}
		}
		if (ld != cd) {
			// swap largest digit with cd
			for (int j = idx + 1; j < str.length(); j++) {
				if (str.charAt(j) - '0' == ld) {
					String swapped = swap(str, idx, j);
					if (cd != ld && isGreater(swapped, max3) == true) {
						max3 = swapped;
					}
					findMaximum3(swapped, k - 1, idx + 1);
				}
			}
		} else {
			findMaximum3(str, k, idx + 1);
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		 max2 = str;
		 max3 = str;
		findMaximum(str, k);
		System.out.println(max);
		findMaximum2(str, k);
		System.out.println(max2);
		findMaximum3(str, k, 0);
		System.out.println(max3);
		scn.close();
	}

}
