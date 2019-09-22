package com.practice.heap.kLargestElement;

public class Client {
	public static void main(String[] args) {
		int arr[] = new int[] {2, 4, 53, 32, 123, 34 };
		int k = 2;
		
		print(arr);
		
		System.out.println("k = " + k);
		System.out.println("Kth largest element is: ");
		int res = HeapUtil.kLargestElement(arr, k);
		System.out.println(res);
	}
	
	private static void print(int arr[]) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
