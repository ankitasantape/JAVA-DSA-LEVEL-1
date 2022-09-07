/*

1. Given an array of size 'N' and an element K.
2. Task is to find all elements that appears more than N/K times in array.
3. Return these elements in an ArrayList in sorted order.
Input Format
N = 8
arr[] = [3, 1, 2, 2, 1, 2, 3, 3]
k = 4
Note : Input is managed for you.
Output Format
[2, 3]
Note : Output is managed for you.


*/

package Arrays_And_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class A07_Majority_Element_General {

	public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        
		HashMap<Integer, Integer> map = new HashMap<>();
		int n = arr.length;
		
		// 1. fill frequency map
		for(int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		ArrayList<Integer> res = new ArrayList<>();
		// 2. travel in hashmap and fill res
		for(int key : map.keySet()) {
			if( map.get(key) > n/k ) {
				res.add(key);
			}
		}
		
		// 3. sort the result
		Collections.sort(res);
		return res;
		
    }
	
	public static void main(String[] args) {
		
		int[] arr = {3, 1, 2, 2, 1, 2, 3, 3};
		int k = 4;
        ArrayList<Integer> res = majorityElement(arr, k);
        System.out.println(res);
		
	}

}
