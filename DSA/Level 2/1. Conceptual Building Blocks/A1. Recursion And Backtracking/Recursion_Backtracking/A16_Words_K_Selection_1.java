/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the 
     word.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Constraints
0 < str.length() < 15
0 < k <= str.length()
Sample Input
aabbbccdde
3
Sample Output
abc
abd
abe
acd
ace
ade
bcd
bce
bde
cde                

*/

package Recursion_Backtracking;

import java.util.HashSet;
import java.util.Scanner;

public class A16_Words_K_Selection_1 {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		int k = scn.nextInt();

		HashSet<Character> unique = new HashSet<>();
		String ustr = "";
		for (char ch : str.toCharArray()) {
			if (unique.contains(ch) == false) {
				unique.add(ch);
				ustr += ch;
			}
		}

		combination(0, ustr, 0, k, "");
		scn.close();
	}

	public static void combination(int i, String ustr, int ssf, int ts, String asf) {
//         jb sarehi chars ka faisla ho gya tb answer ko print kr denge
		if(i == ustr.length()) {
        	if(ssf == ts) {
        		System.out.println(asf);
        	}
        	return;
        }
		
		char ch = ustr.charAt(i);
		combination(i + 1, ustr, ssf + 1, ts, asf + ch);
		combination(i + 1, ustr, ssf + 0, ts, asf + "");
	}
}
