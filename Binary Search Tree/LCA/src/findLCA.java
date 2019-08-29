
class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data) {
		this.data = data;
	}
}

public class findLCA {
    public static void main(String args[]) 
    { 
        TreeNode root = new TreeNode(14);
        root.left = new TreeNode(12); 
        root.right = new TreeNode(15); 
        root.left.left = new TreeNode(10); 
        root.left.right = new TreeNode(13); //nodeB
        root.left.left.left = new TreeNode(2); 
        root.left.left.right = new TreeNode(11); //nodeA
        
//        		 14
//        	    /  \
//        	  12    15
//        	 /  \
//        	10   13
//         /  \
//        2    11
        	  
        //Assume that both nodeA and nodeB are present in the BST
        TreeNode nodeA = root.left.left.right;
        TreeNode nodeB = root.right;
        
        TreeNode lca = findLCA(root, nodeA, nodeB);
        System.out.println(lca.data);
    }
    
    public static TreeNode findLCA(TreeNode root, TreeNode nodeA, TreeNode nodeB) {
    	if(root == null) {
    		return null;
    	}
    	
    	if(root.data == nodeA.data || root.data == nodeB.data) {
    		return root;
    	}
    	if(root.data > nodeA.data && root.data < nodeB.data) {
    		return root;
    	}
    	if(root.data > nodeA.data && root.data > nodeB.data) {
    		return findLCA(root.left, nodeA, nodeB);
    	}
    	else {
    		return findLCA(root.right, nodeA, nodeB);
    	}
    }
}
