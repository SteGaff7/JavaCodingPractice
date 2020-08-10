package pair_sum_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Use hashing to ensure O(n) runtime for finding pair sum
 * A good hashing algorithm gives expected runtime of O(1) for put and get operations
 * One pass through array ensures O(n) * O(1) runtime
 * 
 * Store compliment of element and sum as key and element as value
 * 
 * @author stephen
 *
 */

public class Hashing {
	
	public static int[] hashingMethod(int[] array, int sum) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int e : array) {
			if (map.containsKey(e)) {
				int[] pair = {e, map.get(e)};
				return pair;
			} else {
				map.put(sum - e, e);
			}
		}
		
		return null;
	}
	
	public static int countPairs(int[] array, int sum) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int num = 0;
		
		for (int e : array) {
			if (map.containsKey(e)) {
				int[] pair = {e, map.get(e)};
				System.out.println(Arrays.toString(pair));
				num++;
			} else {
				map.put(sum - e, e);
			}
		}
		return num;
	}

	public static void main(String[] args) {
		int[] array = {-8, 12, 3, 4, 1, 6, 9, 100};
		int sum = 4;
//		System.out.println(Arrays.toString(hashingMethod(array, sum)));
		System.out.println(countPairs(array, sum));
	}

}
