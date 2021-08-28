package Dynamic_Programming_Category3;

import java.util.Scanner;

/*
 1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
Input Format
A number n
Output Format
A number representing the number of ways in which the buildings can be built on both side of roads.
Sample Input
6
Sample Output
441
 */
public class Arrange_Buildings {
	 public static void main(String[] args) throws Exception {
		    Scanner sc = new Scanner(System.in);
		    long n = sc.nextInt();
		    count_arrange_buildings(n); 
		    sc.close();
     }

	private static void count_arrange_buildings(long n) {
		long old_count_buildings = 1;
		long old_count_spaces = 1;
		for(int i = 2; i <= n; i++) {
			long new_count_buildings = old_count_spaces;
			long new_count_spaces = old_count_buildings + old_count_spaces;
			
			old_count_buildings = new_count_buildings;
			old_count_spaces = new_count_spaces; 
		}
		System.out.println((old_count_buildings + old_count_spaces)*(old_count_spaces + old_count_buildings));
	}
}
