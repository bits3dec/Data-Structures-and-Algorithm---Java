package com.practice.tree.kDistanceNode;

public class KDistanceNode {
	
	public int printKDistanceNode(Node node, int target, int k) {
		if(node == null) {
			return -1;
		}
		
		if(node.data == target) {
			printKDistanceNodeDown(node, k);
			return 0;
		}
			
		//dl -> denotes the distance of the root's left child from the target
		//dl = -1 -> denotes target node not found with subtree rooted with node.left
		int dl = printKDistanceNode(node.left, target, k);
		if(dl != -1) {
			if(dl + 1 == k) {
				System.out.println(node.data);
			} else {
				//root's right child will be 2 distance away from root's left child and also 
				// we need to deduct the distance of left child from the target
				printKDistanceNodeDown(node.right, k - dl - 2);
			}
			return 1 + dl;
		}
		
		//MIRROR of the above logic now for right subtree
		//Note- We come here only if target was not found in left subtree	
		int dr = printKDistanceNode(node.right, target, k);
		if(dr != -1) {
			if(dr + 1 == k) {
				System.out.println(node.data);
			} else {
				printKDistanceNodeDown(node.left, k - dr - 2);
			}
			return 1 + dr;
		}
		
		//Target was not found in both left subtree and right subtree
		return -1;
	}
	
	private void printKDistanceNodeDown(Node node, int k) {
		if(node == null || k < 0) {
			return;
		}
		
		if(k == 0) {
			System.out.println(node.data);
			return;
		}
		printKDistanceNodeDown(node.left, k-1);
		printKDistanceNodeDown(node.right, k-1);
	}
}
