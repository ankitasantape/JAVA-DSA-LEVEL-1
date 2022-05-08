package Graph;

public class A11_Island_Perimeter {
    public static int count = 0;
    public static int islandPerimeter(int[][] grid) {
        count  = 0;
        
        for(int i=0; i < grid.length; i++) {
        	for(int j=0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1) {
        			dfs(grid, i, j);
        		}
        	}
        }
        
        return count;
    }
    
    private static void dfs(int[][] grid, int i, int j) {
    	// ans banega base case me
    	if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length  || grid[i][j] == 0) {
    		count++;
    		return;
    	}
    	if( grid[i][j] == 2 ) {
    		return;
    	}
    	// aatehi khudako mark kr lijiye
    	// 0 -> 2 chijo ka indication ban gaya tha isiliye grid ko 2 se mark kiya 
    	// 1 bar 0 visited 0 ko depict kr rha hai
    	// aur 2nd times 0 original 0 ko depict kr rha hai
		grid[i][j] = 2;
		
		// aur apne nbrs pe call laga lijiye
		dfs(grid, i-1, j);
		dfs(grid, i, j-1);
		dfs(grid, i+1, j);
		dfs(grid, i, j+1);
	}

	public static void main(String[] args) {
		int[][] grid = new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0},{1,1,0,0}};
		System.out.println( islandPerimeter(grid) );
	}
}
