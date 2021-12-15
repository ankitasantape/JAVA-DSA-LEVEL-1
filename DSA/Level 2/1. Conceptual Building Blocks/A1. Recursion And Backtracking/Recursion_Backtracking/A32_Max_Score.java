/*
1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet 
     from a to z.
2. You have to find the maximum score of any valid set of words formed by using the given 
     alphabets.
3. A word can not be used more than one time.
4. Each alphabet can be used only once. 
5. It is not necessary to use all the given alphabets.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number N representing number of words
N space separated strings
A number M representing number of alphabets(might be repeating)
M space separated characters
26 numbers representing score of unique alphabets from a to z.
Output Format

Constraints
1 <= N <= 14
1 <= length of word <= 15
1 <= M <= 100
1 <= Value of score <= 10
Sample Input
4
dog cat dad good
9
a b c d d d g o o
1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
Sample Output
23
*/

package Recursion_Backtracking;

import java.util.Scanner;

public class A32_Max_Score {
    
	public static int solution(String[] words, int idx, int[] farr, int[] score) {
		if (idx == words.length) {
			return 0;
		}
		// no ki call
		int f1 = 0 + solution(words, idx + 1, farr, score); 
		// yes ki call
		int f2 = 0;
		
		boolean flag = true;
		int scoreOfCurrentWord = 0;
		for(int i = 0; i < words[idx].length(); i++) {
			char ch = words[idx].charAt(i);
			farr[ch - 'a']--;
			if(farr[ch - 'a'] < 0) {
				flag = false;
			}
			scoreOfCurrentWord += score[ch - 'a'];
		}
		
//		we can write if condition to check freq of char instead of this for loop
//		for(int i = 0; i < farr.length; i++) {
////			agar freq -ve ho gayi toh word possile nhi hai
//			if (farr[i] < 0) {
//				flag = false;
//			}
//		}
		
		if (flag == true) {
			f2 = scoreOfCurrentWord + solution(words, idx + 1, farr, score);
		}
//		we need to fix ( whatever changes you have made need to undo ) frequency array while returning back
		for(int i = 0; i < words[idx].length(); i++) {
			char ch = words[idx].charAt(i);
			farr[ch - 'a']++;
		}
		return Math.max(f1, f2);
	}
	
	public static int solution1(String[] words, int idx, int[] farr, int[] score) {
		
		if(idx == words.length) {
			return 0;
		}
		
		int sword = 0; // score of current word
		int noscore = sword + solution1(words, idx + 1, farr, score); // word not include
		
		 // word to include
		// score word
		String word = words[idx];
		boolean flag = true; // true if yes call can be made
		for (int i = 0; i < words[idx].length(); i++) {
			char ch = word.charAt(i);
			
			if( farr[ch - 'a'] == 0 ) {
				// if frequency is zero for that char then we should avoid yes ki call for that char
			    flag = false;	
			}
			// if char used, reduce frequency of char
			farr[ch - 'a']--;
			// add score of char into score of word
			sword += score[ch - 'a']; 
		}
		
		int yesscore = 0;
		if(flag == true) {
            // we have score of current word from subset and now we have to add score of remaining word from same subset
			yesscore = sword + solution1(words, idx + 1, farr, score);
		}
		
//		backtrack changes
		for (int i = 0; i < words[idx].length(); i++) {
			char ch = word.charAt(i);
			// if char used, reduce frequency of char
			farr[ch - 'a']++;
		}
		return Math.max(yesscore, noscore);
	}		

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, 0, farr, score));
		System.out.println(solution1(words, 0, farr, score));
        scn.close();
	}
}
