package triplet_sum_array;

import java.util.Arrays;

/**
 * Given an array, find three numbers that add to a given sum
 * @author stephen
 *
 * Brute force method generating all triplets
 * Space complexity O(1)
 * Runtime complexity O(n**3)
 */

public class SolutionBruteForce {
	
	public static int[] triplet(int[] arr, int sum) {
		
		for (int i = 0; i < arr.length - 2; i++) {
			
			for (int j = i + 1; j < arr.length - 1; j++) {
					
				for (int k = i + 2; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == sum) {
						int[] res = {arr[i], arr[j], arr[k]};
						return res;
					}
				}
			}
		}
		
		return null;
	}

	public static void main(String[] args) {
		int sum = 24;
		int[] array = {12, 3, 4, 1, 6, 9};
		System.out.println(Arrays.toString(triplet(array, sum)));
	}

}
