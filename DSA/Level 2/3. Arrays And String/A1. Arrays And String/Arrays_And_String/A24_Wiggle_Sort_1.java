/*

1. Given an unsorted array 'arr'.
2. Reorder it in-place such that :  arr[0] <= arr[1] >= arr[2] <= arr[3] . . . .
3. Please sort the array in place and do not define additional arrays.
4. Allowed Time Complexity : O(n)

Input Format
Input: [3, 5, 2, 1, 6, 4]
Output Format
Output: [1, 6, 2, 5, 3, 4]

*/

package Arrays_And_String;

public class A24_Wiggle_Sort_1 {

	public static void wiggleSort(int[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(i % 2 == 0) {
				// even index
				if( arr[i] > arr[i + 1] ) {
					swap(arr, i , i + 1);
				}
			}
			else {
				// odd index
				if( arr[i] < arr[i + 1] ) {
					swap(arr, i , i + 1);
				}
			}
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

	public static void main(String[] args) {
		
		// int[] arr = {3, 5, 2, 1, 6, 4};
		
		int[] arr = {1, 5, 1, 6, 4}; // Ans: {1, 6, 4, 1, 5}

		wiggleSort(arr);

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}


}
