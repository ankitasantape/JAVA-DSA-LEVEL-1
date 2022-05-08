/*
1. You are given an array(arr) of integers.
2. You have to find the length of the largest subarray with sum 0.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing the length of largest subarray with zero sum.

*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A05_Largest_Subarray_With_Zero_Sum {

	public static int solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = -1;
		int maxlength = 0;
		int psum = 0;
		map.put(psum, i);
		while(i < arr.length-1) {
			i++;
			psum += arr[i];
			
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
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
		scn.close();
	}

}
