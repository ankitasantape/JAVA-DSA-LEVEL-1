/*
1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum equals k.
Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
A number representing the count of subarrays having sum equal to K.
Constraints
1 <= N <= 10^5
-1000 <= arr[i] <= 1000
-10^9 <= K <= 10^9
Sample Input
3
1 1 1
2
Sample Output
2

Sample Input
30
1 26 14 -21 37 13 46 -6 25 33 -29 24 34 -12 38 -10 -20 -3 -23 -23 0 10 -15 7 19 19 8 42 4 2
40
Sample Output
4
 
*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A10_Count_Of_Subarrays_Having_Sum_Equals_To_K {
    
	public static int solution(int[] arr, int target){
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = -1;
		int maxCount = 0;
		int sum = 0;
		map.put(sum, 1);
		while(i < arr.length-1) {
			i++;
			sum += arr[i];
			int sum_minus_k = sum - target;
			
			if( map.containsKey(sum_minus_k) == true ) {
			   int sum_minus_k_freq = map.get(sum_minus_k);
			   maxCount += sum_minus_k_freq;
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return maxCount;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
        scn.close();
	}
}
