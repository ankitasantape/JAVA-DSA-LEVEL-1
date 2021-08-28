package Dynamic_Programming_Category3;

import java.util.Scanner;

/*
 1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.
Input Format
A number n
A number k
Output Format
A number representing the number of ways in which the fences could be painted so that not more than two consecutive fences have same colors.
Sample Input
8
3
Sample Output
3672
 */
public class Paint_Fence_leetcode {
     
	public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int k = sc.nextInt();
         paint_fence(n, k);
         sc.close();
    }

	private static void paint_fence(int n, int k) {
		
//		rgb --> repeate me - (eg. r -> rr,g -> gg,b -> bb)
		long same = k * 1;
//		rgb --> choose different options except me (eg. r -> gb, g -> rb, b -> rg)
		long diff = k * (k - 1);
		long total = same + diff;
		
		for(int i = 3; i <= n; i++) {
//			same = diff * 1 -- > jitane bhi diff combinations hai usake last element ko firse multiply kro
			same = diff * 1;  
//			diff = total * ( k - 1 ) --> last combinations se choose any pair whether it is consecutively same or not and it with any other element except that one
			diff = total * ( k - 1 );
			total = same + diff;
		}
		System.out.println(total);
	}
}
