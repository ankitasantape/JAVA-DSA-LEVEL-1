/*
 
1. You are given a number n, representing the number of bridges on a river.
2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
3. You are required to print the count of maximum number of non-overlapping bridges.
Input Format
A number n
.. n pair of number each on a separate line (and pair separated by space)
Output Format
A number representing the count of maximum number of non-overlapping bridges.

Constraints
0 <= n <= 20
0 <= n1n, n1s, n2n, n2s, .. <= 100
Sample Input
10
10 20
2 7
8 15
17 3
21 40
50 4
41 57
60 80
80 90
1 30
Sample Output
7

*/

package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class A12_Maximum_Non_Overlapping_Bridges {
	
	public static class Bridge implements Comparable<Bridge>{
		int n;
		int s;
		
		Bridge(int n, int s){
			this.n = n;
			this.s = s;
		}
		
		public int compareTo(Bridge o) {
			if(this.n != o.n) {
				return this.n - o.n;
			} else {
				return this.s - o.s;	
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
	       Scanner sc = new Scanner(System.in);
	       int input = Integer.parseInt(sc.nextLine());
	       
	       Bridge[] bdgs = new Bridge[input];
	       for(int i = 0; i < input; i++) {
	    	   String line = sc.nextLine();
	    	   String[] parts = line.split(" ");
	    	   int n = Integer.parseInt(parts[0]);
	    	   int s = Integer.parseInt(parts[1]);
	    	   bdgs[i] = new Bridge(n, s);
	       }
	       Arrays.sort(bdgs);
	       
	       int[] dp = new int[input];
	       int omax = 0;
	       for (int i = 0; i < dp.length; i++) {
	    	   int max = 0;
	    	   
	    	   for(int j = 0; j < i; j++) {
	    		   if(bdgs[j].s <= bdgs[i].s) {
	    			   if(dp[j] > max) {
	    			      max = dp[j];
	    			   }
	    		   }
	    	   }
	    	   
	    	   dp[i] = max + 1;
	    	   if(dp[i] > omax) {
	    		   omax = dp[i];
	    	   }
	       }
	       System.out.println(omax);
	       
	       sc.close();
	 }
}
