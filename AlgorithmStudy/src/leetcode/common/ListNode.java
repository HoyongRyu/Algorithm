package leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }
    public String toString(){
    	return val + (next == null ? " :: end" : ", " + next.toString());
//    	return "val : " + val + (next == null ? ", next is null." : ", next : " + next.val);
    }
}