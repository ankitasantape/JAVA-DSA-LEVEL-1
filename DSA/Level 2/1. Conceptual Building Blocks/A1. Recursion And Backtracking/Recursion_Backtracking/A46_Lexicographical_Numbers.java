/*

1. You are given a number.
2. You have to print all the numbers from 1 to n in lexicographical order.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number
Output Format

Constraints
1 <= n <= 50000
Sample Input
14
Sample Output
1
10
11
12
13
14
2
3
4
5
6
7
8
9

*/

package Recursion_Backtracking;

import java.util.Scanner;

public class A46_Lexicographical_Numbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        for(int i = 1; i <= 9; i++) {
        	dfs(i, n);
        }
		scn.close();
	}

	private static void dfs(int i, int n) {
		if(i > n) {
			return;
		}
		System.out.println(i);
		for(int j = 0; j < 10; j++) {
			dfs(10 * i + j, n);
		}
	}
	
}
