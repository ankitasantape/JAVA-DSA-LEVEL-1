/*
1. You are given n space-separated strings, which represents a dictionary of words.
2. You are given another string that represents a sentence.
3. You have to determine if this sentence can be segmented into a space-separated sequence of one or more dictionary words.
Input Format
A number n 
n strings representing words
A string representing a sentence
Output Format

Constraints
1 <= number of words <= 10
1 <= length of each word <= 15
1 <= length of sentence <= 1000
Sample Input
2
pep coding
pepcoding
Sample Output
true
*/

package Dynamic_Programming;

import java.util.HashSet;
import java.util.Scanner;

public class A42_Word_Break {
   
	public static boolean solution(String sentence, HashSet<String> dictionary) {
		
		int dp[] = new int[sentence.length()];
		
		for(int i = 0; i < dp.length; i++) {
			// i like ka 'i' char compare nhi hoga agar humane j < i hi rakha to isiliye hume j ko i tak lekar jana hi padega means ki j <= i
			// i like ka i = 0 aur humane loop me likha hai j < i to 0 < 0 false aayega aur loop chalega hi nahi
			for(int j = 0; j <= i; j++) {
				// prefix -> from 0 to j-1
				// sufix  -> from j to i
				// check for sufixes -> does sufix exists in the dictionary ?
				String w2check = sentence.substring(j, i + 1);
				if(dictionary.contains(w2check)) {
					if (j > 0) {
						// sufix ke count ko current count me add krenge
						// current word ke count me previous word ke count ko add krenge
						dp[i] += dp[j - 1]; 
					} else {
						dp[i] += 1;
					} 
				}
			}
		}

		return dp[sentence.length()-1] > 0;
	}
	
    public static boolean solution2(String sentence, HashSet<String> dictionary) {
		
		boolean dp[] = new boolean[sentence.length() + 1];
		dp[0] = true;
		for(int i = 1; i < dp.length; i++) {
			for(int j = i-1; j >= 0; j--) {
				String w2check = sentence.substring(j, i);
				if(dp[j] == true && dictionary.contains(w2check) == true) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[dp.length-1];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dictionary = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			dictionary.add(scn.next());
		}
		String sentence = scn.next();
		System.out.println(solution(sentence, dictionary));
		System.out.println(solution2(sentence, dictionary));
		scn.close();
	}
}
