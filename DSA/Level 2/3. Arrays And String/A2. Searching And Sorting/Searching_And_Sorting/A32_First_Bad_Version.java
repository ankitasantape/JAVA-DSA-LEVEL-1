/*

Link: https://leetcode.com/problems/first-bad-version/

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.


Example 2:

Input: n = 1, bad = 1
Output: 1

*/

package Searching_And_Sorting;

public class A32_First_Bad_Version {

	
    public static int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        // fbv - first bad version
        int fbv = -1;
        
        while(lo <= hi) {
        	int mid = lo + (hi-lo)/2;
        	
        	if( isBadVersion(mid) == true ) {
        		fbv = mid;
        		// after getting first potential bad version
        		// then we will go left to find exact first bad version
        		hi = mid - 1;
        	
        	}
        	else {
        		lo = mid + 1;
        		
        	}
        }
    	
        return fbv;
    }
    
    static int bad = 0;
    public static boolean isBadVersion(int val) {
    	
    	if( val >= bad ) {
    		return true;
    	
    	} else {
    		return false;
    	}
    		
    }

	public static void main(String[] args) {
		 int n = 5;
		 // first bad version
		 bad = 4;
		 
		 System.out.println( firstBadVersion(n)  );
		
	}

}
