/*
Given two sentences sentence1 and sentence2 each represented as a string array and given a 2d array of string pairs where each row contains two words {x,y} indicating that the word x and y are similar.
Return true if sentence1 and sentence2 are similar, or false if they are not similar. Two sentences are similar if they have the same length and sentence1[i] and sentences2[i] are similar.

Note: Similarity relation is transitive.
Input Format
First line contains an integer denoting the sentence length.
Second line contaions the words of sentence1 separated by space.
Third line contains the words of sentence2 separated by space.
Fourth line contains an integer m denoting number of pairs.
Each of next m lines contains 2 words separated by space which are similar.
Output Format
Print true if Sentence1 and Sentence2 are similar else print false.
Constraints
1 <= sentence1.length, Sentence2.length <= 100000
1 <= sentence1[i].length, sentence2[i].length <= 20
sentence1[i] and sentence2[i] consist of lower-case and upper-case English letters.
Sample Input
3
treat fight miss
like train lost
4
treat catch
train fight
like catch
miss lost
Sample Output
true

*/

package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class A16_Sentence_Similarity_II {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] sentence1 = br.readLine().split(" ");
		String[] sentence2 = br.readLine().split(" ");

		int m = Integer.parseInt(br.readLine());

		String[][] pairs = new String[m][2];
		for (int i = 0; i < m; i++) {
			pairs[i] = br.readLine().split(" ");
		}

		System.out.println(areSentencesSimilarTwo(sentence1, sentence2, pairs));

	}

	static HashMap<String, String> parent;
	static HashMap<String, Integer> rank;
	public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {
          parent = new HashMap<>();
          rank = new HashMap<>();
          
          // initialise parent and rank maps
          for(int i=0; i < pairs.length; i++) {
        	  String word1 = pairs[i][0];
        	  String word2 = pairs[i][1];
        	  
        	  //work on word1
        	  parent.put(word1, word1);
        	  rank.put(word1, 0);
        	  
        	  //work on word2
        	  parent.put(word2, word2);
        	  rank.put(word2, 0);
          }
          
          //apply DSU
          for(int i=0; i<pairs.length; i++) {
        	  String word1 = pairs[i][0];
        	  String word2 = pairs[i][1];
        	  
        	  union(word1, word2);
          }
          
          //verification
          if(Sentence1.length != Sentence2.length) {
        	  return false;
          }
          
          for(int i=0; i<Sentence1.length; i++) {
        	  String word1 = Sentence1[i];
        	  String word2 = Sentence2[i];
        	  
        	  if(Sentence1.equals(Sentence2) == true) {
        		  continue;
        	  }
        	  else if(parent.containsKey(word1) == false || parent.containsKey(word2) == false) {
        		  return false;
        	  }
        	  else {
        		  String sl1 = find(word1);
        		  String sl2 = find(word2);
        		  
        		  if(sl1.equals(sl2) != true) {
        			  return false;
        		  }
        	  }
          }
          return true;
	}
	private static String find(String word) {
		if(parent.get(word).equals(word)) {
			return word;
		}
		String sl = find(parent.get(word));
		parent.put(word, sl);
		return sl;
		
	}
	private static void union(String word1, String word2) {
		String sl1 = find(word1);
		String sl2 = find(word2);
		
		if(sl1.equals(sl2) == false) {
			// merging 
			if(rank.get(sl1) < rank.get(sl2)) {
				parent.put(sl1, sl2);
			}
			else if(rank.get(sl2) < rank.get(sl1)) {
				parent.put(sl2, sl1);
			}
			else {
				parent.put(sl1, sl2);
				rank.put(sl2, rank.get(sl2) + 1);
			}
		}
		
	}
}
