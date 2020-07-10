package container_with_most_water;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * 
 * Note: You may not slant the container and n is at least 2.
 * @author stephen
 * */

public class Solution {
	
	public static int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length - 1; i++) {
        	int x_axis = i + 1;
        	int y_axis = height[i];
        	
        	for (int j = i+1; j < height.length; j++) {
        		int x_axis2 = j + 1;
        		int y_axis2 = height[j];
        		
        		int width = x_axis2 - x_axis;
        		int h = Math.min(y_axis, y_axis2);
        		
        		int area = h * width;
        		
        		if (area > max) {
        			max = area;
        		}
        	}
        }
		return max;
    }

	public static void main(String[] args) {
		int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		System.out.println(maxArea(height));

	}

}
