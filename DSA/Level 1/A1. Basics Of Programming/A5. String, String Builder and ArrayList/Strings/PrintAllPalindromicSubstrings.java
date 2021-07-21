package Strings;

/*
 1. You are given a string. 
2. You have to print all palindromic substrings of the given string.
Input Format
A String
Output Format
All palindromic substrings(one in a line).
First, all palindromic substrings starting from first character of string will be printed, then from second character and so on.
Sample Input
abcc
Sample Output
a
b
c
cc
c
 */
import java.util.Scanner;

public class PrintAllPalindromicSubstrings {

	public static void solution(String str){
		
		for (int si = 0; si < str.length(); si++) {
			for (int ei = si+1; ei <= str.length(); ei++) {
				if(isPalindrom(str.substring(si,ei))) {
					System.out.println(str.substring(si,ei) );
				}
			}
		}
	}
 
	public static boolean isPalindrom(String str) {
		String rev = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			rev += str.charAt(i);
		}
		if (str.equals(rev)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isPalindrom2(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
		scn.close();
	}

}
