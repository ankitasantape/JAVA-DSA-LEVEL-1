/*
1. You are given a string str.
2. You are required to find the character with maximum frequency.
Input Format
A string str
Output Format
The character with highest frequency
Constraints
0 < str.length() <= 100
There will be a single character with highest frequency
Sample Input
zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
Sample Output
q
 */
package HashMap_And_Heap;

import java.util.HashMap;
import java.util.Scanner;

public class A00_Highest_Frequency_Character {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		HashMap<Character, Integer> map = new HashMap<>();
		int maxfreq = Integer.MIN_VALUE;
		char maxfreqCh = '\0';
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch) == true) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
			if (map.get(ch) > maxfreq) {
				maxfreq = map.get(ch);
				maxfreqCh = ch;
			}
		}
		System.out.println(maxfreqCh);

		sc.close();
	}
}
