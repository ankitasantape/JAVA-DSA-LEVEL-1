package Recursion_On_The_Way_Up;

import java.util.Scanner;

/*
  1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of printMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right.
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
hhvv
hvhv
hvvh
vhhv
vhvh
vvhh
 */
public class Print_Maze_Path {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
//       row
         int n = sc.nextInt();
//       col
         int m = sc.nextInt();
         printMazePaths(0,0,n-1,m-1,"");
         sc.close();
	}
	
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
//	        Negative base case
	    	if(sr > dr || sc > dc) {
	    		return;
	    	}
//	    	Positive base case
	    	if(sr == dr && sc == dc) {
	    		System.out.println(psf);
	    		return;
	        }
	    	
	    	printMazePaths(sr, sc + 1, dr, dc, psf + "h");
	    	printMazePaths(sr + 1, sc, dr, dc, psf + "v");
	        

	 }

}
