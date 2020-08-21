package kth_smallest_BST;

public class ArraySolution {
	
	private static int c = 0;
	private static boolean found = false;
	private static int answer;

	
	public static int inOrder(int[] bst, int k) {
		visit(bst, 0, k);
		return answer;
	}
	
	public static void visit(int[] bst, int currIdx, int k) {
		try { 
			if (bst[currIdx] == Integer.MIN_VALUE) {
				return;
			} 
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		
		if (! found) {
			visit(bst, (2 * currIdx) + 1, k);
		}

		c++;
//	 	For checking the order of nodes visited	
//		if (! found) {
//			System.out.println(c);
//		}

		if (c == k) {
			found = true;
			answer = bst[currIdx];
			return;
		}

		if (! found) {
			visit(bst, (2 * currIdx) + 2, k);
		}
	}

	public static void main(String[] args) {
//		int[] tree = {5,3,6,2,4,Integer.MIN_VALUE,Integer.MIN_VALUE,1};
		int[] tree = {25,20,36,10,22,30,40,5,12,Integer.MIN_VALUE,Integer.MIN_VALUE,28,Integer.MIN_VALUE,38, 48};
		int k = 3;
		System.out.println(inOrder(tree, 9));
	}

}
