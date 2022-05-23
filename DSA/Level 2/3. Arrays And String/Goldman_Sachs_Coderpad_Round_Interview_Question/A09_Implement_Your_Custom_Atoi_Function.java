package Goldman_Sachs_Coderpad_Round_Interview_Question;

public class A09_Implement_Your_Custom_Atoi_Function {

	// Covert string to integer
	public static void main(String[] args) {
		String str1 = "123"; // Return 123
		String str2 = "-123"; // Return -123
		String str3 = "1a23"; // Return -1 (Invalid entry)
		
		System.out.println(  myAtoi(str1) == -1 ? "Invalid Input" : myAtoi(str1) );
		System.out.println(  myAtoi(str2) == -1 ? "Invalid Input" : myAtoi(str2) );
		System.out.println(  myAtoi(str3) == -1 ? "Invalid Input" : myAtoi(str3) );
	}

	private static int myAtoi(String str) {
		if( str == null ) {
			return 0;
		}
		str = str.trim();
		if( str.length() == 0 ) {
			return 0;
		}
		
		long ans = 0;
		int sign = str.charAt(0) == '-' ? -1 : 1;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		int i = (str.charAt(0) == '-') || (str.charAt(0) == '+') ? 1 : 0;
		
		for( ; i < str.length(); i++) {
			char ch = str.charAt(i);
			if( ch == ' ' || Character.isDigit(ch) == false ) {
				return -1;
			}
			
			ans = ans * 10 + (ch - '0');
			if( sign == -1 && sign*ans < min ) {
				return min;
			}
			
			if( sign == 1 && sign*ans > max ) {
				return max;
			}
		}
		
		return (int)(sign*ans); 
	}

}
