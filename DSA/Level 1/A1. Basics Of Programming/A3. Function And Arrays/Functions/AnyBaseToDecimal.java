package Functions;

import java.util.Scanner;

public class AnyBaseToDecimal {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
	      int n = scn.nextInt();
	      int b = scn.nextInt();
	      int d = getValueIndecimal(n, b);
	      System.out.println(d);
	      scn.close();
	}
	public static int getValueIndecimal(int n, int b){
	    int i = 0; 
	    int ans = 0;
		while (n != 0) {
			int rem = n % 10;
			ans += rem * Math.pow(b, i);
			n = n / 10;
			i++;
		}
		return ans;
	}

}
