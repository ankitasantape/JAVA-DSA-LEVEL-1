/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
*/

package Stack;

import java.util.Scanner;
import java.util.Stack;

public class A14_Minimum_Remove_To_Make_Valid_Parentheses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println( minRemoveToMakeValid(str) );
		sc.close();
	}

	 public static String minRemoveToMakeValid(String s) {
	        Stack<Integer> st = new Stack<>();
	        
	        for(int i = 0; i < s.length(); i++){
	            if( s.charAt(i) == '(' ){
	                st.push( i );
	            } else if( s.charAt(i) ==')') {
	                if( st.size() > 0 && s.charAt( st.peek() ) == '(' ){
	                    st.pop();
	                } else {
	                    st.push(i);
	                }
	            }
	        }
	        
	        char[] arr = s.toCharArray();
	        while( st.size() != 0 ){
	            int idx = st.pop();
	            arr[idx] = '.';
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for( int i = 0; i < arr.length; i++){
	            if( arr[i] == '.' ){
	                continue;
	            }
	            sb.append( arr[i] );
	        }
	        return sb.toString();
	    }
}
