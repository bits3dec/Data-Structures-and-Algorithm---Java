package com.practice.graph.shortestDistance;

//MinHeap
//Priority: Distance of the node- "distance"
public class Heap {
	private final static Node DUMMY = new Node(-1, Integer.MAX_VALUE);
	
	Node nodes[];
	int count;
	int capacity;
	
	public Heap(int capacity) {
		this.capacity = capacity;
		this.nodes = new Node[capacity];
	}
	
	public Node deleteMin() {
		if(count < 0) {
			return DUMMY;
		}
		
		Node min = nodes[0];
		--count;
		nodes[0] = DUMMY;	
		heapify(0);	
		return min;
	}
	
	private void heapify(int i) {
		int n = count;
		int min = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if(l < n && nodes[l].distance < nodes[min].distance) {
			min = l;
		}
		if(r < n && nodes[r].distance < nodes[min].distance) {
			min = r;
		}
		if(min != i) {
			Node temp = nodes[i];
			nodes[i] = nodes[min];
			nodes[min] = temp;
		
			heapify(min);
		}
	}
	
	public void insert(Node newNode) {
		if(count == capacity) {
			System.out.println("Heap is full !!!");
			return;
		}
		
		int index = count;
		nodes[index] = newNode;
		int parent = (index-1)/2;
		while(index > 0 && nodes[parent].distance > nodes[index].distance) {
			Node temp = nodes[parent];
			nodes[parent] = nodes[index];
			nodes[index] = temp;
			
			index = parent;
			parent = (index-1)/2;
		}
		++count;
	}
}
