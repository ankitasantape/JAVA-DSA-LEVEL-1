/*
Given an array of digits digits, return the largest multiple of three that can be formed by concatenating some of the given digits in any order. If there is no answer return an empty string.

Since the answer may not fit in an integer data type, return the answer as a string. Note that the returning answer must not contain unnecessary leading zeros.

Example 1:

Input: digits = [8,1,9]
Output: "981"
Example 2:

Input: digits = [8,6,7,1,0]
Output: "8760"
Example 3:

Input: digits = [1]
Output: ""
 
Constraints:

1 <= digits.length <= 104
0 <= digits[i] <= 9
 
*/

package Dynamic_Programming;

import java.util.*;

public class Largest_Multiple_Of_Three {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println( largestMultipleOfThree(arr) );
		
		sc.close();
	}

	public static String largestMultipleOfThree(int[] digits) {
        int n = digits.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
        	sum += digits[i];
        }
        
        Arrays.sort(digits);
        if( sum % 3 == 0 ) {
        	if( digits[n-1] == 0 ) {
        		return "0";
        	}
        	
        	String s = "";
        	for(int i = n-1; i >= 0; i--) {
        		s += "" + digits[i];
        	}
        	return s;
        } else if(sum % 3 == 1) {
        	boolean idealFound = false;
        	for (int i = 0; i < n; i++) {
        		if(digits[i] % 3 == 1) {
        			idealFound = true;
        			digits[i] = -1;
        			break;
        		}
        	}
        	if(!idealFound) {
        		int[] idxes = new int[2];
        		idxes[0] = -1;
        		idxes[1] = -1;
        		
        		for (int i = 0; i < n; i++) {
        			if (digits[i] % 3 == 2) {
        				if(idxes[0] == -1) {
        					idxes[0] = i;
        				} else {
        					idxes[1] = i;
        					break;
        				}
        			}
        		}
        		
        		if(idxes[1] != -1) {
        			digits[idxes[0]] = -1;
        			digits[idxes[1]] = -1;
        		} else {
        			return "";
        		}
        	}
        } else {

        	boolean idealFound = false;
        	for (int i = 0; i < n; i++) {
        		if(digits[i] % 3 == 2) {
        			idealFound = true;
        			digits[i] = -1;
        			break;
        		}
        	}
        	if(!idealFound) {
        		int[] idxes = new int[2];
        		idxes[0] = -1;
        		idxes[1] = -1;
        		
        		for (int i = 0; i < n; i++) {
        			if (digits[i] % 3 == 1) {
        				if(idxes[0] == -1) {
        					idxes[0] = i;
        				} else {
        					idxes[1] = i;
        					break;
        				}
        			}
        		}
        		
        		if(idxes[1] != -1) {
        			digits[idxes[0]] = -1;
        			digits[idxes[1]] = -1;
        		} else {
        			return "";
        		}
        	}
        
        }
        String ans = "";
        for (int i = n-1; i>= 0; i--) {
        	if(digits[i] != -1) {
        		ans += (""+digits[i]);
        	}
        }
        return ans;
    }

	
}
