package com.practice.dp.partition;

public class Partition {
	public static boolean partitionPossible(int arr[]) {
		int sum = getSum(arr);
		
		if(sum % 2 == 1) {
			return false;
		}
		
		
		//Problem now reduced to finding if sum/2 exists in the array i.e. CheckSum(int arr[], int k) where k = sum/2
		int k = sum/2;
		return isSumExists(arr, k);
		
	}
	
	private static int getSum(int arr[]) {
		int sum = 0;
		for(int i = 0; i < arr.length; ++i) {
			sum += arr[i];
		}
		return sum;
	}
	
	private static boolean isSumExists(int arr[], int sum) {
		int n = arr.length;
		
		//t[i][j] denotes if sum "j" exists with arr[0...i]
		boolean t[][] = new boolean[n][sum+1];
		
		for(int i = 0; i < n; ++i) {
			t[i][0] = true;//Empty set exists with sum 0
		}
		for(int i = 1; i < n; ++i) {
			for(int j = 1; j <= sum; ++j) {
				if(arr[i] <= j) {
					t[i][j] = t[i-1][j-arr[i]] || t[i-1][j];
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}		
		return t[n-1][sum];
	}
}
