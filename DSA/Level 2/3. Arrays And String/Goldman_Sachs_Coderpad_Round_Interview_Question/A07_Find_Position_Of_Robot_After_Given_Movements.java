package Goldman_Sachs_Coderpad_Round_Interview_Question;

public class A07_Find_Position_Of_Robot_After_Given_Movements {

	public static void main(String[] args) {
		
		findPositions("UDDLRL");
		findPositions("UDDLLRUUUDUURUDDUULLDRRRR");
		findPositions("DOWN UP 2xRIGHT DOWN 3xLEFT");
		
	}

	private static void findPositions(String move) {
		
		int n = move.length();
		int countUp = 0, countDown = 0;
		int countLeft = 0, countRight = 0;
		
		
		for(int i = 0; i < n; i++) {
	      char ch = move.charAt(i);
		  switch(ch) {
		    
		     case 'U':      
		    	 countUp++;
		    	 break;
		     case 'D':
		    	 countDown++;
		    	 break;
		     case 'L':
		         countLeft++;
		         break;
		     case 'R':
		    	 countRight++;
		    	 break;
		     default: 
		    	 System.out.println("Invalid Test Case");
		    	 return;
		   }
		}
		
		System.out.println("Final Position: (" + (countRight - countLeft) + " " + (countUp - countDown) + ")");
	}

}
