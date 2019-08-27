import java.util.*;
import java.util.stream.Collectors;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}
 
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        
        Stack<TreeNode> currentLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        boolean leftToRight = true;
        
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        currentLevel.push(root);
        while(currentLevel.isEmpty() == false) {
            TreeNode temp = currentLevel.pop();
            nodes.add(temp);
            
            if(leftToRight == true) {
                if(temp.left != null) {
                    nextLevel.push(temp.left);
                } 
                if(temp.right != null) {
                    nextLevel.push(temp.right);
                }
            }
            else {
                if(temp.right != null) {
                    nextLevel.push(temp.right);
                } 
                if(temp.left != null) {
                    nextLevel.push(temp.left);
                }
            }
            
            if(currentLevel.isEmpty() == true) {
                Stack<TreeNode> tempLevel = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempLevel;
                
                result.add(nodes.stream().map(node -> node.val).collect(Collectors.toList()));
                nodes.clear();
                
                leftToRight = !leftToRight;
            }
        }
      
        return result;
    }
    
    private void swapLevels(Stack<TreeNode> currentLevel, Stack<TreeNode> nextLevel) {
        Stack<TreeNode> temp = currentLevel;
        currentLevel = nextLevel;
        nextLevel = temp;
    }
}