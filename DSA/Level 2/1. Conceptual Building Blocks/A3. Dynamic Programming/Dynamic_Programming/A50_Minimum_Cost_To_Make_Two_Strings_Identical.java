/*
1. You are given two strings S1, S2, and two numbers x and y.
2. The cost of deleting a character from S1 is x and the cost of deleting a character from S2 is y.
3. You can delete characters from both the strings.
4. You have to find the minimum cost required to make the given two strings identical.
Input Format
Two Strings S1, S2
Two numbers x and y
Output Format
A number representing the minimum cost of making the given two strings identical.

Constraints
1 <= length of strings S1 and S2 <= 1000
1 <= x,y <= 1000
Sample Input
sea
eat
10
7
Sample Output
17

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A50_Minimum_Cost_To_Make_Two_Strings_Identical {
    
	public static int solution(String s1, String s2, int c1, int c2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = dp.length-2; i >= 0; i--) {
			for (int j = dp[0].length-2; j >= 0; j--) {
				char ch1 = s1.charAt(i);
				char ch2 = s2.charAt(j);
				
				if(ch1 == ch2) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}

		int lcs = dp[0][0];
		int s1r = s1.length() - lcs;
		int s2r = s2.length() - lcs;
		int cost = s1r * c1 + s2r * c2;
		
		return cost;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(s1, s2,x, y));
		scn.close();
	}
}
