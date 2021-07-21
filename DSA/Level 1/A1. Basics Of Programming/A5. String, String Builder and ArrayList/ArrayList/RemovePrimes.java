package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

/*
 1. You are given an ArrayList of positive integers.
2. You have to remove prime numbers from the given ArrayList and return the updated ArrayList.

Note -> The order of elements should remain same.
Input Format
A number N
arr1
arr2.. N numbers
Output Format
An Arraylist
Sample Input
4
3 12 13 15
Sample Output
[12, 15]
 */
public class RemovePrimes {

	public static void solution(ArrayList<Integer> al){
		
		
		for(int i = al.size()-1; i >= 0 ; i--){
		    if(isPrime(al.get(i))){
		        al.remove(i);
		    }
		}
		
	}
	
	public static boolean isPrime(int n){
	    boolean isPrime = true;
	    for(int i = 2; i * i <= n; i++){
	        if(n % i == 0){
	            isPrime = false;
	            break;
	        }
	    }
	    return isPrime;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0 ; i < n; i++){
			al.add(scn.nextInt());
		}
		solution(al);
		System.out.println(al);
		scn.close();
	}

}
