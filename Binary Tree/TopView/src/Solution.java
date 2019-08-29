import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
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

        List<Integer> topViewNodes = topView(root);
        for(Integer val : topViewNodes) {
        	System.out.print(val + " ");
        }
	}
	
	public static List<Integer> topView(TreeNode root) {
		if(root == null) {
			return null;
		}
		
		List<Integer> result = topViewUtil(root);
		return result;
	}
	
	private static List<Integer> topViewUtil(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		
		class TreeNodeItem {
			TreeNode node;
			int hd;
			
			TreeNodeItem(TreeNode node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		
		List<TreeNodeItem> nodes = new ArrayList<>();
		Queue<TreeNodeItem> queue = new LinkedList<>();
		Set<Integer> hdSet = new HashSet<>();
		
		queue.add(new TreeNodeItem(root, 0));
		
		while(queue.isEmpty() == false) {
			TreeNodeItem temp = queue.poll();
			if(hdSet.contains(temp.hd) == false) {
				nodes.add(temp);
				hdSet.add(temp.hd);
;			}
			if(temp.node.left != null) {
				queue.add(new TreeNodeItem(temp.node.left, temp.hd-1));
			}
			if(temp.node.right != null) {
				queue.add(new TreeNodeItem(temp.node.right, temp.hd+1));
			}
		}
		
		Collections.sort(nodes, (n1, n2) -> {
			return n1.hd - n2.hd;
		});
		
		result.addAll(nodes.stream().map(nodeItem -> nodeItem.node.val).collect(Collectors.toList()));
		
		return result;
	}
}


