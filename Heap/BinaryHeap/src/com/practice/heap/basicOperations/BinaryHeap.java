package com.practice.heap.basicOperations;

public class BinaryHeap {
	int capacity;
	int count;	
	int arr[];
	
	//MinHeap
	public BinaryHeap(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
	}
	
	//T:O(n)
	public void buildHeap(int arr[]) {
		int n = arr.length;
		if(n > this.capacity) {
			System.out.println("Not sufficient capacity !!!");
			return;
		}
		
		for(int i = 0; i < n; ++i) {
			this.arr[i] = arr[i];
			++count;
		}
		
		for(int i = (n-2)/2; i >= 0; --i) {
			heapify(i);
		}
	}
	
	public int getParentIndex(int i) {
		if(i > 0) {
			return (i-1)/2;
		}
		return -1;
	}
	
	public int getLeftChildIndex(int i) {
		int l = 2*i + 1;
		if(l < count) {
			return l;
		}
		return -1;
	}
	
	public int getRightChildIndex(int i) {
		int r = 2*i + 2;
		if(r < count) {
			return r;
		}
		return -1;
	}
	
	//T:O(log n)
	//MinHeap: Percolate Down
	public void heapify(int i) {
		int l = getLeftChildIndex(i);
		int r = getRightChildIndex(i);
		int min = i;
		
		if(l != -1 && arr[l] < arr[min]) {
			min = l;
		}
		if(r != -1 && arr[r] < arr[min]) {
			min = r;
		}
		if(min != i) {
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			heapify(min);
		}
	}

	public int getMin() {
		if(count < 0) {
			return Integer.MIN_VALUE;
		}	
		return arr[0];
	}
	
	public int deleteMin() {
		if(count < 0) {
			return Integer.MIN_VALUE;
		}
		
		int min = arr[0];
		arr[0] = arr[count-1];
		--count;
		heapify(0);	
		return min;
	}
	
	public void insert(int newValue) {
		if(count == capacity) {
			System.out.println("Heap is full !!!");
			return;
		}
		
		int i = count;
		arr[i] = newValue;
		
		//T:O(log n)
		//MinHeap: Percolate Up
		int parent = getParentIndex(i);
		while(parent != -1 && arr[parent] > arr[i]) {
			int temp = arr[parent];
			arr[parent] = arr[i];
			arr[i] = temp;
			
			i = parent;
			parent = getParentIndex(i);
		}
		++count;
	}
	
	public void print() {
		for(int i = 0; i < count; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
