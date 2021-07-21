package Strings;

/*
 1. You are given a string. 
2. You have to print all permutations of the given string iteratively.
Input Format
A String
Output Format
All permutations of the given string(one in a line). 
Sample Input
abc
Sample Output
abc
bac
cab
acb
bca
cba

 */
import java.util.Scanner;

public class PrintAllPermutationsOfAStringIterative {
	
	public static void solution(String str){
		int tnp = 1;
		for(int i = 1; i <= str.length(); i++) {
			tnp *= i;
		}
		for(int i = 0; i < tnp; i++) {
			int div = str.length();
			int dvd = i;
//			every time we need same string 
			StringBuilder ans = new StringBuilder(str);
		    while(div != 0) {
		    	int rem = dvd % div;
				dvd = dvd / div;
				System.out.print(ans.charAt(rem));
				ans.deleteCharAt(rem);
				div--;
			}
		     System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

}
