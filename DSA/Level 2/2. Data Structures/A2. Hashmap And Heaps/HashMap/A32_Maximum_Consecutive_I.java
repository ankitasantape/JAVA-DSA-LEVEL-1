/*
1. You are given an array(arr) which contains only 0's and 1's.
2. You have to find the maximum number of consecutive 1's in the given array if you can flip at most one zero.
Input Format
A number N
arr1
arr2... N numbers
Output Format
A number representing maximum number of consecutive 1's after flipping at most one zero.
Constraints
1 <= N <= 10^5
0 <= arr[i] <= 1
Sample Input
6
1 1 0 0 1 1
Sample Output
3

*/

package HashMap;

import java.util.*;

public class A32_Maximum_Consecutive_I {

	public static int solution(int[] arr) {
		int cz = 0;
		int olen = 0;
		int i = -1; // acquire
		int j = -1; // release
		
		int n = arr.length;
		
		while( i < n-1 ) {
			// acquiring
			while( i < n-1 ) {
				i++;
				
				if( arr[i] == 0) {
					cz++;
				}
				if( cz <= 1  ) {
					// update
					int len = i - j;
					olen = Math.max(len, olen);
				} else {
					break;
				}
			}
			// releasing
			while( j < i ) {
				j++;
				
				if( arr[j] == 0 ) {
					cz--;
					break;
				} 
			}
		}
		return olen;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
		scn.close();
	}

}
