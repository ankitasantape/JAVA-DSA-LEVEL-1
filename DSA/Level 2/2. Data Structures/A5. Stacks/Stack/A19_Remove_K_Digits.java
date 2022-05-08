/*
Given string num representing a non-negative integer num, and an integer k, print the smallest possible integer after removing k digits from num.
Input Format
A string num
A number k
Output Format
A string representing smallest possible integer after removing k digits from num. Output should not contain any leading 0 except for the 0 itself.

Constraints
1: 1 <= k <= num.length <= 10^5
2: num consists of only digits.
3: num does not have any leading zeros except for the zero itself.
Sample Input
1432219
3
Sample Output
1219

*/

package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class A19_Remove_K_Digits {

	public static String removeKdigits(String num, int k) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0; i < num.length();i++) {
            char ch = num.charAt(i);
            
            while(st.size() > 0 && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }
            
            st.push(ch);
        }
        
        while(k > 0) {
            st.pop();
            k--;
        }
        
        if(st.size() == 0) {
            return "0";
        }
        
        char[]arr = new char[st.size()];
        int idx = arr.length-1;
        
        while(st.size() > 0) {
            arr[idx--] = st.pop();
        }
        
        
        StringBuilder sb = new StringBuilder("");
        int fnz = arr.length-1;
        
        for(int i=0; i < arr.length;i++) {
            sb.append(arr[i]);
            
            if(fnz == arr.length-1 && arr[i] != '0') {
                fnz = i;
            }
        }
        
        return sb.toString().substring(fnz);
        
    }
	 public static void main(String[] args) throws Exception {
	        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

	        String num = read.readLine();
	        int k = Integer.parseInt(read.readLine());

	        // write your code here
	        System.out.println( removeKdigits(num, k) );
	 }
}
