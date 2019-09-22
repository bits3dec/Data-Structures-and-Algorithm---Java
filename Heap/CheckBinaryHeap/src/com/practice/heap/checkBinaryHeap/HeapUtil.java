package com.practice.heap.checkBinaryHeap;

public class HeapUtil {
	
	//MaxHeap
	public static boolean isBinaryHeap(int i, int n, int arr[]) {
		//All leaf nodes will always satisfy the heap property 
		if(i > (n-2)/2) {
			return true;
		}
		
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if(l < n && r < n) {
			if(arr[l] < arr[i] && arr[r] < arr[i] && isBinaryHeap(l, n, arr) == true && isBinaryHeap(r, n, arr) == true) {
				return true;
			}
		} else {
			if(arr[l] < arr[i] && isBinaryHeap(l, n, arr) == true) {
				return true;
			}
		}
		return false;
	}
}
