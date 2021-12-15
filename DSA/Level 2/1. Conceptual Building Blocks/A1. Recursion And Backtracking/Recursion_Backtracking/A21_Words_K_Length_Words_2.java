/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the 
     word.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
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
abc
abd
abe
acb
acd
ace
adb
adc
ade
aeb
aec
aed
bac
bad
bae
bca
bcd
bce
bda
bdc
bde
bea
bec
bed
cab
cad
cae
cba
cbd
cbe
cda
cdb
cde
cea
ceb
ced
dab
dac
dae
dba
dbc
dbe
dca
dcb
dce
dea
deb
dec
eab
eac
ead
eba
ebc
ebd
eca
ecb
ecd
eda
edb
edc
*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class A21_Words_K_Length_Words_2 {
   
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int k = Integer.parseInt(br.readLine());

		HashSet<Character> unique = new HashSet<>();
		String ustr = "";
		for (char ch : str.toCharArray()) {
			if (unique.contains(ch) == false) {
				unique.add(ch);
				ustr += ch;
			}
		}

		generateWord(1, k, ustr, new HashSet<Character>(), "");
		solution(ustr, 0, k, new boolean[ustr.length()], "");
	}
//  cs - current spot, ts - total spot
//	levels -> spots (permutation default)
	private static void generateWord(int cs, int ts, String ustr, HashSet<Character> used, String asf) {
		
		if(cs > ts) {
			System.out.println(asf);
			return;
		}
		
		for(int i = 0; i < ustr.length(); i++) {
			char ch = ustr.charAt(i);
			if(used.contains(ch) == false) {
				used.add(ch);
				generateWord(cs + 1, ts, ustr, used, asf + ch);
				used.remove(ch);
			}
		}
	}
	
	public static void solution(String str, int cs, int ts, boolean[] used, String asf) {
		
		if(cs == ts) {
			System.out.println(asf);
			return;
		}
		
		for(int i = 0; i < str.length(); i++) {
			if(used[i] == false) {
				used[i] = true;
				solution(str, cs + 1, ts, used, asf + str.charAt(i));
				used[i] = false;
			}
		}
	}
}
