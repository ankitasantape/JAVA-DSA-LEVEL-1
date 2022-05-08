/*
1. You are given an array of strings.
2. You have to group anagrams together.

Note -> Every string consists of lower-case English letters only.
Input Format
A number N
str1
str2.. N space-separated strings
Output Format
Every line of output contains space-separated strings which represents a group of anagrams.
Constraints
1 <= N <= 10^4
1 <= length of a string <= 100
Sample Input
5
pepcoding codingpep pepper rapper repepp
Sample Output
codingpep pepcoding 
pepper repepp 
rapper 

*/

package HashMap;

import java.util.*;

public class A24_Group_Anagrams {
   
	// Optimized Approach
	public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
       HashMap<String, ArrayList<String>> map = new HashMap<>();
       
       for(int i=0; i<strs.length; i++) {
    	   String str = strs[i];
    	   String key = getKey(str);
    	   
    	   ArrayList<String> list = map.getOrDefault(key, new ArrayList<>());
    	   list.add(str);
    	   map.put(key, list);
       }
       ArrayList<ArrayList<String>> ans = new ArrayList<>();
       for(String key : map.keySet()) {
    	   ans.add(map.get(key));
       }
		return ans;
	}
	
	public static String getKey(String str) {
		int[] freq = new int[26];
		StringBuilder ans = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			
			for(int j=0; j<str.length(); j++) {
			   char ch = str.charAt(j);
			   freq[ch - 'a']++;
			}	
		}
		for(int k=0;k<26;k++) {
			if(freq[k] != 0) {
				ans.append((char)(k + 'a')+""+freq[k]);
			}
		}
		
		return ans.toString();
	}

	// Long Time Taking Approach
	public static ArrayList<ArrayList<String>> groupAnagrams2(String[] strs) {
	       HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
	       
	       for(int i=0; i<strs.length; i++) {
	    	   String str = strs[i];
	    	   HashMap<Character, Integer> fmap = new HashMap<>();
	    	   
	    	   // create fmap
	    	   for(int j=0; j <str.length(); j++) {
	    		   char ch = str.charAt(j);
	    		   
	    		   fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
	    	   }
	    	   
	    	   if(map.containsKey(fmap) == false) {
	    		   ArrayList<String> list = new ArrayList<>();
	    		   list.add(str);
	    		   map.put(fmap, list);
	    	   } else {
	    		   ArrayList<String> list = map.get(fmap);
	    		   list.add(str);
	    	   }
	       }  
	       ArrayList<ArrayList<String>> ans = new ArrayList<>();
	       for(HashMap<Character, Integer> key: map.keySet()) {
	    	   ans.add(map.get(key));
	       }
		   return ans;
		}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		
		ArrayList<ArrayList<String>> anagramsGrouped = groupAnagrams(arr);
		for (ArrayList<String> lst : anagramsGrouped) {
			Collections.sort(lst);
		}
		anagramsGrouped.sort(new ListComparator());
		display(anagramsGrouped);
		sc.close();
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}
}
