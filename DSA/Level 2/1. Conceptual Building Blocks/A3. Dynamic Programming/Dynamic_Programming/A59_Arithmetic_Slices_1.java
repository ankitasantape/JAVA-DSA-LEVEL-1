/*
1. You are given an array(arr) of integers.
2. You have to find the count of arithmetic slices in the given array.
3. Arithmetic slice is defined as the sub-array having all its elements in A.P and the length of sub-array should be greater than or equal to 3.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
Constraints
1 <= N <= 10^8
-10^8 <= arr[i] <= 10^8
Sample Input
4
1
2
3
4
Sample Output
3

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A59_Arithmetic_Slices_1 {
   
	public static int solution(int[] arr) {
		int[] dp = new int[arr.length];
		int ans = 0;
		
		for(int i = 2; i < arr.length; i++) {
			if(arr[i] - arr[i-1] == arr[i-1] - arr[i-2]) {
				dp[i] = dp[i-1] + 1;
				ans += dp[i];
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
