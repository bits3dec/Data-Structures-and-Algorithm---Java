package com.practice.heap.heapSort;

public class Client {
	public static void main(String[] args) {
		int arr[] = new int[] {2, 34, 4, 1, 12, 45, 90};
		
		System.out.println("Before sorting:");
		print(arr);
		
		HeapSort test = new HeapSort();
		test.sort(arr);
	    
		System.out.println("After sorting:");
		print(arr);
	}
	
	private static void print(int arr[]) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
