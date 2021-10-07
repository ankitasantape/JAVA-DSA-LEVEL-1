package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 1. You are given a postfix expression.
2. You are required to evaluate it and print it's value.
3. You are required to convert it to infix and print it.
4. You are required to convert it to prefix and print it.

Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
Input Format
Input is managed for you
Output Format
value, a number
infix
prefix
Constraints
1. Expression is a valid postfix expression
2. The only operators used are +, -, *, /
3. All operands are single digit numbers.
Sample Input
264*8/+3-
Sample Output
2
((2+((6*4)/8))-3)
-+2/*6483

 */
public class Postfix_Evaluation_And_Conversion {
    
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String exp = br.readLine();

	    // code
	    solution(exp);
	  }
	private static void solution(String exp) {
		Stack<Integer> vst = new Stack<>();
		Stack<String> in = new Stack<>();
		Stack<String> pre = new Stack<>();
		
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				int v2 = vst.pop();
				int v1 = vst.pop();
				int res = operation(v1, v2, ch);
				vst.push(res);
				
				String pre_v2 = pre.pop();
				String pre_v1 = pre.pop();
				
				String prefix = ch + pre_v1 + pre_v2 ;
				pre.push(prefix);
				
				String in_v2 = in.pop();
				String in_v1 = in.pop();
				
				String infix = "(" + in_v1 + ch + in_v2 + ")";
				in.push(infix);
			}else {
				
				vst.push(ch - '0');
				in.push(ch + "");
				pre.push(ch + "");
			}
		}
		System.out.println("Evaluation Value: "+ vst.pop());
		System.out.println("Infix: "+ in.pop());
		System.out.println("Prefix: "+ pre.pop());
	}
	
	private static int operation(int v1, int v2, char optor) {
	    	if(optor == '+') {
				return v1 + v2;
			}else if(optor == '-') {
				return v1 - v2;
			}else if(optor == '*') {
				return v1 * v2;
			}else {
				return v1 / v2;
			} 
	 }
		
}
