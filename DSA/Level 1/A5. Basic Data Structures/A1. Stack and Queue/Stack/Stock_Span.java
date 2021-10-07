package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the prices of a share on n days.
3. You are required to find the stock span for n days.
4. Stock span is defined as the number of days passed between the current day and 
the first day before today when price was higher than today.

e.g.
for the array [2 5 9 3 1 12 6 8 7]
span for 2 is 1
span for 5 is 2
span for 9 is 3
span for 3 is 1
span for 1 is 1
span for 12 is 6
span for 6 is 1
span for 8 is 2
span for 7 is 1
 */

// Next Greater to the Left
public class Stock_Span {

	public static void display(int[] a){
	    StringBuilder sb = new StringBuilder();

	    for(int val: a){
	      sb.append(val + "\n");
	    }
	    System.out.println(sb);
	  }

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int n = Integer.parseInt(br.readLine());
	    int[] a = new int[n];
	    for(int i = 0; i < n; i++){
	       a[i] = Integer.parseInt(br.readLine());
	    }

	    int[] span = solve(a);
	    display(span);
	 }
	// Next Greater to the Left
	 public static int[] solve(int[] price){
	   
		 int[] span = new int[price.length];

			Stack<Integer> s = new Stack<>();

			span[0] = 1;

			s.push(0);

			for (int i = 1; i < price.length; i++) {

//				Push all the smaller element's index into the stack
				while (!s.isEmpty() && price[i] > price[s.peek()]) {

					s.pop();
				}
				
//				Update 
				if (s.isEmpty()) {

//					span[i] = i + 1;
					span[i] = i - (-1);

				} else {

					span[i] = i - s.peek();

				}
//				push current index in the stack
				s.push(i);
			}

			return span;
	 }
}
