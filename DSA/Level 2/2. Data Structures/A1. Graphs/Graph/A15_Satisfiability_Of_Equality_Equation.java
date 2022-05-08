/*
You are given an array of strings equations that represent relationships between variables where each string equations[i] is of length 4 and takes one of two different forms: x==y or x!=y. Here x and y represents lowercase letters.
Input Format
First line contains an integer denoting the number of equation
Each of next n line contains an equation of form "x==y" or "x!=y"
Output Format
print true if all equations can be satisfied else print false.
Constraints
1 <= equations.length <= 100000
equations[i].length == 4
Sample Input
2
b==c
c!=b
Sample Output
false

*/

package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A15_Satisfiability_Of_Equality_Equation {
   
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}

		System.out.println(equationsPossible(arr));
	}
 
	static int[] parent;
	static int[] rank;
	public static boolean equationsPossible(String[] equations) {
		parent = new int[26];
		rank = new int[26];
		
		for(int i=0; i < 26; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		//1. apply DSU using equality equations
		for(int i=0; i<equations.length; i++) {
			String eqn = equations[i];
			
			if(eqn.charAt(1) == '=') {
				char op1 = eqn.charAt(0);
				char op2 = eqn.charAt(3);
				
				union(op1, op2);
			}
		}
		
		//2. Verification using inequalities equations
		for(int i=0; i<equations.length; i++) {
			String eqn = equations[i];
			
			if(eqn.charAt(1) == '!') {
				char op1 = eqn.charAt(0);
				char op2 = eqn.charAt(3);
				
				if(find(op1 - 'a') == find(op2 - 'a')) {
					return false;
				}
			}
		}
		return true;
	}
	private static int find(int x) {
		if( parent[x] == x ) {
			return x;
		}
		int sl = find(parent[x]); // get set leader
		parent[x] = sl;
		return sl;
	}
	private static void union(char ch1, char ch2) {
		int v1 = ch1 - 'a';
		int v2 = ch2 - 'a';
		
		int sl1 = find(v1);
		int sl2 = find(v2);
		
		if(sl1 != sl2) {
			// merging or union by rank
			if(rank[sl1] < rank[sl2]) {
				parent[sl1] = sl2;
			}
			else if(rank[sl2] < rank[sl1]) {
				parent[sl2] = sl1;
			}
			else {
				parent[sl1] = sl2;
				rank[sl2]++;
			}
		}
	}
}
