package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/*
 1. You are given a number n, representing the number of time-intervals.
2. In the next n lines, you are given a pair of space separated numbers.
3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30

Note -> The given input maynot be sorted by start-time.
Constraints
1 <= n <= 10^4
0 <= ith start time < 100
ith start time < ith end time <= 100
Sample Input
6
22 28
1 8
25 27
14 19
27 30
5 12
Sample Output
1 12
14 19
22 30
 */
public class Merge_Overlapping_Interval {
    public static class Pair implements Comparable<Pair>{
    	int start;
    	int end;
    	Pair(int start, int end){
    		this.start = start;
    		this.end = end;
    	}
//    	if this > other return +ve
//    	if this = other return 0
//    	if this < other return -ve
    	public int compareTo(Pair other) {
    		if (this.start != other.start) {
//    			if both(this.start & other.start) have equal time then it will return 0
//    			if start time of this(this.start) is greater than start time of other(other.start) then +ve value will be returned
//    			if start time of this(this.start) is smaller than start time of other(other.start) then -ve value will be returned
//    			so, those have smaller start time that value will put first in the array
    			return this.start - other.start;
    		}else {
//              otherwise, we will sort on the basis of end time 
    			return this.end - other.end;
    		}
    	}
    }
	public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        for(int i = 0; i < arr.length; i++) {
        	pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        for(int i = 0; i < pairs.length; i++) {
        	if (i == 0) {
        		st.push(pairs[i]);
        	} else {
        		Pair top = st.peek();
        		if (pairs[i].start > top.end) {
        			st.push(pairs[i]);
        		} else {
        			top.end = Math.max(top.end, pairs[i].end);
        		}
        	}
        }
        Stack<Pair> rs = new Stack<>();
        while (st.size() > 0) {
        	rs.push(st.pop());
        }
        System.out.println(rs.size());
        while(rs.size() > 0) {
        	Pair p = rs.pop();
        	System.out.println(p.start + " " + p.end);
        }
    }

}
