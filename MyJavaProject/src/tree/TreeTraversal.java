package tree;

import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
}

public class TreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeTraversal obj = new TreeTraversal();
		TreeNode root = obj.constructTree();
		System.out.println("debug");
		LinkedList<Integer> list =   obj.doInorderTraversal(root);
		System.out.println(list);
		System.out.println(obj.isTreeBSTUtil(root));
	}
	
	private boolean isTreeBSTUtil(TreeNode root) {
		Integer prev = null;
		if(root != null) {
			return checkIfBST(root, prev);
		}
		return false;
	}

	private boolean checkIfBST(TreeNode node, Integer prev) {
		if(node == null) {
			return true;
		}
		if(node.left != null && !checkIfBST(node.left, prev)) return false;
		if (prev!= null && prev >= node.val) return false;
		prev = node.val;
		if(node.right != null && !checkIfBST(node.right, prev)) return false;
		return true;
	}

	private LinkedList<Integer> doInorderTraversal(TreeNode root) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<Integer>();
		if(root != null) {
			inorder(root, list);
		}		
		return list;
	}

	private void inorder(TreeNode node, LinkedList<Integer> list) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}
		else {
			inorder(node.left, list);
			list.add(node.val);
			inorder(node.right, list);
			return;
		}		
	}

	private TreeNode constructTree() {
		TreeNode root = new TreeNode();
		root.val = 100;
		root.left = new TreeNode();
		root.right = new TreeNode();
		root.left.val = 50;
		root.right.val = 200;
		root.left.left = new TreeNode();
		root.left.left.val = 25;
		root.left.right = new TreeNode();
		root.left.right.val = 75;
		root.right.left = new TreeNode();
		root.right.left.val = 150;
		root.right.right = new TreeNode();
		root.right.right.val = 275;
		return root;
	}

}
