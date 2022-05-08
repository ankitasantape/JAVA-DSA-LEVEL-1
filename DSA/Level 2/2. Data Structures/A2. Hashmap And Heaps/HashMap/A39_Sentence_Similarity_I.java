/*
Description
Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.

For example, words1 = great acting skills and words2 = fine drama talent are similar, if the similar word pairs are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].

Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and "fine" and "good" are similar, "great" and "good" are not necessarily similar.

However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.

Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

1.The length of words1 and words2 will not exceed 1000.
2.The length of pairs will not exceed 2000.
3.The length of each pairs[i] will be 2.
4.The length of each words[i] and pairs[i][j] will be in the range [1, 20].

Example
Example1

Input: words1 = ["great","acting","skills"], words2 = ["fine","drama","talent"] and pairs = [["great","fine"],["drama","acting"],["skills","talent"]]
Output: true
Explanation:
"great" is similar with "fine"
"acting" is similar with "drama"
"skills" is similar with "talent"
Example2

Input: words1 = ["fine","skills","acting"], words2 = ["fine","drama","talent"] and pairs = [["great","fine"],["drama","acting"],["skills","talent"]]
Output: false
Explanation:
"fine" is the same as "fine"
"skills" is not similar with "drama"
"acting" is not similar with "talent"

*/

package HashMap;

import java.util.*;

public class A39_Sentence_Similarity_I {

	 public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
	     HashMap<String, HashSet<String>> map = new HashMap<>();   
		 
	     for(int i=0; i < pairs.size(); i++) {
	    	 String word1 = pairs.get(i).get(0);
	    	 String word2 = pairs.get(i).get(1);
	    	 
	    	 //word1 as key
	    	 HashSet<String> hset1 = map.getOrDefault(word1, new HashSet<>());
	    	 hset1.add(word2);
	    	 map.put(word1, hset1);
	    	 
	    	//word2 as key
	    	 HashSet<String> hset2 = map.getOrDefault(word2, new HashSet<>());
	    	 hset2.add(word1);
	    	 map.put(word2, hset2);	 
	    	 
	     }
		 
		 //verification
	     if(words1.length != words2.length) {
	    	 return false;
	     }
		 
	     for(int i=0; i < words1.length; i++) {
	    	 String word1 = words1[i];
	    	 String word2 = words2[i];
	    	 
	    	 if(word1.equals(word2) == true) {
	    		 continue;
	    	 }
	    	 else if(map.containsKey(word1) == false || map.containsKey(word2) == false){
	    		 return false;
	    	 }
	    	 else {
	    		 if(map.get(word1).contains(word2) == false) {
	    			 return false;
	    		 }
	    	 }
	     }
		 return true;
	 }
}
