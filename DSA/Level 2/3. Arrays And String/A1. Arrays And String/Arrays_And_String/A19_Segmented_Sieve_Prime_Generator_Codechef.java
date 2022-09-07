/*

Segmented Sieve

a to b -> print all prime

1. Approach - 0 : Check prime for every number => O(n * sq.root n)

2. Approach - 1 : Generate prime array using sieve 

Constraints -> 1. 1 <= a <= b <= 10^9
               2. b-a <= 10^5
 
3. Approach - 2 : 
   1. What
   2. Why
   3. How  
   4. Complexity        
 
1. What ?

1. lower range = 22, upper range = 51, false -> prime, true -> not prime

(boolean) arr -> b - a + 1 = 51 - 22 + 1 = 30

2. Generate prime from 2 to root.b (using sieve)
    2 to root.51
    2, 3, 5, 7
3. Marking using primes
   -> starting index for every prime number.
   
* figure out how will we get starting index?
  Starting Index of Prime Multiple:      
  Prime -> 2  3  5  7   a = 22, b = 51
  
  22/2 = 11
  22/3 = 7.43 or 7.something
  
  If we do 7.43 * 3 = 22.29, but we want the ceil of 7.43 so will be ceil(7.43) = 8 and we will be doing  8*3 = 24
   
  multiple = ceil( a*1.0 / prime[i] )
  
  m = ceil((22*1.0) / 7) = ceil(22/7) = 3.something = 4
  
  StartingIndex = multiple * prime[i] - a = 4*7 - 22 = 28 - 22 = 6
  
  multiple * prime[i] -> multiple
  a -> Base Value           
  
  
  
  
  

*/


package Arrays_And_String;

import java.util.ArrayList;

public class A19_Segmented_Sieve_Prime_Generator_Codechef {

    private static void segmentedSieveAlgo(int a, int b) {
		
    	// 1. make a root of b
    	int rootb = (int)Math.sqrt(b);
    	boolean[] arr = new boolean[b - a + 1]; // false -> prime, true -> not prime
    	// 2. Get prime till root b using sieve
    	ArrayList<Integer> primes = sieve(rootb);
    	// 3. Marking using prime
    	
    	for(int prime : primes) {
    		// find starting index for marking
    		int multiple = (int)Math.ceil((a * 1.0) / prime);
    		
    		if( multiple == 1 ) {
    			multiple++;
    		}
    		
    		int indx = multiple * prime - a;
    		for(int j = indx; j < arr.length; j += prime) {
    			arr[j] = true;
    		}
    	}
    	
    	
    	for(int i = 0; i < arr.length; i++) {
    		if( arr[i] == false && i + a != 1) {
    			int val = i + a;
    			System.out.println( val );
    		}
    	}
	}

	private static ArrayList<Integer> sieve(int num) {
		
		boolean[] arr = new boolean[num + 1]; // false -> prime, true -> not prime
		
		for(int i = 2; i * i <= arr.length; i++) {
			if( arr[i] == false ) {
				for(int j = 2*i; j < arr.length; j += i) {
					arr[j] = true;
				}
			}
		}
		
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int i = 2; i < arr.length; i++) {
			if( arr[i] == false ) {
				res.add(i);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		
		int a = 22;
		int b = 51; // Ans: 30 
		System.out.println("Prime Numbers: " );
		segmentedSieveAlgo(a, b);
		
	}

}
