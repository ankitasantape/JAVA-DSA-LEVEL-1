/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
*/

package HashMap;

import java.util.HashMap;

public class A21_Valid_Anagrams {

	public static void main(String[] args) {
		String s = "rat";
		String t = "car";
		System.out.println(isAnagram(s, t));
	}
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
        	char ch = s.charAt(i);
        	map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int i=0; i<t.length(); i++) {
        	char ch = t.charAt(i);
        	map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        for(char key: map.keySet()) {
        	if( map.get(key) != 0) {
        		return false;
        	}
        }
        return true;
    }

}
