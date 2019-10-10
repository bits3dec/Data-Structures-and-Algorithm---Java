package com.practice.dp.longestIncreasingSubsequence;

public class LongestIncreasingSubsequence {
	public static int lis(int arr[]) {
		int n = arr.length;
		
		//t[j] denotes the longest increasing subsequence with arr[j] as the last element
		int t[] = new int[n];
		
		for(int i = 0; i < n; ++i) {
			t[i] = 1;
		}
			
		for(int j = 1; j < n; ++j) {
			for(int i = 0; i < j; ++i) {
				if(arr[i] <= arr[j]) {
					int temp = t[i] + 1;
					if(temp > t[j]) {
						t[j] = temp;
					}
				}
			}
		}
		
		int res = max(t);
		return res;
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
