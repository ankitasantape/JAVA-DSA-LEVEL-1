package Basic;

public class GreatestNumber {

	public static void main(String[] args) {
		int a = 221;
        int b = 34;
        int c = 171;
        
        if(a > b && a > c ){
            System.out.print("A is greatest");
        }else if( b > c){
            System.out.print("B is greatest");
        }else {
            System.out.print("C is greatest");
        }
	}

}
