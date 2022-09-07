package Arrays_And_String;

public class A20_Transpose_Of_Matrix_With_Dimension_NCrossN_Inplace_Transpose {

    private static void transpose(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[][] matrix = {{10, 20, 30, 40},
				          {50, 60, 70, 80},
				          {90, 100, 110, 120},
				          {130, 140, 150, 160}};
		transpose(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}
