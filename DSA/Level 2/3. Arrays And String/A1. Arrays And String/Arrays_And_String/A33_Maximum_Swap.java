/*

Leetcode 670: https://leetcode.com/problems/maximum-swap/description/

You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.

Example 1:
Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

Example 2:
Input: num = 9973
Output: 9973
Explanation: No swap.

Approach 1: If given value is an integer
       0 1 2 3 4 5 6 7 8 9
nums:  9 9 8 7 4 3 6 2 9 4
right: 8 8 8 8 8 8 8 8 8 9
max        | 
index      valid arr


Step1: Right Max Index -> O(n)
Step2: Travel and figure out position for swapping.
       If values are equal then ignore and move ahead
       arr[i] != arr[rightmax[i]]
       otherwise swap[ arr, i, rightmax[i] ]
Step3: Prepare string       

Approach 2:

       0 1 2 3 4 5 6 7 8
nums:  9 9 4 7 4 2 3 9 3

Step 1:
Last index of digit      

0 ->            5 ->
1 ->            6 ->
2 -> 5          7 -> 3
3 -> 6 -> 8     8 -> 
4 -> 4          9 -> 0 -> 1 -> 7

Step 2:

idx - 0, ele -> 9 kisi ke sath bhi swap nhi ho skta hai becoz wo apne max stage pe hai
idx - 1, ele -> 4 ke liye ye valid candidate 9,8,7,6,5 hai aur to hum unake indexes compare krke swapping krenge,
                  jis index ke sath swapping krni hai wo aage hona chahiye
                 

Step 2: Make Swapping

Step 3: Prepare String for answer


*/


package Arrays_And_String;

public class A33_Maximum_Swap {

    public static String maximumSwap(String num) {
        
    	char[] arr = num.toCharArray();
    	
    	// 1. prepare last index of digit
    	int[] li = new int[10];
    	for(int i = 0; i < arr.length; i++) {
    		int digit = arr[i] - '0';
    		li[digit] = i;
    	}
    	
    	// 2. figure out position for swapping
    	boolean flag = false;
    	for(int i = 0; i < arr.length; i++) {
    		int digit = arr[i] - '0';
    		for(int j = 9; j > digit; j--) {
    			if(i < li[j]) {
    				// swapping and break
    				swap(arr, i, li[j]);
    				flag = true;
    				break;
    			}
    		}
    		if(flag == true) {
    			break;
    		}
    	}
    	
    	// 3. prepare answer in the form of string
    	String res = "";
    	for(int i = 0; i < arr.length; i++) {
    		res += arr[i];
    	}
    	
    	return res;
    }
	
	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		
		String num = "998743261792";
		System.out.println( maximumSwap(num) );
	}

}
