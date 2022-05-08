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

*/

package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A07_Largest_Area_Histogram_2 {

	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int n = Integer.parseInt(br.readLine());
	    int[] a = new int[n];
	    for(int i = 0; i < n; i++){
	       a[i] = Integer.parseInt(br.readLine());
	    }

	    // code
	    System.out.println( largestRectangleArea(a) );
	}

	public static int largestRectangleArea(int[] heights) {

		int[] nsl = nextSmallerLeft(heights);
		int[] nsr = nextSmallerRight(heights);
		int ans = 0;
		int n = heights.length;
		for (int i = 0; i < n; i++) {
			int width = nsr[i] - nsl[i] - 1;
			int area = width * heights[i];
			ans = Math.max(ans, area);
		}
		return ans;
	}

	public static int[] nextSmallerLeft(int[] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int[] nsl = new int[n];
		nsl[0] = -1;
		for (int i = 1; i < n; i++) {
			while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				nsl[i] = -1;
			} else {
				nsl[i] = st.peek();
			}
			st.push(i);
		}
		return nsl;
	}

	public static int[] nextSmallerRight(int[] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		st.push(n - 1);
		int[] nsr = new int[n];
		nsr[n - 1] = n;
		for (int i = n - 2; i >= 0; i--) {
			while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			if (st.size() == 0) {
				nsr[i] = n;
			} else {
				nsr[i] = st.peek();
			}
			st.push(i);
		}
		return nsr;
	}

}
