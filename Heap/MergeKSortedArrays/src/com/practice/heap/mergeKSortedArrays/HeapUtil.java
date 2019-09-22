package com.practice.heap.mergeKSortedArrays;

public class HeapUtil {
	
	public static int[] mergeKSortedArrays(int arr[][], int k) {
		int n = 0;	
		Entry subArr[] = new Entry[k];
		
		for(int i = 0; i < k; ++i) {
			subArr[i] = new Entry(arr[i][0], 0, i);
			n += arr[i].length;
		}
		
		//T:O(k)
		buildHeap(subArr);
		
		int res[] = new int[n];	
		
		//T:O(nlog(k)) where n->total num of elements
		for(int i = 0; i < n; ++i) {
			Entry entry = subArr[0];
			int value = entry.value;
			int index = entry.index;
			int array = entry.array;
			
			res[i] = value;
			
			int next = ++index;
			if(index < arr[array].length) {	
				subArr[0] = new Entry(arr[array][next], next, array);						
			} else {
				subArr[0] = new Entry(Integer.MAX_VALUE, -1, -1);		
			}
			heapify(0, subArr);
		}
		return res;
	}
	
	//MinHeap
	private static void buildHeap(Entry arr[]) {
		int n = arr.length;
		
		//Start from the first non-leaf node since all leaf nodes will always satisfy the heap property
		for(int i = (n-2)/2; i >=0; --i) {
			heapify(i, arr);
		}
	}
	
	//MinHeap
	private static void heapify(int i, Entry arr[]) {
		int n = arr.length;
		int min = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		if(l < n && arr[l].value < arr[min].value) {
			min = l;
		}
		if(r < n && arr[r].value < arr[min].value) {
			min = r;
		}
		if(min != i) {
			Entry temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			
			heapify(min, arr);
		}
	}
}
