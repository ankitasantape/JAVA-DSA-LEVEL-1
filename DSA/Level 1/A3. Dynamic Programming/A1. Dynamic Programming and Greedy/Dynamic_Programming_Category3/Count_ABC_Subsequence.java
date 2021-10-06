package Dynamic_Programming_Category3;

import java.util.Scanner;

/*
1. You are given a string str.
2. You are required to calculate and print the count of subsequences of the nature a+b+c+.
For abbc -> there are 3 subsequences. abc, abc, abbc
For abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
Sample Input : 
abcabc

Sample Output:
7
*/
public class CountABCSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int a = 0;
		int ab = 0;
		int abc = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if( ch == 'a' ) {
//why are we multiplying with 2 becoz 'a' has 2 choices either 'a' can attach itself with 'a' or not [ a, aa' ] => that's why 2 * a and a' itself that's why we add 1
				a = 2 * a + 1;
			} 
			else if ( ch == 'b' )
			{
				ab = 2 * ab + a;
			}
			else if( ch == 'c' ) {
				abc = 2 * abc + ab;
			}
		}
        System.out.println( abc );
        sc.close();
	}

}
