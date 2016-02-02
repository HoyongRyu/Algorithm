package leetcode.complete;

import leetcode.common.ListNode;


public class AddTwoNumbers{

	public static void main(String[] args){
		AddTwoNumbers atn = new AddTwoNumbers();
		
		ListNode l1 = new ListNode(2);
		ListNode l1_2 = new ListNode(4);
		l1.next = l1_2;
		ListNode l1_3 = new ListNode(3);
		l1_2.next = l1_3;
		
		ListNode l2 = new ListNode(5);
		ListNode l2_2 = new ListNode(6);
		l2.next = l2_2;
		ListNode l2_3 = new ListNode(4);
		l2_2.next = l2_3;
		
		ListNode result = atn.addTwoNumbers(l1, l2);
		System.out.println(result);
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode result = null;
		ListNode ln1 = l1;
		ListNode ln2 = l2;
		ListNode tempResult = null;
		
		int carry = 0;
		int temp = 0;
		while (ln1 != null || ln2 != null){
			if (ln1 != null && ln2 != null){
				temp = ln1.val + ln2.val + carry;
				ln1 = ln1.next; ln2 = ln2.next;
			}else if (ln2 == null){
				temp = ln1.val + carry;
				ln1 = ln1.next;
			}else if (ln1 == null){
				temp = ln2.val + carry;
				ln2 = ln2.next;
			}
			carry = temp / 10;
			temp = temp % 10;
			if (result == null){
				result = new ListNode(temp);
				tempResult = result;
			}else {
				tempResult.next = new ListNode(temp);
				tempResult = tempResult.next;
			}
		}
		
		if (carry > 0){
			tempResult.next = new ListNode(carry);
			tempResult = tempResult.next;
		}
		
		return result;

	}
}
