package com.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArray {

	public int maximumSubArrayWithEqualZerosAndOnes(int arr[], int n) {
		if(arr == null) {
			return -1;
		}

		//Replace all the zeroes with -1
		for(int i = 0; i < n; ++i) {
			if(arr[i] == 0) {
				arr[i] = -1;
			}
		}	
		//Problem reduced to finding maximum subarray with sum 0		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxLength = -1;
		int endIndex = -1;
		
		int sum = 0;
		for(int i = 0; i < n; ++i) {			
			sum += arr[i];				
			//For subarray starting with 0 and ending at i
			if(sum == 0) {
				maxLength = i + 1;
			}
			
			//For intermediate subarray
			if(map.get(sum) == null) {
				map.put(sum, i);
			} else {
				int previousIndex = map.get(sum);
				int currentLength = i - previousIndex;
				if(currentLength > maxLength) {
					maxLength = currentLength;
					endIndex = i;
				}
			}
		}
		
		if(endIndex == - 1) {
			System.out.println("All are either 0s or 1s !!! No Subarray with with equal 0s and 1s found !!!");
			return endIndex;
		} else {
			System.out.println("Maximum Subarray with equal 0s and 1s found !!!");
			int startingIndex = endIndex - maxLength + 1;
			System.out.println("Starting Index: " + startingIndex);
			System.out.println("Ending Index: " + endIndex);
			System.out.println("Maximum length: " + maxLength);
			return maxLength;
		}
	}
}
