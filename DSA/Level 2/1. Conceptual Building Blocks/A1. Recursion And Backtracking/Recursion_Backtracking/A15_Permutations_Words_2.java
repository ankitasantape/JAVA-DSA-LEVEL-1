/*
1. You are given a word (may have one character repeat more than once).
2. You are required to generate and print all arrangements of these characters. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. 
Constraints
0 < str.length() <= 4
Sample Input
aabb
Sample Output
aabb
abab
abba
baab
baba
bbaa
*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class A15_Permutations_Words_2 {

	public static void generateWords(int cc, String str, Character[] spots, HashMap<Character, Integer> lastOccurence) {
        if(cc == str.length()) {
        	for(int i = 0; i < spots.length; i++) {
        		System.out.print(spots[i]);
        	}
        	System.out.println();
        	return;
        }
		
		char ch = str.charAt(cc);
		int lastOccur = lastOccurence.get(ch);
		for(int i = lastOccur + 1; i < spots.length; i++) {
			if(spots[i] == null) {
				spots[i] = ch;
				lastOccurence.put(ch, i);
				generateWords(cc + 1, str, spots, lastOccurence);
				spots[i] = null;
				lastOccurence.put(ch, lastOccur);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Character[] spots = new Character[str.length()];
		HashMap<Character, Integer> lastOccurence = new HashMap<>();
		for (char ch : str.toCharArray()) {
			lastOccurence.put(ch, -1);
		}

		generateWords(0, str, spots, lastOccurence);
    }
}
