/*
Pepcoding
1. Given an integers X. 
2. The task is to find the minimum number of jumps to reach a point X in the number line starting from zero.
3. The first jump made can be of length one unit and each successive jump will be exactly one unit longer than the previous jump in length. 
4. It is allowed to go either left or right in each jump.
Input Format
X = 8 Ans: 4
X = 9 Ans: 5
Output Format
4
-1 -> 2 -> 3 -> 4 (order of jumps)

5
1 -> 2 -> -3 -> 4 -> 5 (prder of jumps)


*/


package Arrays_And_String;

public class A14_Min_Jumps_With_plus_i_minus_i_Moves {

	public static int minJumps(int x) {
        
		int jump = 1;
		int sum = 0;
		
		while(sum < x) {
			sum += jump;
			jump++;
		}
		
		if((sum - x) % 2 == 0) {
			return jump - 1;
		} else if((sum + jump - x) % 2 == 0) {
			return jump;
		} else {
			return jump + 1;
		}
    }

    public static void main(String[] args) {
       
        int x = 9;

        int jumps = minJumps(x);
        System.out.println(jumps);
    }

}
