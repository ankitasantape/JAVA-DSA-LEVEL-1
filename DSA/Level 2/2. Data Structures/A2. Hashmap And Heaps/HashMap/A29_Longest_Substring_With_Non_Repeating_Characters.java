/*
1. You are given a string.
2. You have to find the length of the longest substring of the given string that contains all non-repeating characters.
Input Format
A string
Output Format
A number representing the length of longest substring with unique characters.
Constraints
1 <= length of string <= 10^5
Sample Input
aabcbcdbca
Sample Output
4

*/

package HashMap;

import java.util.*;

public class A29_Longest_Substring_With_Non_Repeating_Characters {

	public static int solution(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		int i = -1; // acquire 
		int j = -1; // release
		int olen = 0;
		
		while(i < str.length()-1) {
			// acquire
			while( i < str.length()-1 ) {
				  i++;
				  char ch = str.charAt(i);
				  int nf = map.getOrDefault(ch, 0) + 1;
				  map.put(ch, nf);
				  
				  if( nf == 2 ) {
					  // invalid
					  break;
				  }
				  else { // else me na likhe to bhi chal jayega
					  // valid
					  int len = i-j;
					  if(len > olen) {
						  olen = len;
					  }
				  }
			}
			// release -> to be valid again 
			while( j < i ) {
				j++;
				char ch = str.charAt(j);
				int nf = map.get(ch);
				
				if( nf == 1) {
					map.remove(ch);
				} else {
					// char ki frq kabhi 3 pe jayegi hi nahi
					map.put(ch, 1);
					
					// your are valid again
					break;
				}
			}
		}
		return olen;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
		scn.close();
	}
}
