package pair_sum_array;

import java.util.Arrays;

/**
 * Input must be sorted
 * 
 * @author stephen
 *
 */

public class TwoPointer {
	
	public static int[] twoPointerMethod(int[] array, int sum) {
		int p1 = 0;
		int p2 = array.length - 1;
		
		while (p1 < p2) {
			
			int add = array[p1] + array[p2];
			
			if (add == sum) {
				int[] pair = {array[p1], array[p2]};
				return pair;
			} else if (add > sum) {
				p2--;
			} else {
				p1++;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] array = {-8, 12, 3, 4, 1, 6, 9, 100};
		Arrays.parallelSort(array);
		int sum = 7;
		System.out.println(Arrays.toString(twoPointerMethod(array, sum)));

	}

}
