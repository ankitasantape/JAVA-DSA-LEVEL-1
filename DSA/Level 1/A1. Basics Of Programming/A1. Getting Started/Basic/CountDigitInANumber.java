package Basic;

import java.util.*;

public class CountDigitInANumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while(n > 0) {
        	int num = n / 10;
        	count++;
        	n = num;
        }
        System.out.println(count);
        sc.close();
	}

}
