/*
1. You are given a number n.
2. Print the number produced on setting its i-th bit.
3. Print the number produced on unsetting its j-th bit.
4. Print the number produced on toggling its k-th bit.
5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.
Input Format
A number
Four numbers i,j,k,m.
Output Format
Check the sample ouput and question video.
Constraints
1 <= n <= 10^9
1 <= i <= 9
1 <= j <= 9
1 <= k <= 9
1 <= m <= 9
Sample Input
57
3 
3 
3 
3
Sample Output
57
49
49
true  
*/
package Bit_Manipulation;

import java.util.Scanner;

public class A01_Basics_Of_Bit_Manipulation {
     
	 public static void main(String[] args){
		    Scanner scn = new Scanner(System.in);
		    int n = scn.nextInt();
		    int i = scn.nextInt();
		    int j = scn.nextInt();
		    int k = scn.nextInt();
		    int m = scn.nextInt();
		    
		    //write your code here
		    int on_m =  ( 1 << i ); // set the bit
		    int off_m = ~( 1 << j ); // unset the bit 
		    int togggle_m =  ( 1 << k ); // toggle the bit
		    int check_m =  ( 1 << m );
		    		
		    System.out.println(n | on_m);
		    System.out.println(n & off_m);
		    System.out.println(n ^ togggle_m);
		    System.out.println( (n & check_m) == 0 ? false : true);
		    scn.close();
	}
}
