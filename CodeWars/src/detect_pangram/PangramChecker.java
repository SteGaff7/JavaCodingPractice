package detect_pangram;

/**
 * A pangram is a sentence that contains every single letter of the alphabet at least once. 
 * For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
 * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
 * @author stephen
 *
 */

public class PangramChecker {
	public boolean check(String sentence){
		
//		Can't have all letters represented if < 26 letters
		if (sentence.length() < 26) {
			return false;
		}
		
		boolean[] char_present = new boolean[26];
		
		for (int i=0; i < sentence.length(); i++) {
			char c = sentence.charAt(i);
			int ascii = (int) c;
			
			if (ascii >= 65 && ascii <= 90) {
//				Upper case
				int idx = ascii - (int) 'A';
				char_present[idx] = true;
			} else if (ascii >= 97 && ascii <= 122) {
//				Lower case
				int idx = ascii - (int) 'a';
				char_present[idx] = true;
			}
			
//			Once 26 chars have been checked, check if all letters represented yet
			if (i >= 26) {
				if (checkAllRepresented(char_present)) {
					return true;
				}
			}
		}
		
		return false;
	  }
	
	public boolean checkAllRepresented(boolean[] arr) {
		for (boolean b: arr) {
			if (b == false) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String pangram1 = "The quick brown fox jumps over the lazy dog.";
		boolean x = new PangramChecker().check(pangram1);
		System.out.println(x);
	}

}
