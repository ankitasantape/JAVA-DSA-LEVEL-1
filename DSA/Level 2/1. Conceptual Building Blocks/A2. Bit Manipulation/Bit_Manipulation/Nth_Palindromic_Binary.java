/*
1. You are given an integer N.
2. You have to find the N-th number whose binary representation is a palindrome.

Note -> First binary number whose representation is a palindrome is 1.
Input Format
A number N
Output Format

Constraints
1 <= n <= 2*10^4
Sample Input
17
Sample Output
85
*/
package Bit_Manipulation;

import java.util.Scanner;

public class Nth_Palindromic_Binary {
  
	public static int NthPalindromicBinary(int n) {
        int count = 1;
        int len = 1;
        
        while(count < n) {
        	len++;
        	int elementsForThisLen = (1 << (len - 1) / 2);
        	count += elementsForThisLen; 
        }
        
        count = count - (1 << (len - 1) / 2);
        int offset = n - count - 1;
        
        int ans = (1 << (len - 1 ));
        ans |= (offset << (len / 2));
//        value for reverse
        int valFR = (ans >> (len / 2));
        int rev = getReverse(valFR);
        
        ans |= rev;
        
        return ans;
    }

    private static int getReverse(int n) {
		int rev = 0;
		
		while(n != 0) {
			int lowestbit = (n & 1);
			rev |= lowestbit;
			
			rev <<= 1;
			n >>= 1;
		}
		rev >>= 1;
		return rev;
	}

	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(NthPalindromicBinary(n));
    } 
}
