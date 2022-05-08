/*
1. You are given a string s determine if it is valid or not.
2. A valid string is a string that can be created by inserting abc at any index any number of times.

Example:
aabcbc can be created 
"" -> "abc" -> "aabcbc"

while it is impossible to create abccba.
Constraints
1: s consists of letters 'a', 'b', and 'c' only.
Sample Input
aabcbc
Sample Output
true

 */
package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A30_Check_If_Word_Is_Valid_After_Iteration {

	public static boolean isValid(String s) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i < s.length();i++) {
            char ch = s.charAt(i);
            
            if(ch == 'a' || ch == 'b') {
                st.push(ch);
            }
            else {
                if(st.size() >= 2 && st.pop() == 'b' && st.pop() == 'a') {
                    //no issues
                }
                else {
                    return false;
                }
            }
        }
        
        return st.size() == 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		boolean result = isValid(read.readLine());
		System.out.println(result);

	}

}
