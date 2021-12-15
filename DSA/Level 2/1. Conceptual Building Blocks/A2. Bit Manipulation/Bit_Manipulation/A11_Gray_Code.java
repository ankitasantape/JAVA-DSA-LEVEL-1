/*
1. The gray code is a binary numeral system where two successive numbers differ in only one bit.
2. Given a non-negative integer n representing the total number of bits in the code, print the 
     sequence of gray code. A gray code sequence must begin with 0.
 
 Example:
 Input: 2
 Output: [0,1,3,2]
 Explanation:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 [0,2,3,1] is also a valid gray code sequence.
 00 - 0
 10 - 2
 11 - 3
 01 - 1
Input Format
First line contains n(number of digits).
Output Format
Return the list of numbers in any valid order.
Constraints
0<=n<=20
Sample Input
2
Sample Output
[0, 1, 2, 3]
*/
package Bit_Manipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A11_Gray_Code {
//   Code - 1
	public static List<Integer> grayCode(int n) {
		
		List<Integer> res = new ArrayList<Integer>();
		fun(n, res);
		return res;
	}
	
	public static void fun(int n, List<Integer> ans) {
		if(n == 0) {
			ans.add(0);
			return;
		}
		
		fun(n - 1, ans);
		for(int i = ans.size()-1; i >= 0; i--) {
			ans.add( ans.get(i) | (1 << (n - 1)));
		}
	}
	
//	Code 2
	
	public static ArrayList<String> grayCode2(int n) {
		
		if(n == 1) {
			ArrayList<String> br = new ArrayList<>();
			br.add("0");
			br.add("1");
			return br;
		}
		
		ArrayList<String> rr = grayCode2(n - 1);
		ArrayList<String> mr = new ArrayList<String>();
		for(int i = 0; i < rr.size(); i++) {
			String rstr = rr.get(i);
			mr.add( "0" + rstr);
		}
		
		for(int i = rr.size() - 1; i >= 0; i--) {
			String rstr = rr.get(i);
			mr.add( "1" + rstr);
		}
		return mr;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		List<Integer> ans = grayCode(n);
//		System.out.println(ans);
		Collections.sort(ans);
		System.out.println(ans);
		
		List<String> ans2 = grayCode2(n);
		Collections.sort(ans2);
		System.out.println(ans2);
		scn.close();
	}
}
