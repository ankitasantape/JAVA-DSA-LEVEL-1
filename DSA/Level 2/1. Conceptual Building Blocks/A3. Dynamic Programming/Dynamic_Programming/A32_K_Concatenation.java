/*
1. You are given an array(arr1) of integers and an integer k.
2. Another array(arr2) is formed by concatenating K copies of arr1.
   For example, if arr1 = {1,2} and k = 3, then arr2 = {1,2,1,2,1,2}.
3. You have to find the maximum subarray sum in arr2.
Input Format
A number N
a1
a2.. N integers
A number K
Output Format
A number representing maximum sum subarray in arr2.

Constraints
1 <= N <= 10^5
1 <= K <= 10^5
-10^6 <= arr1[i] <= 10^6 
Sample Input
3
1
2
3
3
Sample Output
18

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A32_K_Concatenation {

	public static long solution(int[] arr, int k, long sum) {
		if (k == 1) {
			return kadanes(arr);
		} else 
		 
		if (sum > 0) {
			return (k - 2) * sum + kadanes2(arr);
		} else {
			return kadanes2(arr);
		}
		
	}

	public static long kadanes(int[] arr) {
		long prev = arr[0];
		long max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			prev = Math.max(prev + arr[i], arr[i]);
			max = Math.max(max, prev);
		}
		return max;
	}

	public static long kadanes2(int[] arr) {
		long prev = arr[0];
		long max = arr[0];

		for (int i = 1; i < 2 * arr.length; i++) {
			prev = Math.max(prev + arr[i % arr.length], arr[i % arr.length]);
			max = Math.max(max, prev);
		}
		return max;
	}
	
	public static long kadanes_2(int[] arr) {
		int narr[] = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			narr[i] = arr[i];
		}
		for(int i = 0; i < arr.length; i++) {
			narr[i + arr.length] = arr[i];
		}
		return kadanes(narr);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		System.out.println(solution(arr, k, sum));
		scn.close();
	}
}
