package add_2_number_linked_list;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Solution2 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		List<Integer> num1Array = new ArrayList<Integer>();
		List<Integer> num2Array = new ArrayList<Integer>();
		
		do {
			int x = l1.val;
			num1Array.add(x);
			l1 = l1.next;
		} while (l1 != null);
		
		do {
			int x = l2.val;
			num2Array.add(x);
			l2 = l2.next;
		} while (l2 != null);
		
		Collections.reverse(num1Array);
		Collections.reverse(num2Array);
		
		StringBuilder num1 = new StringBuilder();
		StringBuilder num2 = new StringBuilder();
		
		for (int i : num1Array) {
			num1.append(i);
		}
		
		for (int i : num2Array) {
			num2.append(i);
		}
		
		BigInteger number1 = new BigInteger(num1.toString());
		BigInteger number2 = new BigInteger(num2.toString());
		
		System.out.println(number1 + " " + number2);
		
		BigInteger y = number1.add(number2);
		
		String num = y + "";
		ListNode nxt = null;
		
		for (int i=0; i<num.length(); i++) {
			char c = num.charAt(i);
			int j = Integer.parseInt(String.valueOf(c));
			ListNode curr = new ListNode(j, nxt);
			nxt = curr;
		}

		return nxt;
        
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
	}
}
