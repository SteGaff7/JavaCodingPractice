package container_with_most_water;

public class Solution2 {
	
	public static int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
		int pointer_L = 0;
		int pointer_R = height.length - 1;
		
        while (pointer_L != pointer_R) {
        	int width = (pointer_R + 1) - (pointer_L + 1);
        	int h = Math.min(height[pointer_L], height[pointer_R]);
        	
        	int area = h * width;
        	
        	if (area > max) {
        		max = area;
        	}
        	
        	if (height[pointer_L] > height[pointer_R]) {
        		pointer_R -= 1;
        	} else {
        		pointer_L += 1;
        	}
        }
		
		return max;
    }

	public static void main(String[] args) {
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(maxArea(height));

	}

}
