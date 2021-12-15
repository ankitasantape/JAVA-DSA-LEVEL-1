/*
1. You are given two integers n and k, where n represents number of elements and k represents 
     number of subsets.
2. You have to partition n elements in k subsets and print all such configurations.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
A number k
Output Format

Constraints
1 <= n <= 10
1 <= k <= 10
Sample Input
3
2
Sample Output
1. [1, 2] [3] 
2. [1, 3] [2] 
3. [1] [2, 3] 
*/
package Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class A29_K_Partitions {
	static int counter = 1;
    // rssf = room selected so far
	public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {  
//		
		if(i == n + 1) {
//			jb sare hi set fill ho jayenge tb sare hi set ko print kr denge
			if(rssf == k) {
				System.out.print(counter + ".");
				for(ArrayList<Integer> list : ans) {
					System.out.print(list + " ");
				}
				System.out.println();
				counter++;
			}
			return;
		}
		
		for(int j = 0; j <= rssf && j < k; j++) {
//	    	if size of set is greater than 0 means non-empty set does exist
			if(ans.get(j).size() == 0) {
//	    		add element into already existing non-empty set
				ans.get(j).add(i);
				solution(i + 1, n, k, rssf + 1, ans);
				ans.get(j).remove(ans.get(j).size() - 1);
			}
			else {
//	    		 if set is empty then add first element into empty set which will make new non-empty relevant set
				ans.get(j).add(i);
				solution(i + 1, n, k, rssf, ans);
				 // arraylist heap me store rehata hai to wapas aate wakt hume khudse removal krna padega
				ans.get(j).remove(ans.get(j).size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);
		scn.close();

	}
}
