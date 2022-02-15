/*
1. You are given an array(arr) of positive numbers and two numbers X and Y.
2. You have to find the maximum sum of elements in two non-overlapping subarrays.
3. One subarray must of length X and the other must be of length Y.
Input Format
A number N
arr1
arr2.. N numbers
Two numbers X and Y
Output Format
A number representing maximum sum of elements in two non-overlapping subarrays. 

Constraints
1 <= N <= 1000
0 <= arr[i] <= 1000
X >= 1, Y >= 1
X + Y <= N
Sample Input
9
0 6 5 2 2 5 1 9 4
1
2
Sample Output
20

Sample Input:
10
4 9 1 4 3 2 6 9 8 0
3
4
*/

package Dynamic_Programming;

import java.util.Scanner;

public class A35_Maximum_Sum_Of_Two_Non_Overlapping_Subarrays {
    
	public static int solution(int[] arr, int x, int y){
		int[] dp1 = new int[arr.length];
		int[] dp2 = new int[arr.length];
		
		int sum = 0;
		for(int i = 0; i < x; i++) {
			sum += arr[i];
		}
		dp1[x-1] = sum;
		for(int i = x; i < dp1.length; i++) {
			sum = sum + arr[i] - arr[i - x];
			dp1[i] = Math.max(dp1[i-1], sum);	
		}
		
		sum = 0;
		for(int j = arr.length-1; j >= arr.length-y; j--) {
			sum += arr[j];
		}
		dp2[dp2.length - y] = sum;
		for(int i = dp2.length - 1 - y; i >= 0; i--) {
			sum = sum + arr[i] - arr[i + y];
			dp2[i] = Math.max(sum, dp2[i + 1]);
		}
		
		int ans = 0;
		for(int i = x - 1; i < arr.length - y; i++) {
			ans = Math.max(ans, dp1[i] + dp2[i + 1]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(Math.max(solution(arr,x,y), solution(arr,y,x)));
		
		scn.close();
	}
	
	
}
