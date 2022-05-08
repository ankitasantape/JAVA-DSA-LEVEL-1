/*
1. You are given a valid parentheses string in form of A+B+C... where A, B and C are valid primitive strings.
2. A primitive string is a valid parentheses string which cant is split in s = x+y, with x and y nonempty valid parentheses strings.
3. You have to remove the outermost parentheses from all primitive strings.

Example "(()())(())" = "(()())" + "(())".
removing outermost parentheses from "(()())" and "(())" will result in ()()().
Constraints
1. s.length <= 10000
2. s[i] is "(" or ")"
3. s is a valid parentheses string
Sample Input
(()())(())
Sample Output
()()()

*/

package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A11_Remove_Outermost_Parentheses {

	public static String removeOuterParentheses(String s) {
		Stack<Character>st = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        
        for(int i=0; i < s.length();i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                if(st.size() != 0) {
                    sb.append('(');
                }
                st.push(ch);
            }
            else {
                st.pop();
                
                if(st.size() != 0) {
                    sb.append(')');
                }
            }
        }
        
        return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		String result = removeOuterParentheses(read.readLine());
		System.out.println(result);
	}

}
