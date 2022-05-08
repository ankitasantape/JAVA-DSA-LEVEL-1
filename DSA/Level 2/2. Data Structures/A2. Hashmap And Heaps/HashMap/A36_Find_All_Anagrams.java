/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 
Input: s = "aa", p = "bb"
Output: [] 

Input:
"aaaaaaaaaa"
"aaaaaaaaaaaaa"
Output:
 
Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.

*/

package HashMap;

import java.util.*;

public class A36_Find_All_Anagrams {
	// Time Complexity : O(n)
    public static void findAnagrams(String s, String p) {
    	List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        if (p.length() > s.length()) {
			return;
		}
        for(int i = 0; i < p.length(); i++) {
        	pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
        	smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int count = 0;
        int i = p.length();
        while(  i < s.length() ) {
        	if(smap.equals(pmap)) {
        		count++;
        		list.add(i - p.length());
        	}
        	char ch = s.charAt(i);
        	smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        	
        	char chr = s.charAt(i - p.length());
        	if(smap.get(chr) == 1){
        		smap.remove(chr);
        	} else {
        		smap.put(chr, smap.get(chr) - 1 );
        	}	
        	
        	i++;
        }
        
        if(smap.equals(pmap) == true) {
        	count++;
        	list.add(i - p.length());
        }
        System.out.println(count);
        for(int idx : list) {
        	System.out.print(idx + " ");
        }
    }
    // leetcode solution -> // Time Complexity : O(n)
    public static List<Integer> findAnagrams_2(String s, String p) {
    	List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        if (p.length() > s.length()) {
			return list;
		}
        for(int i = 0; i < p.length(); i++) {
        	pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
        	smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        int count = 0;
        int i = p.length();
        while(  i < s.length() ) {
        	if(areMapEqual(pmap, smap)) {
        		count++;
        		list.add(i - p.length());
        	}
        	char ch = s.charAt(i);
        	smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        	
        	char chr = s.charAt(i - p.length());
        	if(smap.get(chr) == 1){
        		smap.remove(chr);
        	} else {
        		smap.put(chr, smap.get(chr) - 1 );
        	}	
        	
        	i++;
        }
        
        if(areMapEqual(pmap, smap) == true) {
        	count++;
        	list.add(i - p.length());
        }
        System.out.println(count);
        return list;
    }
    
    public static boolean compare(HashMap<Character, Integer> pmap, HashMap<Character, Integer> smap) {
    	for (char sch : smap.keySet()) {
    		if( pmap.getOrDefault(sch, 0) != smap.get(sch) ) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static boolean areMapEqual(HashMap<Character, Integer> pmap, HashMap<Character, Integer> smap) {
    	if( pmap.size() != smap.size() ) {
    		return false;
    	}
    	for (char key : pmap.keySet()) {
    		if( smap.containsKey(key) == false ) {
    			return false;
    		}
    		int v1 = pmap.get(key);
    		int v2 = smap.get(key);
    		if( v1 != v2 ) {
    			return false;
    		}
    	}
    	return true;
    }
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String p = sc.next();
		findAnagrams(s, p);
		System.out.println();
		System.out.println( findAnagrams_2(s, p) );
		sc.close();
	}

}
