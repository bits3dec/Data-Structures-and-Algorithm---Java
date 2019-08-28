import java.util.ArrayList;
import java.util.List;

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

        printRootToLeaf(root);
	}
	
	public static void printRootToLeaf(TreeNode root) {
		if(root == null) {
			return;
		}
		
		List<TreeNode> path = new ArrayList<>();
		printRootToLeafUtil(root, path);
	}
	
	private static void printRootToLeafUtil(TreeNode root, List<TreeNode> path) {
		if(root == null) {
			return;
		}
		
		path.add(root);
		
		if(root.left == null && root.right == null) {
			printPath(path);
		}
		else {
			printRootToLeafUtil(root.left, path);
			printRootToLeafUtil(root.right, path);
		}
		path.remove(path.size()-1);
	}
	
	private static void printPath(List<TreeNode> path) {
		for(int index = 0; index < path.size(); ++index) {
			System.out.print(path.get(index).data + " ");
		}
		System.out.println();
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
