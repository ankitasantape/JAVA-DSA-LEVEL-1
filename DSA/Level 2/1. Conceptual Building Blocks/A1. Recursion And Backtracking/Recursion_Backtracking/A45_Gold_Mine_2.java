/*
1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are allowed to take one step left, right, up or down from your current position.
5. You can't visit a cell with 0 gold and the same cell more than once. 
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine if 
     you start and stop collecting gold from any position in the grid that has some gold.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
A number m
e11
e12..
e12
e22..
m*n numbers
Output Format
Maximum gold collected

Constraints
1 <= n <= 10
1 <= m <= 10
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
120

Sample Input
3
3
0 6 0
5 8 7
0 9 0
Sample Output
35
*/

package Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class A45_Gold_Mine_2 {
 
	static int max = 0;

	public static void getMaxGold(int[][] arr) {

		boolean[][] visited = new boolean[arr.length][arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if ( arr[i][j] != 0 && visited[i][j] == false) {
					ArrayList<Integer> bag = new ArrayList<>();
					travelAndCollectGold(arr, i, j, visited, bag);

					int sum = 0;
					for (int val : bag) {
						sum += val;
					}

					if (sum > max) {
						max = sum;
					}
				}
			}
		}
	}

	private static void travelAndCollectGold(int[][] arr, int i, int j, boolean[][] visited, ArrayList<Integer> bag) {
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || visited[i][j] == true || arr[i][j] == 0) {
			return;
		}
		visited[i][j] = true;
		bag.add(arr[i][j]);
//		top
		travelAndCollectGold(arr, i - 1, j, visited, bag);
//		right
		travelAndCollectGold(arr, i, j + 1, visited, bag);
//		left
		travelAndCollectGold(arr, i, j - 1, visited, bag);
//		bottom
		travelAndCollectGold(arr, i + 1, j, visited, bag);

//		backtrack krte time sb undo krna padega jaha pe bhi value dali hai
//		visited[i][j] = false;

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
		System.out.println(max);
		scn.close();
	}
}
