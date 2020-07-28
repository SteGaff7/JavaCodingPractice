package trapping_rain_water;

public class Solution2Better {
	
	public static int trap(int[] height) {
		int water = 0;
		
		int startIdx = 0;
		int endIdx = height.length - 1;
		int prevMaxHeight = 0;
		
		while (startIdx < endIdx) {
			
			int leftHeight = height[startIdx];
			int rightHeight = height[endIdx];
			
			int currHeight = Math.min(leftHeight, rightHeight);
			
			if (currHeight > prevMaxHeight) {
	//			Iterate through all the values between start and end index
				for (int i = startIdx; i < endIdx; i++) {
					int value = height[i];
					
	//				Value only valid if lower than the lower bound 
					if (value < currHeight) {
						if (value >= prevMaxHeight) {
							water += currHeight - value;
						} else {
							water += currHeight - prevMaxHeight;
						}
					}
				}
			}
			
//			Reassign previous max height 
			if (currHeight > prevMaxHeight) {
				prevMaxHeight = currHeight;
			}
			
//			Reassign lower height index
			if (leftHeight > rightHeight) {
				endIdx--;
			} else {
				startIdx++;
			}
		}
		return water;
	}

	public static void main(String[] args) {
		int[] in = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] in = {5,5,1,7,1,1,5,2,7,6};
		
		System.out.println(trap(in));

	}

}
