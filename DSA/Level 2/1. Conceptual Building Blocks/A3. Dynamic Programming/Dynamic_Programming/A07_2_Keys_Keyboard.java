/*
1. You are given a number N.
2. You have to print exactly N number of 'X' on a notepad by performing the minimum number of operations.
3. Operations allowed are - 
   copyAll -> You can copy all the characters present on the notepad.
   Paste -> You can paste the last copied characters.
4. You have to find the minimum number of operations to get N 'X'.

Note -> Initially, one 'X' is present on the screen.
Input Format
A number
Output Format

Constraints
1 <= N <= 1000
Sample Input
3
Sample Output
3
*/
package Dynamic_Programming;

import java.util.Scanner;

public class A07_2_Keys_Keyboard {
   
	public static int minSteps(int n) {
		
		int ans = 0;
		for(int i = 2; i*i <= n; ) {
			if(n % i == 0) {
				ans += i;
				n /= i;
			} else {
				i++;
			}
		}
		if(n != 1) {
			ans += n;
		}
		return ans;
	}
//	Same as Code Of Prime Factorization 
	public static int solution(int n) {
		int sum = 0;
		for ( int div = 2; div * div <= n; div++) {
			while(n % div == 0) {
				n = n / div;
				sum += div;
				// System.out.print(div+" ");
			}
		}
		if (n != 1) {
// 			System.out.println(n);
            sum += n;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(minSteps(n));
		System.out.println(solution(n));
		scn.close();
	}
}
