package Arrays;

import java.util.Scanner;

/*
input
4
10 20 30 40
output
10	
10	20	
10	20	30	
10	20	30	40	
20	
20	30	
20	30	40	
30	
30	40	
40	

*/

public class SubarrayProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		subarrayProblem(a, n);
		sc.close();
	}
	
	public static void subarrayProblem(int a[], int n) {
		   
		for (int si = 0; si < n; si++) {
			for(int ei = si; ei < n; ei++) {
				for (int k = si; k <= ei; k++) {
					System.out.print(a[k] + "\t");
				}
				System.out.println();
			}
		}
	}

}
