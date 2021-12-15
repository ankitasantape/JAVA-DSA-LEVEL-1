/*
1. You are given a binary string which represents a number.
2. You have to check whether this number is divisible by 3 or not.
3. Print 'true' if it is divisible by 3, otherwise print 'false'.
Input Format
A binary string
Output Format
true or false

Constraints
1 <= length of binary string <= 10000
Sample Input
10010101010001
Sample Output
false
*/
package Bit_Manipulation;

import java.util.Scanner;

public class Check_Divisibility_By_3 {
    
	 public static void main(String[] args){
		    Scanner scn = new Scanner(System.in);
		    String str = scn.nextLine();

		    int evenbitcount = 0;
		    int oddbitcount = 0;
		    
		    for(int i = 0; i < str.length(); i++) {
//		    	( '0' != 0 ) , ( '0' - '0' = 0 )
		    	int bit = str.charAt(i) - '0';
		    	
		    	if(i % 2 == 0) {
		    		evenbitcount += bit;
		    	} else {
		    		oddbitcount += bit;
		    	}
		    	
		    }
		    
		    int delta = evenbitcount - oddbitcount;
		    if(delta % 11 == 0) { // 11(binary) = 3(dec)
		    	System.out.println(true);
		    }
		    System.out.println(false);
		    scn.close();
	 }
}
