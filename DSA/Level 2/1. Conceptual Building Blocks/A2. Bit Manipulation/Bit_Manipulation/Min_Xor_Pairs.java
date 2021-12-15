/*
1. You are given an array of distinct integers.
2. You have to print all pairs of integers in the array whose XOR value is minimum.
Input Format
A number N
arr1
arr2..
N numbers
Output Format
Constraints
1 <= n <= 10^5
-10^9 <= arr[i] <= 10^9
Sample Input
4
2
0
5
7
Sample Output
0, 2
5, 7

*/

package Bit_Manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Min_Xor_Pairs {
	public static void solution(int[] arr) {
		Arrays.sort(arr);
		
		ArrayList<String> res = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length - 1; i++) {
			int xor = arr[i] ^ arr[i + 1];
			if(xor < min) {
				min = xor;
				res = new ArrayList<>();
				res.add(arr[i] + ", " + arr[i + 1]);
			} else if(xor == min){
				res.add(arr[i] + ", " + arr[i + 1]);
			}
		}
		for(String val : res) {
			System.out.println(val);
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		solution(arr);
		scn.close();
	}
}
