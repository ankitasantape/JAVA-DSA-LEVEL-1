package Arrays;

import java.util.Scanner;

public class BarChart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		
		
		for(int i = 0; i < n; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		
		for (int i = max; i >= 1; i--) {
			for (int j = 0; j < a.length; j++) {
				if(i > a[j]) {
					System.out.print("\t");
				} else {
					System.out.print("*\t");
				}
			}
			System.out.println();
		}
		
		sc.close();
	}

}
