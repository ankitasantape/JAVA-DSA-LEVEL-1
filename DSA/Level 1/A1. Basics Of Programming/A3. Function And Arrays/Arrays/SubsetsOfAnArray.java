package Arrays;

import java.util.Scanner;

public class SubsetsOfAnArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		printSubsetOfArray(a, n);
		System.out.println("------------------------");
		printSubsets(a,n);
		sc.close();
	}

	private static void printSubsets(int[] a, int n) {
//		total number of subsets
		int tns = (int) Math.pow(2, n);
		
		for (int i = 0; i < tns; i++) {
			int bn = DeciToBin(i, 2);
			int div = (int) Math.pow(10, n-1);
			for (int j = 0; j < n; j++) {
				int q = bn / div;
				int r = bn % div;
				if(q == 1) {
					System.out.print(a[j] +"\t");
				} else {
					System.out.print("-\t");
				}
//				reduce binary num
				bn = r;
//				reduce divisor
				div /= 10;
			}
			System.out.println();
		}
	}
	
	private static void printSubsetOfArray(int[] a, int n) {
//		total number of subsets
		int limit = (int) Math.pow(2, n);

		for (int i = 0; i < limit; i++) {
			String set = "";
			int bn = DeciToBin(i, 2);
			for (int j = n - 1; j >= 0; j--) {
				int r = bn % 10;
				bn = bn / 10;
				if (r == 0) {
					set = "-\t" + set;
//					System.out.println(set);
				} else {
					set = a[j] + "\t" + set;
//					System.out.println(set);
				}
			}
			System.out.println(set);
		}

	}

	public static int DeciToBin(int n, int b) {
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
