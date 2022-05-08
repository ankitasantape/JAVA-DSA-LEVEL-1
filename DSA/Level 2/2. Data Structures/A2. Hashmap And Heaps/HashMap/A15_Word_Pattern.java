/*
 1. You are given two strings S1 and S2. S1 represents a word of length N and S2 represents N space-separated words.
2. You have to find if the words in S2 follow the exact order as characters in S1.

Note -> Every string consists of lower-case English letters only.
Input Format
Two strings S1 and S2
Output Format
true/false
Constraints
1 <= length of strings <= 1000
Sample Input
abab
pep coding pep coding
Sample Output
true

Sample Input
aaabccdda
ball ball ball ball ball ball ball ball ball ball ball ball
Sample Output
false

Sample Input
aaaaaaaaaaaaaaaaaaaab
baal tall qall wall eall rall uall iall jaal kal baal tall qall wall eall rall uall iall jaal kal fall
Sample Output
false

*/

package HashMap;

import java.util.*;

public class A15_Word_Pattern {
    
	public static boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if( pattern.length() != words.length ) {
			return false;
		}
		HashMap<Character, String> map = new HashMap<>();
		HashSet<String> isUsed = new HashSet<>();
		for(int i=0; i < pattern.length(); i++) {
			char ch = pattern.charAt(i);
			String word = words[i];
			if( !map.containsKey(ch)  ) {
				
				if( isUsed.contains(word) == true ) {
					return false;
				} 
				map.put(ch, word);
				isUsed.add(word);
			} else {
				String chstr = map.get(ch);
				if( !chstr.equals(word) ) {
					return false;
				} 
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String pattern = scn.nextLine();
		String words = scn.nextLine();
		System.out.println(wordPattern(pattern,words));
		scn.close();
	}
}
