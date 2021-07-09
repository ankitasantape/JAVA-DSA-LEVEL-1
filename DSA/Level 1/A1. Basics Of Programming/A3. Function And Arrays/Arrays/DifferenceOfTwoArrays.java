package Arrays;

import java.util.Scanner;

public class DifferenceOfTwoArrays {

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
		 
        int ans[] = new int[n2];
        int i = a.length-1;
        int j = b.length-1;
        int k = ans.length-1;
        
        int borrow = 0;
        
        while (k >= 0) {
        	int diff = (b[j] - borrow);
//        	to avoid array index out of bound exception
        	if (i >= 0) {
        		diff -= a[i];
        	}
//        	if diff is not negative hai
        	if (diff >= 0) {
        		borrow = 0;
        	} else {  // if diff is negative
        		diff += 10; 
        		borrow = 1;
        	}
        	ans[k] = diff;
        	i--;
        	j--;
        	k--;
        	
        }
        int idx = 0;
        while (idx < ans.length) {
        	if (ans[idx] == 0) {
        		idx++;
        	} else {
        		break;
        	}
        }
        
        while (idx < ans.length) {
        	System.out.println(ans[idx]);
        	idx++;
        }
        
        sc.close();
	}

}
