package Strings;

import java.util.Scanner;

/*
1. You are given a string that contains only lowercase and uppercase alphabets. 
2. You have to form a string that contains the difference of ASCII values of every two consecutive characters between those characters.
   For "abecd", the answer should be "a1b3e-2c1d", as 
   'b'-'a' = 1
   'e'-'b' = 3
   'c'-'e' = -2
   'd'-'c' = 1
   Sample Input
pepCODinG
Sample Output
p-11e11p-45C12O-11D37i5n-39G
 */

public class StringWithDifferenceOfEvery2Consecutivechars {

	public static String solution(String str){
		String ans = "";
		int diff = 0;
		for (int i = 1; i < str.length(); i++) {
			diff = str.charAt(i) - str.charAt(i - 1 );
			ans += str.charAt(i - 1) + "" + diff;
		}
		ans += str.charAt(str.length() - 1);
		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
		scn.close();
	}
}
