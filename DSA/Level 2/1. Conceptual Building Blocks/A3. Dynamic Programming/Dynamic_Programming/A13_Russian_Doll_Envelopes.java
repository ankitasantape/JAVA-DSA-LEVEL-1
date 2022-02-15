/*
1. You are given a number n, representing the number of envelopes.
2. You are given n pair of numbers, representing the width and height of each envelope.
3. You are required to print the count of maximum number of envelopes that can be nested inside each other.
Note -> Rotation is not allowed.
Input Format
A number n
.. n pair of number each on a separate line (and pair separated by space)
Output Format
A number representing the count of maximum number of envelopes that can be nested inside each other.

Constraints
0 <= n <= 20
0 <= n1w, n1h, n2w, n2h, .. <= 100
Sample Input
11
17 5
26 18
25 34
48 84
63 72
42 86
9 55
4 70
21 45
68 76
58 51
Sample Output
5

*/

package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;


public class A13_Russian_Doll_Envelopes {
    
	public static class Envelope implements Comparable<Envelope>{
		int w;
		int h;
		
		Envelope(int w, int h){
			this.w = w;
			this.h = h;
		}
		
		public int compareTo(Envelope o) {
			return this.w - o.w;
		}
	}
	
	 public static void main(String[] args) throws Exception {
		   Scanner sc = new Scanner(System.in);
	       int input = Integer.parseInt(sc.nextLine());
	       
	       Envelope[] envelope = new Envelope[input];
	       for (int i = 0; i < input; i++) {
	    	   String line = sc.nextLine();
	    	   String[] parts = line.split(" ");
	    	   int w = Integer.parseInt(parts[0]);
	    	   int h = Integer.parseInt(parts[1]);
	    	   envelope[i] = new Envelope(w, h);
	       }
	       Arrays.sort(envelope);
	       
	       int n = envelope.length;
	       int[] dp = new int[n];
	       int omax = 0;
	       for (int i = 0; i < n; i++) {
	    	   int max = 0;
	    	   
	    	   for (int j = 0; j < i; j++) {
	    		   if( envelope[j].h < envelope[i].h && envelope[j].w < envelope[i].w ) {
	    			   if (dp[j] > max) {
	    				   max = dp[j];
	    			   }
	    		   }
	    	   }
	    	   dp[i] = max + 1;
	    	   if (dp[i] > omax) {
	    		   omax = dp[i];
	    	   }
	       }
	       System.out.println(omax);
	       sc.close();
	 }

}
