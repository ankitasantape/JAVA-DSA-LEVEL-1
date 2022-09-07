/*
 Perform the following 3 operations:
 a) Sort the students in Ascending order of their Physics marks.
 b) Once this is done, sort the students having same marks in Physics in the descending order of their Chemistry marks.
 c) Once this is also done, sort the students having same marks in Physics and 
 Chemistry in the ascending order of their Maths marks.
 
 n = 5
         s1      s2      s3      s4     s5   
 phy     9        5       9      8       5
 
 chem    3        4       3      7       6   
 
 math    15       10      11     13      12 
 
 
 
 a) Sort the students in Ascending order of their Physics marks.
 phy  5  5  8  9  9   
 b) Once this is done, sort the students having same marks in Physics in the descending order of their Chemistry marks.
 chem 6  4  7  3  3 
 c) Ascending order of their Maths marks
 math 12 10 13 11 15  
 
 s5   5   6   12
 
 s2   5   4   10
 
 s4   8   7   13
 
 s3   9   3   11
 
 s1   9   3   15
 
 */

package Searching_And_Sorting;

import java.util.Arrays;

public class A01_Marks_Of_PCM {

	public static class Marks implements Comparable<Marks>{
		int phy;
		int chem;
		int math;
		
		public Marks() {

		}

		public Marks(int phy, int chem, int math) {
			
			this.phy = phy;
			this.chem = chem;
			this.math = math;
		}
		
		public int compareTo(Marks o) {
			// jisake phy ke marks less hai usko pehle likhenge
			if( this.phy != o.phy ) {
				return this.phy - o.phy; // -ve result will come out means Ascending
			
			} else if( this.chem != o.chem ) { // this.chem > o.chem -> o.chem - this.chem -> -ve descending 
				return o.chem - this.chem; // 
			
			} else {
				return this.math - o.math;
			}
		}
		
	}
	
	public static void customSort(int[] phy, int[] chem, int[] math) {
		int n = phy.length;
		
		Marks[] arr = new Marks[n];
		
		// fill this array
		for(int i = 0; i < n; i++) {
			arr[i] = new Marks(phy[i], chem[i], math[i]);
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {
			phy[i] = arr[i].phy;
			chem[i] = arr[i].chem;
			math[i] = arr[i].math;
		}
	}
	
	public static void main(String[] args) {
		
		int[] phy = {9, 5, 9, 8, 5};
		int[] chem = {3, 4, 3, 7, 6};
		int[] math = {15, 10, 11, 13, 12};
		
		customSort(phy, chem, math);
		
		for(int i = 0; i < phy.length; i++) {
			System.out.print(phy[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < chem.length; i++) {
			System.out.print(chem[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < math.length; i++) {
			System.out.print(math[i] + " ");
		}
		System.out.println();
		
	}

}
