package Arrays;

import java.util.Scanner;

public class FirstIndexAndLastIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
       	 a[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        
        System.out.println(findFirstIndex(a,n,d));
        System.out.println(findLastIndex(a,n,d));
        sc.close();
	}

	private static int findFirstIndex(int[] a, int n, int d) {
		 int left = 0;
		 int right = n-1;
		 int firstIndex = -1;
		 
		 while (left <= right) {
			 int mid = (left + right)/2;
			 if (a[mid] < d) {
				 left = mid + 1;
				 
			 } else if(a[mid] > d) {
				 right = mid - 1;
			 } else {
				
				 firstIndex = mid;
				 right = mid - 1;;
			 }
		 }
		return firstIndex;
	}

	private static int findLastIndex(int[] a, int n, int d) {
		 int left = 0;
		 int right = n-1;
		 int lastIndex = -1;
		 
		 while (left <= right) {
			 int mid = (left + right)/2;
			 if (a[mid] < d) {
				 left = mid + 1;
				 
			 } else if(a[mid] > d) {
				 right = mid - 1;
			 } else {
				
				 lastIndex = mid;
				 left = mid + 1;
			 }
		 }
		 return lastIndex;
	}

}
