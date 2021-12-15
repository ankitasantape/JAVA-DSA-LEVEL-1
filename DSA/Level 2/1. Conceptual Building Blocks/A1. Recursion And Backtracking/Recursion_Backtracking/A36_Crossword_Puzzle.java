/*
1. You are given a 10*10 2-D array(arr) containing only '+' and '-' characters, which represents a 
    crossword puzzle. 
2. You are also given n number of words which need to be filled into the crossword.
3. Cells containing '-' are to be filled with the given words.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
10 * 10 grid of characters containing only '+' and '-' 
A number n
str1
str2
...n strings
Output Format

Constraints
1 <= n <= 10
Sample Input
+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
4
LONDON
DELHI 
ICELAND 
ANKARA
Sample Output
+L++++++++
+O++++++++
+N++++++++
+DELHI++++
+O+++C++++
+N+++E++++
+++++L++++
++ANKARA++
+++++N++++
+++++D++++
*/

package Recursion_Backtracking;

import java.util.Scanner;

public class A36_Crossword_Puzzle {
   
	public static void solution(char[][] arr, String[] words, int vidx) {
		
		if(vidx == words.length) {
			print(arr);
			return;
		}
		
		String word = words[vidx];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
					if( canPlaceWordHorizontally(arr, word, i, j)) {
						boolean[] wePlaced = placeWordHorizontally(arr, word, i, j);
						solution(arr, words, vidx + 1);
						unplaceWordHorizontally(arr, wePlaced, i, j);
					}
					
					if( canPlaceWordVertically(arr, word, i, j)) {
						boolean[] wePlaced = placeWordVertically(arr, word, i, j);
						solution(arr, words, vidx + 1);
						unplaceWordVertically(arr, wePlaced, i, j);
					}
				}
			}
		}
	}

	private static void unplaceWordVertically(char[][] arr, boolean[] wePlaced, int i, int j) {
		for(int ii = 0; ii < wePlaced.length; ii++) {
			if(wePlaced[ii]  == true) {
				arr[i + ii][j] = '-';
			}
		}
	}

	private static boolean[] placeWordVertically(char[][] arr, String word, int i, int j) {
		boolean[] wePlaced = new boolean[word.length()];

		for (int ii = 0; ii < word.length(); ii++) {
			if (arr[i + ii][j] == '-') {
				arr[i + ii][j] = word.charAt(ii);
				wePlaced[ii] = true;
			}
		}
		return wePlaced;
	}

	private static boolean canPlaceWordVertically(char[][] arr, String word, int i, int j) {
//		first place should not be empty before word to be placed
		if(i - 1 >= 0 && arr[i - 1][j] != '+') {
			return false;
//		no place should remain empty next to word to be placed 
		} else if(i + word.length() < arr.length && arr[i + word.length()][j] != '+') {
			return false;
		}
//		we can place char only when that place contains char that we wanted to place or empty place
		for(int ii = 0; ii < word.length(); ii++) {
//			if that place is perfect or not means word should not cross the boundary
			if(i + ii >= arr.length) {
				return false;
			}
			if(arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii)) {
				continue;
			} else {
//				if box is not empty or that box contains the other char that we don't want to put so return false
				return false;
			}
		}
		return true;
	}

	private static void unplaceWordHorizontally(char[][] arr, boolean[] wePlaced, int i, int j) {
		
		for(int jj = 0; jj < wePlaced.length; jj++) {
			if(wePlaced[jj] == true) {	
				arr[i][j + jj] = '-';
			}
		}
	}

	private static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j) {
		boolean[] wePlaced = new boolean[word.length()];
		
		for(int jj = 0; jj < word.length(); jj++) {
			if(arr[i][j + jj] == '-') {
				arr[i][j + jj] = word.charAt(jj);
//				jo hamane dala hai char uske liye true krenge jo already pada hai unko false hi rakhenge
				wePlaced[jj] = true;
			}
		}
		
		return wePlaced;
	}

	private static boolean canPlaceWordHorizontally(char[][] arr, String word, int i, int j) {
//		first place should not be empty before word to be placed
//		agar left side hai aur waha pe '+' sign hai to sahi hai, nhi to false return krdo
		if(j - 1 >= 0 && arr[i][j - 1] != '+') {
			return false;
//		no place should remain empty next to placed word
//		agar right side hai aur waha pe '+' sign hai to sahi hai, nhi to false return krdo
		} else if(j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') {
			return false;
		}
//		we can place char only when that place contains char that we wanted to place or empty place
		for(int jj = 0; jj < word.length(); jj++) {
//			if that place is perfect or not means word should not cross the boundary
//		    agar word array ke bahar nikal gaye to kaha dale return false
			if(j + jj >= arr[0].length) {
				return false;
			}
//			agar dash hai ya jo char dalna hai wahi pada hai means sahi hai nhi to conflict hai return false
			if(arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj)) {
				continue;
			} else {
//				if box is not empty or that box contains the other char that we don't want to put so return false
				return false;
			}
		}
		return true;
	}

	public static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for (int i = 0; i < arr.length; i++) {
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < words.length; i++) {
			words[i] = scn.next();
		}
		solution(arr, words, 0);
		scn.close();
	}
}
