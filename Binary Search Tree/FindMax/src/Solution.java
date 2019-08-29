class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data) {
		this.data = data;
	}
}

public class Solution {
    public static void main(String args[]) 
    { 
        TreeNode root = new TreeNode(17);
        root.left = new TreeNode(12); 
        root.right = new TreeNode(20); 
        root.right.left = new TreeNode(18);
        root.right.left.right = new TreeNode(19); 
        root.left.left = new TreeNode(10); 
        root.left.right = new TreeNode(14);
        root.left.right.right = new TreeNode(16);
        root.left.right.right.left = new TreeNode(15);
        root.left.left.left = new TreeNode(2); 
        root.left.left.right = new TreeNode(11);
        
//        		   17
//        	    /     \
//        	  12       20
//        	 /  \     /
//        	10   14  18
//         /  \    \   \
//        2    11   16  19
//        		   /
//        		  15
        	  
        TreeNode min = findMax(root);
        System.out.println(min.data);
    }
    
    public static TreeNode findMax(TreeNode root) {
    	if(root == null) {
    		return null;
    	}
    	if(root.right == null) {
    		return root;
    	}
    	return findMax(root.right);
    }
}