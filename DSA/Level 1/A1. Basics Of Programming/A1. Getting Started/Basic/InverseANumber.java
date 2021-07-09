package Basic;

import java.util.*;
/*
 Sample Input:   2134
 Sample Output:  1243
 
 Sample Input:   21453
 Sample Output:  23154
     
 */

public class InverseANumber {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 int oriPos = 1;
		 int inverse = 0;
		 while (n > 0) {
			 int oriDig = n % 10;
			 int invPos = oriDig;
			 int invDig = oriPos;
			 
			 inverse += invDig * (int) Math.pow(10, invPos - 1);
			 
//			 Reduce the number
			 n /= 10;
			 
//			 increment oriPos
			 oriPos++;
			 System.out.println(inverse);
		 }
		  
		 System.out.println(inverse);
		 sc.close();
	}

}
