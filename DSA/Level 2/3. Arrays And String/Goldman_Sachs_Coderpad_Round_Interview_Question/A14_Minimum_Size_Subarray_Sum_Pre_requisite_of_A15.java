package Goldman_Sachs_Coderpad_Round_Interview_Question;

public class A14_Minimum_Size_Subarray_Sum_Pre_requisite_of_A15 {

	public static void main(String[] args) {
		int arr[] = {2, 3, 1, 2, 4, 3};
		int tar = 7;
		
		int ans = minimumSizeSuarraySum(arr, tar);
		System.out.println(ans);
	}

	private static int minimumSizeSuarraySum(int[] arr, int tar) {
		int n = arr.length;
		int res = Integer.MAX_VALUE;
		
		int left = 0;
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += arr[i];
			 while( sum >= tar ) {
				 res = Math.min(res, i + 1 - left);
				 sum -= arr[left++];
			 }
		}
		
		return (res != Integer.MAX_VALUE) ? 0 : res;
	}

}
