package Goldman_Sachs_Coderpad_Round_Interview_Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A02_Return_Largest_String_By_Removing_Some_Characters {

	public static void main(String[] args) {
		
		List<String> dict =new ArrayList<String>();
		dict.add("ale");
		dict.add("apple");
		dict.add("monkey");
		dict.add("plea");
		String pattern = "abpcplea";
		
		System.out.println( longestWord(dict, pattern));
	}

	private static String res = "";
	private static String longestWord(List<String> dict, String pattern) {
		
		Collections.sort(dict);
		for(String word: dict) {
			checkSequence(word, pattern);
		}
		
		return res;
	}

	private static void checkSequence(String word, String pattern) {
		int i = 0;
		int j = 0;
		while( i < word.length() && j < pattern.length()) {
			
			if( word.charAt(i) == pattern.charAt(j) ) {
				i++;
				j++;
			}
			else {
				j++;
			}
		}
		if( i == word.length() && res.length() < word.length() ) {
			res = word;
		}
	}

}
