package com.practice.dp.longestIncreasingSubsequence;

public class Client {
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		
		int res = LongestIncreasingSubsequence.lis(arr);
		System.out.println(res);
	}
}
