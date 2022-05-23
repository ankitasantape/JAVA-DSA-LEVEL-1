package Goldman_Sachs_Coderpad_Round_Interview_Question;

public class A05_Median_Of_Two_Sorted_Arrays_Of_Different_Size {

	// Time Complexity - O(n + m)
	// Space Complexity - O(n + m)
	public static void main(String[] args) {
		 int[] a1 = {3, 5, 7, 10, 15};
		 int[] a2 = {2, 4, 12};
	     double median = getMedian(a1, a2);	 
		 System.out.println(median);
	     
	}

	private static double getMedian(int[] a1, int[] a2) {
		int i = 0;
		int j = 0;
		int k = 0;
		int n = a1.length;
		int m = a2.length;
		
		int[] marr = new int[n+m];
		
		while (i < n && j < m) {
			if( a1[i] < a2[j] ) {
				marr[k] = a1[i];
				i++;
				k++;
			}
			else {
				marr[k] = a2[j];
				j++;
				k++;
			}
		}
		
		while(i < n) {
			marr[k] = a1[i];
			i++;
			k++;
		}
		
		while(j < m) {
			marr[k] = a2[j];
			j++;
			k++;
		}
		
		double median = 0.0;
		int mid = marr.length/2;
		
		if( marr.length % 2 == 1 ) {
	    	 median = marr[mid];
	     }
	     else {
	    	 median = (marr[mid] + marr[mid-1]) / 2.0;
	     }
		 return median;
	}

}
