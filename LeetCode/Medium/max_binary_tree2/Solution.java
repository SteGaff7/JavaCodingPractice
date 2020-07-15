package max_binary_tree2;

import max_binary_tree.RecursiveSolution;
import max_binary_tree.TreeNode;

/**
 * We are given the root node of a maximum tree: a tree where every node has a value greater than any other value in its subtree.

Just as in the previous problem, the given tree was constructed from an list A (root = Construct(A)) recursively with the following Construct(A) routine:

If A is empty, return null.
Otherwise, let A[i] be the largest element of A.  Create a root node with value A[i].
The left child of root will be Construct([A[0], A[1], ..., A[i-1]])
The right child of root will be Construct([A[i+1], A[i+2], ..., A[A.length - 1]])
Return root.
Note that we were not given A directly, only a root node root = Construct(A).

Suppose B is a copy of A with the value val appended to it.  It is guaranteed that B has unique values.

Return Constr
 * @author stephen
 *
 */
public class Solution {
	
	public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
		
		TreeNode newNode = new TreeNode(val);
		
//      Compare to root
		if (val > root.val) {
			newNode.left = root;
			return newNode;
		} 
		
		TreeNode prev = root;
		TreeNode curr = root.right;
		
		while (curr != null) {
			if (newNode.val > curr.val) {
				prev.right = newNode;
				newNode.left = curr;
				return root;
			}
			
			prev = curr;
			curr = curr.right;
		}
		
//		If curr is null
		prev.right = newNode;
		
		return root;
    }

	public static void main(String[] args) {
		int[] nums = {2,5,4,3};
		int val = 1;
		
		TreeNode root = RecursiveSolution.constructMaximumBinaryTree(nums);
		System.out.println(insertIntoMaxTree(root, val).val);

	}

}
