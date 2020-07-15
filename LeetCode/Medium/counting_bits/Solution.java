package counting_bits;

import java.util.Arrays;

/**
 * O(nlogn) Solution
 * 
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * Example 1:
 * 
 * Input: 2
 * Output: [0,1,1]
 * @author stephen
 *
 */

public class Solution {
	
	public static int[] countBits(int num) {
        
		int[] res = new int[num + 1];
		
		for (int n = 1; n <= num; n++) {
			res[n] = count1s(n);
		}

		return res;
    }

	private static int count1s(int n) {
//		Could iterate through string representation - O(n) with n loop === O(n2)
//		Mathematically calculate how many 1s?
//		Keep a tracker/counter with conditional?
		
		if (n == 0) {
			return n;
		}
		
		int p = (int) log2(n);
		int b = (int) Math.pow(2, p);
		int r;
		int count1s = 0;
		
		
		while ((r = n % b) != 0) {
//			System.out.println("number: " + n + " base: " + b + " remainder: " + r);
			count1s++;
			n = r;
			p = (int) log2(n);
			b = (int) Math.pow(2, p);
			
			if (r == 1) {
				count1s++;
				return count1s;
			}
		}
		
		count1s++;
		
		return count1s;
	}
	
	public static int log2(int n) {
		
		int result = (int) (Math.log(n) / Math.log(2));
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBits(24)));
	}
}
