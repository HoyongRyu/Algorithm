package leetcode.complete;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.common.TreeNode;

public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		MinimumDepthOfBinaryTree m = new MinimumDepthOfBinaryTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.right = new TreeNode(12);
//		root.left.left = new TreeNode(111);
//		root.left.right = new TreeNode(112);
		
		System.out.println(m.minDepth(root));
	}

	public int minDepth(TreeNode root) {
        
        if (root == null){
        	return 0;
        }
        if (root.left == null
        		&& root.right == null){
        	return 1;
        }
        
        int result = 0;
        		
        Queue<TreeNodeWithDepth> q = new LinkedList<TreeNodeWithDepth>();
        
        TreeNodeWithDepth nodeObject = null;
        q.offer(new TreeNodeWithDepth(root, 1));
        while (!q.isEmpty()){
        	nodeObject = q.poll();
        	if (nodeObject.node.left == null
        			&& nodeObject.node.right == null){
        		result = nodeObject.depth;
        		break;
        	}
        	if (nodeObject.node.left != null){
        		q.offer(new TreeNodeWithDepth(nodeObject.node.left, nodeObject.depth+1));
        	}
        	if (nodeObject.node.right != null){
        		q.offer(new TreeNodeWithDepth(nodeObject.node.right, nodeObject.depth+1));
        	}
        }
        
		return result;
    }
}

class TreeNodeWithDepth{
	TreeNode node;
	int depth;
	
	public TreeNodeWithDepth(TreeNode node, int depth){
		this.node = node;
		this.depth = depth;
	}
}