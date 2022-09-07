/*
Link: https://leetcode.com/problems/partition-labels/

You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

Example 1:
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:
Input: s = "eccbbbbdec"
Output: [10]


*/

package Arrays_And_String;

import java.util.*;

public class A10_Partition_Labels {

    public static List<Integer> partitionLabels(String s) {
		
    	HashMap<Character, Integer> map = new HashMap<>();
    	
    	// 1. filling of impact of characters
    	for(int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		// map will store an index of last occurrence/index of that char
    		map.put(ch, i);
    	}
    	
    	// 2. making of result
    	List<Integer> res = new ArrayList<>();
    	int prevIdx = -1;
    	int maxIdx = 0;
    	
    	// We need to traverse again over the string to find the partition
    	for(int i = 0; i < s.length(); i++) {
    		char ch = s.charAt(i);
    		
    		// is char ka maximum impact kaha tak hai
    		maxIdx = Math.max(maxIdx, map.get(ch));
    		
    		// make partition
    		if(maxIdx == i) {
    			res.add(maxIdx - prevIdx);
    			prevIdx = maxIdx;
    		}
    	}
    	
    	return res;
        
    }
	
	public static void main(String[] args) {
		
		String str = "ababcbacadefegdehijhklij";
		System.out.println( partitionLabels(str) );
		
	}

}
