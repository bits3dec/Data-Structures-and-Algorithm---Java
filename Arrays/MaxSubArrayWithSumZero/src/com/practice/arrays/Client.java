package com.practice.arrays;

public class Client {
	public static void main(String[] args) {
		MaximumSubArray test = new MaximumSubArray();
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 }; 
		int n = arr.length;

		test.maximumSubArrayWithSumZero(arr, n);
	}
}
