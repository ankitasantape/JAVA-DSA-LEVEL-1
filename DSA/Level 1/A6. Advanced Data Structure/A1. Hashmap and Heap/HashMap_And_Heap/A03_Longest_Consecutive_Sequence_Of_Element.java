/*
 1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
Elements of longest sequence of consecutive elements of array in separate lines (ignoring duplicates)
Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 15
Sample Input
17
12
5
1
2
10
2
13
7
11
8
9
11
8
9
5
6
11
Sample Output
5
6
7
8
9
10
11
12
13
 */
package HashMap_And_Heap;

import java.util.HashMap;
import java.util.Scanner;

public class A03_Longest_Consecutive_Sequence_Of_Element {
      
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		HashMap<Integer, Boolean> map = new HashMap<>();
//		1. Consider all elements as valid starting points of the sequence
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			map.put(a[i], true);
		}
//		2. Discard all the invalid starting points
		for(int i = 0; i < n; i++) {
			if(map.containsKey(a[i]-1)) {
				map.put(a[i], false);
			}
			
		}
//		3. Find the stpt with maximum length of consecutive elements
		int stpt = 0;
		int maxLen = 0;
		for(int i = 0; i < n; i++) {
			if(map.get(a[i]) == true) {
				int curr = a[i];
				int len = 1;
				
			    while( map.containsKey(curr + 1) == true ) {
			    	curr++;
			    	len++;
			    }
			    if(len > maxLen) {
			    	stpt = a[i];
			    	maxLen = len;
			    }	
			}
		}
		for(int i = 0; i < maxLen; i++) {
			System.out.println(stpt + i);
		}
		
		sc.close();
	 }
}
