package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RotateAnArray {

	public static void display(int[] a){
	    StringBuilder sb = new StringBuilder();

	    for(int val: a){
	      sb.append(val + " ");
	    }
	    System.out.println(sb);
	  }

	 public static void reverse(int[] a, int i, int j){
	    
	     for ( ; i < j; i++, j--) {
	    	int temp = a[i];
	    	a[i] = a[j];
	    	a[j] = temp;
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int n = Integer.parseInt(br.readLine());
	    int[] a = new int[n];
	    for(int i = 0; i < n; i++){
	       a[i] = Integer.parseInt(br.readLine());
	    }
	    int k = Integer.parseInt(br.readLine());

	    rotate(a, k);
	    display(a);
	}
	

}
