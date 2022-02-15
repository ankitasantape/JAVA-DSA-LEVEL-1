/*
1. You are given an array(arr) of positive numbers and two numbers M and K.
2. You have to find the maximum sum of M non-overlapping subarrays of size K.
3. The size of the given array(arr) is greater than M*K.
Input Format
A number N
arr1
arr2.. N numbers
Two numbers M and K
Output Format
A number representing maximum sum of M non-overlapping subarrays of size K.

Constraints
1 <= N <= 10^3
1 <= arr[i] <= 10^3
M >= 1
K >= 1
N >= M*K
Sample Input
7
2 10 7 18 5 33 0
3
1
Sample Output
61

Sample Input
4
3 2 100 1
2
2
Sample Output
106

Sample Input
412
84 69 11 78 16 23 85 36 72 3 6 3 23 96 9 50 64 52 64 78 33 77 66 88 2 19 67 18 36 23 78 34 72 8 32 1 92 22 16 96 21 67 72 84 75 83 99 88 14 71 56 36 45 80 88 17 32 51 13 75 12 46 47 34 54 53 32 86 88 33 31 72 60 87 66 33 45 85 99 71 53 95 12 12 24 3 86 72 93 58 60 2 49 80 72 27 73 98 6 14 63 52 30 57 9 71 76 33 77 81 47 50 92 54 27 20 93 69 41 93 46 44 99 10 65 76 28 74 86 60 35 18 79 80 11 85 58 93 10 54 89 13 81 36 26 44 22 90 38 46 74 46 14 63 37 50 26 29 7 68 39 56 97 95 45 86 91 80 82 44 29 45 60 34 99 31 82 78 13 46 13 79 36 32 58 41 2 73 97 96 30 34 84 5 93 42 98 3 52 35 80 21 5 52 29 87 30 89 94 41 1 97 85 44 8 34 82 23 60 8 2 31 85 50 8 61 4 17 99 48 12 11 40 37 12 63 32 6 36 95 95 91 88 71 92 36 40 75 57 47 66 65 25 51 93 89 96 60 65 24 59 67 16 66 32 53 30 71 53 36 43 80 39 66 23 55 29 69 6 13 79 41 38 71 24 23 93 92 11 6 77 29 87 3 62 10 21 43 88 71 11 92 86 45 52 33 63 74 65 10 85 51 42 43 54 17 76 73 61 66 7 70 30 92 68 88 38 76 8 72 18 74 58 26 88 30 98 50 72 88 74 41 71 79 44 50 73 45 45 31 43 0 59 19 62 30 60 68 1 26 94 14 44 54 17 33 62 88 80 58 30 19 4 30 5 38 15 93 87 53 75 88 25 15 26 72 34 3 18 42 65 78 73 79 95 11 34 73 35 99 59 96 81 94 57 50 30 9 66 30 91 18 
100
4
Sample Output
21151

*/
package Dynamic_Programming;

import java.util.Scanner;

public class A38_Maximum_Sum_Of_M_Non_Overlapping_Subarrays {
 
	// Recursive
	public static int solution(int[] arr, int idx, int m, int k, int[] pSum, int[][] dp){
		if(m == 0) {
			return 0;
		}
		if ( idx >= arr.length ) {
			return 0;
		}
		if(dp[idx][m] != 0) {
			return dp[idx][m];
		}
		
		int exclude = 0 + solution(arr, idx + 1, m, k, pSum, dp);
		int include = pSum[idx] + solution(arr, idx + k, m - 1, k, pSum, dp);
		
		int ans = Math.max(include, exclude);
		dp[idx][m] = ans;
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
        int m = scn.nextInt();
        int k = scn.nextInt();
        
        int[] pSum = new int[n];
        int sum = 0;
        for(int i = 0; i < k; i++) {
        	sum += arr[i];
        }
        pSum[0] = sum;
        // just like window
        for(int i = k, j = 0; i < n; i++, j++) {
        	sum += arr[i] - arr[j];
        	pSum[i - k + 1] = sum;
        }
        System.out.println(solution(arr, 0, m , k, pSum, new int[n][m+1]));
        scn.close();
	}

}
