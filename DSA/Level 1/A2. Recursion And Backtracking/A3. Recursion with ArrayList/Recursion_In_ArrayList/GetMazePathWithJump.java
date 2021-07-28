package Recursion_In_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

/*
 1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. 
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
A number m
Output Format
Contents of the arraylist containing paths as shown in sample output
Sample Input
2
2
Sample Output
[h1v1, v1h1, d1]
 */

public class GetMazePathWithJump {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
//      row
      int n = sc.nextInt();
//      col
      int m = sc.nextInt();
      System.out.println(getMazePaths(0,0,n-1,m-1));
      sc.close();
}

// sr - source row
// sc - source column
// dr - destination row
// dc - destination column
   public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
    // Negative edge case
    if (dr < sr || dc < sc){
        return new ArrayList<String>();
    }
    // Positive edge case
    if (sr == dr && sc == dc){
        ArrayList<String> ans = new ArrayList<String>();
        ans.add("");
        return ans;
    }
    ArrayList<String> ansPaths = new ArrayList<String>();
    
    for(int i = 1; i <= dc-sc; i++){
        ArrayList<String> hpaths = getMazePaths(sr, sc + i, dr, dc);
        for(String hpath : hpaths){
            ansPaths.add("h"+i+hpath);
        }
//        System.out.println(ansPaths);
    }
    
    for(int i = 1; i <= dr-sr; i++){
        ArrayList<String> vpaths = getMazePaths(sr + i, sc, dr, dc);
        for(String vpath : vpaths){
            ansPaths.add("v"+i+vpath);
        }
//        System.out.println(ansPaths);
    }
    
    for(int i = 1; i <= dr-sr && i <= dc-sc; i++){
        ArrayList<String> dpaths = getMazePaths(sr + i, sc + i, dr, dc);
        for(String dpath : dpaths){
            ansPaths.add("d"+i+dpath);
            
        }
//        System.out.println(ansPaths);
    }
    
    return ansPaths;
}

}
