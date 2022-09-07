/*

Link: https://leetcode.com/problems/guess-number-higher-or-lower/

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
 1: Your guess is lower than the number I picked (i.e. num < pick).
 0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

Example 1:
Input: n = 10, pick = 6
Output: 6

Example 2:
Input: n = 1, pick = 1
Output: 1

Example 3:
Input: n = 2, pick = 1
Output: 1

*/


package Searching_And_Sorting;

public class A33_Guess_Number_Higher_Or_Lower {

	public static int guessNumber(int n) {
	    int lo = 1;
	    int hi = n;
	    
	    while(lo <= hi) {
	    	int mid = lo + (hi - lo)/2;
	    	
	    	if( guess(mid) == 0 ) {
	    		// mid == pick
	    		return mid;
	    	}
	    	else if( guess(mid) == -1 ) {
	    		// pick < mid 
	    		// Your guess is higher than the number I picked -> then you should go left
	    		hi = mid - 1;
	    	}
	    	else if( guess(mid) == 1 ){
	    		// pick > mid
	    		lo = mid + 1;
	    	}
	    }
	    return -1;
	}
	
	static int pn = 0; // picked number
	public static int guess(int val) {
		if( val == pn ) {
			return 0;
		}
		else if(val < pn) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public static void main(String[] args) {
		int n = 10;
		pn = 6;
		
		System.out.println( guessNumber(n) );
	}

}
