/*
1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words by using chars of the word.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 
Constraints
0 < str.length() < 15
0 < k <= str.length()
Sample Input
aaabb
3
Sample Output
aaa
aab
aba
baa
abb
bab
bba
*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class A22_Words_K_Length_Words_3 {
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int k = Integer.parseInt(br.readLine());

		HashMap<Character, Integer> lastOccurence = new HashMap<>();
		for (char ch : str.toCharArray()) {
			lastOccurence.put(ch, -1);	
		}
		generateWords(str, lastOccurence, 0, new Character[k], 0, k);
	}

	private static void generateWords(String str, HashMap<Character, Integer> lastOccurence, int cc,
			Character[] spots, int ssf, int ts) {
		
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
		int lastOccur = lastOccurence.get(ch);
//		yes
		for(int i = lastOccur + 1; i < spots.length; i++) {
			if(spots[i] == null) {
				spots[i] = ch;
				lastOccurence.put(ch, i);
				generateWords(str, lastOccurence, cc + 1, spots, ssf + 1, ts);
				spots[i] = null;
				lastOccurence.put(ch, lastOccur);
			}
		}
//		no -> no ki call tabhi aayegi jb wo elem first time aa rha hai 
		if(lastOccur == -1) {
			generateWords(str, lastOccurence, cc + 1, spots, ssf, ts);
		}
	}
}
