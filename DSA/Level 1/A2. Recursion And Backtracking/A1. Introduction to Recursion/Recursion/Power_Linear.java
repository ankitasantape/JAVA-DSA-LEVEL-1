package Recursion;

import java.util.Scanner;

/*
1. You are given a number x.
2. You are given another number n.
3. You are required to calculate x raised to the power n. Don't change the signature of power function .
Input Format
A number x
A number n
Output Format
x raised to the power n
Sample Input
2
5
Sample Output
32
 */
public class Power_Linear {

	 public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int x = sc.nextInt();
	    int n = sc.nextInt();
	    System.out.println(power(x,n));

	    sc.close();
	  }

	  public static int power(int x, int n) {
	      if (n == 0){
	          return 1;
	      }
	    return power(x,n-1) * x;
	  }

}
