package Goldman_Sachs_Coderpad_Round_Interview_Question;

public class A11_Reverse_Vowels_In_A_Given_String {

	public static void main(String[] args) {
		String str = "hello";
		String reverse = reverseVowels(str);
		System.out.println(reverse);
	}

	// Time complexity: O(n)
	private static String reverseVowels(String str) {
		int left = 0;
		int right = str.length()-1;
		char[] strarr = str.toCharArray();
		while( left < right ) {
			char lch = str.charAt(left);
			char rch = str.charAt(right);
			if (!isVowel(lch)) {
				left++;
				continue;
			} 
			if (!isVowel(rch)) {
				right--;
				continue;
			}

			char t = strarr[left];
			strarr[left] = strarr[right];
			strarr[right] = t;
			
			left++;
			right--;
		}
		String ans = String.copyValueOf(strarr);
		return ans;
	}
	
	private static boolean isVowel(char ch) {
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || 
				ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
	}

}
