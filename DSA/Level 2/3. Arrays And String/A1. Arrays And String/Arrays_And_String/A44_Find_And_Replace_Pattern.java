/*
Leetcode 890: https://leetcode.com/problems/find-and-replace-pattern/

Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]


Hidden TestCase
String : "saamnaa"
Pattern : "arrpqrm"

pch      wch
a    ->  s
r    ->  a
r    ->  a
p    ->  m
q    ->  n
r    ->  a
m    ->  a

HashMap
pch ->  wch
a   ->  s
r   ->  a
p   ->  m
q   ->  n
m   ->  a  -> this mapping is wrong becoz here 'a' is mapping with 'm' but
              'a' is already mapped by 'r'
           -> So here we should be careful, we should be keep notice on word , so here we can use HashSet
 
Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.


*/

package Arrays_And_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class A44_Find_And_Replace_Pattern {

	public static boolean isMatching(String word, String pattern) {
		HashMap<Character, Character> map = new HashMap<>();
		
		HashSet<Character> set = new HashSet<>();
		
		for(int i = 0; i < pattern.length(); i++) {
			char wch = word.charAt(i);
			char pch = pattern.charAt(i);
			
			if(map.containsKey(pch) == true) {
				// pattern character is already mapped with word char
				if(map.get(pch) != wch) {
					return false;
				}
			} else {
				// pattern character is new for mapping
				if( set.contains(wch) ) {
					return false;
				}
				map.put(pch, wch);
				set.add(wch);
			}
		}
		return true;
	}
	
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
       
    	List<String> res = new ArrayList<>();
    	for (String word : words) {
    		if( isMatching(word, pattern) ) {
    			res.add(word);
    		}
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";
		
		List<String> result = findAndReplacePattern(words, pattern);
		
		if(result.size() == 0) {
			System.out.println("Empty");
			return;
		}
		Collections.sort(result);
		for(String str : result) {
			System.out.println(str + " ");
		}
		System.out.println();
	}

}
