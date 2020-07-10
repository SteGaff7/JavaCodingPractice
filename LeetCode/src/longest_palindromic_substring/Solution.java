package longest_palindromic_substring;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
 * @author stephen
 *
 *
 * Check longest to shortest then break
 */

public class Solution {
	
	public static String longestPalindrome(String s) {
		
		int substringLength = s.length();
		
		while (substringLength != 0) {
			
			int startIdx = 0;
			int endIdx = startIdx + substringLength;
			
			while (endIdx <= s.length()) {
				String substring = s.substring(startIdx, endIdx);
				System.out.println(substring);
				if (isPali(substring)) {
					return substring;
				}
				
				startIdx += 1;
				endIdx = startIdx + substringLength;
			}
			
			substringLength -= 1;
		}
        
		return "";
    }
	
	public static boolean isPali(String s) {
		if (s.length() == 1) {
			return true;
		}
		
		for (int i = 0; i < s.length()/2; i++) {
			if (s.charAt(i) != s.charAt(s.length()- (i+1))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "xxracecarzz";
		System.out.println("Answer:" + longestPalindrome(s));
	}

}
