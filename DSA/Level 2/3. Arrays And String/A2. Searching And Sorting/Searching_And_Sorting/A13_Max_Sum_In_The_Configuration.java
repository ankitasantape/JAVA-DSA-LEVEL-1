/*
Given an array(0-based indexing), you have to find the max sum of i*A[i] where A[i] is the element at index i in the array.
The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.

Example 1:

Input:
N = 4
A[] = {8,3,1,2}
Output: 29
Explanation: Above the configuration
possible by rotating elements are
3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11
Here the max sum is 29 
Your Task:
Your task is to complete the function max_sum which takes two arguments which is the array A [ ] and its size and returns an integer value denoting the required max sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).


*/

package Searching_And_Sorting;



public class A13_Max_Sum_In_The_Configuration {

	public static int maximise(int[]arr) {
       int n = arr.length;
       
       int sum = 0;
       int S0 = 0;
       
       for(int i = 0; i < n; i++) {
    	   sum += arr[i];
    	   S0 += arr[i]*i;
       }
       
       int max = S0;
       int Si = S0;
       
       for(int i=0; i < n-1; i++) {
    	   // *********Formula**************
    	   // Si+1 = Si + sum - n*arr[n-i-1]
    	   int Sip1 = Si + sum - n*arr[n-i-1];
    	   
    	   if(Sip1 > max) {
    		   max = Sip1;
    	   }
    	   
    	   Si = Sip1;
       }
       
       return max;
    }

    public static void main(String[]args) {
    	int arr[] = {8,3,1,2};

        int ans = maximise(arr);
        System.out.println(ans);
    }

}
