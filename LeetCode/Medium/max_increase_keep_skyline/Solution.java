package max_increase_keep_skyline;


/**
 * In a 2 dimensional array grid, each value grid[i][j] represents the height of a building located there. We are allowed to increase the height of any number of buildings, by any amount (the amounts can be different for different buildings). Height 0 is considered to be a building as well. 

At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right, must be the same as the skyline of the original grid. A city's skyline is the outer contour of the rectangles formed by all the buildings when viewed from a distance. See the following example.

What is the maximum total sum that the height of the buildings can be increased?
 * @author stephen
 *
 */

public class Solution {
	
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] left_right_max = new int[grid.length];
        int[] top_bottom_max = new int[grid[0].length];
        int maxIncrease = 0;
        
        for (int row = 0; row < grid.length; row++) {
        	for (int col = 0; col < grid[row].length; col++) {
        		top_bottom_max[col] = Math.max(top_bottom_max[col], grid[row][col]);
        		left_right_max[row] = Math.max(left_right_max[row], grid[row][col]);
        	}
        }

        
        for (int row = 0; row < grid.length; row++) {
        	for (int col = 0; col < grid[row].length; col++) {
        		
        		int currentHeight = grid[row][col];
        		
        		maxIncrease += Math.min(left_right_max[row], top_bottom_max[col]) - currentHeight;
        	}
        }
        
		return maxIncrease;
    }

	public static void main(String[] args) {
		int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		System.out.println(maxIncreaseKeepingSkyline(grid));
	}

}
