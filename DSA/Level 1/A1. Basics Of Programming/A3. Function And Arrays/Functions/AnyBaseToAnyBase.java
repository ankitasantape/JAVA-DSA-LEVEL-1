package Functions;

import java.util.Scanner;

public class AnyBaseToAnyBase {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
	      int n = scn.nextInt();
	      int sourceBase = scn.nextInt();
	      int  destBase = scn.nextInt();
	      
	      int getValueInDecimal = AnyBaseToDecimal(n, sourceBase);
	      int getValueInAnyBase = DecimalToAnyBase(getValueInDecimal,destBase );
	      System.out.println(getValueInAnyBase);
	      scn.close();
	}
	
	public static int AnyBaseToDecimal(int n, int b) {
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

	public static int DecimalToAnyBase(int n, int b) {
		int ans = 0;
		int i = 1;
		while (n != 0) {

			int rem = n % b;
			ans += rem * i;
			i *= 10;
			n = n / b;
		}
		return ans;
	}

}
