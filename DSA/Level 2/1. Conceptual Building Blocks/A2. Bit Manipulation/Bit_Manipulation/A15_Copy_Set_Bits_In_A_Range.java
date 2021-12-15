/*
1. You are given two numbers A and B.
2. You are given two more numbers left and right, representing a range [left,right].
3. You have to set bits in B which are set in A lying in the above mentioned range.
4. Print the updated number B.
Input Format
4 numbers representing A,B,left and right.
Output Format
A number
Constraints
-10^9 <= A,B <= 10^9
1 < left < right < 32
Sample Input
10
13
2
3
Sample Output
15
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A15_Copy_Set_Bits_In_A_Range {

	public static void main(String[] args){
	    Scanner scn = new Scanner(System.in);
	    int a = scn.nextInt();
	    int b = scn.nextInt();
	    int left = scn.nextInt();
	    int right = scn.nextInt();

	   //write your code here
	    int mask = a & (((1 << (right - left + 1)) - 1) << (left-1));
	    int ans = b | mask;
	    System.out.println(ans);
	  }
} 
