/*
You are given a string s that consists of lower case English letters and brackets.
Reverse the strings in each pair of matching parentheses, starting from the innermost one.
Your result should not contain any brackets.

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 
Constraints:

1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced.

*/

package Stack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class A13_Reverse_Substrings_Between_Each_Pair_Of_Parentheses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println( reverseParentheses(str) );
		sc.close();
	}
	// Time Complexity: O(2Length) + (some work done by queue and stack) Space Complexity: O(n)
	// Still we can optimized TC becoz stack and queue dynamically grow kr rhe hai
    public static String reverseParentheses(String s) {
          Stack<Character> st = new Stack<>();
          
          for(int i = 0; i < s.length(); i++) {
        	  char ch = s.charAt(i);
        	  Queue<Character> qu = new ArrayDeque<>();
        	  if( ch == ')'  ) {
        		  while(st.size() != 0 && st.peek() != '(' ) {
        			  qu.add( st.pop() );
        		  }
        		  st.pop();
        		  while( !qu.isEmpty() ) {
        			  st.push(qu.remove());
        		  }
        	  } else {
        		  st.push(ch);
        	  }
          }
          char[] arr = new char[st.size()];
          for( int i = arr.length-1; i >= 0; i-- ) {
        	  arr[i] = st.pop();
          }
          
          return new String(arr);
    }
    // You have to solve this using array
    public static String reverseParentheses_2(String s) {
        Stack<Character> st = new Stack<>();
        char ans[] = new char[s.length()];  
        for(int i = 0; i < s.length(); i++) {
      	  char ch = s.charAt(i);
      	  Queue<Character> qu = new ArrayDeque<>();
      	  if( ch == ')'  ) {
      		  int left = 0;
      		  int right = 0;
      		  while(st.size() != 0 && st.peek() != '(' ) {
      			 ans[i] = st.pop();
      			 right++;
      		  }
      		  st.pop();
      		  
      		 
      	  } else {
      		  st.push(ch);
      	  }
        }
        char[] arr = new char[st.size()];
        for( int i = arr.length-1; i >= 0; i-- ) {
      	  arr[i] = st.pop();
        }
        
        return new String(arr);
  }

}
