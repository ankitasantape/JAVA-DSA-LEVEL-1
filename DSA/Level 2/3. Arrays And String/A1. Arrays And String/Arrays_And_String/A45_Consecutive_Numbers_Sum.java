/*
Leetcode 829 - https://leetcode.com/problems/consecutive-numbers-sum/

Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.

 

Example 1:

Input: n = 5
Output: 2
Explanation: 5 = 2 + 3
Example 2:

Input: n = 9
Output: 3
Explanation: 9 = 4 + 5 = 2 + 3 + 4
Example 3:

Input: n = 15
Output: 4
Explanation: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 

Constraints:

1 <= n <= 109


*/


package Arrays_And_String;

public class A45_Consecutive_Numbers_Sum {

    public static int consecutiveNumbersSum(int n) {
        int count = 0 ;
        for(int k = 1; 2 * n > k * (k - 1); k++) {
        	int numerator = n - (k * (k - 1) / 2);
        	
        	if(numerator % k == 0) {
        		count++;
        	}
        }
        
        return count;
    }
	
	public static void main(String[] args) {
		int num = 15;
		int res = consecutiveNumbersSum(num);
		System.out.println(res);
	}

}
