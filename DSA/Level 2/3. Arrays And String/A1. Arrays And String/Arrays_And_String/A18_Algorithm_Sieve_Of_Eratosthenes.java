/*

Sieve Of Eratosthenes

Complete    array(isprime)
            length = n
i = 2        n/2 times will run

i = 3        n/3 times will run

i = 4         -

i = 5         n/5

i = 6         -
 
      ___       /  ___
i = \/ n     n / \/ n   
													__	
Total Iteration = ( n/2 + n/3 + n/5 + ...... + n/ \/n  )
                                                      ___
                = n ( 1/2 + 1/3 + 1/5 + ..... + 1 / \/ n )


Convergence - divergence
  ___
\/ n
-----
\           1
/         --------------  = log( log ( n ) )
-----      prime number
i = 1



*/


package Arrays_And_String;

import java.util.Arrays;

public class A18_Algorithm_Sieve_Of_Eratosthenes {

    private static void printPrimeUsingSieve(int n) {
		boolean[] isprime = new boolean[n + 1];
		
		// initially mark every element as true means they are prime number
		Arrays.fill(isprime, true);
		
		for(int i = 2; i * i <= isprime.length; i++ ) {
			if( isprime[i] == true ) {
				// mark multiples of i as not prime
				// you can write it as i+i or i*2
				for(int j = i + i; j < isprime.length; j += i) {
					isprime[j] = false; // not prime
				}
			}
		}
		
		// print all prime till n
		for(int i = 2; i < isprime.length; i++) {
			if( isprime[i] == true ) {
				System.out.println(i + " ");
			}
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		
		int n = 9;
		printPrimeUsingSieve(n);
		
	}
}
