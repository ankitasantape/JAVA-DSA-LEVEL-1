package Arrays2D;

import java.util.Scanner;

/*
You are given a n*m matrix where n are the number of rows and m are the number of columns. You are also given n*m numbers representing the elements of the matrix.
You will be given a number 'r' representing number of rotations in an anti-clockwise manner of the specified ring.
You are required to rotate the 's'th ring by 'r' rotations and display the rotated matrix. 
 Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements of array a
A number s
A number r
Output Format
output is handled by display function
 Sample Input
5
7
11
12
13
14
15
16
17
21
22
23
24
25
26
27
31
32
33
34
35
36
37
41
42
43
44
45
46
47
51
52
53
54
55
56
57
2
3
Sample Output
11 12 13 14 15 16 17
21 25 26 36 46 45 27
31 24 33 34 35 44 37
41 23 22 32 42 43 47
51 52 53 54 55 56 57
 */

public class RotateRing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int mat[][] = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
//		Shell number
		int s = sc.nextInt();
//		number of rotation
		int r = sc.nextInt();
		
		rotateRing(mat, n, m, s, r);
		
		sc.close();
	}

	public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	public static void rotateRing(int[][] a, int n, int m, int s, int r){
	        
	        int oned[] = fill1DArrayfrom2D(a,n,m,s,r);
	        // rotate oned array
	        rotate(oned, r);
            // refilled shell into 2D matrix
	        fill2DArrayfrom1D(a, n, m , s, r, oned);
	        
	        display(a);
	}		
	
	public static int[] fill1DArrayfrom2D(int[][] a, int n, int m,int s,int r){
		
		int rmin = s-1;
        int cmin = s-1;
        int rmax = n - s;
        int cmax = m - s;
        
        int size = 2 * (rmax - rmin + cmax - cmin);
		int oned[] = new int[size];
		int idx = 0;
        // left 
        for(int row = rmin, j = cmin; row <= rmax; row++) {
        	oned[idx] = a[row][j];
        	idx++;
        }
        cmin++;
        // bottom 
        for(int col = cmin; col <= cmax; col++) {
        	oned[idx] = a[rmax][col];
        	idx++;
        }
        rmax--;
        // right 
        for(int row = rmax, j = cmax; row >= rmin; row--) {
        	oned[idx] = a[row][j];
        	idx++;
        }
        cmax--;
        // top
        for(int col = cmax; col >= cmin; col--) {
        	oned[idx] = a[rmin][col];
        	idx++;
        }
        
        return oned;
	}
	
	public static void fill2DArrayfrom1D(int[][] a, int n, int m,int s,int r, int[] oned){
		int rmin = s-1;
        int cmin = s-1;
        int rmax = n - s;
        int cmax = m - s;
        
		int idx = 0;
        // left 
        for(int row = rmin, j = cmin; row <= rmax; row++) {
        	 a[row][j] = oned[idx];
        	idx++;
        }
        cmin++;
        // bottom 
        for(int col = cmin; col <= cmax; col++) {
        	 a[rmax][col] = oned[idx];
        	idx++;
        }
        rmax--;
        // right 
        for(int row = rmax, j = cmax; row >= rmin; row--) {
        	 a[row][j] = oned[idx];
        	idx++;
        }
        cmax--;
        // top
        for(int col = cmax; col >= cmin; col--) {
        	 a[rmin][col] = oned[idx];
        	idx++;
        }
        
	}	
	
	public static void reverse(int[] a, int si, int ei){
	    
	     while ( si < ei) {
	    	int temp = a[si];
	    	a[si] = a[ei];
	    	a[ei] = temp;
	    	si++;
	    	ei--;
	     }
	     
	 }   
	
	 public static void rotate(int[] a, int k){
		    k = k % a.length;
		    if (k < 0) {
		    	k = k + a.length;
		    }
//		    1. Rotate whole array from 0 to n-1
		    reverse(a, 0, a.length-1);
//		    2. Rotate 0 to k-1 array
		    reverse(a, 0, k-1);
//		    3. Rotate k to n-1 array
		    reverse(a, k , a.length-1);
		    
	  }
}
