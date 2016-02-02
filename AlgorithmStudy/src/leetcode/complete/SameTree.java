package leetcode.complete;

import leetcode.common.TreeNode;

public class SameTree {

	public static void main(String[] args) {
		SameTree s = new SameTree();

		TreeNode a = new TreeNode(0);
		TreeNode al = new TreeNode(1);
		TreeNode ar = new TreeNode(2);
		TreeNode all = new TreeNode(3);
		TreeNode alr = new TreeNode(4);
		TreeNode b = new TreeNode(0);
		TreeNode bl = new TreeNode(1);
		TreeNode br = new TreeNode(2);
		TreeNode bll = new TreeNode(3);
		TreeNode blr = new TreeNode(4);
		
		a.left = al;
		a.right = ar;
		al.left = all;
		al.right = alr;
		
		b.left = bl;
		b.right = br;
		bl.left = bll;
		bl.right = blr;
		
		System.out.println(s.isSameTree(a, b));
		
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if ( (p != null && q == null) 
				|| (p == null && q != null)) {
			return false;
		}else if (p==null && q==null){
			return true;
		}
		
		if (p.val != q.val){
			return false;
		}
		
		//왼쪽 자식 검사
		if (!isSameTree(p.left, q.left)){
			return false;
		}
		
		//오른쪽 자식 검사
		if (!isSameTree(p.right, q.right)){
			return false;
		}
		
        return true;
    }
}
