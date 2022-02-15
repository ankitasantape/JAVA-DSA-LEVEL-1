/*
1. You are given an array(arr) of integers.
2. You have to find the count of arithmetic slices in the given array.
3. Arithmetic slice is defined as the sub-sequence of an array having all its elements in A.P and length of sub-sequence should be greater than or equal to 3.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
Constraints
1 <= N <= 1000
-10^8 <= arr[i] <= 10^8
Sample Input
4
1
2
3
4
Sample Output
3

Sample Input
3
0
2000000000
-294967296
Sample Output
0

*/

package Dynamic_Programming;

import java.util.*;

public class A60_Arithmetic_Slices_2 {
    
	public static int solution(int[] arr) {
		int ans = 0;
		
		HashMap<Integer, Integer>[] maps = new HashMap[arr.length];
		for (int i = 0; i < arr.length; i++) {
			// j tak new HashMap<> nhi kroge tab tak heap me hashmap ka object create nhi hoga
			maps[i] = new HashMap<>();
		}
		
		for(int i = 1; i < maps.length; i++) {
			for(int j = 0; j < i; j++) {
			    long cd = (long)arr[i] - (long)arr[j];
				if(cd <= Integer.MIN_VALUE || cd >= Integer.MAX_VALUE) {
					continue;
				}
			    
				int apsEndingOnJ = maps[j].getOrDefault((int)cd, 0);
				int apsEndingOnI = maps[i].getOrDefault((int)cd, 0);
				
				ans += apsEndingOnJ;
				maps[i].put((int)cd, apsEndingOnI + apsEndingOnJ + 1);
				
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
		scn.close();
	}
}
