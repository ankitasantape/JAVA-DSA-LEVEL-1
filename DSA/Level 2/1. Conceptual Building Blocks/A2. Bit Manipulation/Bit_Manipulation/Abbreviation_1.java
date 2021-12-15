/*
1. You are given a word.
2. You have to generate all abbrevations of that word.
Note - Use bit manipulation
Input Format
A string representing a word
Output Format
Check the sample ouput and question video.

Constraints
1 <= length of string <= 32
Sample Input
pep
Sample Output
pep
pe1
p1p
p2
1ep
1e1
2p
3

*/
package Bit_Manipulation;

import java.util.Scanner;

public class Abbreviation_1 {
    
	public static void solve(String str){
        int n = (int) Math.pow(2, str.length());
       
//        we can do n = (1 << str.length()) also becoz 2 raise to power str.length() is same as 1 << str.length()
		for(int i = 0; i < n; i++) {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			
			for(int j = 0; j < str.length(); j++) {
				char ch = str.charAt(j);
//				bit ki indexing right se start hoti hai n
//				string ki indexing left se start hoti hai
//				but we have to start bit's indexing from left to right 
//              so, bits indexing will start from extreme of string
//				string ka first char means bits ki extreme position ki bit becoz bits ki indexing start from right 
//				first bit will get at extreme index of string
				int b = str.length() - 1 - j;
//				check bit on/off inside i
//				0 means off and 1 means on
				if((i & (1 << b)) == 0) {
				     if(count == 0) {
				    	 sb.append(ch);
				     } else {
				    	 sb.append(count);
				    	 sb.append(ch);
				    	 count = 0;
				     }
				} else {
					count++;
				}	
			}
			if(count > 0) {
				sb.append(count);
			}
			System.out.println(sb);
		}
    }
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
        scn.close();
    }
}
