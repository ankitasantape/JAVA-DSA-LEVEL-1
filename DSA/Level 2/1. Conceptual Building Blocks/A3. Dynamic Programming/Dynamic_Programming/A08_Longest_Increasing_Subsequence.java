/*
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest increasing subsequence of array.
Input Format
A number n
.. n more elements
Output Format
A number representing the length of longest increasing subsequence of array.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 100
Sample Input
10
10
22
9
33
21
50
41
60
80
1
Sample Output
6
*/
package Dynamic_Programming;

import java.util.Scanner;

public class A08_Longest_Increasing_Subsequence {
    
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = sc.nextInt();
        }
        // Approach 1
        int rs = recursive_LIS(arr, 0, -1);
        System.out.println("Recursive Result1 : " + rs);
        
        // Approach 2
        int maximum = 1;
        for (int i = 0; i < n; i++) {
        	maximum = Math.max(maximum, recursive2_LIS(arr, i));	
        }
        System.out.println("Recursive Result2 : " + maximum);
        
        // Approach 3 - Memoization
        int ms = memoize_LIS(arr, 0, -1, new int[n]);
        System.out.println("Memoized Result : " + ms);
        
        // Approach 4 - Tabulation
        // dp[i] -> Length of Longest increasing subsequence ending at arr[i]
        int dp[] = new int[n];
       
        int omax = 0;
        for (int i = 0; i < n; i++) {
        	int max = 0;
        	
        	for(int j = 0; j < i; j++) {
        		if(arr[j] < arr[i]) {
        			if(dp[j] > max) {
            			max = dp[j];
            		}
        		}
        	}
        	
        	dp[i] = max + 1;
        	if(dp[i] > omax) {
        		omax = dp[i];
        	}
        }
        System.out.println("DP Result : "+omax);
       
       
        sc.close();
    }

	

	private static int memoize_LIS(int[] arr, int idx, int pv, int[] storage) {
		if (idx == arr.length) {
			return 0;
		}
		if(storage[idx] != 0) {
			return storage[idx];
		}
		int f1 = 0 + memoize_LIS(arr, idx + 1, pv, storage); // no ki call
		int f2 = 0;
		
		if (arr[idx] > pv) {
			f2 = 1 + memoize_LIS(arr, idx + 1, arr[idx], storage); // yes ki call
		}
		if(storage[idx] == 0) {
			storage[idx] = Math.max(f1, f2);
		}
		
		return Math.max(f1, f2);
	}



	private static int recursive2_LIS(int[] arr, int idx) {
		int max = 0;
		for(int i = 0; i < idx; i++) {
			if(arr[i] < arr[idx]) {
				max = Math.max(max, recursive2_LIS(arr, i));
			}
		}
		return max + 1;
	}

	private static int recursive_LIS(int[] arr, int idx, int prev_val) {
		if (idx == arr.length) {
			return 0;
		}
		
		int f1 = 0 + recursive_LIS(arr, idx + 1, prev_val); // no ki call
		int f2 = 0;
		// if prev val is smaller than current val then we can apply call for next val
		if (arr[idx] > prev_val) {
			f2 = 1 + recursive_LIS(arr, idx + 1, arr[idx]); // yes ki call
		}
		return Math.max(f1, f2);
	}
} 
