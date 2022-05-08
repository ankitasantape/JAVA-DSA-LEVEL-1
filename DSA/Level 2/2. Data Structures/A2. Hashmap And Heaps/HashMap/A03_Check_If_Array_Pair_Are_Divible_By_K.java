/*
1. You are given an array(arr) of integers and a number K.
2. You have to find if the given array can be divided into pairs such that the sum of every pair is divisible by k.
Input Format
A number N
arr1
arr2.. N numbers
A number K
Output Format
true or false.

Constraints
1 <= N <= 10^6
1 <= arr[i] <= 10^4
1 <= K <= 10^4
Sample Input
4
9 7 5 3
6
Sample Output
true

*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A03_Check_If_Array_Pair_Are_Divible_By_K {

	public static boolean solution(int[] arr, int k){
        HashMap<Integer,Integer>map = new HashMap<>(); //rem vs count
        
        for(int i=0; i < arr.length;i++) {
            int rem = arr[i] % k;
            
            if(rem < 0) {
                rem += k;
            }
            
            if(map.containsKey(rem) == false) {
                map.put(rem,1);
            }
            else {
                int nf = map.get(rem) + 1;
                map.put(rem,nf);
            }
        }
        
        for(int rem : map.keySet()) {
            if(rem == 0 || (k % 2 == 0 && rem == k/2)) {
                int f = map.get(rem);
                
                if(f % 2 == 1) { // if freq odd -> return false
                    return false;
                } 
                else {
                    continue;
                }
            }
            
            int f1 = map.get(rem); // curr element frequency
            int f2 = map.getOrDefault(k - rem, -1); // other frequency
            
            if(f2 == -1 || f1 != f2) { 
                return false;
            }
            
        }
        
        return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		System.out.println(solution(arr,k));
		scn.close();
	}

}
