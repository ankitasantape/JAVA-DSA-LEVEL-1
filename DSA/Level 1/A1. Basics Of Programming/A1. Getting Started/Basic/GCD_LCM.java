package Basic;

import java.util.*;
public class GCD_LCM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
         int n1 = sc.nextInt();
         int n2 = sc.nextInt();
         
         int on1 = n1, on2 = n2;
         int rem = n1 % n2;
         while (rem != 0) {
        	 n1 = n2;
        	 n2 = rem;
        	rem = n1 % n2;
         }
         
         int gcd = n2;
         int lcm = (on1 * on2) / gcd;
         
         System.out.println(gcd);
         System.out.println(lcm);
         sc.close();
	}

}
