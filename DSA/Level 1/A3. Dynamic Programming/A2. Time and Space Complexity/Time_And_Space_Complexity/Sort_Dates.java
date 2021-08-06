package Time_And_Space_Complexity;

import java.util.Scanner;

/*
1. You are given an array(arr) of different dates in format DD-MM-YYYY.
2. You have to sort these dates in increasing order.
Sample Input
5
12041996
20101996
05061997
12041989
11081987
Sample Output
11081987
12041989
12041996
20101996
05061997
 */
public class Sort_Dates {
    
	public static void sortDates(String[] arr) {
		for(int i = 0; i < arr.length; i++) {
//			to sort dates with respect to day
			countSort(arr, 1000000, 100, 32);
//			to sort dates with respect to month
			countSort(arr, 10000, 100, 13);
//			to sort dates with respect to year
			countSort(arr, 1, 10000, 2501);
		}
	}

	public static void countSort(String[] arr, int div, int mod, int range) {
		int freq[] = new int[range];
		// create the frequency array
		for (int i = 0; i < arr.length; i++) {
			int idx = Integer.parseInt( arr[i], 10 )/ div % mod ;
			freq[idx]++;
		}

		// convert frequency array into prefix sum array
		for (int i = 1; i < freq.length; i++) {
			freq[i] = freq[i - 1] + freq[i];
		}

		String ans[] = new String[arr.length];

		// travel from right to left in original array and fill the ans array
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = freq[Integer.parseInt( arr[i], 10 )/ div % mod];
			ans[pos - 1] = arr[i];
			freq[Integer.parseInt( arr[i], 10 )/ div % mod]--;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = ans[i];
		}
		
	}

	public static void print(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			String str = scn.next();
			arr[i] = str;
		}
		sortDates(arr);
		print(arr);
		scn.close();
	}

}
