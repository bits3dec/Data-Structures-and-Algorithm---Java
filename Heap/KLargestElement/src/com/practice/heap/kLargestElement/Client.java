package com.practice.heap.kLargestElement;

public class Client {
	public static void main(String[] args) {
		//int arr[] = new int[] {2, 4, 53, 32, 123, 34 };
		int arr[] = new int[] {12, 4, 43, 11, 10, 47, 87};
		int k = 4;
		
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
