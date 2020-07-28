package trapping_rain_water;

/**
 * N**2 solution
 * 
 * @author stephen
 *
 */
public class Solution {
	
	public static int trap(int[] height) {
        int water = 0;
        int maxHeight = 0;
        
//        Get highest point
        for (int i : height) {
        	maxHeight = Math.max(i, maxHeight);
        }
        
        int[][] matrix = new int[maxHeight][height.length];
        
//        Set up matrix
        for (int i = 0; i < height.length; i++) {
        	int h = height[i];
        	
        	for (int j = 0; j < h; j++) {
        		matrix[j][i] = 1;
        	}
        }
        
//        Print matrix
        for (int i =0; i < matrix.length; i++) {
        	boolean leftBased = false;
        	int counter = 0;
        	for (int j = 0; j < matrix[i].length; j++) {
        		System.out.print(matrix[i][j] + " ");
        		
        		int value = matrix[i][j];
        		
        		if (value == 0) {
        			counter += 1;
        		}
        		
        		if (value == 1) {
        			if (leftBased) {
        				water += counter;
        			}
        			counter = 0;
        			leftBased = true;
        		}
        	}
        	System.out.println();
        }
        return water;
    }

	public static void main(String[] args) {
		int[] in = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		System.out.println(trap(in));

	}

}
