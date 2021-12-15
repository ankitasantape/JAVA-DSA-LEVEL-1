/*
1. You are given a number n.
2. You have to check whether it is a power of 2 or not.
Input Format
A number n
Output Format
true/false
Constraints
1 <= n <= 10^9
Sample Input
1024
Sample Output
true
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A16_Is_A_Power_Of_2 {
   
	public static void main(String[] args){
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    //write your code here
	    
	    int val = (n & (n - 1));
	    if(val == 0) {
	    	System.out.println(true);
	    } else {
	    	System.out.println(false);
	    }
	    scn.close();
	}
}
