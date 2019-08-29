
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data) {
		this.data = data;
	}
}

public class Solution1 {

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
		
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		return isBSTUtil(root, min, max);
	}
	
	private static boolean isBSTUtil(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		
		if(root.data < min || root.data > max) {
			return false;
		}
		return isBSTUtil(root.left, min, root.data) && isBSTUtil(root.right, root.data, max);
	}
}
