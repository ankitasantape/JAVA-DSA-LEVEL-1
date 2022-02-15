/*
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest bitonic subsequence of array.
Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.
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
7

*/

package Dynamic_Programming;

import java.util.Scanner;

public class A11_Longest_Bitcoin_Subsequence {
    
	 public static void main(String[] args) throws Exception {
		 Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int arr[] = new int[n];
	        for (int i = 0; i < n; i++) {
	        	arr[i] = sc.nextInt();
	        }
	        int lis[] = new int[n];
	        for (int i = 0; i < n; i++) {
	        	int max = 0;
	        	
	        	for(int j = 0; j < i; j++) {
	        		if(arr[j] < arr[i]) {
	        			if(lis[j] > max) {
	            			max = lis[j];
	            		}
	        		}
	        	}
	        	
	        	lis[i] = max + 1;
	        }
	        
			int lds[] = new int[n];
			for (int i = n - 1; i >= 0; i--) {
				int max = 0;

				for (int j = n - 1; j > i; j--) {
					if (arr[j] < arr[i]) {
						if (lds[j] > max) {
							max = lds[j];
						}
					}
				}

				lds[i] = max + 1;
			}
	        int omax = 0;
	        for(int i = 0; i < n; i++) {
	        	omax = Math.max(omax, lis[i] + lds[i] - 1);
	        }
	        System.out.println(omax);
	        sc.close(); 
	 }
}
