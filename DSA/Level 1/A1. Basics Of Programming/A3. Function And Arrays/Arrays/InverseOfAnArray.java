package Arrays;

import java.util.Scanner;

public class InverseOfAnArray {

	public static int[] inverse(int[] a){
		int n = a.length;
		int inv[] = new int[n];
        for(int i = 0; i < n; i++) {
       	 int val = a[i];
       	 inv[val] = i;
        }
        
        return inv;
     }
	
	public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int a[] = new int[n];
         for (int i = 0; i < n; i++) {
        	 a[i] = sc.nextInt();
         }
         int[] inv = inverse(a);
         
         display(inv);
         sc.close();
	}
	
	public static void display(int[] a){
	    StringBuilder sb = new StringBuilder();

	    for(int val: a){
	      sb.append(val + "\n");
	    }
	    System.out.println(sb);
	  }


}
