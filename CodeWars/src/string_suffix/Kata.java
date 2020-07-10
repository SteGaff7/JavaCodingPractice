package string_suffix;

public class Kata {
	public static boolean solution(String str, String ending) {
		
		if (ending.length() > str.length()) {
			return false;
		}
		
	    for (int i=0; i < ending.length(); i++) {
	    	if  (ending.charAt(ending.length() - (i+1)) != str.charAt(str.length() - (i+1))) {
	    		return false;
	    	}
	    }
		return true;
	  }

	public static void main(String[] args) {
		System.out.println(solution("abc", "bc"));

	}

}
