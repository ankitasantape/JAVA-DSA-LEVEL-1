/*
1. You are given two integers N and M, and an array(arr) of numbers with length M.
2. N represents the total number of tasks assigned to a group of 5 students.
3. Out of these five students, three students completed M number of tasks of their choices and left the group.
4. Tasks completed by these students are represented by the given array.
5. Now, the remaining two students(s1 and s2) have to complete all the remaining tasks.
6. They decided to complete the remaining tasks in an alternate way -
   First of the remaining tasks will be completed by s1
   Second of the remaining tasks will be completed by s2
   Third of the remaining tasks will be completed by s1.. and so on.    
7. You have to find the tasks that s1 and s2 have to complete.
Input Format
Two Number N and M
arr1
arr2.. M numbers
Output Format
2 lines containing space-separated numbers.
Numbers in first line represents the tasks that s1 have to complete.
Numbers in second line represents the tasks that s2 have to complete. 
Constraints
1 <= M,N <= 10^3
1 <= arr[i] <= 10^3
Sample Input
15 6
2 5 6 7 9 4
Sample Output
1 8 11 13 15 
3 10 12 14 

*/
package HashMap;

import java.util.*;

public class A25_Task_Completion {

	public static void completeTask(int n, int m, int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		
		for(int val: arr) {
			set.add(val);
		}
		
		ArrayList<Integer> l1 = new ArrayList<>(); // for student1
		ArrayList<Integer> l2 = new ArrayList<>(); // for student2
		boolean flag = true; // flag == true (allocate to s1) else (allocate to s2)
		for(int i=1; i<= n; i++) {
			if( set.contains(i) == false) {
				// ith task is not done
				
				if(flag == true) {
					l1.add(i);
					flag = false;
				} 
				else {
					l2.add(i);
					flag = true;
				}
			}
		}
		for(int val : l1) {
			System.out.print(val + " ");
		}
		System.out.println();
		for(int val : l2) {
			System.out.print(val);
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] num = new int[m];
		for (int i = 0; i < m; i++) {
			num[i] = scn.nextInt();
		}
		completeTask(n, m, num);
		scn.close();
	}
}
