package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to "next greater element on the right" for all elements of array
4. Input and output is handled for you.

"Next greater element on the right" of an element x is defined as the first element to right of x having value greater than x.
Note -> If an element does not have any element on it's right side greater than it, consider -1 as it's "next greater element on right"
e.g.
for the array [2 5 9 3 1 12 6 8 7]
Next greater for 2 is 5
Next greater for 5 is 9
Next greater for 9 is 12
Next greater for 3 is 12
Next greater for 1 is 12
Next greater for 12 is -1
Next greater for 6 is 8
Next greater for 8 is -1
Next greater for 7 is -1
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
0 <= n < 10^5
-10^9 <= a[i] <= 10^9
Sample Input
5
5
3
8
-2
7
Sample Output
8 8 -1 7 -1
 */
public class Next_Greater_Element_To_The_Right {
	public static void display(int[] a) {
		StringBuilder sb = new StringBuilder();

		for (int val : a) {
			sb.append(val + "\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}

		int[] nge = solve(a);
		display(nge);
		next_greater_element(a);
	}

	public static int[] solve(int[] arr) {
		int n = arr.length;
		int nge[] = new int[n];
		Stack<Integer> st = new Stack<>();
//		st.push(arr[n-1]);
//		nge[n-1] = -1;
		for(int i = n-1; i >= 0; i--) {
//			next greater --> arr[i] < arr[i+1] --> push into the stack
//			if arr[i] > st.peek() --> pop() element from the stack --> means left elem should not be greater than than right 
//			right hand side element should always be greater if not then pop out element
			
//			1. Pop All Smaller Elements
			while(st.size() > 0 && arr[i] > st.peek()) {
				st.pop();
			}
//			2. Update Answer
			if(st.size() == 0) {
				nge[i] = -1;
			} else {
				nge[i] = st.peek();
			}
//			3. Push Current Element In The Stack
			st.push(arr[i]);
		}
		return nge;
	}
	
	public static void next_greater_element(int []arr) {
		
		Stack<Integer> st = new Stack<>();
		int ans[] = new int[arr.length];
		for(int i = arr.length - 1; i >= 0; i--) {
			while(!st.isEmpty() && arr[i] > arr[st.peek()] ) {
				st.pop();
			}
			
			if(st.size() == 0) {
				ans[i] = -1;
				
			} else {
				ans[i] = arr[st.peek()];
			}
			st.push(i);
		}
		
		display(ans);
		
	}
}
