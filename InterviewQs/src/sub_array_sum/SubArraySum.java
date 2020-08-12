package sub_array_sum;

/**
 * Problem at: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 * @author stephen
 *
 */

public class SubArraySum {
	public static void subArray(int[] arr, int sum) {
		int startIdx = 0;
		int endIdx = 0;
		int prevEndIdx = -1;
		int runTotal = 0;
		
		while (startIdx < arr.length && endIdx < arr.length) {
			if (endIdx != prevEndIdx) {
				runTotal += arr[endIdx];
				prevEndIdx = endIdx;
			}
			
			if (runTotal == sum) {
				System.out.println(startIdx + " " + endIdx);
				return;
			} else if (runTotal < sum) {
				prevEndIdx = endIdx;
				endIdx++;
			} else if (runTotal > sum) {
				runTotal -= arr[startIdx];
				startIdx++;
			}
		}
		System.out.println(-1);
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		int sum = 9;
		subArray(a, sum);

	}

}
