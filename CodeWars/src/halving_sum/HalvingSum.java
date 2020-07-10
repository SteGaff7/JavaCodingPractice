package halving_sum;

public class HalvingSum {
	public static int halvingSum(int n) {
		
		if (n < 0) {
			return 0;
		}
		
		int sum = 0;
		
		while (n != 0) {
			sum += n;
			n = n/2;
		}
		
	    return sum;
	  }

	public static void main(String[] args) {
		System.out.println(HalvingSum.halvingSum(25));

	}

}
