/*
1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.
Input Format
A string
Output Format
A number representing the count of substrings having all unique characters.
Constraints
1 <= length of string <= 10^5
Sample Input
aabcbcdbca
Sample Output
24

*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A30_Count_Of_Substrings_Having_All_Unique_Characters {

	// Time Complexity: O(n) 
	public static int solution(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		int i = -1; // acquire 
		int j = -1; // release
		int count = 0;
		
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
					  count += (i-j); // answers -> j+1 to i(starting points) and i (end point) 
					  
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
					
					count += (i-j);
					
					// your are valid again
					break;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
		scn.close();
	}

}
