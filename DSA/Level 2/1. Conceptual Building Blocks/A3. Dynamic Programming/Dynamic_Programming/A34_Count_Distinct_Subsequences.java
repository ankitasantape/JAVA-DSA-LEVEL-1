/*
1. You are given a string.
2. You have to print the count of distinct and non-empty subsequences of the given string. 

Note -> String contains only lowercase letters.
Input Format
A String
Output Format
A number

Constraints
1 <= length of string <= 60
Sample Input
abc
Sample Output
7

*/
package Dynamic_Programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class A34_Count_Distinct_Subsequences {
     
	public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        long[] dp = new long[str.length() + 1];
        dp[0] = 1;
        // lo => last occurrence
        HashMap<Character, Integer> lo = new HashMap<>();
        
        for (int i = 1; i < dp.length; i++) {
        	dp[i] = 2 * dp[i - 1];
        	
        	char ch = str.charAt(i - 1);
        	if (lo.containsKey(ch)) {
        		int oldIdx = lo.get(ch); 
        		dp[i] = dp[i] - dp[oldIdx - 1];
        	}
        	
        	lo.put(ch, i);
        }
        // dp[str.length()] ye actual me ek subsequence de raha hai but hume actual subsequence nhi print krna usame se 1 minus krna hai
        System.out.println(dp[str.length()] - 1);
        solution(str);
        scn.close();     
    }
	
	public static void solution(String str) {
		HashSet<Character> unique = new HashSet<>();
		for(int i = 0; i < str.length(); i++) {
			if(unique.contains(str.charAt(i))) {
				continue;
			}
			unique.add(str.charAt(i));
		}
		System.out.println(unique.size());
	}
	
	
}
