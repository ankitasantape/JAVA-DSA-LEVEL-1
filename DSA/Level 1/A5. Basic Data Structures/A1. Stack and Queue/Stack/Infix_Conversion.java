package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 1. You are given an infix expression.
2. You are required to convert it to postfix and print it.
3. You are required to convert it to prefix and print it.
Input Format
Input is managed for you
Output Format
postfix
prefix
Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.
Sample Input
a*(b-c+d)/e
Sample Output
abc-d+*e/
/*a+-bcde
  
 
 
 */
public class Infix_Conversion {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String exp = br.readLine();
		solution(exp);
	}

	private static void solution(String exp) {
		Stack<Character> operator = new Stack<Character>();
		Stack<String> prefix = new Stack<String>();
		Stack<String> postfix = new Stack<String>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == '(') {
				operator.push(ch);
			} else if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
				prefix.push(ch + "");
				postfix.push(ch + "");
			} else if (ch == ')') {
				while (operator.peek() != '(') {
					char optr = operator.pop();
					String v2 = prefix.pop();
					String v1 = prefix.pop();
					prefix.push(optr + v1 + v2);

					v2 = postfix.pop();
					v1 = postfix.pop();
					postfix.push(v1 + v2 + optr);
				}
				operator.pop();
			} else if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^') {

				while (operator.size() > 0 && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch)) {
					char optr = operator.pop();
					String v2 = prefix.pop();
					String v1 = prefix.pop();
					prefix.push(optr + v1 + v2);

					v2 = postfix.pop();
					v1 = postfix.pop();
					postfix.push(v1 + v2 + optr);

				}
				operator.push(ch);
			}
		}

		while (operator.size() != 0) {
			char optr = operator.pop();
			String v2 = prefix.pop();
			String v1 = prefix.pop();
			prefix.push(optr + v1 + v2);

			v2 = postfix.pop();
			v1 = postfix.pop();
			postfix.push(v1 + v2 + optr);
		}
//	     String ans = postfix.peek();
		System.out.println(postfix.peek());
		System.out.println(prefix.peek());
//	     System.out.println(ans);
	}

	private static int precedence(char optor) {
		if (optor == '+') {
			return 1;
		} else if (optor == '-') {
			return 1;
		} else if (optor == '*') {
			return 2;
		} else if (optor == '/') {
			return 2;
		} else if (optor == '^') {
			return 3;
		} else {
			return 0;
		}
	}

// Optimised code
	private static void solution2(String exp) {
		Stack<String> postfix = new Stack<>();
		Stack<String> prefix = new Stack<>();
		Stack<Character> ops = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch == '(') {
				ops.push(ch);
			} else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				postfix.push(ch + "");
				prefix.push(ch + "");
			} else if (ch == ')') {
				while (!ops.isEmpty() && ops.peek() != '(') {
					process(postfix, prefix, ops);
				}
				ops.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (!ops.isEmpty() && ops.peek() != '(' && precedence(ops.peek()) >= precedence(ch)) {
					process(postfix, prefix, ops);
				}
				ops.push(ch);
			}
		}
		while (!ops.isEmpty()) {
			process(postfix, prefix, ops);
		}
		System.out.println(postfix.peek());
		System.out.println(prefix.peek());
	}

	public static void process(Stack<String> postfix, Stack<String> prefix, Stack<Character> ops) {
		char op = ops.pop();
		String postv2 = postfix.pop();
		String postv1 = postfix.pop();
		String postres = postv1 + postv2 + op;
		postfix.push(postres);
		String prev2 = prefix.pop();
		String prev1 = prefix.pop();
		String preres = op + prev1 + prev2;
		prefix.push(preres);
	}

}
