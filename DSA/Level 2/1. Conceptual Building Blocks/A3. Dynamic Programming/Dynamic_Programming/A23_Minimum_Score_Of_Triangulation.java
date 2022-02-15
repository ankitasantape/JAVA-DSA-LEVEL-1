/*
1. You are given an array of integers, which represents the vertices of an N-sided convex polygon in clockwise order.
2. You have to triangulate the given polygon into N-2 triangles.
3. The value of a triangle is the product of the labels of vertices of that triangle.
4. The total score of the triangulation is the sum of the value of all the triangles.
5. You have to find the minimum score of the triangulation of the given polygon.
Input Format
A number N
a1
a2.. N integers
Output Format 

Constraints
1 <= N <= 1000
1 <= arr[i] <= 100
Sample Input
3
1
2
3
Sample Output
6
*/
package Dynamic_Programming;

import java.util.Scanner;

public class A23_Minimum_Score_Of_Triangulation {
	public static int minScoreTriangulation(int[] arr) {
		int[][] dp = new int[arr.length][arr.length];
		for(int g = 0; g < dp.length; g++) {
			for(int i = 0, j = g; j < dp[0].length; i++, j++) {
				if (g == 0) { 
					dp[i][j] = 0;
				} 
				else if (g == 1){
					dp[i][j] = 0;
				} 
				else if(g == 2) {
					dp[i][j] = arr[i] * arr[i + 1] * arr[i + 2];
				}
				else {
					int min = Integer.MAX_VALUE;
					
					for (int k = i + 1; k <= j-1; k++) {
//					dp -> i, k left half and k + 1, j right half
//				    arr -> i * k + 1 right half, k + 1 * j + 1 right half		
						int mcost = arr[i] * arr[j] * arr[k];
						int left = dp[i][k];
						int right = dp[k][j];
						
						int totalcost = left + right + mcost;
						min = totalcost < min ? totalcost : min;
					}
					
					dp[i][j] = min;
				}
				
			}
		}
		return dp[0][arr.length - 1];
	}
	public static int minScoreTriangulation_2(int[] arr) {
	    int n = arr.length;
		int [][]dp = new int[n][n];
		
		for(int g = 2; g < n; g++){
		    for (int si = 0, ei = g; ei < dp.length; si++, ei++){
		        if(g == 2){
		           dp[si][ei] = arr[si] * arr[si + 1] * arr[si + 2]; 
		        } else {
		           int min = Integer.MAX_VALUE;
		          for(int cp = si+1; cp < ei; cp++){
		             int lans = dp[si][cp];
		             int rans = dp[cp][ei];
		             min = Math.min(min, lans + rans + arr[si] * arr[cp] * arr[ei]);
		          }  
		          dp[si][ei] = min;
		        }
		    }
		}
		return dp[0][n-1];
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(minScoreTriangulation(arr));
		System.out.println(minScoreTriangulation_2(arr));
		scn.close();
	}
}
