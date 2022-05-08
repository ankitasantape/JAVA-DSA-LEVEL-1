/*
1. You are given an array(arr) of integers.
2. You have to find if the elements of the given array can be arranged to form an arithmetic progression.
3. Arithmetic progression is defined as a sequence of numbers where the difference between any two consecutive numbers is the same. 

Note -> Try to solve this in linear time complexity.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
true/false
Constraints
1 <= N <= 10^6
1 <= arr[i] <= 10^3
Sample Input
3
3 5 1
Sample Output
true
Sample Input
7
1 11 5 9 3 7 13
Sample Output
true
Sample Input
100
62 18 25 31 57 40 17 37 45 100 57 30 19 16 26 38 15 26 69 47 52 63 74 11 25 25 20 74 81 17 83 78 12 71 93 81 88 17 36 42 99 95 35 18 78 15 13 80 89 81 96 91 65 55 85 15 44 23 58 52 56 22 52 45 37 13 81 25 31 79 47 61 90 16 10 71 84 21 39 32 29 72 30 90 37 17 43 27 90 38 38 91 90 23 69 91 37 31 51 94
Sample Output
true

Sample Input
4
4 4 4 4
Sample Output


Sample Input
5
9 10 10 10 19
Sample Output

*/

package HashMap;

import java.util.HashSet;
import java.util.Scanner;

public class A17_Check_Arithmetic_Sequence {

	public static boolean solution(int[] arr) {
		HashSet<Integer> set = new HashSet<>();

		int min = Integer.MAX_VALUE;
		int smin = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				smin = min;
				min = arr[i];
			} else if (arr[i] < smin) {
				smin = arr[i];
			}
			set.add(arr[i]);
		}
		int cd = smin - min;
		if (cd == 0) {
			return set.size() == 1;
		}
		int term = min;

		for (int i = 0; i < arr.length; i++) {
			if (set.contains(term) == false) {
				return false;
			}
			term = term + cd;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
		scn.close();
	}

}
