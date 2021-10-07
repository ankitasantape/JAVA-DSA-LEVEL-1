package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 1. You are given a prefix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to postfix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
Input Format
Input is managed for you
Output Format
value, a number
infix
postfix
Constraints
1. Expression is a valid prefix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.
Sample Input
-+2/*6483
Sample Output
2
((2+((6*4)/8))-3)
264*8/+3-
 */
public class Prefix_Evaluation_And_Conversion {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();

		// code
		solution(exp);
	}

	private static void solution(String exp) {
		 Stack<Integer> operand = new Stack<Integer>(); 
	     Stack<String> infix = new Stack<String>(); 
	     Stack<String> postfix = new Stack<String>(); 
		    
	 		for (int i = exp.length()-1; i >=0 ; i--) {
	 			char ch = exp.charAt(i);
	 			
	 			if (ch == '+' || ch == '-' || ch == '/' || ch == '*') {
	 				int v1 = operand.pop();
	 				int v2 = operand.pop();
	 				int vr = evaluate(v1, v2, ch);
	 				operand.push(vr);
	 				
	 				String post_v1 = postfix.pop();
	 				String post_v2 = postfix.pop();
	 				String post_res = post_v1 + post_v2 + ch;
	 				postfix.push(post_res);
	 				
	 				String in_v1 = infix.pop();
	 				String in_v2 = infix.pop();
	 				String in_res = "(" +in_v1 + ch + in_v2+ ")" ;
	 				infix.push(in_res);
	 				
	 			}else {
	 				operand.push(ch - '0');
	 				postfix.push(ch + "");
	 				infix.push(ch +"");
	 			}
	 		}
	 		System.out.println("Value: " + operand.pop());
	 		System.out.println("Infix Expression: " + infix.pop());
	 		System.out.println("Postfix Expression: " + postfix.pop());
	}
	
	public static int precedence(char ch) {
		if(ch == '+' || ch == '-') {
			return 1;
		} else if(ch == '*' || ch == '/') {
			return 2;
		} else {
			return 0;
		}
	}
	
	public static int evaluate(int v1, int v2, char optr) {
		if(optr == '+') {
			return v1 + v2;
		} else if(optr == '-') {
			return v1 - v2;
		} else if(optr == '*') {
			return v1 * v2;
		} else {
			return v1 / v2;
		}
	}
}
