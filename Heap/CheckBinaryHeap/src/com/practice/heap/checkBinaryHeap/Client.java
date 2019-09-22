package com.practice.heap.checkBinaryHeap;

public class Client {
	public static void main(String[] args) {
		int[] arr = { 90, 15, 10, 7, 12, 2, 7, 3 };
		print(arr);
		
		if(HeapUtil.isBinaryHeap(0, arr.length, arr) == true) {
			System.out.println("Binary heap (MaxHeap) !!!");
		} else {
			System.out.println("Not a Binary Heap (MaxHeap) !!!");
		}
		
	}
	
	private static void print(int arr[]) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
