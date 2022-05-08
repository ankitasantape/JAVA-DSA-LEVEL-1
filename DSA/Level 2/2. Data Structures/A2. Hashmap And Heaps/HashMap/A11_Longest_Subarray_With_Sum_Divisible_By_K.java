/*
1. You are given an array of integers(arr) and a number K.
2. You have to find length of the longest subarray whose sum is divisible by K.

Constraints
1 <= N,K <= 10^5
-1000 <= arr[i] <= 1000

Format
Input
A number N
arr1
arr2.. N numbers
A number K

Output
A number representing length of the longest subarray whose sum is divisible by K.

Example
Sample Input
6
2 7 6 1 4 5
3
Sample Output
4

*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A11_Longest_Subarray_With_Sum_Divisible_By_K {
    // always represent -ve number 
	// like, -16 represented as: -16 = -5 * 3 + (-1) + 3 - 3 = -6 * 3 + 2
	// whenever you get remainder -ve just add k into rem to represent remainder as +ve
	public static int solution(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = -1;
		int maxlength = 0;
		int psum = 0;
		map.put(psum, i);
		while(i < arr.length-1) {
			i++;
			psum += arr[i];
		    int remainder = psum % k;
		    if( remainder < 0 ) {
		    	remainder += k;
		    }
			//-------------------------------j:ps=mk+x
			//---------------i:ps=nk+x
			//                ----------------
			// i+1 to j = m*k+x - (n*k+x) 
			//          = (m - n) * k
			if( map.containsKey(remainder) == true ) {
				int rem_idx = map.get(remainder);
				maxlength = Math.max(maxlength, i - rem_idx);
			}
			else {
				map.put(remainder, i);
			}
		}
		return maxlength;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
        scn.close();
    }

}
