package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

e.g.
for the array [6 2 5 4 5 1 6] -> 12
Input Format
Input is managed for you
Output Format
A number representing area of largest rectangle in histogram
Constraints
0 <= n < 20
0 <= a[i] <= 10
Sample Input
7
6
2
5
4
5
1
6
Sample Output
12

Sample Input
7
7
8
8
7
7
9
2
Sample Output
42

Sample Input
8
5
3
6
6
6
3
5
4
Sample Output
24
 */
public class Largest_Area_Histogram {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int n = Integer.parseInt(br.readLine());
	    int[] a = new int[n];
	    for (int i = 0; i < n; i++) {
	      a[i] = Integer.parseInt(br.readLine());
	    }
	    
	    System.out.println("Double Iteration Solution: "+largest_area_of_histogram_1(n, a));
	    System.out.println("Single Iteration Solution: "+largest_area_of_histogram_2(n, a));
	}
	
//	Time Complexity : O(n) Space Complexity : O(k)
	private static int largest_area_of_histogram_2(int n, int[] a) {
		Stack<Integer> st = new Stack<>();
		st.push(-1);
		st.push(0);
		int max = 0;
		for(int i = 1; i <= n; i++) {
            int val = ( i == n ? 0 : a[i] ); 
//            find the maximum area
			while(st.size() > 0 && a[st.peek()] > val) {
				int r = st.pop();
//				max = max ( max, height * width ), width --> (next_small_right - next_small_left - 1)
				max = Math.max(max, a[r] * (i - (st.peek()) - 1));
//				to avoid index out of bound exception
				if(st.peek() == -1) {
					break;
				}
			}
			st.push(i);
		}
		return max;
	}
	
	private static int largest_area_of_histogram_1(int n, int[] a) {
//		right boundry - nearest smaller to right 
		int rb[] = new int[n];  // nse index to right
		rb = nextSmallerElementOnRightIndex(n, a);
		
//		left boundry - nearest smaller to left
		int lb[] = new int[n]; // nse index to left
		lb = nearestSmallerElementOnLeftIndex(n, a);
		
		int maxArea = 0;
		for(int i = 0; i < n; i++) {
			int width = rb[i] - lb[i] - 1;
//			System.out.println(a[i]+" "+width);
			int area = a[i] * width;
			if( area > maxArea ) {
				maxArea = area;
			}
		}
		return maxArea;
	}

    private static int[] nearestSmallerElementOnLeftIndex(int n, int[] arr) {
		int nsl[] = new int[n];
		nsl[0] = -1;
		Stack<Integer> st = new Stack<>();
		st.push(0);
		
		for(int i = 1; i < n; i++) {
//			pop all the element from the stack which is less than current element
			while( st.size() > 0 && arr[i] <= arr[st.peek()] ) {
				st.pop();
			}
//			if size of stack is zero means that element itself is greater than all the element, there is no next greater element from right to the current element
			if( st.size() == 0 ) {
				nsl[i] = -1;
			}else {
//				then the stack of peek is greater than the current element 
				nsl[i] = st.peek();
			}
//			push the current element into the stack
			st.push(i);
		}
		return nsl;
	}

	private static int[] nextSmallerElementOnRightIndex(int n, int[] arr) {
		int nsr[] = new int[n];
		nsr[n-1] = n;
		
		Stack<Integer> st = new Stack<>();
		st.push(n-1);
		for(int i = n-2; i >= 0; i--) {
//			pop all the element from the stack which is less than current element
			while( st.size() > 0 && arr[i] <= arr[st.peek()] ) {
				st.pop();
			}
//			if size of stack is zero means that element itself is greater than all the element, there is no next greater element from right to the current element
			if( st.size() == 0 ) {
				nsr[i] = n;
			}else {
//				then the stack of peek is greater than the current element 
				nsr[i] = st.peek();
			}
//			push the current element into the stack
			st.push(i);
		}
		return nsr;
	}
	
}
