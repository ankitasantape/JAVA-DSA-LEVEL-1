package Recursion_In_Array;

import java.util.Scanner;
/*
 1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the elements of array from beginning to end each in a separate line.
4. For the above purpose complete the body of displayArr function. Don't change the signature.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
n1
n2
.. n elements
Sample Input
5
3
1
0
7
5
Sample Output
3
1
0
7
5
 */
public class Display_Array {
	 public static void main(String[] args) throws Exception {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int a[] = new int[n];
         for(int i = 0; i < n; i++){
             a[i] = sc.nextInt();
         }
         displayArr(a,0);
         sc.close();
    }

    public static void displayArr(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr, idx + 1);
    }

}
