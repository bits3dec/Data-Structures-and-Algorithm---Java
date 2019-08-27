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
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

        Map<Integer, List<TreeNode>> hdMap = new TreeMap<Integer, List<TreeNode>>();
        Map<TreeNode, Integer> vdMap = new HashMap<TreeNode, Integer>();
        verticalTraversalUtil(root, 0, 0, hdMap, vdMap);
        
        for(Map.Entry<Integer, List<TreeNode>> entry : hdMap.entrySet()) {
            List<TreeNode> nodes = entry.getValue();
            Collections.sort(nodes, (n1, n2) -> {
                if(vdMap.get(n1) == vdMap.get(n2)) {
                    return n1.val - n2.val;
                }
                
                return vdMap.get(n1) - vdMap.get(n2);
            });
            result.add(nodes.stream().map((a) -> a.val).collect(Collectors.toList()));
        }
        
        return result;
    }
    
    private void verticalTraversalUtil(TreeNode root, int hd, int vd, Map<Integer, List<TreeNode>> hdMap, Map<TreeNode, Integer> vdMap) {
        if(root == null) {
            return;
        }
        //PreOrder Traversal
        //Process
        List<TreeNode> current = hdMap.get(hd);
        if(current == null) {
            current = new ArrayList<TreeNode>();
            current.add(root);
            hdMap.put(hd, current);
            vdMap.put(root, vd);
        } else {
            current.add(root);
            vdMap.put(root, vd);
        } 
        //LeftSubtree
        verticalTraversalUtil(root.left, hd-1, vd+1, hdMap, vdMap);       
        //rightSubTree
        verticalTraversalUtil(root.right, hd+1, vd+1, hdMap, vdMap);
    }
}