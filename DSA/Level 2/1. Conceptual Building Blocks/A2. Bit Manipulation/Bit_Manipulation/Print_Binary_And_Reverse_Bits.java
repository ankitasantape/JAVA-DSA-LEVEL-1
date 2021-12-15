/*
1. You are given a number.
2. You have to print its binary representation.
3. You also have to reverse the bits of n and print the number obtained after reversing the bits.
Input Format
A number n
Output Format

Constraints
1 <= n <= 10^9
Sample Input
11
Sample Output
1011
13
*/
package Bit_Manipulation;

import java.util.Scanner;

public class Print_Binary_And_Reverse_Bits {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		boolean flag = false; // ab tk ek bhi 1 nhi mila
		int rev = 0;
		int j = 0;
		
        for(int i = 31; i >= 0; i--) {
        	int mask = (1 << i);
        	
        	if(flag) {
//        		agar flag on hai to uske bad sare ke sare 1's and 0's print honge 
        		if((n & mask) != 0) {
        			System.out.print(1);
        			
        			int smask = (1 << j); // agar bit set mili to jth position pe on kr denge
        			rev |= smask; // reverse num me jth bit ko on kr denge
        			
        		} else {
        			System.out.print(0);
        		}
        		j++; // bit on mile ya off mile j always left me increment hota rahega
        	} else {
//        		agar sbse first 1 mila to aur wo bit on hai to 1 print hoga and flag ko bhi true mark kr denge
        		if((n & mask) != 0) {
        			flag = true;
        			System.out.print(1);
        			
//        			sbse first bit on mili to jth bit pe usko set krdenge means 0th pos ki bit on krdenge
        			int smask = (1 << j);
        			rev |= smask; // reverse num me bhi jth bit ko on kr denge
        			j++; // left me increment krenge
        		}
        	}
        }
        System.out.println();
        System.out.println(rev);
        scn.close();
	}

}
