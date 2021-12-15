/*
 1. You are given an array of numbers.
2. All numbers occur twice in the array except one.
3. You have to find that number by traversing only once in the array and without using any extra 
     space.
Input Format
A number n
a1
a2..
n numbers
Output Format
Non-repeating number
Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 
Sample Input
5
23 27 23 17 17
Sample Output
27
 */
package Bit_Manipulation;

import java.util.Scanner;

public class A04_All_Repeating_Except_One {
     
	public static void main(String[] args){
	    Scanner scn = new Scanner(System.in);
	    int n = scn.nextInt();
	    int[] arr = new int[n];
	    for(int i = 0 ; i < n; i++){
	      arr[i] = scn.nextInt();
	    }
	    //write your code here
	    int ans = arr[0];
	    for(int i = 1; i < n; i++) {
	    	ans ^= arr[i];
	    }
	    System.out.println(ans);
	}
}
