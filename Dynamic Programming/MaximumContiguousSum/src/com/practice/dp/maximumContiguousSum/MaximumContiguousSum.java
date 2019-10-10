package com.practice.dp.maximumContiguousSum;

public class MaximumContiguousSum {
	public static int maxContinuousSum(int arr[]) {
		int n = arr.length;
		
		if(allNegative(arr) == true) {
			return max(arr);
		}
		
		int sumSoFar = 0;
		int maxSoFar = Integer.MIN_VALUE;
				
		for(int i = 0; i < n; ++i) {
			sumSoFar += arr[i];		
			if(sumSoFar > maxSoFar) {
				maxSoFar = sumSoFar;
			}
			if(sumSoFar < 0) {
				sumSoFar = 0;
			}
		}
		
		return maxSoFar;
	}
	
	private static boolean allNegative(int arr[]) {
		for(int i = 0; i < arr.length; ++i) {
			if(arr[i] >= 0) {
				return false;
			}
		}
		return true;
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
