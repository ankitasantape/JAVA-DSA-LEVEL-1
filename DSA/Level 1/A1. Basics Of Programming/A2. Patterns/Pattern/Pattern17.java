package Pattern;

import java.util.Scanner;

public class Pattern17 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    
	    int sp = n/2;
	    int st = 1;
	    for (int i = 1; i <= n; i++) {
	    	
	    	if(i == n/2 + 1) {
	    		for(int j = 1; j <= n/2; j++) {
	    			System.out.print("*\t");
	    		}
	    	}else {
	    		for (int j = 1; j <= sp; j++) {
		    		System.out.print("\t");
		    	}
	    	}
	    	for (int j = 1; j <= st; j++) {
	    		System.out.print("*\t");
	    	}
	    	if (i <= n/2) {
	    		st++;
	    	} else {
	    		st--;
	    	}
	    	
	    	System.out.println();
	    }
	    sc.close();
	}

}
