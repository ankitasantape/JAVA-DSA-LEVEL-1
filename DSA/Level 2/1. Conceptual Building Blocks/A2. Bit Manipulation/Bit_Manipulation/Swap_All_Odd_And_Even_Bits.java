/*
1. You are given a number n.
2. You have to swap all odd position bits with even position bits.
3. Every odd position bit is swapped with adjacent bit on left side.
4. Every even position bit is swapped with adjacent bit on right side.
5. Print the number formed after swapping.
Input Format
A number n
Output Format
Check the sample ouput and question video.
Constraints
1 <= n <= 10^9
Sample Input
10
Sample Output
5
*/
package Bit_Manipulation;

import java.util.Scanner;

public class Swap_All_Odd_And_Even_Bits {
    
	 public static void main(String[] args){
		    Scanner scn = new Scanner(System.in);
		    int n = scn.nextInt();
		    //write your code here
		    
		    int oddmask = 0x55555555;
		    int evenmask = 0xAAAAAAAA;
		    
		    int odds = (n & oddmask);
		    int evens = (n & evenmask);
		    
		    odds <<= 1;
		    evens >>= 1;
		    
		    n = odds | evens;
		    
		    System.out.println(n);
		    scn.close();
	 }
}
