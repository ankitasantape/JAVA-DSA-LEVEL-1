/*000000
1. You are given an array(arr) of integers and a number K.0
2. You have to find the count of distinct numbers in all windows of size k.

Constraints
1 <= N <= 10^5
1 <= arr[i] <= 10^4
1 <= k <= N

Format
Input
A number N
arr1
arr2.. N numbers
A number K

Output
Space separated numbers representing the count of distinct numbers in all windows of size k.

Example
Sample Input

7
1 2 1 3 4 2 3        
4

Sample Output
3 4 4 3 

*/

package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class A04_Count_Distinct_Elements_In_Every_Window_Of_Size_K {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int i;
		for( i=0; i < k-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		for(int j=0; i < arr.length; i++,j++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			ans.add( map.size() );
			if( map.containsKey(arr[j])  ) {
				if( map.get(arr[j]) == 1 ) {
					map.remove(arr[j]);
				} else {
					map.put(arr[j], map.get(arr[j])-1);
				}
			} else {
				map.put(arr[i], 1);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
		scn.close();
	}

}
