/*

Leetcode 43: https://leetcode.com/problems/multiply-strings/

Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"


Hidden TestCase1:

Result: 0001203

How to handle this leading zeroes?

* Get a flag when first non-zero encounter.
* Iterate using that flag.
 
loop ---> {
   if( arr[i] == 0 && flag == false ){
          // leading zeroes
           continue;
    } else {
          flag = true;
          [ work ]
    }
}    
                 
Result -> 1203                 

Hidden TestCase2:

if num1 == 0 or num2 == 0 then result should be 0


*/

package Arrays_And_String;

public class A27_Multiply_Strings {

	public static String multiply(String num1, String num2) {
	    
	    int l1 = num1.length();
	    int l2 = num2.length();
	    int[] res = new int[l1 + l2];
	    
	    int i = l2 - 1;
	    int pf = 0; // power factor - pf ye batayega ki kitane index pichese start krna hai -> 10^0 = 1, 10^1 = 10, 10^2 = 100
	    
	    while(i >= 0) {
	    	int ival = i >= 0 ? num2.charAt(i) - '0' : 0;
	    	i--;
	    	
	    	int j = l1 - 1;
	    	int k = res.length - 1 - pf;
	    	int carry = 0;
	    	
	    	while(j >= 0 || carry != 0) {
	    		int jval = j >= 0 ? num1.charAt(j) - '0' : 0;
	    		j--;
	    		
	    		int prod = ival * jval + carry + res[k];
	    		
	    		res[k] = prod % 10;
	    		carry = prod / 10;
	    		k--;
	    	}
	    	pf++;
	    }
		
	    // management of leading zero using general method
	    String str = "";
	    boolean flag = false;
	    for(int val : res) {
	    	
	    	if(val == 0 && flag == false) {
	    		// leading zero
	    		continue;
	    	} else {
	    		flag = true;
	    		str += val;
	    	}
	    }
	    
	    return str;
	}
	
	public static void main(String[] args) {
		
		String num1 = "123";
		String num2 = "456";
		
		String res = multiply(num1, num2); // 56088
		System.out.println(res);
	}

}
