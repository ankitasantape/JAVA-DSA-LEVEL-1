package Recursion;

import java.util.Scanner;

/*
1. You are given a number n.
2. You are required to calculate the factorial of the number. Don't change the signature of factorial function.
Sample Input
5

Sample Output
120
*/
public class Factorial {

	 public static void main(String[] args) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        System.out.println(factorial(n));
	        
	        sc.close();
	    }

	    public static int factorial(int n){
	        if(n == 1){
	            return 1;
	        }
	        return factorial(n-1)*n;
	    }
}
