public class Solution2 {
	static TreeNode root;
	static TreeNode prev;
	
    public static void main(String args[]) 
    { 
        TreeNode root = new TreeNode(14);
        root.left = new TreeNode(12); 
        root.right = new TreeNode(15); 
        root.left.left = new TreeNode(10); 
        root.left.right = new TreeNode(13);
        root.left.left.left = new TreeNode(2); 
        root.left.left.right = new TreeNode(11);
        
//        		 14
//        	    /  \
//        	  12    15
//        	 /  \
//        	10   13
//         /  \
//        2    11
          
        if (isBST(root)) 
            System.out.println("IS BST"); 
        else
            System.out.println("Not a BST"); 
    }
    
	public static boolean isBST(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		if(isBST(root.left) == false) {
			return false;
		}
		if(prev != null && root.data < prev.data) {
			return false;
		}
		prev = root;
		
		return isBST(root.right);
	}
}
