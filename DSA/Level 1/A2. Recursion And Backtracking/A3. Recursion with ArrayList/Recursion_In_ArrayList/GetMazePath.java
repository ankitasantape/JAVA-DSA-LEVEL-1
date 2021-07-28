package Recursion_In_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
/*
 1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.
Input Format
A number n
A number m
Output Format
Contents of the arraylist containing paths as shown in sample output

Sample Input
3
3
Sample Output
[hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]
 */
public class GetMazePath {

	public static void main(String[] args) throws Exception {
          Scanner sc = new Scanner(System.in);
//          row
          int n = sc.nextInt();
//          col
          int m = sc.nextInt();
          System.out.println(getMazePaths3(0,0,n-1,m-1));
          sc.close();
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths3(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc) {
        	ArrayList<String> ans = new ArrayList<>();
        	ans.add("");
        	return ans;
        }
    	ArrayList<String> vpaths = new ArrayList<>();
    	ArrayList<String> hpaths = new ArrayList<>();
    	ArrayList<String> paths = new ArrayList<>();
    	if(sc < dc ) {
    	   
    		hpaths = getMazePaths3(sr,sc + 1,dr,dc);
    	}
    	
    	if (sr < dr ) {
    		vpaths = getMazePaths3(sr + 1,sc,dr,dc);
    	}
    	
    	for(String str : hpaths) {
    		paths.add("h"+str);
    	}
        for(String str : vpaths) {
        	paths.add("v"+str);
    	}
        
        return paths;
    }

    public static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc) {
//      Negative base case
    	if(sr > dr || sc > dc) {
    		ArrayList<String> bans = new ArrayList<>();
        	return bans;
    	}
//    	Positive base case
    	if(sr == dr && sc == dc) {
        	ArrayList<String> bans = new ArrayList<>();
        	bans.add("");
        	return bans;
        }
    	ArrayList<String> vpaths = getMazePath(sr + 1,sc,dr,dc);
    	ArrayList<String> hpaths = getMazePath(sr,sc + 1,dr,dc);
    	ArrayList<String> paths = new ArrayList<>();
    	
    	for(int i = 0; i < hpaths.size(); i++) {
    		paths.add("h"+hpaths.get(i));
    	}
    	for(int i = 0; i < vpaths.size(); i++) {
    		paths.add("v"+vpaths.get(i));
    	}
        
        return paths;
    }
}
