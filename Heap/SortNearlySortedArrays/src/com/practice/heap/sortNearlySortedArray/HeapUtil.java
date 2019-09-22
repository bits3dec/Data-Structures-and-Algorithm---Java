package com.practice.heap.sortNearlySortedArray;

public class HeapUtil {
	
	//Given an array of n elements, where each element is at most k away from its target position
	public static void sortNearlySorted(int arr[], int k) {
		int subArr[] = new int[k+1];
		
		for(int i = 0; i <= k; ++i) {
			subArr[i] = arr[i];
		}
		
		//MinHeap
		//T:O(k+1)
		buildHeap(subArr);
		
		int index = 0;
		int n = arr.length;
		//T:0((n-k-1)log(k+1))
		for(int i = k+1; i < n; ++i) {
			arr[index] = subArr[0];
			++index;
			
			subArr[0] = arr[i];
			heapify(0, subArr);
		}
		while(index < n) {
			arr[index] = deleteMin(subArr);
			++index;
		}
	}
	
	//MinHeap
	private static void buildHeap(int arr[]) {
		int n = arr.length;
		
		for(int i = (n-2)/2; i >= 0; --i) {
			heapify(i, arr);
		}
	}
	
	//MinHeap
	private static void heapify(int i, int arr[]) {
		int n = arr.length;
		int l = 2*i + 1;
		int r = 2*i + 2;
		int min = i;
		
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
		
			heapify(min, arr);
		}
	}
	
	private static int deleteMin(int arr[]) {
		int min = arr[0];
		arr[0] = Integer.MAX_VALUE;
		
		heapify(0, arr);
		return min;
	}
}
