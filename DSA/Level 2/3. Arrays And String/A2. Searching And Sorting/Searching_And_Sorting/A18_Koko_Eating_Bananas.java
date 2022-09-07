/*
Link: https://leetcode.com/problems/koko-eating-bananas/

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23





*/



package Searching_And_Sorting;

public class A18_Koko_Eating_Bananas {

    public static int minEatingSpeed(int[] piles, int h) {
        
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < piles.length; i++) {
    		max = Math.max(max, piles[i]);
    	}
    	
    	if ( h == piles.length ) {
    		return max;
    	}
    	
    	int lo = 0;
    	int hi = max;
    	int speed = Integer.MAX_VALUE;
    	
    	while( lo <= hi ) {
    		int sp = lo + ( hi - lo )/2; // to avoid overflow & here we are working on values also not on indexes
    		
    		// hum ye speed rakhkar hum sari piles ki sare bananas ko h hrs me eat kr payenge ya nhi
    		if( isPossible(piles, sp, h) == true ) {
    			// these lines are kind of similar to FindFirst And FindLast Index Problem
    			// Lalach ki wajah thoda aur min speed find krne ki koshish krenge
    			
    			speed = sp;
    			hi = sp - 1;
    		}
    		else {
    			lo = sp + 1;
    		}
    	}
    	
    	return speed;
    }
    
	// calculate the count of possible hours 
	private static boolean isPossible(int[] piles, int sp, int h) {
		// hume kitna time lagega ki sp speed rkhkar sare bananas ko eat kr skte ya nhi
		
		int time = 0;
		
		for(int i = 0; i < piles.length; i++) {
			// 2.3  or 2.something aa rha ho tabhi 2 milega humako to hum int ko double me convert krenge becoz hume 2 ka decimal chahiye 2.something otherwise typecasting ka issue dega
			time += (int)Math.ceil(piles[i]*1.0/sp); // 7/3 = 2.333 -> take a ceil of 2.333 -> becoz 1 banana bhi bacha na to hume 1 hr spend krna padega 1 banana khane ko
			
		}
		// if time == h is true that means hum h hours ke under sare bananas kha paye
		return time <= h;
	}

	public static void main(String[] args) {
		int[] piles = {30,11,23,4,20}; // ans: 23
		int hours = 6; 
		
		System.out.println( minEatingSpeed(piles, hours) );
		
	}

}
