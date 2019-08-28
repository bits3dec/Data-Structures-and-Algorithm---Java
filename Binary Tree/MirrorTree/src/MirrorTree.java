
public class MirrorTree {
	public static void main(String[] args) {
        TreeNode root = new TreeNode(1);      
        /* Construct the following binary tree 
                  1 
                /   \ 
               2     3 
              /  \ 
             4    5 
            / 
           7 
        */
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5); 
        root.left.left.left = new TreeNode(7); 
   
        printTreeInOrder(root);
        
        mirrorTree(root);
        
        System.out.println();
        printTreeInOrder(root);
	}
	
	public static void mirrorTree(TreeNode root) {
		if(root == null) {
			return;
		}
		
		mirrorTree(root.left);
		mirrorTree(root.right);
		//swap left child and right child
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}
	
	private static void printTreeInOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		printTreeInOrder(root.left);
		System.out.print(root.data + " ");
		printTreeInOrder(root.right);
	}
}


class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}
}
	
