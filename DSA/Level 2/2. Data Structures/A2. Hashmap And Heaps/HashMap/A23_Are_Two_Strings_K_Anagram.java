/*
1.Given two strings of lowercase alphabets and a value K.
2.Your task is to complete the given function areKAnagrams() which tells if two strings are K-anagrams of each other or not.
 Two strings are called K-anagrams if both of the below conditions are true.
 a. Both have same number of characters.
 b. Two strings can become anagram by changing at most K characters in a string.
Input Format
First line contains an Integer denoting the size of the array 'N'
 Second line contains space seperated strings A and B
 Third line contains an integer K
Output Format
Return true or false
Constraints
1 <= |length of String| <= 200
 1 <= K <= |length of String|
Sample Input
fodr
gork
2
Sample Output
true

Sample Input
aaaabccccdef
aabbbbccdefgg
4
Sample Output
true

Sample Input
aaaabccccdef
aabbbbccdefgg
3
Sample Output
false

Sample Input
ukdbgygrsjlaukwsgc 
memdwhetaewfahkc
14
Sample Output
false

*/

package HashMap;

import java.util.*;

public class A23_Are_Two_Strings_K_Anagram {

	public static boolean areKAnagrams(String s1, String s2, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		// populate map  using s1
		for(int i=0; i<s1.length(); i++) {
			char ch = s1.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		System.out.println(map);
		// destroy freqmap using s2
		for(int i=0; i<s2.length(); i++) {
			char ch = s2.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) - 1);
		}
		System.out.println(map);
	
		int ro = 0;   // ro -> required operation
 		// summation of +ve or -ve values from the map
		for(char key : map.keySet()) {
			if( map.get(key) > 0 ) {
				ro += map.get(key);
			}
		}
		System.out.println(ro + " " + k);
		return ro <= k;
	}

	// Don't make changes here
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str1 = s.next();
		String str2 = s.next();
		int k = s.nextInt();
		System.out.println(areKAnagrams(str1, str2, k));
		s.close();

	}


}
