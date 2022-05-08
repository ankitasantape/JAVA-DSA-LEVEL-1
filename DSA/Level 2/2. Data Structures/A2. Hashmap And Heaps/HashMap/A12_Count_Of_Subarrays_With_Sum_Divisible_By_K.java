/*
1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum is divisible by K.

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
A number representing the count of subarrays whose sum is divisible by K.

Example
Sample Input

6
2 7 6 1 4 5
3

Sample Output
5

*/
package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A12_Count_Of_Subarrays_With_Sum_Divisible_By_K {

	public static int solution(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = -1;
		int maxCount = 0;
		int psum = 0;
		map.put(psum, 1);
		while(i < arr.length-1) {
			i++;
			psum += arr[i];
			int remainder = psum % k;
			if( remainder < 0 ) {
				remainder += k;
			}
			if( map.containsKey(remainder) == true ) {
			   int remainder_freq = map.get(remainder);
			   maxCount += remainder_freq;
			}
			map.put(remainder, map.getOrDefault(remainder, 0) + 1);
		}
		return maxCount;
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
