package Arrays;

import java.util.Scanner;

public class FindElementInAnArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        
        for (int i = 0; i < n; i++) {
       	 a[i] = sc.nextInt();
        }
        
        int d = sc.nextInt();
        int ans = -1;
        for(int i = 0; i < n; i++) {
       	 if (a[i] == d) {
       		 ans = i;
       		 break;
       	 }
        }
         System.out.println(ans);
        sc.close();
	}

}
