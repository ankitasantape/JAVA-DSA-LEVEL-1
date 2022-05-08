/*
1. You are given an array of N elements.
 2. You are also given a number K.
 3. You have to find the maximum length of a subarray whose sum is equal to K.
 4. For example:
 Input: arr = [3, 4, 2, 7, 1, 8] and K = 9
 Output: 3
 Explanation:
 The subarrays with sum = 9 are:
 [3, 4, 2] , [2, 7] and [1, 8]
 The subarray with maximum length is [3, 4, 2] and its length is 3. 
 5. display is a utility function, feel free to use it for debugging purposes.
 6. main takes input from the users and creates the array.
 7. This is a functional problem. 
 8. You have to complete the maxLenSubarray function. It takes as input an array and K. It should return the maximum length of subarray whose sum is K. If no such subarray, it should return 0.
 9. Don't change the code of main and display.
Input Format
First line takes input N, the length of the array.
 Second line takes input N space separated numbers representing the elements of the array.
 Third line takes input K.
 Input is handled for you.
Output Format
Maximum length of subarray whose sum is K if present, else 0.
Output is handled for you.
 
Constraints
1 <= N <= 30000
Sample Input
6
3 4 2 7 1 8
9
Sample Output
3
*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A09_Maximum_Size_Subarray_Sum_Equals_K {

	 // This is a functional problem. You have to complete this function.
    // It takes as input an array and K.
    // It should return the length of maximum subarray whose sum is K. If no such subarray, return 0.
    public static int maxLenSubarray(int[] nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<>();
		int i = -1;
		int maxlength = 0;
		int sum = 0;
		map.put(sum, i);
		while(i < nums.length-1) {
			i++;
			sum += nums[i];
			int sum_minus_k = sum - k;
			
			if( map.containsKey(sum_minus_k) == true ) {
				int sum_minus_k_idx = map.get(sum_minus_k);
				maxlength = Math.max(maxlength, i - sum_minus_k_idx);
			}
			if( map.containsKey(sum) == false ) {
				map.put(sum, i);
			}
		}
		return maxlength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for length of first array.
        int N = sc.nextInt();

        int[] arr1 = new int[N];

        // Input for array1 elements.
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        int result = maxLenSubarray(arr1, K);

        System.out.println(result);
        sc.close();

    }

    // Function to display an array.
    public static void display(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
