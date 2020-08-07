package triplet_sum_array;

import java.util.Arrays;

/**
 * O(n**2) Solution
 * @author stephen
 * 
 * Sort Array
 * Iterate through each element O(n)
 * For each element find pair that add with element to make sum
 * Use 2 pointer technique which runs in O(n)
 */

public class SolutionSorted {
	
	private static int[] triplet(int[] array, int sum) {
//		Sort array
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		
//		Iterate through each element -- n runtime
		for (int i = 0; i < array.length; i++) {
			
//			Return any pair that equals sum - element  -- n runtime
			int[] pair = twoPointer(array, sum - array[i], i);
			if (pair != null) {
				int[] ans = {array[i], pair[0], pair[1]};
				return ans;
			}
		}
		
		return null;
	}
	
	public static int[] twoPointer(int[] array, int sum, int currentIdx) {
		int p1 = 0;
		int p2 = array.length - 1;
		
		while (p1 < p2) {
//			Skip current index if needed as this element shouldn't be used in pair
			if (p1 == currentIdx) {
				p1++;
			}
			if (p2 == currentIdx) {
				p2--;
			}
			
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
		int sum = -4;
		int[] array = {-8, 12, 3, 4, 1, 6, 9, 100};
//		int sum = -1;
//		int[] array = {-2, 1, 3, 4, 6};
		System.out.println(Arrays.toString(triplet(array, sum)));
//		System.out.println(Arrays.toString(twoPointer(array, sum)));

	}

}
