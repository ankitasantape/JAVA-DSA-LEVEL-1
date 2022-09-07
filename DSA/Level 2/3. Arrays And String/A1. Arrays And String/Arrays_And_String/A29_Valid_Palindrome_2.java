/*
Leetcode 680: https://leetcode.com/problems/valid-palindrome-ii/

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:
Input: s = "aba"
Output: true

Example 2:
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:
Input: s = "abc"
Output: false

Example 4:
Input: s = "malayalam
Output: true

Example 5:
Input: s = "madam"
Output: true

Example 3:
Input: s = "abcdefcba"
Output: false

*/

package Arrays_And_String;

public class A29_Valid_Palindrome_2 {

	public static boolean validPalindrome(String s) {
	        
		 int i = 0;
		 int j = s.length()-1;
		 
		 while(i < j) {
			 if( s.charAt(i) == s.charAt(j) ) {
				 i++;
				 j--;
			 } else {
				 // skip from left Or skip from right -> delete at most one character
				 return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
			 }
		 }
		 return true;
	}
	
	private static boolean isPalindrome(String s, int i, int j) {
		
		while(i < j) {
			if( s.charAt(i) != s.charAt(j) ) {
				return false;
			} 
			i++;
			j--;
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		String str = "abcdefcba";
		boolean ans = validPalindrome(str);
		System.out.println(ans);
	}

}
