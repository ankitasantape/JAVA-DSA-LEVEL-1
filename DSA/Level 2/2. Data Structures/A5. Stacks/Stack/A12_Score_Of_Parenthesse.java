/*
Given a balanced parentheses string S, compute the score of the string based on the following rule:
    () has score 1
    AB has score A + B, where A and B are balanced parentheses strings.
    (A) has score 2 * A, where A is a balanced parentheses string.

Score of ()()() string is 3 => 1 + 1 + 1
Score of (()) string is 2 => 2 * 1
Constraints
1: S is a balanced parentheses string, containing only ( and ).
2: 2 <= S.length <= 50
Sample Input
(()(()))
Sample Output
6

*/
package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A12_Score_Of_Parenthesse {

	public static int scoreOfParentheses(String s) {
        Stack<Integer>st = new Stack<>();
        
        //-1 -> represents the presence '('
        
        for(int i=0; i < s.length();i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                st.push(-1);
            }
            else {
                if(st.peek() == -1) {
                    st.pop();
                    st.push(1);
                }
                else {
                    int sc = 0;
                    while(st.peek() != -1) {
                        sc += st.pop();
                    }
                    st.pop();
                    st.push(2*sc);
                }
            }
        }
        
        int ans = 0;
        
        while(st.size() > 0) {
            ans += st.pop();
        }
        
        return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int score = scoreOfParentheses(read.readLine());
		System.out.println(score);

	}

}
