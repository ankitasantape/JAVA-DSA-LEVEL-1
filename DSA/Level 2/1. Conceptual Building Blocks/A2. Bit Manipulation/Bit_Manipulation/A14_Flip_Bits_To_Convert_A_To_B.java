/*
1. You are given two numbers A and B.
2. You have to print the count of bits needed to be flipped to convert 'A' to 'B'.
Input Format
2 numbers A and B
Output Format
A number
Constraints
-10^9 <= A,B <= 10^9
Sample Input
57
76
Sample Output
5
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A14_Flip_Bits_To_Convert_A_To_B {
     
	public static void main(String[] args){
	    Scanner scn = new Scanner(System.in);
	    int a = scn.nextInt();
	    int b = scn.nextInt();

	    int count = 0;
	    int n = a ^ b;
	    while ( n != 0 ) {
	        int rsbm = ( n & ((~n) + 1)); 
	        n = n - rsbm; 
            count++;
	    }
	    System.out.println(count);
	    scn.close();
	}
}
