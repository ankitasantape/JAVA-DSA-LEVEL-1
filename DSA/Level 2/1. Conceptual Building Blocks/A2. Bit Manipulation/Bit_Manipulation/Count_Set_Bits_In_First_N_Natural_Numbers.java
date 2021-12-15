/*
1. You are given a number n.
2. You have to print the count of set bits of first n natural numbers.
Input Format
A number n
Output Format
A number

Constraints
1 <= n <= 10^9
Sample Input
17
Sample Output
35
*/
package Bit_Manipulation;

import java.util.Scanner;

public class Count_Set_Bits_In_First_N_Natural_Numbers {
	public static void main(String[] args){
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    System.out.println(solution(n));
	    scn.close();
	  }

	  public static int solution(int n){
		  if(n == 0) {
			  return 0;
		  }
	      int x = largestPowerOf2inrange(n);
//	      bits upto 2^x 
	      int btill2x = x * (1 << (x - 1)); //  2 ^ (x - 1) => (1 << (x - 1))
//	      most significant bit from 2^x to n , MSB of 8 = 1000 (msb = 1)
	      int msb2xton = n - (1 << x) + 1;
	      int rest = n - (1 << x);
	      int ans = btill2x + msb2xton + solution(rest);
	      return ans;
	  }
	  
	  public static int largestPowerOf2inrange(int n) {
		  int x = 0;
		  
		  while((1 << x) <= n) {
			  x++;
		  }
		  return x - 1;
	  }

}
