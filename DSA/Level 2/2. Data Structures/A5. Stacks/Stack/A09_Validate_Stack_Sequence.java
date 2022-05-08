/*
1: Given two sequences pushed and popped with distinct values.
2: You have to return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack
Constraints
1: pushed is a permutation of popped
2: pushed and popped have distinct values
Sample Input
1 2 3 4 5
4 5 3 2 1
Sample Output
true

*/

package Stack;

import java.util.Stack;

public class A09_Validate_Stack_Sequence {

	public static void main(String[] args) {
		int[] pushed = {1, 2, 3, 4, 5};
		int[] popped = {4, 3, 1, 5, 2}; // false
		
		System.out.println( validate_stack_sequence(pushed, popped));
	}

	private static boolean validate_stack_sequence(int[] pushed, int[] popped) {
		int n = pushed.length;	
		Stack<Integer> st  = new Stack<>();
	    st.push( pushed[0] );
	    int i = 1;
	    int j = 0;
	    int matchcount = 0;
	    // sirf j dependent condition hogi, becoz hum sirf pop ke liye hi dekh rhe hai ki 
	    // 
	    while( j < n ) {
	    	
	    	if(st.size() > 0 && st.peek() == popped[j] ) {
	    		st.pop();
	    		matchcount++;
	    		j++;
	    	} else {
	    		if( i < n ) {
	    			st.push(pushed[i]);
	    			i++;
	    		} else {
	    			// else loop will run infinite number of times 
	    			// so, return false
	    			return false;
	    		}
	    	}
	    }
	    return matchcount == n;
	}

}
