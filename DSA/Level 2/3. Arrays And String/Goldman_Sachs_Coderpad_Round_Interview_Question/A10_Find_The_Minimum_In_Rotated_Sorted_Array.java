package Goldman_Sachs_Coderpad_Round_Interview_Question;

public class A10_Find_The_Minimum_In_Rotated_Sorted_Array {

	public static void main(String[] args) {
		int[] arr = {5, 6, 1, 2, 3, 4};
		System.out.println( find_minimum(arr) );
	}

	private static int find_minimum(int[] arr) {
		int n = arr.length-1;
		int lo = 0;
		int hi = n;
		while( lo < hi ) {
			int mid = ( lo + hi ) / 2;
			
			if( arr[mid] == arr[hi] ) {
				hi--;
			}
			else if( arr[mid] > arr[hi] ) {
				lo = mid + 1;
			}
			else {
				hi = mid;
			}
		}
		return arr[hi];
	}

}
