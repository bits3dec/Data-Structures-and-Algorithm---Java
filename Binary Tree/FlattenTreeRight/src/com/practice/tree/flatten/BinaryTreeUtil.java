package com.practice.tree.flatten;

public class BinaryTreeUtil {
	static TreeNode prev = null;
	public static void flatten(TreeNode root) {
		if(root == null) {
			return;
		}
		
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}
}
