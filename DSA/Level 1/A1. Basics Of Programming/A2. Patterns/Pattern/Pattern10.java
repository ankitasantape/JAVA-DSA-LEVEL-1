package Pattern;

import java.util.Scanner;

public class Pattern10 {

	public static void main(String[] args) {
           Scanner scn = new Scanner(System.in);
           int n = scn.nextInt();
           
           int insp = -1;
           int outsp = n/2; 
           for (int i = 1; i <= n; i++) {
        	   for (int j = 1; j <= outsp; j++) {
        		   System.out.print("\t");
        	   }
        	   System.out.print("*\t");
        	   
        	   for (int j = 1; j <= insp; j++) {
        		   System.out.print("\t");
        	   }
        	   if (i > 1 && i < n) {
        		   System.out.print("*\t"); 
        	   }
        	  
        	   System.out.println();
        	   if(i <= n/2) {
        		   outsp--;
        		   insp += 2;
        	   } else {
        		   outsp++; 
        		   insp -= 2;
        	   }
        	  
           }
           scn.close();
	}

}
