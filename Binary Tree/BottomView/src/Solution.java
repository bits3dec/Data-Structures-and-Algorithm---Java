import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}
}

class TreeNodeItem {
	TreeNode node;
	int hd;
	
	TreeNodeItem(TreeNode node, int hd) {
		this.node = node;
		this.hd = hd;
	}
}

public class Solution {
	public static void main(String[] args) {
        TreeNode root = new TreeNode(1);      
        /* Construct the following binary tree 
                  1 
                /   \ 
               2     3 
              /  \ 
             4    5 
            / 	/   \
           7   8	 9
           			  \
           			   10
        */
        root.left = new TreeNode(2); 
        root.right = new TreeNode(3); 
        root.left.left = new TreeNode(4); 
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.left.right.right.right = new TreeNode(10);
        root.left.left.left = new TreeNode(7); 

        List<Integer> bottomViewNodes = bottomView(root);
        for(Integer val : bottomViewNodes) {
        	System.out.print(val + " ");
        }
	}
	
	public static List<Integer> bottomView(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		List<Integer> result = new ArrayList<>();
		List<TreeNodeItem> nodes = new ArrayList<>();
		Set<Integer> hdSet = new HashSet<>();
		bottomViewUtil(root, 0, hdSet, nodes);
		Collections.sort(nodes, (n1, n2) -> {
			return n1.hd - n2.hd;
		});
		result.addAll(nodes.stream().map(nodeItem -> nodeItem.node.data).collect(Collectors.toList()));
		
		return result;
	}
	
	private static void bottomViewUtil(TreeNode root, int hd, Set<Integer> hdSet, List<TreeNodeItem> nodes) {
		if(root == null) {
			return;
		}
		
		bottomViewUtil(root.left, hd-1, hdSet, nodes);
		bottomViewUtil(root.right, hd+1, hdSet, nodes);
		if(hdSet.contains(hd) == false) {
			nodes.add(new TreeNodeItem(root,hd));
			hdSet.add(hd);
		}
	}
}
