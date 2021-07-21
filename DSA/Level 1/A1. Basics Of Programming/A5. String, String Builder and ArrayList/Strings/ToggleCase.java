package Strings;

import java.util.Scanner;

/*
1. You are given a string that contains only lowercase and uppercase alphabets. 
2. You have to toggle the case of every character of the given string.
Input Format
A String
Output Format
A String
Sample Input
pepCODinG
Sample Output
PEPcodINg
 */

public class ToggleCase {

	public static String toggleCase(String str){
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				ans += str.substring(i,i+1).toUpperCase();
			} else {
				ans += str.substring(i,i+1).toLowerCase();
			}
		}
		return ans;
	}
	
	public static String toggleCase2(String str){
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				ans += (char) (str.charAt(i) - 'a' + 'A');
			} else {
				ans += (char) (str.charAt(i) - 'A' + 'a');
			}
			
		}
		return ans;
	}
	
	public static String toggleCase3(String str){
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				ans.append((char) (ch - 'a' + 'A'));
			} else {
				ans.append((char) (ch - 'A' + 'a'));
			}
			
		}
		return ans.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
		scn.close();
	}

}
