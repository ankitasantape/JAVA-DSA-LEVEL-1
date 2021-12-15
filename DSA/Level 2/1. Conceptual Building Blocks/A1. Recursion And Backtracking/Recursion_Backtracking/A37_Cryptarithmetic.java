/*
1. You are given three strings s1, s2 and s3.
2. First two are supposed to add and form third. s1 + s2 = s3
3. You have to map each individual character to a digit, so that the above equation holds true.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing the signature. The judge can't force you but intends you to teach a concept.
Input Format
Three strings
s1
s2
s3
Output Format

Constraints
1 <= length of s1,s2,s3 <= 10
Sample Input
team
pep
toppr
Sample Output
a-3 e-9 m-4 o-1 p-2 r-6 t-0 
a-3 e-9 m-5 o-1 p-2 r-7 t-0 
a-3 e-9 m-6 o-1 p-2 r-8 t-0 
a-4 e-9 m-2 o-1 p-3 r-5 t-0 
a-4 e-9 m-5 o-1 p-3 r-8 t-0 
a-5 e-9 m-2 o-1 p-4 r-6 t-0 
a-5 e-9 m-3 o-1 p-4 r-7 t-0 
a-6 e-9 m-2 o-1 p-5 r-7 t-0 
a-6 e-9 m-3 o-1 p-5 r-8 t-0 
a-7 e-9 m-2 o-1 p-6 r-8 t-0 
*/

package Recursion_Backtracking;

import java.util.HashMap;
import java.util.Scanner;

public class A37_Cryptarithmetic {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.nextLine();
		String s2 = scn.nextLine();
		String s3 = scn.nextLine();

		HashMap<Character, Integer> charIntMap = new HashMap<>();
		String unique = "";
		for (int i = 0; i < s1.length(); i++) {
			if (!charIntMap.containsKey(s1.charAt(i))) {
				charIntMap.put(s1.charAt(i), -1);
				unique += s1.charAt(i);
			}
		}

		for (int i = 0; i < s2.length(); i++) {
			if (!charIntMap.containsKey(s2.charAt(i))) {
				charIntMap.put(s2.charAt(i), -1);
				unique += s2.charAt(i);
			}
		}

		for (int i = 0; i < s3.length(); i++) {
			if (!charIntMap.containsKey(s3.charAt(i))) {
				charIntMap.put(s3.charAt(i), -1);
				unique += s3.charAt(i);
			}
		}

		boolean[] usedNumbers = new boolean[10];
		solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
		scn.close();
	}

	public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
			String s1, String s2, String s3) {
		
		 if(idx == unique.length()) {
			 int num1 = getNumber(s1, charIntMap);
			 int num2 = getNumber(s2, charIntMap);
			 int num3 = getNumber(s3, charIntMap);
			 
			 if(num1 + num2 == num3) {
				 for(int i = 0; i < 26; i++) {
					 char ch = (char)('a' + i);
					 if(charIntMap.containsKey(ch)) {
						 System.out.print(ch + "-" + charIntMap.get(ch) + " ");
					 }
				 }
				 System.out.println();
			 }
			 return;
		 }
		 char ch = unique.charAt(idx);
		 for(int num = 0; num <= 9; num++) {
			 if(usedNumbers[num] == false) {
				 usedNumbers[num] = true;
				 charIntMap.put(ch, num);
				 solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
				 usedNumbers[num] = false;
				 charIntMap.put(ch, -1);
			 }
		 }
	}

	private static int getNumber(String s, HashMap<Character, Integer> charIntMap) {
		String num = "";
//		hashmap me char ke against jo number hai unko add krenge
		for(int i = 0; i < s.length(); i++) {
			num += charIntMap.get(s.charAt(i));
		}
		return Integer.parseInt(num);
	}

}
