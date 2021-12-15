/*
1. You are given a positive number N.
2. You have to find the minimum number of operations required to convert N into 1.
3. Operations allowed :
     (i)  If n is even, you have to replace n with n/2.
     (ii) If n is odd, you can replace n with either n-1 or n+1.
Input Format
A number N
Output Format
Check the sample ouput and question video.
Constraints
1 <= N <= 2147483647
Sample Input
8
Sample Output
3
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A09_Reduce_N_To_1 {
  
	public static int solution(int n) {
        int count = 0;
        long m = (long)n;
        
        while(m != 1) {
        	if(m % 2 == 0) {
        		m = m >> 1;
        		count++;
        	} else {
        		if(m == 3) {
        			count += 2;
        			m = 1;
        		} else {
        			count++;
        			if((m & 2) == 0) {
        				m -= 1;
        			} else {
        				m += 1;
        			}
        		}
        	}
        }
        
        return count;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
        scn.close();
    }
}
