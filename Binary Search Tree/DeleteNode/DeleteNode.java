public class DeleteNode {
    public static void main(String args[]) {
//        		   17
//        	    /     \
//        	  12       20
//        	 /  \     /
//        	10   14  18
//         /  \    \   \
//        2    11   16  19
//        		   /
//        		  15
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

        inOrder(root);

        System.out.println();
        delete(root, 10);

        inOrder(root);
    }

    static TreeNode delete(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.data > key) {
            root.left = delete(root.left, key);
        } else if(root.data < key) {
            root.right = delete(root.right, key);
        }    
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else
        { 
            // node with only one child or no child 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            // node with two children: Get the inorder successor (smallest 
            // in the right subtree) 
            root.data = findMax(root.left); 
  
            // Delete the inorder predecessor 
            root.left = delete(root.left, root.data); 
        } 
        return root;
    }

    private static int findMax(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }

        if(root.right == null) {
            return root.data;
        }        
        return findMax(root.right);
    }

    private static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}