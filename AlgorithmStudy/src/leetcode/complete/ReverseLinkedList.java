package leetcode.complete;

import leetcode.common.ListNode;

public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head = r.reverseList(head);
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	public ListNode reverseList(ListNode head) {
		if (head == null){
			return null;
		}
		if (head.next == null){
			return head;
		}
		ListNode inputNode = head;
		ListNode prevNode = null;
		ListNode node = null;
		
		prevNode = new ListNode(inputNode.val);
		inputNode = inputNode.next;
        while(inputNode != null){
        	node = new ListNode(inputNode.val);
        	node.next = prevNode;
        	prevNode = node;
        	inputNode = inputNode.next;
//        	System.out.println(node.toString());
        }
        
        return node;
    }
}
