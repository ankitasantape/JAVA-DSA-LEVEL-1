/*
Return the number of distinct non-empty substrings of text that can be written as
the concatenation of some string with itself 
(i.e. it can be written as a + a where a is some string).

Example 1:

Input: text = "abcabcabc"
Output: 3
Explanation: The 3 substrings are "abcabc", "bcabca" and "cabcab".
Example 2:

Input: text = "leetcodeleetcode"
Output: 2
Explanation: The 2 substrings are "ee" and "leetcodeleetcode".
 

Constraints:

1 <= text.length <= 2000
text has only lowercase English letters.

*/
package Dynamic_Programming;

import java.util.*;

public class Distinct_Echo_Substrings {
	static long[] hash;
	static long[] pow;
	
	static long r = 256; // radix value to generate unique hash value
	static long mod = (long)1e9+7; // 10^9+7 = 1000000007 which is biggest prime number
	
    
	// Time Complexity : O(n^3)
	public static int solution1(String text) {
         int n = text.length();
         HashSet<String> set = new HashSet<>();
         
         for(int len = 1; len <= n/2; len++) {
        	 int count = 0;
        	 for(int l = 0, r = len; r < n; l++, r++) { // O(n/2) ~ ( in worst case ) = O(n)
        		 
        		 if(text.charAt(l) == text.charAt(r)) { // O(n/2) ~ ( in worst case ) = O(n)
        			 count++;
        		 } else {
        			 count = 0;
        		 }
        		 if(count == len) {
        			 String substr = text.substring(l, r); // O(n/2) ~ ( in worst case ) = O(n)
        			 set.add(substr);
        			 count--;
        		 }
        	 }
         }
         return set.size();
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println( solution1(str) );
		System.out.println( solution2(str) );
		scn.close();
	}

	public static void process(String text, int n) {
		hash = new long[n];
		pow = new long[n];
		
		pow[0] = 1;
		for(int i = 1; i < n; i++) {
			hash[i] = ( hash[i-1]*r + text.charAt(i) ) % mod;
			pow[i] = ( pow[i-1]*r ) % mod;
		}
	}
	
	public static long hashCode(int l, int r) {
		// long hv = hash[r] - hash[l] * pow[r - l] % m;
		// if hashvalue convert into -ve then add m into hv
		long hv = ( hash[r] - hash[l] * pow[r - l] % mod + mod) % mod;
		return hv;
	}
	
	// Time Complexity: O(n^2)
	private static int solution2(String text) {
		int n = text.length();
		process(text, n);
        HashSet<Long> set = new HashSet<>();
        
        for(int len = 1; len <= n/2; len++) {
       	 int count = 0;
       	 for(int l = 0, r = len; r < n; l++, r++) { // O(n/2) ~ ( in worst case ) = O(n)
       		 
       		 if(text.charAt(l) == text.charAt(r)) { // O(n/2) ~ ( in worst case ) = O(n)
       			 count++;
       		 } else {
       			 count = 0;
       		 }
       		 if(count == len) {
       			 Long hashvalue = hashCode(l, r);
       			 set.add(hashvalue);
       			 count--;
       		 }
       	 }
        }
        return set.size();
	}
}
