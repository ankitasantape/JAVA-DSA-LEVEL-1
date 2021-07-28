package Recursion_In_Array;

import java.util.Scanner;
/*
 1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are required to find the maximum of input. 
4. For the purpose complete the body of maxOfArray function. Don't change the signature.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
A number representing max
Sample Input
6
15
30
40
4
11
9
Sample Output
40
 */
public class Max_Of_An_Array {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int a[] = new int[n];
          for(int i = 0; i < n; i++){
              a[i] = sc.nextInt();
          }
          System.out.println(maxOfArray(a,0));
          sc.close();
     }

     public static int maxOfArray(int[] arr, int idx){
          if(idx == arr.length){
              return Integer.MIN_VALUE;
          }
          
          int max = maxOfArray(arr, idx + 1);
          max = arr[idx] > max ? arr[idx] : max;
          return max;
     }

}
