/*
Sample Input
n = 6
arr : 5 2 3 80 5 20
diff = 17
Sample Output
3 20

After sorting : 2 3 5 5 20 80
i = 0, j = 1 
( arr[j] - arr[i] == 17 )
    3 - 2 = 1 < 17  j++ = 2
    5 - 2 = 3 < 17  j++ = 3
    5 - 2 = 3 < 17  j++ = 4
   20 - 2 =18 > 17  i++ = 1
   20 - 3 =17 = 17  print arr[i] : 3, arr[j] = 20 return

Sample Input
n = 6
arr : 5 2 3 80 5 20
diff = 9
Sample Output
-1

*/


package Searching_And_Sorting;

import java.util.Arrays;

public class A08_Find_Pair_With_Given_Difference {

	public static void main(String[] args) {
		
		int[] arr = { 5, 2, 3, 80, 5, 20 };
		int diff = 9;
		findPair( arr, diff);
	}

	private static void findPair(int[] arr, int diff) {
		Arrays.sort(arr);
		
		int i = 0;
		int j = 1;
		
		while(i < arr.length && j < arr.length) {
			if( arr[j] - arr[i] == diff ) {
				System.out.println(arr[i] + " " + arr[j]);
				return;
			}
			else if(arr[j] - arr[i] < diff) {
				j++;
			}
			else {
				i++;
			}
		}
		System.out.println("-1");
	}

}
