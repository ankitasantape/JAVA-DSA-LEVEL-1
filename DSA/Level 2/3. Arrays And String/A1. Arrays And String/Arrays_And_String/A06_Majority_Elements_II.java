/*

Link: https://leetcode.com/problems/majority-element-ii/
Given an integer array of size n, find all elements that appear more than [ n/3 ] times.

Example 1:
Input: nums = [3,2,3]
Output: [3]


Example 2:
Input: nums = [1]
Output: [1]


Example 3:
Input: nums = [1,2]
Output: [1,2]

Hidden Test Case
Example 4:
Input: nums = [1,1,1,1]
Output: [1]


*/

package Arrays_And_String;

import java.util.ArrayList;

public class A06_Majority_Elements_II {

	// We need to do mapping of more than n/3 elements
    // two distinct value ko third distinct value ke sath pair up krke mapping krna hai means hume triplet mil jayega
	public static ArrayList<Integer> printMajorityElement2(int[] arr) {
		int val1 = arr[0];
		int count1 = 1;
		
		int val2 = arr[0];
		int count2 = 0;
		
	    for(int i = 1; i < arr.length; i++) {
	    	
	    	if( arr[i] == val1 ) {
	    		count1++;
	    	}
	    	else if( arr[i] == val2 ) {
	    		count2++;
	    	}
	    	else {
	    	    if( count1 == 0 ) {
	    	    	val1 = arr[i];
	    	    	count1 = 1;
	    	    }
	    	    else if( count2 == 0 ) {
	    	    	val2 = arr[i];
	    	    	count2 = 1;
	    	    
	    	    } else {
	    	    	// we got a triplets
	    	        count1--;
	    	        count2--;
	    	    }
	    	    
	    	}
	    }
	    
	    // val1 and val2 -> potential candidate
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    if( isGreaterThanNb3(arr, val1) == true ) {
	    	res.add(val1);
	    }
	    
	    if( val1 != val2 && isGreaterThanNb3(arr, val2) == true ) {
	    	res.add(val2);
	    }
		
		return res;
	
	}
	
	private static boolean isGreaterThanNb3(int[] arr, int val) {
		int count = 0;
		
		for(int ele : arr) {
			if(ele == val) {
				count++;
			}
		}
		
		return count > arr.length/3;
	}

	public static void main(String[] args) {
		int[] arr = {3,2,3};
		System.out.println( printMajorityElement2(arr) );
	}

}
