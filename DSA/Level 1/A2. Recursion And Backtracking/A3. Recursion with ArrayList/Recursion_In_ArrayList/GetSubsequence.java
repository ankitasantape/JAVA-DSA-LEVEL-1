package Recursion_In_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
/*
 1. You are given a string str.
2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
Use sample input and output to take idea about subsequences.
Sample Input
abc
Sample Output
[, c, b, bc, a, ac, ab, abc]
 */
public class GetSubsequence {

	 public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
         String str = sc.next();
         ArrayList<String> ans = gss(str);
         System.out.print(ans);
         sc.close();
   }

   public static ArrayList<String> gss(String str) {
       if(str.length() == 0){
            ArrayList<String> mr = new  ArrayList<String>();
            mr.add("");
           return mr;
       }
       char ch = str.charAt(0);
       ArrayList<String> rr = gss(str.substring(1));
       ArrayList<String> mr = new  ArrayList<String>();
       for(int i = 0; i < rr.size(); i++){
           mr.add(rr.get(i));
       }
       
        for(int i = 0; i < rr.size(); i++){
           mr.add(ch + rr.get(i));
       }
       
       return mr;
   }

}
