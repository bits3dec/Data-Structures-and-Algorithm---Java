package com.practice.dp.maximumContiguousSum;

public class Client {
	public static void main(String[] args) {
		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		
		int maxSum = MaximumContiguousSum.maxContinuousSum(arr);
		System.out.println(maxSum);
		
		maxSum = MaximumContiguousSumDP.maxContinuousSum(arr);
		System.out.println(maxSum);
	}
}
