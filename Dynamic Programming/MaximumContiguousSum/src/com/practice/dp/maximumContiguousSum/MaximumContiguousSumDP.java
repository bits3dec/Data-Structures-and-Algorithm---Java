package com.practice.dp.maximumContiguousSum;

public class MaximumContiguousSumDP {
	public static int maxContinuousSum(int arr[]) {
		int n = arr.length;
		
		//t[j] denotes the maximum contiguous sum with arr[j] as the last element
		int t[] = new int[n];

		t[0] = arr[0] > 0 ? arr[0] : 0;	
		for(int i = 1; i < n; ++i) {
			if(t[i-1] + arr[i] > 0) {
				t[i] = t[i-1] + arr[i];
			}
		}	
		return max(t);
	}
	
	private static int max(int arr[]) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
}
