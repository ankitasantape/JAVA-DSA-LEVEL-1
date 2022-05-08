/*
1. There are some rabbits in the forest and each rabbit has some color.
2. Some(possibly all) rabbits are selected from them and they tell you about the number of other rabbits having the same color as them.
3. You are given an array(arr) that contains the answers of all selected rabbits.
4. You have to find the minimum number of rabbits that could be in the forest.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
A number representing the minimum number of rabbits in the forest.
Constraints
1 <= N <= 1000
0 <= arr[i] <= 1000
Sample Input
5
1 0 1 0 0
Sample Output
5

*/
package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A18_Rabbits_In_The_Forest {
    
	public static int solution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < arr.length; i++) {
        	map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int mr = 0;
        
        for(int key : map.keySet()) {
        	int val = map.get(key);
        	int gs = key + 1;
        	mr += Math.ceil( val * 1.0 / gs ) * gs;
        }
        return mr;
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
		scn.close();
	}
}
