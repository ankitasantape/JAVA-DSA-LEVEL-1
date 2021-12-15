/*
1. You are given a string and a pattern. 
2. You've to check if the string is of the same structure as pattern without using any regular 
     expressions.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A String str
A pattern ptr
Output Format

Constraints
1 <= length of str,ptr <= 20
Sample Input
graphtreesgraph
pep
Sample Output
p -> graph, e -> trees, . 

*/

package Recursion_Backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class A38_Pattern_Matching {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		if (pattern.length() == 0) {
			if (str.length() == 0) {
				HashSet<Character> alreadyPrinted = new HashSet<>();
				
				for(int i = 0; i < op.length(); i++) {
					char ch = op.charAt(i);
					if(alreadyPrinted.contains(ch) == false) {
						System.out.print(ch + " -> " + map.get(ch) + ", ");
						alreadyPrinted.add(ch);
					}
				}
				System.out.println(".");
			}
			return;
		}
		char ch = pattern.charAt(0);
		String rop = pattern.substring(1); // rest of the pattern
		
		if( map.containsKey(ch) ) {			
			String previousMapping = map.get(ch); // get the already mapped string for that char
			
			// check some chars from the string whether it is matching with previous mapping or not
			// if next some chars are matching with already mapped string then cut/skip that part and another call will be applied on next chars   
			
			if(str.length() >= previousMapping.length()) {
				String prefix = str.substring(0, previousMapping.length());
				String ros = str.substring(previousMapping.length());
				if(previousMapping.equals(prefix)) {
					solution( ros, rop, map, op);
				}
			}	
		} else {
			for (int i = 0; i < str.length(); i++) {
				String prefix = str.substring(0, i + 1);
				String ros = str.substring(i + 1); // rest of the string

				map.put(ch, prefix);
				solution(ros, rop, map, op);
				map.remove(ch);

			}
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
		scn.close();
	}
	
}
