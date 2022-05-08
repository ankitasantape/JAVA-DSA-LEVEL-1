/*
Given a string s representing an expression, implement a basic calculator to evaluate it.
Constraints
1. 1 <= s.length <= 3 * 10^5
2. s consists of digits, '+', '-', '(', ')', and ' '.
3. s represents a valid expression.
4. result of the expression always lies in range of -2^31 to 2^31
Sample Input
(1+(4+5+2)-3)+(6+8)
Sample Output
23

*/
package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A24_Basic_Calculator {

	public static int calculate(String s){
		Stack<Integer> st = new Stack<>();
		int sum = 0;
		int sign = +1;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			
			if( Character.isDigit(ch) ) {
				int val = 0;
				while ( i < s.length() && Character.isDigit(s.charAt(i)) ) {
					val = val * 10 + (s.charAt(i) - '0');
					i++;
				}
				i--;
				val *= sign; 
				sign = +1;
				sum += val;
				;
			} else if( ch == '(' ) {
				st.push(sum);
				st.push(sign);
				sum = 0;
				sign = +1;
				
			} else if( ch == ')' ) {
				sum = sum * st.pop(); // sum = 23, st.pop() = -ve or +ve sign, sum = 23 * (-1) or sum = 23 * (+1
				sum = sum + st.pop();
				
			} else if( ch == '-' ) {
				sign = sign * -1;
				
			}
		}
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = calculate(read.readLine());
        System.out.println(result);
        
    }

}
