/*
1. Given a string s which represents an expression, evaluate this expression and return its value. 
2. while dividing (/) numbers discard the decimal part.Example 3/2 should be 1 insteed of 1.5
Constraints
1. 1 <= s.length <= 3 * 10^5
2. s consists of digits and operators ('+', '-', '*', '/') separated by some number of spaces.
3. All the integers in the expression are non-negative integers.
Sample Input
3+3/2*3-2
Sample Output
4

*/
package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A25_Basic_Calculator_II {

	public static int calculate(String s) {
		Stack<Integer> vs = new Stack<>();
		Stack<Character> os = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (Character.isDigit(ch) == true) {
				int val = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i)) == true) {
					val = val * 10 + (s.charAt(i) - '0');
					i++;
				}
				vs.push(val);
				i--;
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (os.size() > 0 && os.peek() != '(' && priority(os.peek()) >= priority(ch)) {
					int b = vs.pop();
					int a = vs.pop();
					char opr = os.pop();
					vs.push(evaluate(a, b, opr));
				}
				os.push(ch);
			}
		}

		while (os.size() > 0) {
			int b = vs.pop();
			int a = vs.pop();
			char opr = os.pop();
			vs.push(evaluate(a, b, opr));
		}

		return vs.peek();
	}

	public static int evaluate(int a, int b, char opr) {
		if (opr == '+') {
			return a + b;
		} else if (opr == '-') {
			return a - b;
		} else if (opr == '*') {
			return a * b;
		} else {
			return a / b;
		}
	}

	public static int priority(char opr) {
		if (opr == '+' || opr == '-') {
			return 1;
		} else {
			return 2;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int result = calculate(read.readLine());
		System.out.println(result);

	}

}
