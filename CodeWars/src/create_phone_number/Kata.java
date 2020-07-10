package create_phone_number;

public class Kata {
	public static String createPhoneNumber(int[] numbers) {
		
		if (numbers.length != 10) {
			return null;
		}
		
		StringBuilder phoneNumber = new StringBuilder(10);
		phoneNumber.append("(");
		
		for (int i=0; i < numbers.length; i++) {
			if (i == 3) {
//				Add ") "
				phoneNumber.append(") ");
			} else if (i == 6) {
//				Add "-"
				phoneNumber.append("-");
			}
			phoneNumber.append(numbers[i]);
		}	
		
		return phoneNumber.toString();
	  }

	public static void main(String[] args) {
		System.out.println(createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
	}

}
