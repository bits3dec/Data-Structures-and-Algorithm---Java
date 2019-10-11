package com.practice.dp.partition;

public class Client {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 1, 2, 2, 1 };
        
        boolean res = Partition.partitionPossible(arr);
        System.out.println(res);
	}
}
