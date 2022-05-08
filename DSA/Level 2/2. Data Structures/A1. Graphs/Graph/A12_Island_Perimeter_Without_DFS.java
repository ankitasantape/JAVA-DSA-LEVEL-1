package Graph;

public class A12_Island_Perimeter_Without_DFS {

	
    public static int islandPerimeter(int[][] grid) {
        int count  = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i < grid.length; i++) {
        	for(int j=0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1) {
        			//top
        			if(i-1 == -1 || grid[i-1][j] == 0) {
        				count++;
        			}
        			//left
        			if(j-1 == -1 || grid[i][j-1] == 0) {
        				count++;
        			}
        			
        			//down
        			if(i+1 == m || grid[i+1][j] == 0) {
        				count++;
        			}
        			
        			//right
        			if(j+1 == n || grid[i][j+1] == 0) {
        				count++;
        			}
        		}
        	}
        }
        
        return count;
    }

	public static void main(String[] args) {
		int[][] grid = new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0},{1,1,0,0}};
		System.out.println( islandPerimeter(grid) );
	}
}
