package add_2_number_linked_list;

/**
 * Better Solution
 * 
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

public class Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		boolean first = true;
		int carry = 0;
		
		ListNode curr = new ListNode();
		ListNode head = new ListNode();
		
		while (l1 != null || l2 != null || carry != 0) {
			
			int a = 0;
			if (l1 != null) {
				a = l1.val;
				l1 = l1.next;
			}
			int b = 0;
			if (l2 != null) {
				b = l2.val;
				l2 = l2.next;
			}
			
			int sum = a + b + carry;
			
			carry = sum / 10;
			
			ListNode next = new ListNode();
			
			curr.val = sum % 10;
			
			// Handle end case
			if ((l1 != null) || (l2 != null) || (carry != 0)) {
				curr.next = next;
			}

			// Set head pointer
			if (first) {
				head = curr;
				first = false;
			}
			
			curr = next;
			
		}
		
		return head;
	}
	
	
	public static void main(String[] args) {
		ListNode c = new ListNode(3);
		ListNode b = new ListNode(4, c);
		ListNode a = new ListNode(2, b);
		
		ListNode z = new ListNode(4);
		ListNode y = new ListNode(6, z);
		ListNode x = new ListNode(5, y);
		
		System.out.println(addTwoNumbers(a, x).val);
		System.out.println(addTwoNumbers(a, x).next.val);
		System.out.println(addTwoNumbers(a, x).next.next.val);
	}
}
