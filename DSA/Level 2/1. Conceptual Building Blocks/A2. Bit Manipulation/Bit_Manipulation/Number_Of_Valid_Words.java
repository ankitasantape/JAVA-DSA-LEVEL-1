/*
1. You are given N number of words.
2. You are given M puzzles in the form of M strings.
3. For a given puzzle, a word is valid if both the following conditions are confirmed - 
    Condition 1 -> Word contains the first letter of puzzle.
    Condition 2 -> For each letter in word, that letter should be present in puzzle.
4. You have to print the number of valid words corresponding to a puzzle.
Input Format
A number N
N space separated strings
A number M
M space separated strings
Output Format
Check the sample ouput and question video.
Constraints
1 <= N <= 10^5
4 <= length of word <= 50
1 <= M <= 10^4
length of puzzle string = 7
puzzle string doesn't contain any repeated characters.
Sample Input
7
aaaa asas able ability actt actor access 
6
aboveyz abrodyz abslute absoryz actresz gaswxyz
Sample Output
aboveyz -> 1
abrodyz -> 1
abslute -> 3
absoryz -> 2
actresz -> 4
gaswxyz -> 0
*/
package Bit_Manipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Number_Of_Valid_Words {
    
	public static ArrayList<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0; i < 26; i++) {
			char ch = (char) ('a' + i);
			map.put(ch, new ArrayList<Integer>());
		}
//		For words
		for(String word : words) {
			int mask = 0;
			for(char ch : word.toCharArray()) {
				int bit = ch - 'a';
				mask = mask | (1 << bit);
			}
	        HashSet<Character> unique = new HashSet<>();
			for(char ch: word.toCharArray()) {
				if(unique.contains(ch)) {
					continue;
				}
				unique.add(ch);
				map.get(ch).add(mask);
			}
		}
		
		ArrayList<Integer> res = new ArrayList<>();
		for(String puzzle : puzzles) {
			int pmask = 0;
			for(char ch : puzzle.toCharArray()) {
				int bit = ch - 'a';
				pmask = pmask | (1 << bit);
			}
//			get first char of puzzle to check whether the Word contains the first letter of puzzle or not
			char fch = puzzle.charAt(0);
			ArrayList<Integer> wordToCheck = map.get(fch);
			int count = 0;
			
			for(int wmask : wordToCheck) {
				if( (wmask & pmask) == wmask ) {
					count++;
				}
			}
			res.add(count);
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < words.length; i++) {
			words[i] = scn.next();
		}
		int m = scn.nextInt();
		String[] puzzles = new String[m];
		for (int i = 0; i < m; i++) {
			puzzles[i] = scn.next();
		}
		ArrayList<Integer> ans = findNumOfValidWords(words, puzzles);
		for (int i = 0; i < m; i++) {
			System.out.println(puzzles[i] + " -> " + ans.get(i));
		}
		scn.close();
	}

}
