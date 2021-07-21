package Strings;

import java.util.Scanner;

/*
1. You are given a string. 
2. You have to compress the given string in the following two ways - 
   First compression -> The string should be compressed such that consecutive duplicates of characters are replaced with a single character.
   For "aaabbccdee", the compressed string will be "abcde".
   Second compression -> The string should be compressed such that consecutive duplicates of characters are replaced with the character and followed by the number of consecutive duplicates.
   For "aaabbccdee", the compressed string will be "a3b2c2de2".
Input Format
A String
Output Format
Two strings representing first compressed string and second compressed string respectively.
Sample Input
wwwwaaadexxxxxx
Sample Output
wadex
w4a3dex6
 */

public class CompressedString {

	public static String compression1(String str){
		String ans = ""+str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != ans.charAt(ans.length() - 1)) {
				ans += str.charAt(i);
			}
		}
		return ans;
	}

	public static String compression2(String str){
		String ans = "";
		ans += str.charAt(0);
		int count = 1;
		
		for (int i = 1; i < str.length(); i++) {
			
			if (str.charAt(i) == ans.charAt(ans.length() - 1)) {
				count++;
			}else {
				if (count > 1) {
					ans += count;
				
				}
					ans += str.charAt(i);
					count = 1;
				
			}
		}
		if(count > 1) {
			ans += count;
		}
		return ans;
		
//		String inputString = str;
//		String s = "";
//		for(int i = 0; i < inputString.length(); i++)
//		{
//			int count = 1;
//			while( i < inputString.length() - 1 && inputString.charAt(i) == inputString.charAt(i + 1) )
//			{
//				count++;
//				i++;
//			}
//			
//			if(count == 1)
//			{
//				s += inputString.charAt(i);
//			} else {
//				s += inputString.charAt(i) + "" + count;
//			}
//		}
//
//       return s;

	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
		scn.close();
	}
}
