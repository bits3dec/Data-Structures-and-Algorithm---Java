package com.practice.heap.mergeKSortedArrays;

public class Client {
	public static void main(String[] args) {
		int k = 3;
        int arr[][] = new int[][] {new int[] { 2, 6, 12 },
                               new int[] { 1, 9 },
                               new int[] { 23, 34, 90, 2000 } };
                              
        int res[] = HeapUtil.mergeKSortedArrays(arr, k);
        print(res);
	}
	
	private static void print(int arr[]) {
		for(int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
