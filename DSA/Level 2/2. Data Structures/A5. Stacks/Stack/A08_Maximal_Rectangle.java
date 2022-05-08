/*

1. Given a rows x cols binary matrix filled with 0's and 1's.
2. Find the largest rectangle containing only 1's and return its area.
Constraints
1. 1 <= row, cols <= 200
2. matrix[i][j] is 0 or 1.
Sample Input
2
5
10100
10111
Sample Output
3

*/
package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A08_Maximal_Rectangle {

	public static int[] nextSmallerLeft(int[]arr) {
        int n = arr.length;
        int[]ans = new int[n];
        Stack<Integer>st = new Stack<>();
        
        ans[0] = -1;
        st.push(0);
        
        for(int i=1; i < n;i++) {
            while(st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                ans[i] = -1;
            }
            else {
                ans[i] = st.peek();
            }
            
            st.push(i);
        }
        
        return ans;
    }
    
    public static int[] nextSmallerRight(int[]arr) {
        int n = arr.length;
        int[]ans = new int[n];
        Stack<Integer>st = new Stack<>();
        
        ans[n-1] = n;
        st.push(n-1);
        
        for(int i=n-2; i >= 0;i--) {
            while(st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            
            if(st.size() == 0) {
                ans[i] = n;
            }
            else {
                ans[i] = st.peek();
            }
            
            st.push(i);
        }
        
        return ans;
        
    }
    
    public static int largestRectangleArea(int[] heights) {
        int[]nsl = nextSmallerLeft(heights);
        int[]nsr = nextSmallerRight(heights);
        
        int ans = 0;
        
        for(int i=0; i < heights.length;i++) {
            int w = nsr[i] - nsl[i] - 1;
            int h = heights[i];
            
            int area = h*w;
            
            ans = Math.max(ans,area);
        }
        
        return ans;
    }
    
    
    public static int maximalRectangle(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[]arr = new int[m];
        int max = 0;
        
        for(int i=0; i < n;i++) {
            for(int j=0; j < m;j++) {
                if(matrix[i][j] == 0) {
                    arr[j] = 0;
                }
                else {
                    arr[j] += 1;
                }
            }
            
            int area = largestRectangleArea(arr);
            max = Math.max(area,max);
        }
        
        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int row = Integer.parseInt(read.readLine());
        int col = Integer.parseInt(read.readLine());
        
        int bmat[][] = new int[row][col];

        for(int i=0;i<row;i++){
            String s = read.readLine();
            for(int j=0;j<col;j++){
                bmat[i][j] = s.charAt(j)-'0';
            }
        }

        int result = maximalRectangle(bmat);
        System.out.println(result);
        
    }

}
