package com.practice.heap.heapSort;

public class HeapSort {
	//Ascending order
	public void sort(int arr[]) {
		int n = arr.length;
		
		//Build Heap(MaxHeap)
		//T:O(n)
		for(int i = (n-2)/2; i >= 0; --i) {
			heapify(i, n, arr);
		}
		
		//T:O(nlog(n))
		for(int i = n-1; i >= 0; --i) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapify(0, i, arr);
		}
	}
	
	//MaxHeap
	private void heapify(int i, int n, int arr[]) {
		int l = 2*i + 1;
		int r = 2*i + 2;
		int max = i;
		
		if(l < n && arr[l] > arr[max]) {
			max = l;
		}
		if(r < n && arr[r] > arr[max]) {
			max = r;
		}
		if(max != i) {
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			
			heapify(max, n, arr);
		}
	}
}
