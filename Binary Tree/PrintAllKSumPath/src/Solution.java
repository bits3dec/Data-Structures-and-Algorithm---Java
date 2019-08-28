import java.util.*;

public class Solution {
	// Driver code
	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(1);
		root.right = new TreeNode(-1);
		root.right.left = new TreeNode(4);
		root.right.left.left = new TreeNode(1);
		root.right.left.right = new TreeNode(2);
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(2);

		int k = 5;
		printAllKSumPath(root, k);
	}

	public static void printAllKSumPath(TreeNode root, int sum) {
		List<Integer> path = new ArrayList<>();
		printAllKSumPathUtil(root, sum, path);
	}

	private static void printAllKSumPathUtil(TreeNode root, int sum, List<Integer> path) {
		if (root == null) {
			return;
		}

		path.add(root.data);

		printAllKSumPathUtil(root.left, sum, path);
		printAllKSumPathUtil(root.right, sum, path);

		int currentSum = 0;
		for (int index = path.size() - 1; index >= 0; --index) {
			currentSum += path.get(index);
			if (currentSum == sum) {
				printPath(path, index);
			}
		}
		path.remove(path.size() - 1);
	}

	private static void printPath(List<Integer> path, int ancestorIndex) {
		for (int index = path.size() - 1; index >= ancestorIndex; --index) {
			System.out.println(path.get(index) + " ");
		}
		System.out.println();
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		data = x;
	}
}

