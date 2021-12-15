/*
1. You are given a word.
2. You have to generate all abbreviations of that word.

Use recursion as suggested in question video
Input Format
A string representing a word
Output Format

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

package Recursion_Backtracking;

import java.util.Scanner;

public class A31_Abbreviation_Using_Backtracking {
  
	public static void solution(String str, String asf, int count, int idx) {

		if ( idx == str.length()) {
			if(count > 0) {
				System.out.println(asf + count);
			} else {
				System.out.println(asf);
			}
			return;
		}
		
		solution(str, count > 0 ? asf + count + str.charAt(idx) : asf + str.charAt(idx), 0 ,idx + 1 );
		solution(str, asf, count + 1 , idx + 1 );
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "", 0, 0);
		scn.close();
	}
    
}
