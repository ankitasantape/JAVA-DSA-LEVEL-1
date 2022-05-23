package Goldman_Sachs_Coderpad_Round_Interview_Question;

import java.util.HashMap;

public class A08_First_Non_Repeating_Character {

	public static void main(String[] args) {
		String str1 = "12345";
		String str2 = "abebacd";
		
		System.out.println( firstNonRepeatingChar(str1) ); // 1
		System.out.println( firstNonRepeatingChar(str2) ); // c
	}

	private static char firstNonRepeatingChar(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		for(char key : str.toCharArray()) {
			if( map.get(key) == 1 ) {
				return key;
			}
		}
		return 0;
	}

}
