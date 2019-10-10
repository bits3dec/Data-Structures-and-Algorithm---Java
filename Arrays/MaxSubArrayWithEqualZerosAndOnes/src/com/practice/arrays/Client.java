package com.practice.arrays;

public class Client {
	public static void main(String[] args)  
    { 
		MaximumSubArray test = new MaximumSubArray(); 
        int arr[] = {1, 1, 0, 1, 0, 1, 1, 0 , 1, 0}; 
        int n = arr.length; 
  
        test.maximumSubArrayWithEqualZerosAndOnes(arr, n); 
    } 
}
