package Functions;

import java.util.Scanner;

public class AnyBaseAddition {

	public static void main(String[] args) {
	      Scanner scn = new Scanner(System.in);
	      int b = scn.nextInt();
	      int n1 = scn.nextInt();
	      int n2 = scn.nextInt();
	  
	      int d = getSum(b, n1, n2);
	      System.out.println(d);
	      int d1 = getSum1(b, n1, n2);
	      System.out.println(d1);
	      scn.close();
	   }
	  
	   public static int getSum(int b, int n1, int n2){
		   int sum = 0, i = 1, cy = 0, digit = 0;
			do
			{
				digit = (n1 % 10) + (n2 % 10)+ cy;
				//cy = ((n1 % 10) + (n2 % 10)) / b;
				
				if( digit > b-1)
				{
					cy = 1;
					digit = digit % b;
				} 
				else 
				{
					cy = 0;
				}
				sum += digit * i;
				i *= 10;
				n1 /= 10;
				n2 /= 10;
			} while(n1 != 0 || n2 != 0 || cy != 0 );
			
			return sum;
	   }
	   
	   public static int getSum1(int b, int n1, int n2){
	       int sum = 0, cy = 0, power = 1;
	       
	       while(n1 != 0 || n2 != 0 || cy != 0){
	           int l1 = n1 % 10;
	           int l2 = n2 % 10;
	           n1 = n1 / 10;
	           n2 = n2 / 10;
	           
	           int digit = l1 + l2 + cy;
	           int rem = digit % b;
	           int q = digit / b;
	           
	           sum += rem * power;
	           power *= 10;
	           cy = q;
	       }
	       
	       return sum;
	   }

}
