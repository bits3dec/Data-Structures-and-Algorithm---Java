package com.practice.tree.kDistanceNode;

public class Client {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(6);
		
		root.right.right = new Node(7);
		root.right.right.left = new Node(8);
		root.right.right.right = new Node(9);
		root.right.right.right.left = new Node(21);
		root.right.right.right.right = new Node(20);
		root.right.right.right.right.left = new Node(22);
		root.right.right.right.right.right = new Node(23);
		root.right.right.right.right.right.left = new Node(24);
		root.right.right.left.left = new Node(10);
		root.right.right.left.right = new Node(11);
		root.right.right.left.right.left = new Node(12);
		
		KDistanceNode test = new KDistanceNode();
		int target = 9;
		int k = 3;
		test.printKDistanceNode(root, target, k);
	}
}
