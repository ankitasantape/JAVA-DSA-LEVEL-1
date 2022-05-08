/*
1. You are given a string str.
2. You have to find the smallest window length that contains all the unique characters of the given string.
Input Format
A string
Output Format
A number representing smallest window length that contains all unique characters of the given string.
Constraints
1 <= length of string <= 10^6
Sample Input
aabcbcdbca
Sample Output
4

*/

package HashMap;

import java.util.*;

public class A28_Smallest_Substring_Of_A_String_Containing_All_Unique_Characters_Of_Itself {

	public static int solution(String str){
		int olen = Integer.MAX_VALUE;
		
		HashSet<Character> hs = new HashSet<>();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i < str.length(); i++) {
			hs.add(str.charAt(i));
		}
		
		int i = -1;
		int j = -1;
		
		while(i < str.length()-1) {
			while(i < str.length()-1 && map.size() < hs.size()) {
			    i++;
			    
			    char ch = str.charAt(i);
			    map.put(ch, map.getOrDefault(ch, 0) + 1);   
			}
			
			while(j < i && map.size() == hs.size()) {
				// ans
				int len = i-j;
				if(len < olen) {
					olen = len;
				}
				j++;
				
				char ch = str.charAt(j);
				
				if(map.get(ch) == 1) {
					map.remove(ch);
				} else {
					map.put(ch, map.get(ch) - 1);
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
