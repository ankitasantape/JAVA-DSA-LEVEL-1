/*
Pepcoding offers total of n courses labelled from 0 to n-1.

Some courses may have prerequisites. you have been given m pairs ai,bi. where 1 pair means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses. If it is impossible to finish all courses print -1.
Input Format
first line contains 2 numbers n,m wher n represents number of course and m is number of pairs representing prerequisite. Then m lines follow, each line has 2 space separated integers ai , bi.
Output Format
Print the ordering of courses you should take to finish all courses.Print the ordering of courses you should take to finish all courses.
Constraints
1 <= numCourses <= 2000
0 <= ai, bi < numCourses
ai != bi
All the pairs ai,bi are distinct.
Sample Input
4 4
1 0
2 0
3 1
3 2
Sample Output
0 1 2 3 

*/

package Graph;

import java.io.IOException;
import java.util.*;

public class A19_Pepcoding_Course_Schedule_I {
 
	public static void main(String[] args) throws NumberFormatException, IOException {
        
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<Integer>[] graph = new ArrayList[numCourses];

		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			int u = prerequisites[i][0];
			int v = prerequisites[i][1];

			graph[u].add(v);
		}

		int[] ans = kahn(graph);

		if (ans.length == 0) {
			return false;
		} else {
			return true;
		}
	}

	public int[] kahn(ArrayList<Integer>[] graph) {
		int n = graph.length;

		// create indegree array
		int[] indegree = new int[n];

		for (int i = 0; i < graph.length; i++) {
			for (int nbr : graph[i]) {
				indegree[nbr]++;
			}
		}

		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		while (q.size() > 0) {
			int rem = q.remove();
			list.add(rem);

			for (int nbr : graph[rem]) {
				indegree[nbr]--;

				if (indegree[nbr] == 0) {
					q.add(nbr);
				}
			}
		}

		if (list.size() == n) {
			// valid topological sort is present in this graph
			int[] ts = new int[n];
			for (int i = 0; i < n; i++) {
				ts[i] = list.get(i);
			}
			return ts;
		} else {
			int[] arr = {};
			return arr;
		}

	}
}
