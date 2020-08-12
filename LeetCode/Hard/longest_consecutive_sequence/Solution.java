package longest_consecutive_sequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 * 
 * O(n) solution that stores length of seq as a value in a hashmap
 * 
 * @author stephen
 *
 */
public class Solution {
	
	public static int longestConsecutive(int[] nums) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i : nums) {
			if (! map.containsKey(i)) {
				map.put(i, 1);
				
//				If previous number is present
				if (map.containsKey(i - 1)) {
					int prevValue = map.get(i - 1);
					int currValue = map.get(i);
					map.put(i, currValue + prevValue);
				}
				
//				If next number is present
				if (map.containsKey(i + 1)) {
					int currValue = map.get(i);
					int nextValue = map.get(i + 1);
					map.put(i, currValue + nextValue);
				}
				
//				Update headers if needed
				if (map.containsKey(i - 1)) {
					int prevValue = map.get(i - 1);
					int currValue = map.get(i);
//					Update header of this sequence
					map.put(i - prevValue, currValue);
				}
				
				if (map.containsKey(i + 1)) {
					int currValue = map.get(i);
					int nextValue = map.get(i + 1);
//					Update trailer of this sequence
					map.put(i + nextValue, currValue);
				}
				
			}
		}
		
//		Find largest value in map
		int max = 0;
		
		for (int v : map.values()) {
			max = Math.max(max, v);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(arr));
	}

}
