/*
1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (same coin can be used 
     again any number of times) using which the amount "amt" can be paid.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
Input Format
A number n
n1
n2
.. n number of elements
A number amt
Output Format

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= amt <= 50
Sample Input
5
2
3
5
6
7
12
Sample Output
2-2-2-2-2-2-.
2-2-2-3-3-.
2-2-2-6-.
2-2-3-5-.
2-3-7-.
2-5-5-.
3-3-3-3-.
3-3-6-.
5-7-.
6-6-.

*/

package Recursion_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A25_Coin_Change_Combinations_2 {
    
	public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
		if (amtsf > tamt) {
			return;
		}
		if (i == coins.length) {
			if (amtsf == tamt) {
				System.out.println(asf + ".");
			}
			return;
		}
//			tamt = 12, j = tamt / coins[i] = 12 / 2 = 6, 6 to 1 tk calls lagayenge and 0 tk nhi liya becoz 0th call no ki lagegi
		 for(int j = tamt / coins[i]; j >= 1; j--) {
			    String part = "";
//			    2 ko 6 times part me add krenge aur part ko asf me part = "2-2-2-2-2-2"
			    for(int k = 0; k < j; k++) {
			    	part += coins[i] + "-";
			    }
			 
//				yes ki call
			    
//			    amtsf me 2 * 6 ( = 12 ) add kr denge 
				coinChange(i + 1, coins, amtsf + coins[i] * j, tamt, asf + part );

		 }
//			no ki call
			coinChange(i + 1, coins, amtsf , tamt, asf );
    }
	
	public static void coinChange2(int i, int[] coins, int amtsf, int tamt, String asf) {
		if (amtsf > tamt) {
			return;
		}
		if (i == coins.length) {
			if (amtsf == tamt) {
				System.out.println(asf + ".");
			}
			return;
		}
//		yes ki call
		coinChange2(i , coins, amtsf + coins[i], tamt, asf + coins[i] +"-");
//		no ki call
		coinChange2(i + 1, coins, amtsf , tamt, asf );
	}	

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
        coinChange2(0, coins, 0, amt, "");
    }
}
