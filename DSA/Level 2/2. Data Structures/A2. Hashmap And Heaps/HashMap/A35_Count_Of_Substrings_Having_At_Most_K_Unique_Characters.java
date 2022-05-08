/*
1. You are given a string(str) and a number K.
2. You have to find the count of substrings of the given string that contains at most K unique characters.
Input Format
A string
A number
Output Format
A number representing the count of substrings with at most K unique characters.
Constraints
1 <= length of string <= 10^5
1 <= K <= 26
Sample Input
aabcbcdbca
2
Sample Output
23

*/

package HashMap;

import java.util.*;

public class A35_Count_Of_Substrings_Having_At_Most_K_Unique_Characters {
   // wrong one - but dry run over this code where ur test cases get failed 
	public static int solution(String str, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		int count = 0;
		int i = -1;
		int j = -1;
		
		while( i < str.length()-1 ) {
			// acquire
			while( i < str.length()-1 && map.size() <= k ) {
				i++;
				char ch = str.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);
				if( map.size() <= k ) {
					count += i-j;
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
					count += (i-j);
					break;
				}
			}
		}
		return count;
	}
	
	public static int solution_2(String str, int k) {
		HashMap<Character, Integer> map = new HashMap<>();
		int count = 0;
		int i = -1;
		int j = -1;
		
		while( i < str.length()-1 ) {
			// acquire
			while( i < str.length()-1 ) {
				i++;
				char ch = str.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);
				if( map.size() <= k ) {
					// ans updation
					count += i-j;
				} else {
					break;
				}
			}
			// release
			while( j < i && map.size() > k ) {
				j++;
				char ch = str.charAt(j);
				int nf = map.get(ch);
				
				if( nf == 1) {
					map.remove(ch);
					// valid again
					count += (i-j);
					break;
				} else { 
					map.put(ch, nf - 1);	
				}	
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
		System.out.println(solution_2(str,k));
		scn.close();
	}
}
