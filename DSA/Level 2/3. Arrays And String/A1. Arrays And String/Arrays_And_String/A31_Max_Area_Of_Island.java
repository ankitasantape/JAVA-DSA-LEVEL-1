/*

Leetcode 695: https://leetcode.com/problems/max-area-of-island/

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:
Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

*/


package Arrays_And_String;

public class A31_Max_Area_Of_Island {

	//i me up jayenge to -1 ka change hoga
	//i me left jayenge to 0 ka change hoga
	//i me down jayenge to 1 ka change hoga
	//i me right jayenge to 0 ka change hoga
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,-1,0,1};
	
   private static int findAreaOfIsland(int[][] grid, boolean[][] vis, int i, int j) {
	   
	   int n = grid.length;
   	   int m = grid[0].length;
		
   	   if(i >= n|| j >= m || i < 0 || j < 0) {
   		   return 0;
   	   }
   	   
   	   if(grid[i][j] == 0 || vis[i][j]) {
   		   return 0;
   	   }
   	   
   	   int nextAns = 0;
   	   vis[i][j] = true;
   	   
   	   for(int d = 0; d < 4; d++) {
   		   nextAns += findAreaOfIsland(grid, vis, i + di[d], j + dj[d]); 
   	   }
   	   return nextAns + 1;
   	   
	}
	
	// Backtracking Approach
    public static int maxAreaOfIsland(int[][] grid) {
        
    	int n = grid.length;
    	int m = grid[0].length;
    	
    	boolean[][] vis = new boolean[n][m];
    	int ans = 0;
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < m; j++) {
    			if( grid[i][j] == 1 && vis[i][j] == false ) {
    				ans = Math.max(ans, findAreaOfIsland(grid, vis, i, j));
    			}
    		}
    	}
    	
    	return ans;
    }

	public static void main(String[] args) {
		
//		int[][] grid = { 
//				{0,0,1,0,0,0,0,1,0,0,0,0,0},
//				{0,0,0,0,0,0,0,1,1,1,0,0,0},
//				{0,1,1,0,1,0,0,0,0,0,0,0,0},
//				{0,1,0,0,1,1,0,0,1,0,1,0,0},
//				{0,1,0,0,1,1,0,0,1,1,1,0,0},
//				{0,0,0,0,0,0,0,0,0,0,1,0,0},
//				{0,0,0,0,0,0,0,1,1,1,0,0,0},
//				{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		
		int[][] grid = {{1,1}}; // Ans: 2
		
		System.out.println( maxAreaOfIsland(grid) );
		
	}

}
