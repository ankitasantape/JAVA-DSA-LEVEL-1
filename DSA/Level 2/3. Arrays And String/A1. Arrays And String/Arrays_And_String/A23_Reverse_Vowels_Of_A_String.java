/*
Link: https://leetcode.com/problems/reverse-vowels-of-a-string/

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

Example 1:

Input: s = "hello"
Output: "holle"
Example 2:

Input: s = "leetcode"
Output: "leotcede"


*/

package Arrays_And_String;

public class A23_Reverse_Vowels_Of_A_String {

    public static String reverseVowels(String s) {
        char[] charr = s.toCharArray();
    	
    	int left = 0;
        int right = charr.length-1;
        
        while(left < right) {
        	
        	// left -> vowel
        	while(left < right && isVowel(charr[left]) == false) {
        		left++;
        	}
        	
        	// right -> vowel
        	while(left < right && isVowel(charr[right]) == false ) {
        		right--;
        	}
        	
        	// swap -> left, right
			char temp = charr[left];
			charr[left] = charr[right];
			charr[right] = temp;

			left++;
			right--;
        	
        }
    	
        String res = "";
        		
        for(char ch : charr) {
        	res += ch;
        }
        
        return res;
    }
    
    public static boolean isVowel(char ch) {
    	if( ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' 
    			|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
	
	public static void main(String[] args) {
		String str = "aklighOustmIghAsOtUAli";
		
		System.out.println( reverseVowels(str)  );
		
	}

}
