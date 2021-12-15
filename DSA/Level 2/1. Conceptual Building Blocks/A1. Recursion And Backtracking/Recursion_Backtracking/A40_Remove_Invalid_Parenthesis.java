/*
1. You are given a string, which represents an expression having only opening and closing parenthesis.
2. You have to remove minimum number of parenthesis to make the given expression valid.
3. If there are multiple answers, you have to print all of them.

Note -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't 
               force you but intends you to teach a concept.
Input Format
A string containing only opening and closing parenthesis
Output Format
Print all the Valid expressions. 
Constraints
1 <= length of string <= 20
Sample Input
()())()
Sample Output
(())()
()()()

*/

package Recursion_Backtracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class A40_Remove_Invalid_Parenthesis {
  
	// mra - minimum removal allowed
	public static void solution(String str, int mra, HashSet<String> ans) {
		 
		if (mra == 0) {
			// current minimum removal
			int cmr = getMin(str);
			if(cmr == 0) {
				if ( !ans.contains(str) ) {
					System.out.println(str);
					ans.add(str);
				}
			}
			return;
		}
		
		for(int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i);
			String right = str.substring(i + 1);
			solution(left + right, mra - 1, ans);
		}
	}

	public static int getMin(String str) {
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(') {
				st.push(ch);
			} else if(ch == ')') {
				if(st.size() == 0) {
					st.push(ch);
				} else if(st.peek() == ')') {
					st.push(ch);
				} else if(st.peek() == '(') {
					st.pop();
				}
			}
		}
		return st.size();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str, getMin(str),new HashSet<>());
		scn.close();
	}
}


