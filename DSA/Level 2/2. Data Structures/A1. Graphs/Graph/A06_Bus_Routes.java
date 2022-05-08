/*
You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.

For example, if routes[1] = [1, 5, 7], this means that the 1st bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.

You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
Constraints
1 <= routes.length <= 500.
1 <= routes[i].length <= 10^5.
All the values of routes[i] are unique.
0 <= routes[i][j] < 10^6.
0 <= source, target < 10^6.
Sample Input
2
3
1 2 7
3 6 7
1 6
Sample Output
2


*/

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A06_Bus_Routes {
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] st = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}

		String[] st1 = br.readLine().split(" ");
		int src = Integer.parseInt(st1[0]);
		int dest = Integer.parseInt(st1[1]);
		System.out.println(numBusesToDestination(arr, src, dest));

	}

	public static class Pair{
		int bus_stand;
		int level;
		
		Pair(){
			
		}
		
		Pair(int bus_stand, int level){
			this.bus_stand = bus_stand;
			this.level = level;
		}
	}
	
	public static int numBusesToDestination(int[][] routes, int source, int target) {
          
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < routes.length; i++) {
			for(int j = 0; j < routes[i].length; j++) {
				int bus = i;
				int bus_stand = routes[i][j];
				
				ArrayList<Integer> list = map.getOrDefault(bus_stand, new ArrayList<>());
				list.add(bus); // aaj ke bus ka number add krdo
				map.put(bus_stand, list); // aur map me is bus_stand se ye-ye us hokar gujarti hai
			}
		}
		
		return bfs(routes, map, source, target);
	}

	private static int bfs(int[][] routes, HashMap<Integer, ArrayList<Integer>> map, int src, int dest) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		HashSet<Integer> vis_bus_stand = new HashSet<>();
		HashSet<Integer> vis_bus = new HashSet<>();
		
		q.add(new Pair(src, 0));
		
		while(q.size() > 0) {
			Pair rem = q.remove();
			
			if(rem.bus_stand == dest) {
				return rem.level; 
			}
			
			for(int bus : map.get(rem.bus_stand)) {
				if(vis_bus.contains(bus) == false) {
					vis_bus.add(bus);
					for(int bus_stand : routes[bus]) {
						if(vis_bus_stand.contains(bus_stand) == false) {
							q.add(new Pair(bus_stand, rem.level + 1));
							vis_bus_stand.add(bus_stand);
						}
					}
				}
			}
		}
		return -1;
	}
}
