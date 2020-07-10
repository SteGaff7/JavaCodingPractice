package subrectangle_queries;

/**
 * Implement the class SubrectangleQueries which receives a rows x cols rectangle as a matrix of integers in the constructor and supports two methods:

1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)

Updates all values with newValue in the subrectangle whose upper left coordinate is (row1,col1) and bottom right coordinate is (row2,col2).
2. getValue(int row, int col)

Returns the current value of the coordinate (row,col) from the rectangle.
 * @author stephen
 *
 */

public class SubrectangleQueries {
	int[][] rectangle_matrix;
	int rows;
	int cols;
	
	public SubrectangleQueries(int[][] rectangle) {
        this.rectangle_matrix = rectangle;
        this.rows = rectangle.length;
        this.cols = rectangle[0].length;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    	
    	if (row1 < 0 || row1 >= rows || col1 < 0 || col1 >= cols) {
    		throw new IndexOutOfBoundsException();
    	} else if (row2 < row1 || col2 < col1 || row2 >= rows || col2 >= cols) {
    		throw new IndexOutOfBoundsException();
    	}
    	
    	for (int i = row1; i <= row2; i++) {
    		for (int j = col1; j <= col2; j++) {
    			rectangle_matrix[i][j] = newValue;
    		}
    	}
        
    }
    
    public int getValue(int row, int col) {
    	
    	if (row >= rows || col >= cols) {
    		throw new IndexOutOfBoundsException();
    	}
        
    	return rectangle_matrix[row][col];
    }

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */

	public static void main(String[] args) {
		int[][] rectangle = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
		SubrectangleQueries obj = new SubrectangleQueries(rectangle);
		obj.updateSubrectangle(0, 0, 3, 2, 5);
		int param_2 = obj.getValue(0, 2);
		System.out.println(param_2);
	}

}
