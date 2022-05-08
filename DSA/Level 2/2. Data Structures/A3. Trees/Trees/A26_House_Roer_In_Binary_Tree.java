/*
1. You are given a partially written function to solve.
2. The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting the police.
Constraints
0 <= Number of Nodes <= 10^9
-10^9 <= value of Node data <= 10^9
Sample Input
15
1
1
-1
1
1
-1
1
-1
-1
1
-1
-1
1
-1
-1
Sample Output
4

*/


package Trees;

import java.util.*;

public class A26_House_Roer_In_Binary_Tree {
   
	public static Scanner scn = new Scanner(System.in);

	public static class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static class Pair{
        public int incMaxProfit; // inclusion ka max profit (node is inc
        public int excMaxProfit; // exclusive ka max profit (node is exc
        Pair(int incMaxProfit, int excMaxProfit){
            this.incMaxProfit = incMaxProfit;
            this.excMaxProfit = excMaxProfit;
        }
    }

    public static Pair solve(TreeNode node){
        if( node == null ){
            
            Pair bp = new Pair(0, 0);
            return bp;
        }
        Pair lp = solve(node.left);
        Pair rp = solve(node.right);
        
        int incMaxProfit = lp.excMaxProfit + rp.excMaxProfit + node.val;
        int excMaxProfit = Math.max( lp.incMaxProfit, lp.excMaxProfit ) + Math.max( rp.incMaxProfit, rp.excMaxProfit );
        
        Pair mp = new Pair(incMaxProfit, excMaxProfit );
        return mp;
    }

    public static int HouseRobber(TreeNode root) {
        
        Pair anspair = solve(root);
        return Math.max(anspair.incMaxProfit , anspair.excMaxProfit);
        
    }
	// input_Section_====================================================================

	public static TreeNode createTree(int[] arr, int[] IDX) {
		if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
			IDX[0]++;
			return null;
		}

		TreeNode node = new TreeNode(arr[IDX[0]++]);
		node.left = createTree(arr, IDX);
		node.right = createTree(arr, IDX);

		return node;
	}

	public static void solve() {
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();

		int[] IDX = new int[1];
		TreeNode root = createTree(arr, IDX);
		System.out.println(HouseRobber(root));
	}

	public static void main(String[] args) {
		solve();
	}
}
