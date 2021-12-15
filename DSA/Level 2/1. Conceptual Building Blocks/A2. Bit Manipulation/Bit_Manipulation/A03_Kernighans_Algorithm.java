/*
1. You are given a number n.
2. You have to count the number of set bits in the given number.
Input Format
A number n
Output Format
Number of set bits in n

Constraints
1 <= n <= 10^9
Sample Input
58
Sample Output
4
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A03_Kernighans_Algorithm {
    
	public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();

	    //write your code here

	    int count = 0;
//	    while ( n != 0 ) {
//	      n = n ^ ( n & ((~n) + 1));
//	      count++;
//	    }
//	    OR
	    while ( n != 0 ) {
	        int rsbm = ( n & ((~n) + 1)); 
	        n = n - rsbm; 
            count++;
	    }
	    System.out.println(count);
	    scn.close();
	}
	
}
