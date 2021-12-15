/*
1. Pepcoder is feeling confident after solving many problems on Bit Manipulation.
2. So, his teacher ask him to find out the count of positive integers strictly less than N, having same 
     number of set bits as that of N.
3. Let us see that if pepcoder can solve it or not.
Input Format
A number N
Output Format
Check the sample ouput and question video.
Constraints
1 <= N <= 10^12
Sample Input
1024
Sample Output
10 
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A10_Pepcoder_And_Bits {
    
	public static long ncr(long n, long r) {
		if (n < r) {
			return 0L;
		}

		long res = 1L;

		for (long i = 0L; i < r; i++) {
			res = res * (n - i);
			res = res / (i + 1);
		}

		return res;
	}

	public static long solution(long n, int k, int i) {
//		Code - 1 Recursive Approach
//		if(i == 0) {
//			return 0;
//		}
//		long mask = 1L << i;
//		long res = 0;
//		if((n & mask) == 0) {
//			res = solution(n, k, i - 1);
//		} else {
//			long res1 = solution(n, k - 1, i - 1);
//			long res0 = ncr(i, k);
//			res = res1 + res0;
//		}
//		return res;
		
		
//		Code - 2 Iterative Approach
        long ans = 0;
        
//        Why 62? and Why not 63? 2 ki pow 63 out of range hai. so we need to do 2 ki pow 63 minus 1 ( 2 ^ 63 - 1 )
//        we can run this loop from 40 also as given in the constrains 
        for( i = 40; i >= 0; i-- ) {
//        	check if the ith bit is on 
//        	agar 1 goes to goes to i( 1 << i) krenge to int value milegi but hume chahiye long
//        	1 goes to goes to i se milata hai 2 ki pow i to hum 2 raise to pow i se hi nikalenge aur usko long me convert kr denge
        	long mask = (long) Math.pow(2, i);
        	if((mask & n) != 0 && k > 0) {
        		ans += ncr(i, k);
        		k--;
        	}
        }
		return ans;
	}
//   Kernighans algorithm
	public static int csb(long n) {
		int res = 0;

		while (n > 0) {
			long rsb = n & -n;
			n -= rsb;
			res++;
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		int k = csb(n);
		System.out.println(solution(n, k, 63));
		scn.close();
	}
}
