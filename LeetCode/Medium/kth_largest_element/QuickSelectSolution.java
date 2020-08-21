package kth_largest_element;

import java.util.ArrayList;
import java.util.List;

/**
 * Quick select solution - In theory O(n**2) but in practice quick select is very fast
 * @author stephen
 *
 */
public class QuickSelectSolution {
	
	public static int findNum(int[] arr, int k) {
		
		int kIndex = arr.length - k;
		List<Integer> list = new ArrayList<Integer>(arr.length);
		
		for (int i : arr) {
			list.add(i);
		}
		
		return quickSelect(list, kIndex);
	}
	
	
	public static int quickSelect(List<Integer> arr, int kIndex) {
		int pivot = (int) (Math.random() * arr.size());
		int pivotValue = arr.get(pivot);
		
		List<Integer> lessThan = new ArrayList<Integer>();
		List<Integer> equal = new ArrayList<Integer>();
		List<Integer> greaterThan = new ArrayList<Integer>();
		
		for (int i : arr) {
			if (i < pivotValue) {
				lessThan.add(i);
			} else if (i > pivotValue) {
				greaterThan.add(i);
			} else {
				equal.add(i);
			}
		}
		

		if ((kIndex >= lessThan.size() && (kIndex < lessThan.size() + equal.size()))) {
			return pivotValue;
		} else if (kIndex < lessThan.size()) {
			return quickSelect(lessThan, kIndex);
		} else {
			return quickSelect(greaterThan, kIndex - lessThan.size() - equal.size());
		}
	}
	

	public static void main(String[] args) {
//		int k = 2;
//		int[] array = {3,2,1,5,6,4};
		int[] array = {-1,2,0};
		int k = 3;
		
		System.out.println(findNum(array, k));
	}
}
