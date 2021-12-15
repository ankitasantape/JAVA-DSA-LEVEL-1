/*
1. You are given an array of length n containing numbers from 1 to n.
2. One number is present twice in array and one is missing.
3. You have to find these two numbers.
Input Format
A number n
a1
a2..
n numbers
Output Format
Missing number
Repeating Number
Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 
Sample Input
7
1 
3 
4 
5 
1 
6 
2
Sample Output
Missing Number -> 7
Repeating Number -> 1
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A06_One_Repeating_And_One_Missing {
     
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
		// write your code here
		int xxory = 0;
	    for(int i = 0; i < arr.length; i++) {
	    	xxory ^= arr[i] ^ (i+1);   
	    }
        int rsbm = xxory & -xxory;
		
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if((arr[i] & rsbm) == 0) {
				x = x ^ arr[i];
			} else {
				y = y ^ arr[i];
			}
			
			if(((i+1) & rsbm) == 0) {
				x ^= (i + 1); 
			} else {
				y = y ^ (i + 1);
			}
		}
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == x) {
				System.out.println("Missing Number -> "+ y);
				System.out.println("Repeating Number -> "+ x);
				break;
			} 
			if(arr[i] == y) {
				System.out.println("Missing Number -> "+ x);
				System.out.println("Repeating Number -> "+ y);	
				break;
			} 
		}
		
		
	}
} 
