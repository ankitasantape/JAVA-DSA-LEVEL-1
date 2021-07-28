package Recursion_In_Array;

import java.util.Scanner;
/*
 1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number x. 
4. You are required to find the first index at which x occurs in array a.
5. If x exists in array, print the first index where it is found otherwise print -1.
Input Format
A number n
n1
n2
.. n number of elements
A number x
Output Format
A number representing first index of occurence of x in array a or -1 if not found at all.
Sample Input
6
15
11
40
4
4
9
4
Sample Output
3
 */
public class First_Index {
	  public static void main(String[] args) throws Exception {
	       Scanner sc = new Scanner(System.in);
	         int n = sc.nextInt();
	         int a[] = new int[n];
	         for(int i = 0; i < n; i++){
	             a[i] = sc.nextInt();
	         }
	         int x = sc.nextInt();
	         System.out.println(firstIndex(a,0,x));
	         sc.close();
	    }

	    public static int firstIndex(int[] arr, int idx, int x){
	       if(idx == arr.length){
	           return -1;
	       }
	       
	       if(arr[idx] == x){
	           return idx;
	       }
	       return firstIndex(arr, idx + 1, x);
	    }

}
