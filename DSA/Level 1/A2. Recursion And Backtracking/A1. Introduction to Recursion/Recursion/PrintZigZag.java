package Recursion;

import java.util.Scanner;

/*
 1. Here are a few sets of inputs and outputs for your reference
Input1 -> 1
Output1 -> 1 1 1

Input2 -> 2
Output2 -> 2 1 1 1 2 1 1 1 2

Input2 -> 3
Output3 -> 3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3

2. Figure out the pattern and complete the recursive function pzz to achieve the above for any positive number n.
 
Sample Input
3
Sample Output
3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3
 */
public class PrintZigZag {

	 public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    pzz(n);
	    sc.close();
	  }

	  public static void pzz(int n) {
	    if (n == 0) {
	      return;
	    }
	    System.out.print(n + " ");
	    pzz(n - 1);
	    System.out.print(n + " ");
	    pzz(n - 1);
	    System.out.print(n + " ");
	  }

}
