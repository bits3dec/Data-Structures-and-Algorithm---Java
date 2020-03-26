import java.util.*;

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

        bottomView(root);
	}
	
	static void bottomView(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNodeItem> queue = new LinkedList<TreeNodeItem>();
        Map<Integer, TreeNodeItem> nodeByHD = new TreeMap<Integer, TreeNodeItem>();
        queue.add(new TreeNodeItem(root, 0));

        while(!queue.isEmpty()) {
            TreeNodeItem temp = queue.poll();
            int hd = temp.hd;
            nodeByHD.put(hd, temp);
            if(temp.node.left != null) {
                queue.add(new TreeNodeItem(temp.node.left, hd-1));
            }
            if(temp.node.right != null) {
                queue.add(new TreeNodeItem(temp.node.right, hd+1));
            }
        }

        List<TreeNode> result = new ArrayList<>();
        for(Map.Entry<Integer, TreeNodeItem> entry : nodeByHD.entrySet()) {
            TreeNodeItem nodeItem = entry.getValue();
            result.add(nodeItem.node);
        }
        print(result);
	}
	
    private static void print(List<TreeNode> nodes) {
        for(TreeNode node : nodes) {
            System.out.print(node.data + " ");
        }
    }
}
