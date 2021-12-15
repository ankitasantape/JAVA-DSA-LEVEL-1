/*
1. You are given an array of numbers.
2. You have to find 2 non-repeating numbers in an array.
3. All repeating numbers are repeating even number of times.
Input Format
A number n
a1
a2..
n numbers
Output Format
2 Non-repeating number
Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 
Sample Input
6
23 27 23 17 17 37
Sample Output
27
37 
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A05_All_Repeating_Except_Two {

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

	public static void solution(int[] arr) {
		
		int xxory = 0;
		
		for(int val : arr) {
			xxory = xxory ^ val;
		}
		
		int rsbm = xxory & -xxory;
		
		int x = 0;
		int y = 0;
		
		for(int val : arr) {
			if((val & rsbm) == 0) {
				x = x ^ val;
			} else {
				y = y ^ val;
			}
		}
		if(x < y) {
			System.out.println(x);
			System.out.println(y);
		} else {
			System.out.println(y);
			System.out.println(x);
		}
		
        
        
	}
}
