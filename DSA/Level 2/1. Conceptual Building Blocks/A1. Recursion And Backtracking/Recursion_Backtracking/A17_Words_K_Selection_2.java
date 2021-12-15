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

public class A17_Words_K_Selection_2 {
    
	 public static void main(String[] args){
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

			combination(ustr, 1, k, -1, "");
			scn.close();
	 }
//   ts - total selection, cs - current selection, lc - last char 
	private static void combination(String ustr, int cs, int ts, int lc, String asf) {
		if(cs > ts) {
			System.out.println(asf);
			return;
		}
		for(int i = lc + 1; i < ustr.length(); i++) {
			char ch = ustr.charAt(i);
			combination(ustr, cs + 1, ts, i, asf + ch);
		}
	}
}
