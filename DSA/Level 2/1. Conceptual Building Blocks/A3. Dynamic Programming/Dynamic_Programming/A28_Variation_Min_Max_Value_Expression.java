/*
1. You are given a string that represents an expression containing numbers and two operators + and *.
2. You have to find the minimum and maximum value which can be obtained by evaluating this expression by different parenthesization.
Input Format
A string
Output Format
Constraints
1 <= length of string <= 100
Range of numbers -> [0,9]
Sample Input
1+2*3+4*5
Sample Output
Minimum Value -> 27
Maximum Value -> 105

*/
package Dynamic_Programming;


import java.util.ArrayList;
import java.util.Scanner;

public class A28_Variation_Min_Max_Value_Expression {
    
	  public static int[] solution1(String str, String optr) {
			int[][] maxVal = new int[str.length()][str.length()];
			int[][] minVal = new int[str.length()][str.length()];
			for(int i=0; i < maxVal.length; i++){
			    for(int j=i; j < maxVal.length; j++){
			        maxVal[i][j] = Integer.MIN_VALUE;
			    }
			}
			for(int i=0; i < minVal.length; i++){
			    for(int j=i; j < minVal.length; j++){
			        minVal[i][j] = Integer.MAX_VALUE;
			    }
			}
			
			for(int g=0; g<str.length(); g++){
			    for(int i=0, j=g; j<str.length(); i++,j++){
			        if( g==0 ){
			            int val = str.charAt(i) - '0';
			            maxVal[i][j] = Math.max( Integer.MIN_VALUE, val);
			            minVal[i][j] = Math.min( Integer.MAX_VALUE, val);
			        } else {
			            for(int k=i; k<j; k++){
			                char op = optr.charAt(k);
			                int lminv = minVal[i][k];
			                int rminv = minVal[k+1][j];
			                int lmaxv = maxVal[i][k];
			                int rmaxv = maxVal[k+1][j];
			                if( op == '+' ){
			                    maxVal[i][j] = Math.max(maxVal[i][j], lmaxv + rmaxv);
			                    minVal[i][j] = Math.min(maxVal[i][j], lminv + rminv);
			                } else if( op == '*' ){
			                    maxVal[i][j] = Math.max(maxVal[i][j], lmaxv * rmaxv);
			                    minVal[i][j] = Math.min(minVal[i][j], lminv * rminv);
			                } 
			            }
			        }
			    }
			}
	        int[] ans = new int[2];
	        ans[0] = minVal[0][str.length()-1];
	        ans[1] = maxVal[0][str.length()-1];
			return ans;
		}	 
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '+' || ch == '*') {
				str2 += ch;
			} else {
				str1 += ch;
			}
		}
		int[] arr1 = solution1(str1, str2);
		System.out.println("Minimum Value -> " + arr1[0]);
		System.out.println("Maximum Value -> " + arr1[1]);
		scn.close();
	}
}
