/*
1. You are given an array that contains only 0s and 1s.
2. You have to find length of the longest subarray with equal number of 0s and 1s.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing length of the longest subarray with equal number of 0s and 1s.
Constraints
1 <= N <= 10^5
0 <= arr[i] <= 1
Sample Input
6
0 1 1 0 1 1
Sample Output
4

*/
package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A07_Longest_Subarray_With_EqualNumber_Of_Zeroes_And_Ones {

	public static int solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = -1;
		int maxlength = 0;
		int psum = 0;
		map.put(psum, i);
		while(i < arr.length-1) {
			i++;
			if( arr[i] == 0 ) {
				psum += -1;
			} else {
				psum += 1;
			}
			
			if( map.containsKey(psum) == false ) {
				map.put(psum, i);
			} else {
				int psum_idx = map.get(psum);
				maxlength = Math.max(maxlength, i - psum_idx);
			}
		}
		return maxlength;
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
