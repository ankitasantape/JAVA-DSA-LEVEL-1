/*
1. You are given an array of n numbers.
2. You have to find the sum of bit differences in all pairs that can be formed from n numbers.
3. Bit difference of two numbers is defined as the count of different bits at same positions in binary representations of two numbers.
Input Format
A number n
a1
a2..
n numbers
Output Format

Constraints
1 <= n <= 10^9
1 <= arr[i] <= 10^9
Sample Input
3
1 2 3
Sample Output
8
*/
package Bit_Manipulation;

import java.util.Scanner;

public class Sum_Of_Bit_Differences_Of_All_Pairs {
	public static long solution(int[] arr) {
		long res = 0;
		
		for(int i = 0; i < 32; i++) {
			long counton = 0;
			for(int val : arr) {
//				check whether the bit is on/off
				if((val & (1 << i)) != 0) {
					counton += 1;
				}
			}
			long countoff = arr.length - counton;
			long diff = counton * countoff * 2;
			res += diff;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
		scn.close();
	}
}
