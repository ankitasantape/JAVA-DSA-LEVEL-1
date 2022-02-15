/*
1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "tar" or not.
5. Also, you have to print the indices of elements that should be selected to achieve the given target.
6. You have to print all such configurations.
Input Format
A number n
n1
n2
.. n number of elements
A number tar
Output Format

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= tar <= 50
Sample Input
5
4
2
7
1
3
10
Sample Output
true
2 4 
1 2 3 
0 1 3 4 
*/

package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A05_Print_All_Paths_With_Target_Sum_Subset {
    
	public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        boolean dp[][] = new boolean[n + 1][tar + 1];
        
        for(int i = 0; i < dp.length; i++) {
        	for(int j = 0; j < dp[0].length; j++) {
        		if(i == 0 && j == 0) {
        			dp[i][j] = true;
        		} else if(i == 0) {
        			dp[i][j] = false;
        		} else if(j == 0) {
        			dp[i][j] = true;
        		} else {
        			if(dp[i - 1][j] == true) {
        				dp[i][j] = true;
        			} else {
        				if(j - arr[i - 1] >= 0) {
        					dp[i][j] = dp[i - 1][j - arr[i - 1]];
        				}
        			}
        		}
        	}
        }
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(n, tar, ""));
        
        while (queue.size() > 0) {
        	Pair rp = queue.removeFirst();
        	
        	
        	if(rp.i == 0 || rp.j == 0) {
        		System.out.println(rp.psf);
        	} else {
        		
        		if (rp.j - arr[rp.i - 1] >= 0) {
					boolean inc = dp[rp.i - 1][rp.j - arr[rp.i - 1]];
					if (inc) {
						queue.add(new Pair(rp.i - 1, rp.j - arr[rp.i - 1],(rp.i - 1) + " " + rp.psf ));
					}
				}
        	
				boolean exc = dp[rp.i - 1][rp.j];
				if (exc) {
					queue.add(new Pair(rp.i - 1, rp.j, rp.psf));
				}	
        	}
        }
        
    }
}
