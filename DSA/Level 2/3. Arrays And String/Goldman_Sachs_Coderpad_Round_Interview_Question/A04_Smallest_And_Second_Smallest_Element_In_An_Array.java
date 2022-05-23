package Goldman_Sachs_Coderpad_Round_Interview_Question;

public class A04_Smallest_And_Second_Smallest_Element_In_An_Array {

	public static void main(String[] args) {
//		int[] arr = {1,6,3,8,5,2};
		
		int[] arr = {100, 99, 1, -1, 2, -33, 55};
		
		int smallest = Integer.MAX_VALUE;
		int second_smallest = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			if( arr[i] < smallest ) {
				second_smallest = smallest;
				smallest = arr[i];
			}
			else if( arr[i] < second_smallest ){
				second_smallest = arr[i];
			}
		}
		
		System.out.println("Smallest " + smallest );
		System.out.println("Second Smallest "+ "  " + second_smallest);
		
		
	}

}
