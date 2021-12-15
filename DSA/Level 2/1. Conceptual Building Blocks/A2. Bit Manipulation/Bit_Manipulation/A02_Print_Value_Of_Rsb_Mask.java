/*
1. You are given a number n.
2. You have to print the right-most set bit mask.
Input Format
A number n
Output Format
A number
Constraints
1 <= n <= 10^9
Sample Input
58
Sample Output
10 
*/

package Bit_Manipulation;

import java.util.Scanner;

public class A02_Print_Value_Of_Rsb_Mask {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(Integer.toBinaryString(n & ((~n) + 1)));
//	     or
		System.out.println( Integer.toBinaryString(n & (-n) ));
		scn.close();
	}
}
