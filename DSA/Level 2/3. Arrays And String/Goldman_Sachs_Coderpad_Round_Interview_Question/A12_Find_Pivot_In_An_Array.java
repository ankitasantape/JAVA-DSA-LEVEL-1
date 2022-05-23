package Goldman_Sachs_Coderpad_Round_Interview_Question;

public class A12_Find_Pivot_In_An_Array {

/*	

[1,7,3,6,5,6] -> Ans: index -> 3
[1,2,3] -> Ans: index -> -1
[2,1,-1] -> Ans: index -> 0

*/
	public static void main(String[] args) {
		
		int[] arr = {1,7,3,6,5,6};
		int[] arr1 = {1,2,3};
		int[] arr2 = {2,1,-1};
		System.out.println( pivotIndex(arr) );
		System.out.println( pivotIndex(arr1) );
		System.out.println( pivotIndex(arr2) );
	}
	 public static int pivotIndex(int[] nums) {
	        int n = nums.length;
	        
	        int sum = 0;
	        for(int num : nums){
	            sum += num;
	        }
	        
	        int leftsum = 0;
	        for(int i = 0; i < n; i++){
	            int rightsum = sum - leftsum - nums[i];
	            if( leftsum == rightsum ){
	                return i;
	            }
	            leftsum += nums[i];
	        }
	        return -1;
	    }

}
