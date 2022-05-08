/*
1. You are given a string(str) and a number K.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has exactly K unique characters.
Input Format
A string
Output Format
A number representing count of substrings with exactly K unique characters.
Constraints
1 <= length of string <= 10^5
1 <= k <= 26
Sample Input
aabcbcdbca
2
Sample Output
12

*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A37_Count_Of_Substrings_With_Exactly_K_Unique_Characters {
   
	public static int countOfSSAtmostKDistinct(String str, int k) {
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
	
	public static int solution(String str, int k){
		
		int ans = countOfSSAtmostKDistinct(str, k) - countOfSSAtmostKDistinct(str, k-1);
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
		scn.close();
	}
}
