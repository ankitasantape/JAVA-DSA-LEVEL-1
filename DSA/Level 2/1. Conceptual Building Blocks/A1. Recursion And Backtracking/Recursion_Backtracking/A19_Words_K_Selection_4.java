/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all ways you can select k characters out of the word.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format

Constraints
0 < str.length() < 15
0 < k <= str.length()
Sample Input
aabbbccdde
3
Sample Output
aab
aac
aad
aae
abb
abc
abd
abe
acc
acd
ace
add
ade
bbb
bbc
bbd
bbe
bcc
bcd
bce
bdd
bde
ccd
cce
cdd
cde
dde

*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class A19_Words_K_Selection_4 {
   
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int k = Integer.parseInt(br.readLine());

		HashMap<Character, Integer> unique = new HashMap<>();
		String ustr = "";
		for (char ch : str.toCharArray()) {
			if (unique.containsKey(ch) == false) {
				unique.put(ch, 1);
				ustr += ch;
			} else {
				unique.put(ch, unique.get(ch) + 1);
			}
		}
//		k - total spots
        fun(ustr, unique, 0, k, "", 0);
	}
	
//  cs - current spot, ts - total spots , lcui - last char used index
	private static void fun(String str, HashMap<Character, Integer> fmap, int cs, int ts, String asf, int lcui) {
	    if(cs == ts) {
	    	System.out.println(asf);
	    	return;
	    }
		for(int i = lcui; i < str.length(); i++) {
			char ch = str.charAt(i);
			if( fmap.get(ch)  > 0 ) {
				fmap.put(ch, fmap.get(ch) - 1);
				fun(str, fmap, cs + 1, ts, asf + ch, i);
				fmap.put(ch, fmap.get(ch) + 1);	
			}
		}
	}
}
