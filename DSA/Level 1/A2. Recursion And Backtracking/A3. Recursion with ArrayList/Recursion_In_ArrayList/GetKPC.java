package Recursion_In_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
/*
Sample Input
78
Sample Output
[tv, tw, tx, uv, uw, ux]

 */
public class GetKPC {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> ans = getKPC(str);
        System.out.print(ans);
        sc.close();
    }
    static String[] codes = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"}; 
    public static ArrayList<String> getKPC(String str) {
    	if(str.length() == 0){
            ArrayList<String> mr = new  ArrayList<String>();
            mr.add("");
           return mr;
       }
       char ch = str.charAt(0);
       ArrayList<String> rr = getKPC(str.substring(1));
       ArrayList<String> mr = new  ArrayList<String>();
//       for(int i = 0; i < rr.size(); i++){
//           mr.add(rr.get(i));
//       }
       
       String codeforch = codes[ch - '0' ];
       for(int i = 0; i < codeforch.length(); i++){
    	   char chcode = codeforch.charAt(i);
    	   for(String rstr : rr) {
    		   mr.add( chcode + rstr);
    	   }
           
       }
       
       return mr;
    }
}
