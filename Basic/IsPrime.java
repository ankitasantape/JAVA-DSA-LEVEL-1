package Basic;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		  
	       int t = scn.nextInt();
	       while(t != 0){
	    	   int n = scn.nextInt();
	           
	           int factors = 0;
	           for(int i = 2; i*i < n; i++){
	               if (n % i == 0){
	                   factors++;
	               }
	           }
	           if(factors == 0){
	               System.out.println("prime");
	           }else{
	                System.out.println("not prime");
	           }
	         
	           t--;
	       }
	       scn.close();
	}

}
