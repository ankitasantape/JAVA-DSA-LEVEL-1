/*
 1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain 
                   empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without 
                   changing signature. The judge can't force you but intends you to teach a concept.
Input Format
Input is managed for you
Output Format
Check the sample ouput and question video. - means empty box, i means occupied by item.
Constraints
0 < nboxes <= 10
0 <= ritems <= nboxes
Sample Input
5
3
Sample Output
iii--
ii-i-
ii--i
i-ii-
i-i-i
i--ii
-iii-
-ii-i
-i-ii
--iii

*/
package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A04_Combinations_2 {
//    llb - last box index, ci - current item, ti - total item
	public static void combinations(boolean[] boxes, int ci, int ti, int llb) {
		if (ci > ti) {
			for(int i = 0; i < boxes.length; i++) {
				if(boxes[i]) {
					System.out.print("i");
				} else {
					System.out.print("-");
				}
			}
			System.out.println();
			return;
		}
		for(int box = llb + 1; box < boxes.length; box++) {
			if( boxes[box] == false ) {
				boxes[box] = true;
				combinations(boxes, ci + 1, ti, box);
				boxes[box] = false;
			}	
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nboxes = Integer.parseInt(br.readLine());
		int ritems = Integer.parseInt(br.readLine());
		combinations(new boolean[nboxes], 1, ritems, -1);
	}
}
