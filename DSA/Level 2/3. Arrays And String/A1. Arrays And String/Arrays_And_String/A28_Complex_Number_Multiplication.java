/*
1. A complex number can be represented as a string on the form "Real + Imaginary i" where:
    1.1 Real is the real part and is an integer in the range [-100, 100].
    1.2 Imaginary is the imaginary part and is an integer in the range [-100, 100].
    1.3 i^2 == -1.
2. Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.
Input Format
1. num1 = "1+1i", num2 = "1+1i"
2. num1 = "1+-1i", num2 = "1+-1i"
Output Format
1. "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.



*/

package Arrays_And_String;

public class A28_Complex_Number_Multiplication {

	public static String complexNumberMultiply(String num1, String num2) {
	    // num1 = a + bi
		// num2 = c + di
		// res = (a * c) - (b * d) + (a * d) + (c * b) i
		
		int a = Integer.parseInt(num1.substring(0, num1.indexOf('+')));
		int b = Integer.parseInt(num1.substring(num1.indexOf('+') + 1, num1.length() - 1));
		int c = Integer.parseInt(num2.substring(0, num2.indexOf('+')));
		int d = Integer.parseInt(num2.substring(num2.indexOf('+') + 1, num2.length() - 1));
		
		return "" + (a*c - b*d) + "+" + (a*d + c*b) + "i";
	}
	
	public static void main(String[] args) {
		 String num1 = "1+1i";
		 String num2 = "1+1i";
		 String res = complexNumberMultiply(num1, num2); // Ans: 0+2i
		 System.out.println(res);
		  
	}

}
