package Arrays;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
       	 a[i] = sc.nextInt();
        }
        
        int d = sc.nextInt();
        
        int index = binarySearch(a, n, d);
        System.out.println(index);
        sc.close();
	}

	private static int binarySearch(int[] a, int n, int d) {
		int left = 0;
		int right = n-1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if(a[mid] == d) {
				return mid;
			}else if (d < a[mid]) {
				right = mid - 1;
			} else if (d > a[mid]) {
				left = mid + 1;
			} 
		}
		return -1;
	}

}
