package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.

e.g.
for the n = 17, array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, 
the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]
Input Format
Input is managed for you
Output Format
Maximum of each window in separate line
Constraints
0 <= n < 100000
-10^9 <= a[i] <= 10^9
0 < k < n
Sample Input 
17
2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6
4
Sample Output
9 9 8 12 12 14 14 32 32 32 32 19 19 19
 */
public class Sliding_Window_Maximum {

	public static void main(String[] args) throws Exception {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();

	    sliding_windows_maximum(arr, n, k); 
	    System.out.println();
	    sliding_windows_maximum_2(arr, n, k);
	    findLargestFromSlidingWindow(n, arr, k);
	    sc.close();
	  }
	
	public static void sliding_windows_maximum(int arr[], int n, int k) {
		 int nge_idx[] = next_Greater_Element_Right(arr, n);
		 int i = 0, j = 0;
		 
		 for(i = 0; i <= n-k; i++) {
//			 if j had left behind, first make j equal to i
			 if (j < i) {
				 j = i;
			 }
			 
//			 Agar, next greater hai, j ka nge[j], wo agar window(i+k) ke under hai to, to hum nge pe ja skte hai jump krke  
			 while( nge_idx[j] < i+k ) {
				
				 j = nge_idx[j];
			 }
			
			System.out.print(arr[j]+" ");
		 }	 
	}
	  
	public static int[] next_Greater_Element_Right(int arr[], int n) {
		Stack<Integer> st = new Stack<>();
		int nge_idx[] = new int[n];
		for(int i = n-1; i >= 0; i-- ) {
			
//			Pop all the smaller or equal elements
			while(st.size() > 0 && arr[i] >= arr[st.peek()] ) {
				st.pop();
			}
// Update - *trick - we are storing nge_index = n(arr.length), if we store -1 which does not really exist & sometimes we check
// Does nge exists outside the window or those element that doesn't have nge in array for that element -1 would be a mistake that's y we can take(n/INFI),

//			jis element ka next greater element nhi hai uske liye by default greater element ka index arr.length le rhe hai
			if(st.size() == 0) {
				nge_idx[i] = n;
			} else {
				nge_idx[i] = st.peek();
			}
//			push element
			st.push(i);
		}
		
		return nge_idx;
	}
	
	
	public static void sliding_windows_maximum_2(int arr[], int n, int k) {
		Deque<Integer> dq = new ArrayDeque<>();
//		int ans[] = new int[n-k+1];
//		int j = 0;
	    int i = 0;
	    while(i < k) {
            while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
				dq.removeLast();
			}
            dq.addLast(i);
            ++i;
	    }
		for(; i < n; ++i) {
//			ans[j++] = arr[dq.peek()];
			System.out.print(arr[dq.peek()]+ " ");
			while( !dq.isEmpty() && dq.peek() <= i-k) {
				dq.removeFirst();
		    }
			while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
				dq.removeLast();
			} 
			 
			dq.addLast(i);
		}
//		ans[j] = arr[dq.peek()];
		System.out.println(arr[dq.peek()]+ " ");
	}

	private static void findLargestFromSlidingWindow(int n, int[] a, int k) {

//		find next greater element's index and store it in reverse order form right side
		Stack<Integer> st = new Stack<>();

//		store the next greater element
		int nge[] = new int[n];

//		initially, insert the last index of arr element into stack
		st.push(n - 1);

//		last element ka next greater element nhi hota so hum yha pe arr.length ko last index add kr rhe to avoid exception
		nge[n - 1] = n;

		for (int i = n - 2; i >= 0; i--) {
//			Strategy - pop() ---> add() ---> push()  -a+
//			jb tak next greater element nhi milata tb tk pop() krte jayenge
			while (st.size() > 0 && a[i] >= a[st.peek()]) {
				st.pop();
			}

			if (st.size() == 0) {
				nge[i] = a.length;
			} else {
				nge[i] = st.peek();
			}

			st.push(i);
		}

//		Actual Code
		int j = 0;
		for (int i = 0; i <= n - k; i++) {
			if (j < i) {
				j = i;
			}
//			apply loop to find the maximum of window starting at j
			while (nge[j] < i + k) {
				j = nge[j];
			}

			System.out.print(a[j] + " ");
		}

	}
}
