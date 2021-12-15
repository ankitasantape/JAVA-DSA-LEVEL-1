/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens can be placed on the 
     n * n chess-board. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
Output Format
Check the sample output and question video
Constraints
1 <= n <= 5
Sample Input
2
Sample Output
q1	q2	
-	-	

q1	-	
q2	-	

q1	-	
-	q2	

q2	q1	
-	-	

-	q1	
q2	-	

-	q1	
-	q2	

q2	-	
q1	-	

-	q2	
q1	-	

-	-	
q1	q2	

q2	-	
-	q1	

-	q2	
-	q1	

-	-	
q2	q1	
*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A05_Queens_Permutations_1_2dAs2d_QueenChooses {
    
	public static void queensPermutations(int qpsf, int tq, int[][] chess) {
//		 if queen path so far ki length equal ho gayi total queen ki lenght se then print 
		if(qpsf == tq) {
			for(int i = 0; i < chess.length; i++) {
				for(int j = 0; j < chess[i].length; j++) {
					if(chess[i][j] == 0) {
						System.out.print("-\t");
					} else {
						System.out.print("q" + chess[i][j] + "\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < chess.length; i++) {
			for(int j = 0; j < chess[0].length; j++) {
				if(chess[i][j] == 0) {
					chess[i][j] = (qpsf + 1);
					queensPermutations(qpsf + 1, tq, chess);
					chess[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] chess = new int[n][n];
        
		queensPermutations(0, n, chess);
	}
}
