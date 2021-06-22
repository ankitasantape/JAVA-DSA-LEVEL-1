package Basic;

import java.util.Scanner;

public class PrintAllPrimesTillN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int low = scn.nextInt();
		int high = scn.nextInt();

		for (int n = low; n <= high; n++) {
			int factors = 0;
			for (int i = 2; i*i <= n; i++) {
				if (n % i == 0) {
					factors++;
					break;
				}
			}
			if (factors == 0) {
				System.out.println(n);
			}
		}

		scn.close();
	}

}
