package Stack;

import java.util.*;
public class A01_Next_Greater_Element_To_The_Right {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 2};
		int[] nge = nextGreaterElementToRight(arr); 
		for(int i = 0; i < nge.length; i++) {
			System.out.print(nge[i] + " ");
		}
	}

	private static int[] nextGreaterElementToRight(int[] arr) {
		int n = arr.length;
		int[] nge = new int[n];
		Stack<Integer> st = new Stack<>();
		nge[n-1] = -1;
		st.push(arr[n-1]);
		for(int i = n-2; i >= 0; i--) {
			while(st.size() != 0 && st.peek() <= arr[i] ) {
				st.pop();
			}
		    if( st.size() == 0 ) {
		    	nge[i] = -1;
		    } else {
		    	nge[i] = st.peek();
		    }
		    st.push(arr[i]); 		
		}
		return nge;
	}

}
