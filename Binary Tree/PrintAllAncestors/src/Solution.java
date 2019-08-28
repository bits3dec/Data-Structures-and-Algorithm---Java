
public class Solution {
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
   
        printAllAncestors(root, 5);
	}

	public static boolean printAllAncestors(TreeNode root, int key) {
		if(root == null) {
			return false;
		}
		
		if(root.data == key) {
			System.out.println(root.data + " ");
			return true;
		}
		
		if(printAllAncestors(root.left, key) == true || printAllAncestors(root.right, key) == true) {
			System.out.println(root.data + " ");
			return true;
		}
		
		return false;
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
