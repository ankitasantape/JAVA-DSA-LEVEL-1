package Recursion;

import java.util.Scanner;

/*
 1. You are given a positive number n. 
2. You are required to print the counting from n to 1 and back to n again.
3. You are required to not use any loops. Complete the body of pdi function to achieve it. Don't change the signature of the function.
 Input Format
A number n
Output Format
n
n - 1
n - 2
..
1
1
2
3
..
n
Sample Input
3
Sample Output
3
2
1
1
2
3

 */
public class PrintIncreasingDecreasing {

	  public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    pdi(n);
	    sc.close();
	  }

	  public static void pdi(int n) {
	    if (n == 0) {
	      return;
	    }
	    System.out.println(n);
	    pdi(n - 1);
	    System.out.println(n);
	  }

}
