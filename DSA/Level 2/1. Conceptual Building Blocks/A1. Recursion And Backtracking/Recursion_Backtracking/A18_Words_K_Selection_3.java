/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k characters out of the word.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 
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

public class A18_Words_K_Selection_3 {

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
        fun(ustr, unique, 0, "", k);
        fun_2(ustr, unique, 0, "", k);
	}
//   Approach 1
	private static void fun(String ustr, HashMap<Character, Integer> fmap, int idx, String asf, int k) {
		if(k < 0) {
			return;
		}
		
		if(idx == ustr.length()) {
			if(k == 0) {
				System.out.println(asf);
			}
			return;
		}
		
		char ch = ustr.charAt(idx);
//		0 no ki call lagayega
		for(int i = fmap.get(ch); i >= 0; i--) {
//			use stringBuilder instead string
			String s = "";
			for(int j = 0; j < i; j++) {
				s += ch;
			}
			fun(ustr, fmap, idx + 1, asf + s, k - i);
		}
	}
//	Approach 2
	private static void fun_2(String ustr, HashMap<Character, Integer> fmap, int idx, String asf, int k) {
		if(k < 0) {
			return;
		}
		
		if(idx == ustr.length()) {
			if(k == 0) {
				System.out.println(asf);
			}
			return;
		}
		
		char ch = ustr.charAt(idx);
        if( fmap.get(ch) > 0 ) {
//        	reduce frequency
        	fmap.put(ch, fmap.get(ch) - 1);
//        	agar element select hona chahta hai to same index ke element ko firse chance denge
        	fun_2(ustr, fmap, idx , asf + ch, k - 1);
//        	while returning you should restore frequency 
        	fmap.put(ch, fmap.get(ch) + 1);
        }
        fun_2(ustr, fmap, idx + 1, asf , k );
	}
}
