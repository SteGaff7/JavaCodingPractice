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
 * Expand around centres using the fact that there are 2n -1 centres
 */

public class Solution2ExpandAroundCentres {
	public static String longestPalindrome(String s) {
		
		String maxSubstring = "";
		
		if (s.isEmpty() || s == null) {
			return maxSubstring;
		}
		
//		Iterate through possible centres.
		for (int centre = 0; centre < s.length(); centre ++) {
			
			boolean skip1 = false;
			boolean skip2 = false;
			
			int maxPossibleDist1 = 2 * Math.min(0 + centre, ((s.length() - 1) - centre)) + 1; 
			
			if (maxPossibleDist1 <= maxSubstring.length()) {
				skip1 = true;
			}
			
			int maxPossibleDist2 = 2 * Math.min(centre + 1, s.length() - (centre + 1));
			
			if (maxPossibleDist2 <= maxSubstring.length()) {
				skip2 = true;
			}
			
//			Centre 1 - True Index
			int end = centre + 1;
			int start = centre;
			String sub;
			
			while (start >= 0 && end < s.length() + 1 && isPali(sub = s.substring(start, end)) && ! skip1) {	
				
				if (sub.length() > maxSubstring.length()) {
					maxSubstring = sub;
				}
				
//				Expand around centre 
				start -= 1;
				end += 1;
			}
			
//			Break from loop at last centre
			if (centre == s.length() - 1) {
				break;
			}
			
//			Centre 2 - Between Indices Centre
			end = centre + 2;
			start = centre;

			while (start >= 0 && end < s.length() + 1 && isPali(sub = s.substring(start, end)) && ! skip2) {
				
				if (sub.length() > maxSubstring.length()) {
					maxSubstring = sub;
				}

				start -= 1;
				end += 1;
			}
		}

		return maxSubstring;
	}
	
	public static boolean isPali(String s) {
		return s.charAt(0) == s.charAt(s.length()-1);
	}

	public static void main(String[] args) {
		String s = "racecar";
		System.out.println("Answer:" + longestPalindrome(s));
	}
}
