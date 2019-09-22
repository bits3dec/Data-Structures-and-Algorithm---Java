package com.practice.heap.sortNearlySortedArray;

public class Client {
	public static void main(String[] args) {
		 int arr[] = { 10, 9, 8, 7, 4, 70, 60, 50 };
         int k = 4;
         System.out.println("Before sorting:");
         print(arr);
         
         HeapUtil.sortNearlySorted(arr, k);
         System.out.println("After sorting:");
         print(arr);
	}
	
	private static void print(int arr[]) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
	}
}