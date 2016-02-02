package leetcode.complete;

import leetcode.common.ListNode;

public class DeleteNodeInLinkedList {

	public static void main(String[] args) {
		DeleteNodeInLinkedList d = new DeleteNodeInLinkedList();

		ListNode l1 = new ListNode(1);		
		ListNode l2 = new ListNode(2);
		l1.next = l2;
		ListNode l3 = new ListNode(3);
		l2.next = l3;
		ListNode l4 = new ListNode(4);
		l3.next = l4;
		
		System.out.println(l1.toString());
		
		d.deleteNode(l3);
		
		System.out.println(l1.toString());
	}

	
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
    }
}
