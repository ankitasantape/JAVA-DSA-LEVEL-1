/*
1. You are given a string(str) and a number K.
2. You have to find length of the longest substring that has exactly k unique characters.
3. If no such substring exists, print "-1".
Input Format
A string
Output Format
A number representing length of the longest K unique characters substring.
Constraints
1 <= length of string <= 10^5
1 <= k <= 26
Sample Input
aabcbcdbca
2
Sample Output
4
*/

package HashMap;

import java.util.*;

public class A31_Longest_Substring_With_Exactly_K_Unique_Characters {

	public static int solution(String str, int k){
		HashMap<Character, Integer> map = new HashMap<>();
		int olen = -1;
		int i = -1;
		int j = -1;
		
		while( i < str.length()-1 ) {
			// acquire
			while( i < str.length()-1 && map.size() <= k ) {
				i++;
				char ch = str.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);
				if( map.size() == k ) {
					
					int len = i-j;
					if( len > olen ) {
						olen = len;
					}
				}
			}
			// release
			while( j < i && map.size() > k ) {
				j++;
				char ch = str.charAt(j);
				int nf = map.get(ch);
				
				if( nf == 1) {
					map.remove(ch);
				} else {
					map.put(ch, nf - 1);
				}
				
			}
		}
		return olen;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
		scn.close();
	}


}
