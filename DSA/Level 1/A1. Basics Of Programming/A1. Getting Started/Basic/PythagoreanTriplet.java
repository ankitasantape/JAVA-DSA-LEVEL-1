package Basic;

import java.util.*;
public class PythagoreanTriplet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
//		1. Initially, find the max length of a triangle
		int max = a;
		if (b >= max) {
			max = b;
		}
		if (c >= max) {
			max = c;
		}
//		2. if ( square of max length ) is equal to sum of square of remaining two side
		if (max == a) {
			boolean flag = (((b * b) + (c * c)) == (a * a));
			System.out.println(flag);
		}
		if (max == b) {
			boolean flag = (((a * a) + (c * c)) == (b * b));
			System.out.println(flag);
		}
		if (max == c) {
			boolean flag = (((b * b) + (a * a)) == (c * c));
			System.out.println(flag);
		}
	     sc.close();	
	}

}
