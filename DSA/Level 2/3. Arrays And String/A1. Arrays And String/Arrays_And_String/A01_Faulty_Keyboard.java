/*
Link: https://leetcode.com/problems/long-pressed-name/

Example 1:
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed output.

name: m a n n u

typed: m m a a n n u
 
 
 
*/


package Arrays_And_String;

public class A01_Faulty_Keyboard {

   private static boolean isPossible(String name, String typed) {
		if( name.length() > typed.length() ) {
			return false;
		}
	    int i = 0;
	    int j = 0;
	    
	    while(i < name.length() && j < typed.length()) {
	    	if( name.charAt(i) == typed.charAt(j) ) {
	    		i++;
	    		j++;
	    		
	    	} else if( i > 0 && name.charAt(i - 1) == typed.charAt(j) ) {
	    		
	    		j++;
	    	
	    	} else {
	    		return false;
	    	}
	    }
	    
	    while(j < typed.length()) {
	    	if( name.charAt(i - 1) != typed.charAt(j) ) {
	    		return false;
	    	}
	    	j++;
	    }
	   
		return i < name.length() ? false : true;
	}

	
	public static void main(String[] args) {
		String name = "mannu";
		String typed = "mmaannu";
		boolean res = isPossible(name, typed);
		System.out.println(res);	
	}

}
