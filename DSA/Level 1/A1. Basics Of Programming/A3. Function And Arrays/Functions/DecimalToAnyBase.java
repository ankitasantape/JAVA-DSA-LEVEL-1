package Functions;

import java.util.Scanner;

public class DecimalToAnyBase {

	public static void main(String[] args) {
	      Scanner scn = new Scanner(System.in);
	      int n = scn.nextInt();
	      int b = scn.nextInt();
	      int dn = getValueInBase(n, b);
	      System.out.println(dn);
	      scn.close();
	   }
	  
	   public static int getValueInBase(int n, int b){
	       int ans = 0;
	       int i = 1;
		   while (n != 0) {
			   
			   int rem = n % b; 
			   ans +=  rem * i;
			   i *= 10;
			   n  = n / b;
		   }
		   return ans;
	   }

}
