package Basic;

import java.util.*;

public class DigitsOfANumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int newnum = n;
		int count = 0;
        while(n > 0) {
        	int num = n / 10;
        	count++;
        	n = num;
        }
        
        int div = (int) Math.pow(10, count-1);
		while (newnum > 0) {
			System.out.println(newnum / div);
			int num = newnum % div;
			
			div = div / 10;
			newnum = num;
		}
		sc.close();
	}

}
