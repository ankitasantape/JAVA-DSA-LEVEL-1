package Basic;

import java.util.*;

public class PrimeFactorizationOfANumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for ( int div = 2; div * div <= n; div++) {
			while(n % div == 0) {
				n = n / div;
				System.out.println(div+" ");
				
//				System.out.print(div+" "+n+" ");
//				System.out.println("r");
			}
		}
		if (n != 1) {
			System.out.println(n);
//			System.out.println("r");
		}
		sc.close();
	}

}
