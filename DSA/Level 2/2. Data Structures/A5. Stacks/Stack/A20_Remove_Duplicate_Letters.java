/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 
Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
 
Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
*/

package Stack;

import java.util.Stack;

public class A20_Remove_Duplicate_Letters {

	public static void main(String[] args) {
		System.out.println( removeDuplicateLetters("bcabc") );
	}
    public static String removeDuplicateLetters(String s) {
        
    	Stack<Character> st = new Stack<>();
    	int[] freq = new int[26];
    	boolean[] exist = new boolean[26];
    	
    	for(int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		freq[ch - 'a']++;
    	}
    	
    	for(int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
            freq[ch - 'a']--;
    		if( exist[ch - 'a'] == true) {
    			continue;
    		}
    		while( st.size() != 0 && st.peek() > ch && freq[st.peek() - 'a'] > 0) {
    			 char rem = st.pop();
    			 exist[rem - 'a'] = false; 
    		}
    		st.push(ch);
            exist[ch - 'a'] = true;
    		
    	}
    	
    	char[] ans = new char[st.size()];
    	int i = ans.length-1;
    	while( i >= 0 ) {
    		ans[i] = st.pop();
    		i--;
    	}
    	return new String(ans);
    }
}
