package com.practice.dp.checkSum;

public class Client {
	public static void main(String[] args) {
		 int arr[] = { 3, 34, 4, 12, 5, 2 };
         int sum = 9;
         
         boolean res = CheckSum.isSumExists(arr, sum);
         System.out.println(res);
	}
}
