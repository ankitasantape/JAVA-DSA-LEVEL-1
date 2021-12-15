/*
1. You are given an array of numbers.
2. All numbers occur thrice in the array except one.
3. You have to find the element that occurs once.
Input Format
A number n
a1
a2..
n numbers
Output Format
A number
Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9
Sample Input
4
1 1 1 2 
Sample Output
2
*/

package Bit_Manipulation;

import java.util.Scanner;

public class A07_All_Repeating_Three_Times_Except_One {

	public static void main(String[] args){
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for(int i = 0 ; i < n; i++){
	      arr[i] = scn.nextInt();
	    }
	    solution(arr);
	    scn.close();
	  }

	  public static void solution(int[] arr){
	   //write your code here
		int ans = 0;

		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if ((arr[j] & (1 << i)) != 0) {
					count++;
				}
			}
			if (count % 3 != 0) {
				ans |= (1 << i);
			}
		}
		System.out.println(ans);
	  }
}
