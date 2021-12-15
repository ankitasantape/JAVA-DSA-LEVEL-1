/*
1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
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
qq
--

q-
q-

q-
-q

-q
q-

-q
-q

--
qq 
*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A06_Queens_Combinations_1_2dAs2d_BoxChooses {
     
	public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        
		if( row == tq ) {
			if(qpsf == tq) {
				System.out.println(asf);
			}
			return;
		}
		
		int new_row = 0;
		int new_col = 0;
		String yes_qpsf = "";
		String no_qpsf = "";
//		if column is at extreme position of row then add queen into yes_qpsf and enter
		if( col == tq - 1 ) {
			new_row = row + 1;
			new_col = 0;
			yes_qpsf = asf + "q\n";
			no_qpsf = asf + "-\n";
		} else {
			new_row =  row;
			new_col = col + 1;
			yes_qpsf = asf + "q";
			no_qpsf = asf + "-";
		}
		queensCombinations(qpsf + 1, tq, new_row, new_col, yes_qpsf);
		queensCombinations(qpsf + 0, tq, new_row, new_col, no_qpsf);
    }
	public static void queensCombinations_2(int qpsf, int tq, int row, int col, String asf){
	    if(col == tq) {
	    	col = 0;
	    	row++;
	    	asf += "\n";
	    }
	    if(row == tq) {
	    	if(qpsf == tq) {
	    		System.out.println(asf);
	    	}
	    	return;
	    }
	    queensCombinations_2(qpsf + 1, tq, row, col + 1, asf + "q"); // yes
	    queensCombinations_2(qpsf , tq, row, col + 1, asf + "-"); // no
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations_2(0, n, 0, 0, "");
    }
}
