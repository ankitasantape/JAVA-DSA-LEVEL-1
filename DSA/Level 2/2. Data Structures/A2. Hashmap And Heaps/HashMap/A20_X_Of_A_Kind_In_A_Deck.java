/*
In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
Each group has exactly X cards.
All the cards in each group have the same integer.
 

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.
 

Constraints:

1 <= deck.length <= 104
0 <= deck[i] < 104

*/

package HashMap;

import java.util.HashMap;

public class A20_X_Of_A_Kind_In_A_Deck {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,4,3,2,1};
		System.out.println(hasGroupsSizeX(arr) );
	}
    public static boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<deck.length;i++) {
        	map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        int gcd = 0;
        for(int key : map.keySet()) {
        	gcd = GCD(gcd, map.get(key));
        }
        if(gcd == 1) {
        	return false;
        } else {
        	return true;
        }
    }
	private static int GCD(int a, int b) {
		if(b == 0) {
			return a;
		}
		return GCD(b, a%b);
	}

}
