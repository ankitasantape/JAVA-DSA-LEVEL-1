/*

Leetcode: https://leetcode.com/problems/pascals-triangle-ii/description/

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:

Input: rowIndex = 0
Output: [1]
Example 3:

Input: rowIndex = 1
Output: [1,1]
 

Constraints:

0 <= rowIndex <= 33
 

*/



package Arrays_And_String;

import java.util.ArrayList;
import java.util.Scanner;

public class A42_Pascal_Triangle_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		pascalPattern(n);
		System.out.println("-------------------------------");
		ArrayList<Integer> res = pascalRow(n);
		
		System.out.println(n + "th row -> " );
		for(int val : res) {
			System.out.print( val + "\t");
		}
		System.out.println();
		
		sc.close();
	}

	// i - rowIndex
	private static ArrayList<Integer> pascalRow(int i) {
		
		ArrayList<Integer> res = new ArrayList<>();
		
		int val = 1;
		for(int j = 0; j <= i; j++) {
			res.add(val);
			val = val * (i-j) / (j+1);
		}
		
		return res;
	}

	private static void pascalPattern(int n) {
		
		for(int i = 0; i <= n; i++) { // rowIndex
			int icj = 1;
			for(int j = 0; j <= i; j++) { // ColIndex
				System.out.print(icj + "\t");
				int icjp1 = icj * (i - j) / (j + 1);
				icj = icjp1;
			}
			System.out.println();
		}
		
	}
	
}
