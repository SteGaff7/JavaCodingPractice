package kth_largest_element;

import java.util.Arrays;

/**
 * Simple sort and index solution with runtime O(nlogn)
 * @author stephen
 *
 */
public class Solution {
	
	public static int findNum(int[] arr, int k) {
		Arrays.parallelSort(arr);
		
		return arr[k-1];
	}

	public static void main(String[] args) {
		int k = 2;
		int[] array = {3,2,1,5,6,4};
		System.out.println(findNum(array, k));
	}

}
