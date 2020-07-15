package max_binary_tree;

import java.util.Arrays;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.
 * @author stephen
 *
 */

public class RecursiveSolution {
	
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		int max = Integer.MIN_VALUE;
		int idx = 0;
		
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] > max) {
        		max = nums[i];
        		idx = i;
        	}
        }
        
        TreeNode treeRoot = new TreeNode(nums[idx]);
        
        if (idx > 0) {
        	int[] leftArray = Arrays.copyOfRange(nums, 0, idx);
        	treeRoot.left = constructMaximumBinaryTree(leftArray);
        }
        
        if (idx + 1 < nums.length) {
        	int[] rightArray = Arrays.copyOfRange(nums, idx + 1, nums.length);
        	treeRoot.right = constructMaximumBinaryTree(rightArray);
        }

        return treeRoot;
    }
	
	public static void main(String args[]) {
		int[] nums = {3,2,1,6,0,5};
		System.out.println(constructMaximumBinaryTree(nums).val);
	}

}
