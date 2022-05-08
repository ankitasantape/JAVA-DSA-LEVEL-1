/*
Given an m*n binary matrix mat, return the number of distinct island.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
Input Format
First line contains two integers n and m.
Each of next n lines contain n numbers containing either 0 or 1.
Output Format
print number of distinct island.
Constraints
1<= n <= 1000
1<= e <= n*(n-1)/2
Sample Input
3 3
1 0 0
0 1 0
1 1 1
Sample Output
2

*/

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A02_Number_Of_Distinct_Island {
  
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}

		System.out.println(numDistinctIslands(arr));

	}

	public static StringBuilder psf = new StringBuilder();

	public static int numDistinctIslands(int[][] arr) {
	    HashSet<String> hs = new HashSet<>();
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if( arr[i][j] == 1 ) {
					psf = new StringBuilder();
					dfs(arr, i, j);
					hs.add(psf.toString());
				}
			}
		}	
		return hs.size();
	}
//  Time Complexity: O(m * n)
	private static void dfs(int[][] arr, int i, int j) {
		// aate hi khudko mark krlo
		arr[i][j] = 0;
		
		// agar nbr valid hai to call lagao
		//top -> top nbr
		if(i-1 >= 0 && arr[i-1][j] == 1) {
			psf.append('t');
			dfs(arr, i-1, j);
		}
		
		//left -> left nbr
		if(j-1 >= 0 && arr[i][j-1] == 1) {
			psf.append('l');
			dfs(arr, i, j-1);
		}
		
		//down -> down nbr
		if(i+1 < arr.length && arr[i+1][j] == 1) {
			psf.append('d');
			dfs(arr, i+1, j);
		}
		
		//right -> right nbr
		if(j+1 < arr[0].length && arr[i][j+1] == 1) {
			psf.append('r');
			dfs(arr, i, j+1);
		}
		
		// backtracking
		psf.append('b');
	}
}
