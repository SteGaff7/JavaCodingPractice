package largest_5_digit;

/**
 * Complete the solution so that it returns the greatest sequence of five consecutive digits found within the number given. 
 * The number will be passed in as a string of only digits. It should return a five digit integer. 
 * The number passed may be as large as 1000 digits.
 * @author stephen
 *
 */

public class LargestFiveDigitNumber {

	public static int solve(final String digits) {
		if (digits.length() < 5) {
			return 0;
		}
		
		int largest = Integer.MIN_VALUE;
		for (int i=0; i<= digits.length()-5; i++) {
			String sub = digits.substring(i, i+5);
			int current = Integer.parseInt(sub);
			
			largest = Math.max(current, largest);
		}	
		
		return largest;
	}
	
	public static void main(String[] args) {
		System.out.println(LargestFiveDigitNumber.solve("999912349995561"));
	}
}
