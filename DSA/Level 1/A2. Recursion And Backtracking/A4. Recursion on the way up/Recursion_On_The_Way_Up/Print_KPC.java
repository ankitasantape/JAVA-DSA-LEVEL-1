package Recursion_On_The_Way_Up;


import java.util.Scanner;

/*
 1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
2. The following list is the key to characters map
    0 -> .;
   1 -> abc
   2 -> def
   3 -> ghi
   4 -> jkl
   5 -> mno
   6 -> pqrs
   7 -> tu
   8 -> vwx
   9 -> yz
3. Complete the body of printKPC function - without changing signature - to print the list of all words that could be produced by the keys in str.
Use sample input and output to take idea about output.
Input Format
A string str
Output Format
Words that can be produced by pressed keys indictated by str in order hinted by Sample output
Sample Input
78
Sample Output
tv
tw
tx
uv
uw
ux
 */
public class Print_KPC {
   
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        String str = sc.next();
        printKPC(str, "");
        sc.close();
    }
	static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"}; 
	   
    public static void printKPC(String str, String asf) {
    	if(str.length() == 0){
           System.out.println(asf);
           return;
       }
       char ch = str.charAt(0);  // str = 78   ch = 7  8
       
       String codeforch = codes[ch - '0' ];  // codes[7] = {"tu"} codes[8] = {"vwx"}
       for(int i = 0; i < codeforch.length(); i++){  // for i = 0 to 1 i = 1  ----> i = 0 to 2  i = 1 i = 2
    	   char chcode = codeforch.charAt(i);   //ch = 7 chcode = t u  ch = 8   chcode = v   w     x  
    	   printKPC(str.substring(1),asf + chcode);     // asf = "" + t = t   asf = t + v = tv, asf = t + w = tw, asf = t + x = tx  asf = uv asf = uw asf = ux
           
       }
       
    }
}
