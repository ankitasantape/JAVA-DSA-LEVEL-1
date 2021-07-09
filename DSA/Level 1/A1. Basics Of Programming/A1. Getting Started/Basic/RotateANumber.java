package Basic;

import java.util.*;
public class RotateANumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
//   1. find number of digits 
        int num = n;
        int nod = 0;
        while (num != 0) {
        	num /= 10;
        	nod++;
        }
        
//   2. bring value of k in range
        k = k % nod;
        if (k < 0) {
        	k = k + nod;
        }
//   3. set value of k in range 
        int div = (int)Math.pow(10, k);
        int multi = (int)Math.pow(10, nod - k);
        
//    4. set value of q and r    
        int q = n / div;
        int r = n % div;
        
        int ans = (r * multi) + q;
        System.out.println(ans);

        sc.close();
	}

}
