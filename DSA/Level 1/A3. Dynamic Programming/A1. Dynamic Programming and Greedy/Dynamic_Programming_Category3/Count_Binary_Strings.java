package Dynamic_Programming_Category3;

import java.util.Scanner;
/*
1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
Input Format
A number n
Output Format
A number representing the number of binary strings of length n with no consecutive 0's.
Sample Input
6
Sample Output
21
 */
public class Count_Binary_Strings {
    
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    count_binary_string1(n);
	    count_binary_string2(n);
	    sc.close();
	}
	
	public static void count_binary_string1(int n) {
		 int []dp0 = new int[n+1]; // endings at 0
		    int []dp1 = new int[n+1]; // endings at 1
		    
		    dp0[1] = 1;
		    dp1[1] = 1;
		    for(int i = 2; i <= n; i++) {
		    	dp0[i] = dp1[i-1] ;
//		    	System.out.print(dp0[i] +" ");
		    	dp1[i] = dp0[i-1] + dp1[i-1];
//		    	System.out.println(dp1[i] + " ");
		    }
		    System.out.println(dp0[n] + dp1[n]);
	}
	public static void count_binary_string2(int n) {
		int old_count_0s = 1;
		int old_count_1s = 1;
		for(int i = 2; i <= n; i++) {
			int new_count_0s = old_count_1s;
			int new_count_1s = old_count_0s + old_count_1s;
			
			old_count_0s = new_count_0s;
			old_count_1s = new_count_1s; 
		}
		System.out.println(old_count_0s + old_count_1s);
	}
}
