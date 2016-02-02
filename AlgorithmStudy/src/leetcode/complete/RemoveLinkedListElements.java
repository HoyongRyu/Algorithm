package leetcode.complete;

import leetcode.common.ListNode;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l2_1 = new ListNode(6);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		
		l1.next = l2;
		l2.next = l2_1;
		l2_1.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		ListNode c = new RemoveLinkedListElements().removeElements(l1, 6);
		System.out.println("");
		
		l5.next = null;
		ListNode c1 = new RemoveLinkedListElements().removeElements(l1, 6);
		System.out.println("");
		
		new RemoveLinkedListElements().removeElements(null, 6);
	}
	
	public ListNode removeElements(ListNode head, int val) {
//		System.out.println("현재 node : " + head.val + ", 다음 node : " + head.next.val);
		if (head == null){
			return null;
		}
		if (head.val == val){
			if (head.next == null) {
				return null;
			}else {
				return removeElements(head.next, val);
			}
        }else {
        	if (head.next == null) {
    			return head;
    		}else {
	        	head.next = removeElements(head.next, val); 
	        	return head;
    		}
        }
        
    }

}
