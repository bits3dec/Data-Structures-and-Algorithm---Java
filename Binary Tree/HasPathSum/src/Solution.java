
public class Solution {
	public static void main(String[] args) {
		TreeNode root  = new TreeNode(10); 
	    root.left  = new TreeNode(28); 
	    root.right = new TreeNode(13); 
	  
	    root.right.left   = new TreeNode(14); 
	    root.right.right  = new TreeNode(15); 
	  
	    root.right.left.left   = new TreeNode(21); 
	    root.right.left.right  = new TreeNode(22); 
	    root.right.right.left  = new TreeNode(23); 
	    root.right.right.right = new TreeNode(24); 
	  
	    int sum = 38; 
	    hasPathSum(root, sum); 
	}
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		
		if(root.data == sum) {
			System.out.println(root.data + " ");
			return true;
		}
		
		int remainingSum = sum - root.data;
		if(hasPathSum(root.left, remainingSum) == true || hasPathSum(root.right, remainingSum) == true) {
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
