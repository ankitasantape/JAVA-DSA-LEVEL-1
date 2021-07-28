package Recursion_On_The_Way_Up;

import java.util.Scanner;

/*
 1. You are given a string str.
2. Complete the body of printSS function - without changing signature - to calculate and print all subsequences of str.
Use sample input and output to take idea about subsequences.
Input Format
A string str
Output Format
Subsequences of str in order hinted by Sample output
Sample Input
yvTA

Sample Output
yvTA
yvT
yvA
yv
yTA
yT
yA
y
vTA
vT
vA
v
TA
T
A
 */
public class Print_Subsequences {
  public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
         String str = sc.next();
         printSS(str, "");
         sc.close();
  }

  public static void printSS(String str, String ans) {
      if(str.length() == 0){
          System.out.println(ans);
          return;
      }
      char ch = str.charAt(0);
      String rs = str.substring(1);
      printSS(rs, ans + ch);
      printSS(rs, ans);
  }

}
