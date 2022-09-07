/*

Leetcode 838: https://leetcode.com/problems/push-dominoes/

There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.

After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.

For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.

You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

 

Example 1:

Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
Example 2:


Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."
 

Constraints:

n == dominoes.length
1 <= n <= 105
dominoes[i] is either 'L', 'R', or '.'.

*/

package Arrays_And_String;

public class A46_Push_Dominoes {

	public static void solveConfiguration(char[] arr, int i, int j) {
		if(arr[i] == 'L' && arr[j] == 'L') {
			// make all dots ar L
			for(int k = i + 1; k < j; k++) {
				arr[k] = 'L';
			}
		} else if( arr[i] == 'R' && arr[j] == 'R' ) {
			// make all dots ar R
			for(int k = i + 1; k < j; k++) {
				arr[k] = 'R';
			} 
		} else if( arr[i] == 'L' && arr[j] == 'R' ) {
			// nothing to do
			
		} else {
			// solve according to odd count and even count of dots
			int diff = j - i;
			int mid = (i + j) / 2;
			if(diff % 2 == 0) {
				// odd dots
				for(int k = i + 1; k < mid; k++) {
					arr[k] = 'R';
				}
				for(int k = mid + 1; k < j; k++) {
					arr[k] = 'L';
				}
			} else {
				// even dots
				for(int k = i + 1; k <= mid; k++) {
					arr[k] = 'R';
				}
				for(int k = mid + 1; k < j; k++) {
					arr[k] = 'L';
				}
				
			}
		}
	}
	
    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = new char[n + 2];
        arr[0] = 'L';
        arr[n + 1] = 'R';
        
        for(int i = 1; i < arr.length-1; i++) {
        	arr[i] = dominoes.charAt(i - 1);
        }
        
        int j = 0;
        int k = 1;
        
        while (k < arr.length) {
        	while(arr[k] == '.') {
        		k++;
        	}
        	
        	if( k-j > 1 ){
        	    solveConfiguration(arr, j, k);
        	}    
        	j = k;
        	k++;
        }
        
//        String res = "";
//        for(int i = 1; i < arr.length - 1; i++) {
//        	res += arr[i];
//        }
        
        StringBuilder res = new StringBuilder();
        for(int i = 1; i < arr.length - 1; i++) {
        	res.append(arr[i]);
        }
        
        return res.toString();
    }
	
	public static void main(String[] args) {
		
		String dominoes = "RR.L";
		String result = pushDominoes(dominoes);
		System.out.println(result);
		
	}

}
