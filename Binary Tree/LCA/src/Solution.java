
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

        //Assumption both nodeA and nodeB are present in the tree
        TreeNode lca = findLCA(root, 7, 3);
        if(lca != null) {
        	System.out.println(lca.data);	
        }
        else {
        	System.out.println("No LCA !!!");
        }
	}
	
	public static TreeNode findLCA(TreeNode root, int valueA, int valueB) {
		if(root == null) {
			return null;
		}
		
		if(root.data == valueA || root.data == valueB) {
			return root;
		}
		
		TreeNode left = findLCA(root.left, valueA, valueB);
		TreeNode right = findLCA(root.right, valueA, valueB);
		
		if(left != null && right != null) {
			return root;
		}
		else if(left == null) {
			return right;
		}
		else {
			return left;
		}
		
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
