package com.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubArray {
	public int maximumSubArrayWithSumZero(int arr[], int n) {
		if(arr == null) {
			return -1;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxLength = -1;
		int endIndex = -1;
		int sum = 0;
		
		for(int i = 0; i < n; ++i) {
			if(arr[i] == 0 && maxLength == -1) {
				maxLength = 1;
				endIndex = i;
			}
			sum += arr[i];			
			//For subarray starting with index 0 and ending at i
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
		
		if(endIndex == -1) {
			System.out.println("No subbarry with sum Zero found !!!");
			return endIndex;
		} else {
			System.out.println("Maximum subarray with sum zero found !!!");
			int startingIndex = endIndex - maxLength + 1;
			System.out.println("Starting Index: " + startingIndex);
			System.out.println("Ending Index: " + endIndex);
			System.out.println("Maximum length: " + maxLength);
			return maxLength;
		}
	}
}
