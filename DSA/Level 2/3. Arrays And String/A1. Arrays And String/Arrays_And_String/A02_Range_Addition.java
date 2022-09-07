/*

1. Assume you have an array of length 'n' initialized with all 0's and are given 'q' queries to update.
2. Each query is represented as a triplet: [startIndex, endIndex, inc] 
   which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
3. Return the modified array after all 'q' queries were executed.

Input Format
length = 5,
updates = 
{
    {1,  3,  2},
    {2,  4,  3},
    {0,  2, -2}
}
Output Format
return {-2, 0, 3, 5, 3}
Explanation : 
Initial state:
{ 0, 0, 0, 0, 0 }
After applying operation [1, 3, 2]:
{ 0, 2, 2, 2, 0 }
After applying operation [2, 4, 3]:
{ 0, 2, 5, 5, 3 }
After applying operation [0, 2, -2]:
{-2, 0, 3, 5, 3 }


Steps:
Step-1) Impact on starting index as well as on ending index+1
Starting : val
Ending :  -val

Step-2) Prefix sum array
 


*/


package Arrays_And_String;

public class A02_Range_Addition {

	// Time  Complexity : O(n)
	public static int[] getModifiedArray(int length, int[][] queries) {
		int[] res = new int[length];
		
		for(int i = 0; i < queries.length; i++) {
			int si = queries[i][0];
			int ei = queries[i][1];
			int inc = queries[i][2];
			
			res[si] += inc;
	
			if(ei+1 < length) {
				res[ei + 1] = -inc; // yaha pe aake extra value will be negligible when we will do prefix sum
			}
			
		}
		
		// prefix sum
		int sum = 0;
		for(int i = 0; i < res.length; i++) {
			sum += res[i];
			res[i] = sum;
		}
		
		return res;
        
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {        
        int length = 5;
   
        int[][] queries = {
        	    {1,  3,  2},
        	    {2,  4,  3},
        	    {0,  2, -2}
        	};
        int[] res = getModifiedArray(length, queries);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        
    }

}
