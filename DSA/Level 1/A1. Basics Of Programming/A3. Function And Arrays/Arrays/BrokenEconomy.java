package Arrays;

import java.util.Scanner;

//Find ceil and floor
public class BrokenEconomy {

	public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int a[] = new int[n];
         for (int i = 0; i < n; i++) {
        	 a[i] = sc.nextInt();
         }
         
         int d = sc.nextInt();
         
         findCeilAndFloor(a, n, d);
         sc.close();
	}

	private static void findCeilAndFloor(int[] a, int n, int d) {
		int left = 0, right = n-1;
		int ceil = -1, floor = -1;
		while(left <= right) {
			int mid = (left + right)/2;
			if (d < a[mid]) {
				right = mid - 1;
				ceil = a[mid];
			} else if (d > a[mid]) {
				floor = a[mid];
				left = mid + 1;
			} else {
				ceil = a[mid];
				floor = a[mid];
				break;
			}
		}
		
			System.out.println(ceil);
			System.out.println(floor);
		
	}

}
