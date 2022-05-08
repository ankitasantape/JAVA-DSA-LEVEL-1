/*
1. You are given number N and 2*N number of strings that represent a list of N tickets(source and destination).
2. You have to find the itinerary in order using the given list of tickets.

Assumption -> The input list of tickets is not cyclic and there is one ticket from every city except the final destination.
Input Format
A number N
N number of lines, where each line contains 2 strings.
Constraints
1 <= N <= 100
Sample Input
4
Chennai Banglore 
Bombay Delhi 
Goa Chennai 
Delhi Goa 
Sample Output
Bombay -> Delhi -> Goa -> Chennai -> Banglore.
*/

package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class A02_Find_Itinery_From_Tickets {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		//write your code here
		HashMap<String, Boolean> stpt = new HashMap<>();
		for(String src : map.keySet()) {
			 String dest = map.get(src);
			 
			 stpt.put(src, stpt.getOrDefault(src, true));
			 stpt.put(dest, false);
		}
		
		String city = "";
		for(String sp : stpt.keySet()) {
			if( stpt.get(sp) == true ) {
				city = sp;
				break;
			}
		}
		
		while( map.containsKey(city) ) {
			System.out.print( city + " -> " );
			city = map.get(city);
		}
		System.out.print( city + "." );
		scn.close();
	}

}
