/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens can be placed on the 
     n * n chess-board. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
Output Format
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


q2	-
q1	-


q2	-
-	q1


-	q1
q2	-


-	q1
-	q2


-	q2
q1	-


-	q2
-	q1


-	-
q1	q2


-	-
q2	q1
*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A07_Queens_Permutations_2_2dAs2d_BoxChooses {
	public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
		if ( row == tq ) {
			if(qpsf == tq) {
				System.out.println(asf);
				System.out.println();
			}
			return;
		}

		int nr = 0;
		int nc = 0;
		String sep = " ";
		
		if(col == tq - 1) {
			nr = row + 1;
			nc = 0;
			sep = "\n";
		} else {
			nr = row;
			nc = col + 1;
			sep = "\t";
		}
		
		for(int i = 0; i < queens.length; i++) {
			if(queens[i] == false) {
				queens[i] = true;
				queensPermutations(qpsf + 1, tq, nr, nc, asf + "q" + (i + 1) + sep, queens);
				queens[i] = false;
			}
		}
		queensPermutations(qpsf + 0, tq, nr, nc, asf + "-" + sep, queens);
    }
	
	public static void queensPermutations_2(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
		if (col == tq) {
			col = 0;
			row++;
			asf += "\n";
		}

		if (row == tq) {
			if (qpsf == tq) {
				System.out.println(asf);
				System.out.println();
			}
			return;
		}
//      Yes
		for (int i = 0; i < queens.length; i++) {
			if (queens[i] == false) {
				queens[i] = true;
				queensPermutations_2(qpsf + 1, tq, row, col + 1, asf + "q" + (i + 1) + "\t", queens);
				queens[i] = false;
			}
		}
//		No
		queensPermutations_2(qpsf , tq, row, col + 1, asf +"-\t", queens);
	}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
