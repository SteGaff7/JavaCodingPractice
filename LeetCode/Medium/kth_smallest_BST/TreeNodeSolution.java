package kth_smallest_BST;

/**
 * Very fast solution that runs in O(n) but practically runs very quickly due to the use
 * of global/static variables
 * 
 * Space complexity O(1)
 * 
 * @author stephen
 *
 */

public class TreeNodeSolution {
	
	private static int counter;
	private static boolean found;
	private static int answer;
	private static int k;
	
	public static int inOrder(TreeNode root, int kth) {
		counter = 0;
        found = false;
		k = kth;
		visit(root);
		return answer;
	}
	
	public static void visit(TreeNode n) {
		if (n.left != null && ! found) {
			visit(n.left);
		}
		counter++;
//		System.out.println(counter);
		if (counter == k) {
			answer = n.val;
            found = true;
            return;
		}
		if (n.right != null && ! found) {
			visit(n.right);
		}
	}

	public static void main(String[] args) {
		
//		TreeNode two = new TreeNode(2, null, null);
//		TreeNode one = new TreeNode(1, null, two);
//		TreeNode four = new TreeNode(4, null, null);
//		TreeNode three = new TreeNode(3, one, four);
		
		TreeNode one = new TreeNode(1, null, null);
		TreeNode four = new TreeNode(4, null, null);
		TreeNode two = new TreeNode(2, one, null);
		TreeNode three = new TreeNode(3, two, four);
		TreeNode six = new TreeNode(3, null, null);
		TreeNode five = new TreeNode(3, three, six);
		
		int k = 3;
		
		System.out.println(inOrder(five, k));
	}

}
