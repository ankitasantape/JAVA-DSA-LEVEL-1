package Goldman_Sachs_Coderpad_Round_Interview_Question;

public class A06_Median_Of_Two_Sorted_Arrays_Optimized_Approach {

	// Time Complexity - O(log (n + m))
	public static void main(String[] args) {
		 int[] a1 = {3, 5, 7, 10, 15};
		 int[] a2 = {2, 4, 12};
	     double median = getMedian(a1, a2);	 
		 System.out.println(median);
	}

	private static double getMedian(int[] a, int[] b) {
		
		if( a.length > b.length ) {
			int[] temp = a;
			a = b;
			b = temp;
		}
		
		int lo = 0;
		int hi = a.length-1;
		int te = a.length + b.length; // total element
		
		while( lo <= hi ) {
			int aleft = (lo + hi)/2;
			int bleft = (te + 1)/2 - aleft;
			
			// To manage all the hidden test cases
			// aleft minus 1 -> ( aleft - 1 )th element 
			int alm1 = ( aleft == 0 ) ? Integer.MIN_VALUE : a[aleft-1];
			int al = ( aleft == a.length ) ? Integer.MAX_VALUE : a[aleft];
			int blm1 = ( bleft == 0 ) ? Integer.MIN_VALUE : b[bleft-1];
			int bl = ( bleft == b.length ) ? Integer.MAX_VALUE : b[bleft];
			
			// valid segregation
			
			// Agar (aleft-1)th element is less than or equal to bleft
			// (bleft-1) element is less then or equal to aleft
			if( alm1 <= bl && blm1 <= al ) {
				double median = 0.0;
				
				if( te % 2 == 0 ) {
					int lmax = Math.max(alm1, blm1);
					int rmin = Math.min(al, bl);
					median = ( lmax + rmin ) / 2.0;
				}
				else {
					int lmax = Math.max(alm1, blm1);
					median = lmax;
				}
				return median;
			}
			// Agar (aleft-1)th element is greater than bleft then shift high to aleft-1
			else if(alm1 > bl){
				hi = aleft - 1;
			}
			// Agar (aleft)th element is less than (bleft-1)th then shift low to aleft+1
			else if(al < blm1) {
				lo = aleft + 1;
			}
		}
		
		return 0;
	}

}
