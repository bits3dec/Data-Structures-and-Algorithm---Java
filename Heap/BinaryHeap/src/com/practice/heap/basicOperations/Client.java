package com.practice.heap.basicOperations;

public class Client {
	public static void main(String[] args) {
		System.out.println("*** Min Heap ***");
		
		BinaryHeap heap = new BinaryHeap(10);
        heap.insert(17);
        heap.insert(15);
        heap.insert(6);
        heap.insert(1);
        heap.insert(4);
        heap.insert(2);
        heap.insert(5);

        System.out.println("Heap1: ");
        heap.print();
        
        System.out.println("Minimum element: " + heap.getMin());
        
        System.out.println("Deleting minimum element: " + heap.deleteMin());
        System.out.println("Heap1 after deleting min: ");
        heap.print();
        
        heap.insert(10);
        System.out.println("Heap1 after inserting new element: ");
        heap.print();
        
        int arr[] = new int[]{9, 1, 2, 3, 8, 7};
        BinaryHeap heap2 = new BinaryHeap(arr.length);
        heap2.buildHeap(arr);
        System.out.println("Heap2: ");
        heap2.print();
	}
}
