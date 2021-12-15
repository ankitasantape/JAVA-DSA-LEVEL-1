/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
     n * n chess-board. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
Constraints
1 <= n <= 5
Sample Input
2
Sample Output
q	q	
-	-	

q	-	
q	-	

q	-	
-	q	

-	q	
q	-	

-	q	
-	q	

-	-	
q	q	
 */
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A09_Queens_Combinations_3_2dAs1d_QueenChooses {
//      Optimized Approach
	public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
        // write your code here
		if(qpsf == tq) {
			for(int row = 0; row < chess.length; row++) {
				for(int col = 0; col < chess.length; col++) {
					if(chess[row][col] == true) {
						System.out.print("q\t");
					} else {
						System.out.print("-\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		for(int cell = lcno + 1; cell < chess.length*chess.length; cell++) {
			int rno = cell / chess.length;
			int cno = cell % chess.length;
			
			chess[rno][cno] = true;
			queensCombinations(qpsf + 1, tq, chess, cell);
			chess[rno][cno] = false;
		}
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
