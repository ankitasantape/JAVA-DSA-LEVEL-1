package Recursion_On_The_Way_Up;

import java.util.Scanner;

/*
 1. You are given a string str.
2. Complete the body of printPermutations function - without changing signature - to calculate and print all permutations of str.
Use sample input and output to take idea about permutations.
Input Format
A string str
Output Format
Permutations of str in order hinted by Sample output
Sample Input
abc
Sample Output
abc
acb
bac
bca
cab
cba 
 */
public class Print_Permutation {

	public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        String str = sc.next();
        printPermutations(str, "");
        sc.close();
	}

	public static void printPermutations(String str, String asf) {
        if(str.length() == 0) {
        	System.out.println(asf);
        	return;
        }
		for(int i = 0; i < str.length(); i++) {
			 char ch = str.charAt(i);
			 String lpart = str.substring(0, i);
			 String rpart = str.substring(i+1);
			 printPermutations(lpart + rpart, asf + ch ); 
		}
		
		 
		 
	}

}
