/*
1: Given a string S of '(' and ')' parentheses.
2: You need to find count of minimum number of parentheses '(' or ')' when added in any positions so that the resulting parentheses string is valid.
Constraints
1: S.length <= 1000
2: S only consists of '(' and ')' characters.
Sample Input
()))((
Sample Output
4
*/
package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A10_Minimum_Add_To_Make_Parentheses_Valid {

	//T : o(n), S : o(n)
    //follow up T : o(n), S : o(1)
    public static int minAddToMakeValid(String s) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i < s.length();i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                st.push(ch);
            }
            else if(ch == ')') {
                //is '(' available for me
                if(st.size() > 0 && st.peek() == '(') {
                    st.pop();
                }
                else {
                    st.push(ch);
                }
            }
        }
        
        return st.size();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = minAddToMakeValid(read.readLine());
        System.out.println(result);
    }

}
