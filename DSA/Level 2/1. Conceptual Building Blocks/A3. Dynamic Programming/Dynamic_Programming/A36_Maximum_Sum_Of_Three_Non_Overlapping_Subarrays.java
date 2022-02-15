/*
 1. You are given an array(arr) of positive numbers and a number K.
2. You have to find the maximum sum of elements in three non-overlapping subarrays.
3. Also, you have to print indices representing the starting position of every subarray.
4. If there are multiple answers, print the lexicographically smallest one.
Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
4 space-separated numbers, where first number represents the maximum sum of three non-overlapping subarrays and rest three represents the starting position of every subarray.

Constraints
1 <= N <= 20000
1 <= arr[i] <= 10^5
1 <= K <= N/3
Sample Input
8
1 2 1 2 6 7 5 1 
2
Sample Output
23 0 3 5 

Sample Input
13
4 2 3 2 4 6 7 1 2 8 5 2 1 
3
Sample Output
41

Sample Input
20
17 9 3 2 7 10 20 1 13 4 5 16 4 1 17 6 4 19 8 3
4
Sample Output
123 3 8 14 
 
*/
package Dynamic_Programming;

import java.util.Scanner;

public class A36_Maximum_Sum_Of_Three_Non_Overlapping_Subarrays {
    
	public static void solution(int[] arr, int k){
		int[] dp1 = new int[arr.length];
		int[] dp2 = new int[arr.length];
		
		int sum = 0;
		for(int i = 0; i < k; i++) {
			sum += arr[i];
		}
		dp1[k-1] = sum;
		for(int i = k; i < dp1.length; i++) {
			sum = sum + arr[i] - arr[i - k];
			dp1[i] = Math.max(dp1[i-1], sum);	
		}
		
		sum = 0;
		for(int j = arr.length-1; j >= arr.length-k; j--) {
			sum += arr[j];
		}
		dp2[dp2.length - k] = sum;
		for(int i = dp2.length - 1 - k; i >= 0; i--) {
			sum = sum + arr[i] - arr[i + k];
			dp2[i] = Math.max(sum, dp2[i + 1]);
		}
		
		int psum[] = new int[arr.length];
		psum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			psum[i] = arr[i] + psum[i-1];
		}
		
		int si = k;
		int ei = arr.length - 2*k;
		int sima = -1;
		int li = -1;
		int ri = -1;
		int lsum = 0;
		int rsum = 0;
		int max = Integer.MIN_VALUE;
		for(int i = si; i <= ei; i++) {
			int fsum = psum[i - 1 + k] - (si == 0 ? 0 :psum[i - 1]);
			if (max < dp1[i-1] + fsum + dp2[i+k]) {
				lsum = dp1[i - 1];
				rsum = dp2[i + k];
				max = dp1[i-1] + fsum + dp2[i+k];
				sima = i;
//				li = i - k - 1;
//				ri = i + k + 2;
			}
		}
		for(int i = k-1; i < arr.length; i++) {
			if(dp1[i] == lsum) {
				li = i - k + 1;
				break;
			}
		}
		for(int i = sima+k; i < arr.length; i++) {
			if(psum[i + k - 1] - psum[i - 1] == rsum) {
				ri = i;
				break;
			}
		}
		System.out.println(max +" "+ li +" "+sima+" "+ri);
 	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
		scn.close();
	}
}
