/*
GFG: https://www.geeksforgeeks.org/counting-inversions/

Inversion Count for an array indicates – 
how far (or close) the array is from being sorted. 
If the array is already sorted, then the inversion count is 0, 
but if the array is sorted in the reverse order, 
the inversion count is the maximum. 

Formally speaking, 
two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

Example: 

Input: arr[] = {8, 4, 2, 1}
Output: 6

Explanation: Given array has six inversions:
(8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).


Input: arr[] = {3, 1, 2}
Output: 2

Explanation: Given array has two inversions:
(3, 1), (3, 2) 




arr: 1 2 3 4  -> inversion will be 0

arr: 4 3 2 1  -> inversion will be max




*/

package Searching_And_Sorting;

public class A11_Count_Inversion {

	public static void main(String[] args) {
		int[] arr = {8, 4, 2, 1}; // output: 6
		
		mergeSort(arr, 0, arr.length-1);
		System.out.println(count);
	}

	public static int count = 0;
	private static int[] mergeSort(int[] arr, int lo, int hi) {
		
		if( lo == hi ) {
			int[] ba = new int[1];
			ba[0] = arr[lo];
			return ba;
		}
		
		int mid = (lo + hi)/2;
		// left array ko sort krke lao
		int[] left = mergeSort(arr, lo, mid);
		// right array ko sort krke lao		
		int[] right = mergeSort(arr, mid + 1, hi);
		
		int[] mergedArr = mergeTwoSortedArr(left, right);
				
		return mergedArr;
	}

	private static int[] mergeTwoSortedArr(int[] left, int[] right) {
		
		int[] res = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < left.length && j < right.length) {
			  if( left[i] <= right[j] ) {
				  res[k] = left[i];
				  k++;
				  i++;
			  
			  } else {
				  // left array ke curr element ke right ke sabhi elements inversion krenge krenge with rightArray ke current element ke sath 
				  count += (left.length - i);
				  
				  res[k] = right[j];
				  k++;
				  j++;
			  }
		}
		
		while( i < left.length ) {
			res[k] = left[i];
			k++;
			i++;
		}
		
		while( j < right.length ) {
			res[k] = right[j];
			k++;
			j++;
		}
		return res;
	}

}
