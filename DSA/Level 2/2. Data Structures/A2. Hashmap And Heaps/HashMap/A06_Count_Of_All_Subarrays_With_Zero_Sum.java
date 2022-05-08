/*
1. You are given an array(arr) of integers.
2. You have to find the count of all subarrays with sum 0.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing the count of all subarrays with sum 0. 
Constraints
1 <= N <= 10^6
1 <= arr[i] <= 10^4
Sample Input
8
15 -2 2 -8 1 7 10 23
Sample Output
3

Sample Input
8
1 0 0 0 0 0 0 0
Sample Output
28

*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A06_Count_Of_All_Subarrays_With_Zero_Sum {

	public static int solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = -1;
		int maxCount = 0;
		int psum = 0;
		map.put(psum, 1);
		while(i < arr.length-1) {
			i++;
			psum += arr[i];
			
			if( map.containsKey(psum) == false ) {
				map.put(psum, 1);
			} else {
			    int psum_count = map.get(psum);
			    maxCount += psum_count;
				map.put(psum, psum_count + 1);
			}
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
		System.out.println(solution(arr));
		scn.close();

	}

}
