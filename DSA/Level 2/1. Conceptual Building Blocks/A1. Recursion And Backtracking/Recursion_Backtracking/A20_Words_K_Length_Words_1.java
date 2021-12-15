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
adb
aeb
acd
ace
adc
aec
ade
aed
bac
bad
bae
cab
dab
eab
cad
cae
dac
eac
dae
ead
bca
bda
bea
cba
dba
eba
cda
cea
dca
eca
dea
eda
bcd
bce
bdc
bec
bde
bed
cbd
cbe
dbc
ebc
dbe
ebd
cdb
ceb
dcb
ecb
deb
edb
cde
ced
dce
ecd
dec
edc
*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class A20_Words_K_Length_Words_1 {
   
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
		Character[] spots = new Character[k];
        generateWords(0, ustr, 0 ,k, spots);
	}
//  levels -> Characters, options -> spots 
//	Permutation's derived approach
	private static void generateWords(int cc, String str, int ssf, int ts, Character[] spots) {
		if(cc == str.length()) {
			if(ssf == ts) {
				for(int i = 0; i < spots.length; i++) {
					System.out.print(spots[i]);
				}
				System.out.println();	
			}
			return;
		}
		
		char ch = str.charAt(cc);
        // yes
		for(int i = 0; i < spots.length; i++) {
			if(spots[i] == null) {
				spots[i] = ch;
				generateWords(cc + 1, str, ssf + 1, ts, spots);
				spots[i] = null;
			}
		}
		
        // no
		generateWords(cc + 1, str, ssf + 0, ts, spots);
	}

	
}
