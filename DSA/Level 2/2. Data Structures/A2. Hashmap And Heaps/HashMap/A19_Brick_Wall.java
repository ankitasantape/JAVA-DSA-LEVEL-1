/*
Input: wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
Output: 2
Example 2:

Input: wall = [[1],[1],[1]]
Output: 3

*/

package HashMap;

import java.util.HashMap;
import java.util.List;

public class A19_Brick_Wall {

	public static void main(String[] args) {
		
		for(int i = 0; i < args.length; i++) {
			System.out.println(args.length + " " +  args[i]);
		}
	}
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall) {
        	int psum = 0;
        	// we don't need to go upto end of the list becoz we are not considering end of wall
        	for(int i=0; i<list.size()-1; i++) {
        		psum += list.get(i);
        		map.put(psum, map.getOrDefault(psum, 0) + 1);
        	}
        }
        int maxgap = 0;
        for(int key : map.keySet()) {
        	if( map.get(key) > maxgap ) {
        		maxgap = map.get(key);
        	}
        }
        // min bricks kitane crossed krenge 
        int minbrick = wall.size() - maxgap;
        return minbrick;
    }

}
