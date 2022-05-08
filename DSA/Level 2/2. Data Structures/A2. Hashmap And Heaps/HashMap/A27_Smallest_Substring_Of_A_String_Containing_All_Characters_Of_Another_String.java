/*
1. You are given two strings s1 and s2 containing lowercase english alphabets.
2. You have to find the smallest substring of s1 that contains all the characters of s2.
3. If no such substring exists, print blank string("").
Input Format
Two strings s1 and s2
Output Format
A string
Constraints
1 <= length of string s1 and s2 <= 10000
Sample Input
timetopractice
toc
Sample Output
toprac

*/
package HashMap;

import java.util.*;

public class A27_Smallest_Substring_Of_A_String_Containing_All_Characters_Of_Another_String {

	public static String solution(String s, String t){
		
        HashMap<Character,Integer>sm = new HashMap<>(); //for current window
        HashMap<Character,Integer>tm = new HashMap<>(); //for 't' string
        
        for(int i=0; i < t.length();i++) {
            char ch = t.charAt(i);
            int nf = tm.getOrDefault(ch,0) + 1;
            tm.put(ch,nf);
        }
        int mtc = 0;
        int as = -1;
        int ae = -1;
        int olen = Integer.MAX_VALUE;
        int i = -1; //aquiring
        int j = -1; //release
        
        while(i < s.length()-1) { // becoz i hamesha j se aage rahega
            //aquire 
            while(i < s.length()-1 && mtc < t.length()) {
                i++;
                
                //aquire ith char 
                char ch = s.charAt(i);
                
                int nf = sm.getOrDefault(ch,0) + 1;
                sm.put(ch,nf);
                
                //impact on mtc
                if(sm.get(ch) <= tm.getOrDefault(ch,0)) {
                    mtc++;
                }
            }
            
            //release
            while(j < i && mtc == t.length()) {
                //ans -> j+1 to i
                
                int len = i-j;
                if(len < olen) {
                    as = j+1;
                    ae = i;
                    olen = len;
                }
                
                j++;
                
                //release jth char
                char ch = s.charAt(j);
                if(sm.get(ch) == 1) {
                    sm.remove(ch);
                }
                else {
                    int nf = sm.get(ch) - 1;
                    sm.put(ch,nf);
                }
                
                //impact on match count
                if(sm.getOrDefault(ch,0) < tm.getOrDefault(ch,0)) {
                    mtc--;
                }
            }
        }
        
        if(as == -1 && ae == -1) {
            return "";
        }
        
        return s.substring(as,ae+1);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
		scn.close();
	}

}
