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
    
	  static boolean isOperator(char op)
	  {
	    return (op == '+' || op == '*');
	  }
	 
	  // method prints minimum and maximum value
	  // obtainable from an expression
	 public static int[] solution(String exp) {
	    ArrayList<Integer> num = new ArrayList<>();
	    ArrayList<Character> opr = new ArrayList<>();
	    String tmp = "";
	 
	    //  store operator and numbers in different vectors
	    for (int i = 0; i < exp.length(); i++)
	    {
	      if (isOperator(exp.charAt(i)))
	      {
	        opr.add(exp.charAt(i));
	        num.add(Integer.parseInt(tmp));
	        tmp = "";
	      }
	      else
	      {
	        tmp += exp.charAt(i);
	      }
	    }
	 
	    //  storing last number in vector
	    num.add(Integer.parseInt(tmp));
	 
	    int len = num.size();
	    int[][] minVal = new int[len][len];
	    int[][] maxVal = new int[len][len];
	 
	    //  initializing minval and maxval 2D array
	    for (int i = 0; i < len; i++)
	    {
	      for (int j = 0; j < len; j++)
	      {
	        minVal[i][j] = Integer.MAX_VALUE;
	        maxVal[i][j] = 0;
	 
	        //  initializing main diagonal by num values
	        if (i == j)
	          minVal[i][j] = maxVal[i][j]
	          = num.get(i);
	      }
	    }
	 
	    // looping similar to matrix chain multiplication
	    // and updating both 2D arrays
	    for (int L = 2; L <= len; L++)
	    {
	      for (int i = 0; i < len - L + 1; i++)
	      {
	        int j = i + L - 1;
	        for (int k = i; k < j; k++)
	        {
	          int minTmp = 0, maxTmp = 0;
	 
	          // if current operator is '+', updating
	          // tmp variable by addition
	          if (opr.get(k) == '+')
	          {
	            minTmp = minVal[i][k]
	              + minVal[k + 1][j];
	            maxTmp = maxVal[i][k]
	              + maxVal[k + 1][j];
	          }
	 
	          // if current operator is '*', updating
	          // tmp variable by multiplication
	          else if (opr.get(k) == '*')
	          {
	            minTmp = minVal[i][k]
	              * minVal[k + 1][j];
	            maxTmp = maxVal[i][k]
	              * maxVal[k + 1][j];
	          }
	 
	          //  updating array values by tmp
	          //  variables
	          if (minTmp < minVal[i][j])
	            minVal[i][j] = minTmp;
	          if (maxTmp > maxVal[i][j])
	            maxVal[i][j] = maxTmp;
	        }
	      }
	    }
	 
		int ans[] = new int[2];
		ans[0] = minVal[0][minVal.length - 1];
		ans[1] = maxVal[0][maxVal.length - 1];
		
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
//		int[] arr = solution(str1, str2);
		int[] arr = solution(s); 
		System.out.println("Minimum Value -> " + arr[0]);
		System.out.println("Maximum Value -> " + arr[1]);
		scn.close();
	}
}
