/*
1. You are given an array asteroids of integers representing asteroids in a row.
2. For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
3. Each asteroid moves at the same speed.
4. You need to find out the state of the asteroids after all collisions.
5. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
Constraints
1. 2 <= asteroids.length <= 10^4
2. -1000 <= asteroids[i] <= 1000
3. asteroids[i] != 0
Sample Input
7
3
2
-1
3
-3
3
-4
Sample Output
1
-4

*/
package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A18_Asteroid_Collision {

	public static int[] asteroidCollision(int[] asteroids) {
       Stack<Integer>st = new Stack<>();
        
        for(int i=0; i < asteroids.length;i++) {
            int val = asteroids[i];
            
            if(st.size() > 0 && st.peek() > 0 && val < 0) {
                while(st.size() > 0 && st.peek() > 0 && st.peek() < -val) {
                    st.pop();
                }
                if(st.size() > 0 && st.peek() == -val) {
                    st.pop();
                }
                else if(st.size() > 0 && st.peek() > -val){
                    continue;
                }
                else {
                    st.push(val);
                }
            }
            else {
                st.push(val);
            }
        }
        
        int[]ans = new int[st.size()];
        int idx = ans.length-1;
        
        while(st.size() > 0) {
            ans[idx--] = st.pop();
        }
        
        return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(read.readLine());
		int result[] = asteroidCollision(arr);

		System.out.println(result.length);
		for (int e : result) {
			System.out.println(e);
		}

	}

}
