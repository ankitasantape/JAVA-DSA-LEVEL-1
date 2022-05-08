package HashMap;

import java.util.HashMap;
/*
1. You are given two strings s1 and s2.
2. You have to determine if they are isomorphic or not.
3. Two strings are called isomorphic if -
   -> Every character of s1 can be mapped with characters of s2.
   -> A character of s1 can be mapped to only one character.
   -> All occurrences of a character must be replaced with another character while preserving the order of characters.

Note -> Length of s1 is equal to the length of s2.
Input Format
Two strings s1 and s2
Output Format
true/false

Constraints
1 <= length of strings <= 1000
Sample Input
pepcoding
sosherlok
Sample Output
false

*/

import java.util.HashSet;
import java.util.Scanner;

public class A16_Isomorphic_Strings {
	
	public static boolean isIsomorphic(String s, String t) {
		if( s.length() != t.length() ) {
			return false;
		}
		HashMap<Character, Character> map = new HashMap<>();
		HashSet<Character> isUsed = new HashSet<>();
		for(int i=0; i < s.length(); i++) {
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			if( !map.containsKey(ch1)  ) {
				
				if( isUsed.contains(ch2) == true ) {
					return false;
				} 
				map.put(ch1, ch2);
				isUsed.add(ch2);
			} else {
				if( map.get(ch1).equals(ch2) == false ) {
					return false;
				} 
			}
		}
		
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String A = scn.next();
		String B = scn.next();
		System.out.print(isIsomorphic(A, B));
		scn.close();
	}


}
