package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
1. You are given an infix expression.
2. You are required to evaluate and print it's value.
Input Format
Input is managed for you
Output Format
Value of infix expression
Constraints
1. Expression is balanced
2. The only operators used are +, -, *, /
3. Opening and closing brackets - () - are used to impact precedence of operations
4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
5. In two operators of equal precedence give preference to the one on left.
6. All operands are single digit numbers.
Sample Input
2 + 6 * 4 / 8 - 3
Sample Output
2
 */
public class Infix_Evaluation {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String exp = br.readLine();
	    
	     Stack<Character> operator = new Stack<Character>(); 
	     Stack<Integer> operand = new Stack<Integer>(); 
	     for(int i = 0; i < exp.length(); i++) {
	    	  char ch = exp.charAt(i);
	    	  if(ch == '(') {
	    		  operator.push(ch);
	    	  } else if(Character.isDigit(ch)) {
	    		  operand.push(ch - '0');
	    	  } else if(ch == ')') {
	    		  while(operator.peek() != '(') {
	    			  char optr = operator.pop();
	    			  int v2 = operand.pop();
	    			  int v1 = operand.pop();
	    			  int res = evaluate(v1, v2, optr);
	    			  operand.push(res);
	    		  }
	    		  operator.pop();
	    	  } else if(ch == '+' || ch == '-' || ch == '/' || ch == '*'){
	    		 
	    		  while(operator.size() > 0 && operator.peek() != '(' &&  precedence(operator.peek()) >= precedence(ch)) {
	    			  char optr = operator.pop();
	    			  int v2 = operand.pop();
	    			  int v1 = operand.pop();
	    			  int res = evaluate(v1, v2, optr);
	    			  operand.push(res);
	    		  } 
	    		  operator.push(ch);
	    	  }	 
	     }
	     
	     while(operator.size() != 0) {
	    	 char optr = operator.pop();
			  int v2 = operand.pop();
			  int v1 = operand.pop();
			  int res = evaluate(v1, v2, optr);
			  operand.push(res);
	     }
	     System.out.println(operand.peek());
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
