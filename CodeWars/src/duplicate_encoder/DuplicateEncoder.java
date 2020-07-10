package duplicate_encoder;

import java.util.HashMap;;

/**
 * The goal of this exercise is to convert a string to a new string where each character in the new string is 
 * "(" if that character appears only once in the original string, or ")" if that character appears more than 
 * once in the original string. Ignore capitalization when determining if a character is a duplicate.
 * @author stephen
 *
 */

public class DuplicateEncoder {
	
	static String encode(String word){
		
		HashMap<Character, Boolean> charUniqueMap = new HashMap<Character, Boolean>();
		
		StringBuilder modified = new StringBuilder(word.length());
		
//		Iterate through sentence to get a count using a hashMap
		for (int i=0; i < word.length(); i++) {
			char c = word.charAt(i);
			
//			Convert to lower
			if ((int) c >= 65 && (int) c  <= 90) {
				c = (char) ((int)c + 32);
			}
			
			if (charUniqueMap.containsKey(c)) {
				charUniqueMap.replace(c, false);
			} else {
				charUniqueMap.put(c, true);
			}
		}
		
//		Iterate through sentence, replacing with "(" or ")"
		for (int i=0; i < word.length(); i++) {
			char c = word.charAt(i);
			
//			Convert to lower
			if ((int) c >= 65 && (int) c  <= 90) {
				c = (char) ((int)c + 32);
			}
			
			if (charUniqueMap.get(c) == true) {
				modified.append("(");
			} else {
				modified.append(")");
			}
		}
		
	    return modified.toString();
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DuplicateEncoder.encode("Prespecialized"));
	}

}
