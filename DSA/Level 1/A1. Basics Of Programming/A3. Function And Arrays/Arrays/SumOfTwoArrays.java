package Arrays;

import java.util.Scanner;

public class SumOfTwoArrays {

	public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n1 = sc.nextInt();
         int a[] = new int[n1];
         
         for(int i = 0; i < n1; i++) {
        	 a[i] = sc.nextInt();
         }
         
         int n2 = sc.nextInt();
         int b[] = new int[n2];
         
         for(int i = 0; i < n2; i++) {
        	 b[i] = sc.nextInt();
         }
		 
         int ans[] = new int[n1 > n2 ? n1 : n2];
         int i = a.length-1;
         int j = b.length-1;
         int k = ans.length-1;
         
         int cy = 0;
         
         while (k >= 0) {
        	 int digit = cy;
        	 
        	 if(i >= 0) {
        		digit += a[i]; 
        	 }
        	 
        	 if(j >= 0) {
        		 digit += b[j];
        	 }
        	 
        	 cy = digit / 10;
        	 digit = digit % 10;
        	 
        	 ans[k] = digit;
        	 i--;
        	 j--;
        	 k--;
        	 
         }
         
         if (cy != 0) {
        	 System.out.println(cy);
         }
         for (int sum : ans) {
        	 System.out.println(sum);
         }
         
         sc.close();
	}

}
