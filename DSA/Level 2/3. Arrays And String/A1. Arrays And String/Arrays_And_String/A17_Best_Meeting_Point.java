/*

1. A group of two or more people wants to meet and minimize the total travel distance.
2. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. 
3. Return min distance where distance is calculated using 'Manhattan Distance', where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
Input Format
[
    [1,0,0,0,1],
    [0,0,0,0,0],
    [0,0,1,0,0]
]
Output Format
6

Explanation:
The point (0,2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6 is minimal. So return 6.


Approach - 1:
1. Get all x-coordinate
2. Get all y-coordinate
3. Sort both array
4. Select mid point at median
 
                              mid         
x -> (0, 0, 2) -> (0, 0, 2) -> 0

y -  (0, 4, 2) -> (0, 2, 4) -> 2

Best meeting point -> (0, 2)



*/


package Arrays_And_String;

import java.util.ArrayList;

public class A17_Best_Meeting_Point {

	public static int minTotalDistance(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		
	    // 1. Get x-coordinate -> row wise
		ArrayList<Integer> xcord = new ArrayList<>();  
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if( grid[i][j] == 1 ) {
					xcord.add(i);
				}
			}
		}
		
		
		// 2. Get y-coordinate -> column wise
		ArrayList<Integer> ycord = new ArrayList<>();  
		for(int j = 0; j < m; j++) {
			for(int i = 0; i < n; i++) {
				if( grid[i][j] == 1 ) {
					ycord.add(j);
				}
			}
		}
		
		// 3. Get mid -> best meeting point
		int x = xcord.get( xcord.size() / 2 );
		int y = ycord.get( ycord.size() / 2 );
		
		// 4. calculate distance -> min distance (because of medium)
		int dist = 0;
		for(int xval : xcord) {
			dist += Math.abs(x - xval);
		}
		
		for(int yval : ycord) {
			dist += Math.abs(y - yval);
		}
		
		// 5. return ans
		return dist;
	}
	
	public static void main(String[] args) {
		int[][] grid = {
		                {1,0,0,0,1},
		                {0,0,0,0,0},
		                {0,0,1,0,0} };
		
		int dist = minTotalDistance(grid);
        System.out.println(dist);
		
	}

}
