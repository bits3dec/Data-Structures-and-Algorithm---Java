package com.practice.tree.flatten;

public class Client {
	public static void main(String[] args) {
	    /* 
	          1 
        	/   \ 
    	   2     5 
          / \     \ 
         3   4     6 
       */

		TreeNode root = new TreeNode(1); 
	    root.left = new TreeNode(2); 
	    root.right = new TreeNode(5); 
	    root.left.left = new TreeNode(3); 
	    root.left.right = new TreeNode(4); 
	    root.right.right = new TreeNode(6); 
    
	    System.out.println("*** Before flattening ***");
	    inOrder(root);
	    
	    BinaryTreeUtil.flatten(root);
	    
	    System.out.println("\n*** After flattening ***");
	    inOrder(root);
	}
	
	private static void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data +" ");
		inOrder(root.right);
	}
}
