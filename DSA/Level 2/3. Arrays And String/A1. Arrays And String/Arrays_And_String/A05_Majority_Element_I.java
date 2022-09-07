/*

1. Given an array of size 'n'
2. Find Majority element and print it(if exists) otherwise print "No Majority Element exists".
3. Majority element -> if frequency of an element is more than n/2 then that element is exist in majority.

array -> 1   1   2   3   4   1   1   6   1   1
         0   1   2   3   4   5   6   7   8   9
answer -> 1 <- Majority element   

Brute Force :  0 -> Traverse on every element
                    & count its frequency from beginning
Time Complexity : O(n^2)                           

Brute Force :  1. -> HashMap  <Integer Vs Integer>
							  value   Vs Frequency 
					Present    1   -->  increment
					Absent     1   -->  1   
					
			   2. -> Travel on HashMap & check if frequency is greater than n/2  				  

Time Complexity : O(n)
Space Complexity : O(n) 


array -> 1   1   2   3   4   1   1   6   1   1
         0   1   2   3   4   5   6   7   8   9

Pairing of   (1 , 2)   (3 , 4)  (5 , 6)   (6 , 7)   (9 , 9)<--- may be it is majority element
distinct
Element 

Hint: Count Management, if two elements are same hai to count++, if not then count--



*/

package Arrays_And_String;

public class A05_Majority_Element_I {

	// Moore's Voting Algorithm Used
	// We need to do mapping of more than n/2 elements
	// two distinct value ki pair ki mapping krna hai
	public static int validCandidate(int[] arr) {
		int val = arr[0];
		int count = 1;
		
		for(int i = 1; i < arr.length; i++) {
			// if matching element is there then increment the count
			// same element, increment in frequency
			if(val == arr[i]) {
				count++;
				
			}
			else {
				// distinct element, map it with val
				count--;
			}
			
			if(count == 0) {
				val = arr[i];
				count = 1;
			}
		}
		return val;
	}
	
	public static void printMajorityElement(int[] arr) {
		// value have potential candidate for majority
		int value = validCandidate(arr);
		
		// find freq for potential candidate
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == value) {
				count++;
			}
		}
		
		// if potential majority candidates frequency is greater than n/2 then that means 
		// that value is the majority element
		if(count > arr.length/2) {
			System.out.println(value);
			
		}
		else {
			
			System.out.println("No majority element");
		}
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1, 2, 1, 3, 1, 4, 1}; // Ans: 1
		printMajorityElement(arr);
	}

}
