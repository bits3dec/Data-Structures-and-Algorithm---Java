package com.practice.heap.kLargestElement;

public class HeapUtil {
	
	public static int kLargestElement(int arr[], int k) {
		int n = arr.length;
		if(k > n) {
			System.out.println("Array length is less than k");
			return -1;
		}
		
		buildHeap(arr, k);//MinHeap
		
		for(int i = k; i < n; ++i) {
			if(arr[i] > arr[0]) {
				int temp = arr[0];
				arr[0] = arr[i];
				arr[i] = temp;
				
				heapify(0, k, arr);
			}
		}
		return arr[0];
	}
	
	private static void buildHeap(int arr[], int n) {
		for(int i = (n-2)/2; i >= 0; --i) {
			heapify(i, n, arr);
		}
	}
	
	private static void heapify(int i, int n, int arr[]) {
		int min = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if(l < n && arr[l] < arr[min]) {
			min = l;
		}
		if(r < n && arr[r] < arr[min]) {
			min = r;
		}
		if(min != i) {
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			
			heapify(min, n, arr);
		}
	}
}
