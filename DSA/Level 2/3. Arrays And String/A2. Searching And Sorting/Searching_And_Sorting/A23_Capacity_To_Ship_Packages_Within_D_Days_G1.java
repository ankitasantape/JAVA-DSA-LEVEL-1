/*

Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/ 
 
Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4

Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1

 
*/

package Searching_And_Sorting;

public class A23_Capacity_To_Ship_Packages_Within_D_Days_G1 {

    public static int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        
        for(int val : weights) {
        	sum += val;
        	max = Math.max(max, val);
        }
        
        if( weights.length == days ) {
        	return max;
        }
        
        int lo = max;
        int hi = sum;
        int ans = Integer.MIN_VALUE;
        
        while(lo <= hi) {
        	int mid = lo + (hi - lo)/2;
        	
        	if( isPossible(weights, mid, days) == true ){
        		ans = mid;
        		hi = mid-1;
        	
        	} else {
        		lo = mid+1;
        	}
        }
        return ans;
    }
	
	private static boolean isPossible(int[] weights, int mid, int days) {
		int d = 1;
		int sum = 0;
		
		for(int wt : weights) {
			sum += wt;
			
			if(sum > mid) {
				d++;
				sum = wt;
			}
		}
		return d <= days;
	}

	public static void main(String[] args) {
		
		int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int days = 5; // Ans: 15
		System.out.println( shipWithinDays(weights, days)  );
	}

}
