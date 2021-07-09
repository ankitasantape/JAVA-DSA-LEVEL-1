package Functions;

import java.util.Scanner;

public class AnyBaseMultiplication {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int b = scn.nextInt();
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();

		int d = getProduct(b, n1, n2);
		System.out.println(d);
		scn.close();
	}

	public static int getProduct(int b, int n1, int n2) {
		 
		int ans = 0;
		int p = 1;
		
		 while ( n2 != 0) {
			 int ld2 = n2 % 10;
			 n2 /= 10;
			 
//			 product with single digit 
			 int pwsd = gpwsd(n1, ld2, b);
			 
//			 ans += pwsd * power; -----> this is wrong
			 
			 ans = aba( ans, pwsd * p, b); 
			 p *= 10;
		 }
		 
	   	 return ans;
	}
	
	public static int aba(int n1, int n2, int b){
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
	
//	n2 is a single digit number
	public static int gpwsd(int n1, int n2, int b) {
		 
		int cy = 0;
		int sum = 0;
		int power = 1;
		
		while(n1 != 0 || cy != 0) {
			int ld1 =  n1 % 10;
			n1 /= 10;
			
			int multi = ld1 * n2 + cy;
			int quo = multi / b;
			int rem = multi % b;
			
			sum += rem * power;
			cy = quo;
			power *= 10;
			
		}
		return sum;
	}
    

}
