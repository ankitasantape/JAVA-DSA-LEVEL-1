package Recursion_In_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

/*
1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.
Sample Input
3
Sample Output
[111, 12, 21, 3]
*/
public class GetStairPaths {
	 public static void main(String[] args) throws Exception {
           Scanner sc = new Scanner(System.in);
           int n = sc.nextInt();
           System.out.println(getStairPaths(n));
           sc.close();
	 }

	 public static ArrayList<String> getStairPaths(int n) {
		     if(n == 0) {
		    	ArrayList<String> ans = new ArrayList<String>();
		    	ans.add("");
		    	return ans;
		     } else if (n < 0){
		    	 ArrayList<String> ans = new ArrayList<String>();
			     return ans;
		     }
		     
		     ArrayList<String> rr1 = getStairPaths(n-1);
		     ArrayList<String> rr2 = getStairPaths(n-2);
		     ArrayList<String> rr3 = getStairPaths(n-3);
		     ArrayList<String> rr = new ArrayList<String>();
		     for(String str : rr1) {
		    	 rr.add("1" + str);
		     }
		     for(String str : rr2) {
		    	 rr.add("2" + str);
		     }
		     for(String str : rr3) {
		    	 rr.add("3" + str);
		     }
		    
	        return rr;
	 }
}
