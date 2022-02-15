/*
You are given a string s.
A split is called good if you can split s into two non-empty strings sleft and sright where their concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.
Return the number of good splits you can make in s.

Example 1:

Input: s = "aacaba"
Output: 2
Explanation: There are 5 ways to split "aacaba" and 2 of them are good. 
("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
Example 2:

Input: s = "abcd"
Output: 1
Explanation: Split the string as follows ("ab", "cd").
 
Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.

*/
package Dynamic_Programming;

import java.util.Scanner;

public class Number_Of_Good_Ways_To_Split_A_String {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(numSplits(str));
		sc.close();
	}
	
    public static int numSplits(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        int[] sufix = new int[n];
        
        int[] freq = new int[26];
        int count = 0;
        
        for(int i = 0; i < n; i++) {
        	int ch = s.charAt(i) - 'a';
        	freq[ch]++;
        	
        	if(freq[ch] == 1) {
        		count++;
        	}
        	
        	prefix[i] = count;	
        }
        freq = new int[26];
        count = 0;
        
        for(int i = n-1; i>= 0; i--) {
        	int ch = s.charAt(i) - 'a';
        	freq[ch]++;
        	
        	if(freq[ch] == 1) {
        		count++;
        	}
        	
        	sufix[i] = count;	
        }
        int ans = 0;
        for(int i = 0; i < n-1; i++) {
        	if( prefix[i] == sufix[i+1] ) {
        		ans++;
        	}
        }
        
    	return ans;
    }

}
