package com.practice.dp.bridges;

import java.util.Arrays;

public class Bridges {
	public static int maxBridges(CityPair[] cityPairs) {
		int n = cityPairs.length;
		
		//Sort the cityPairs according to their southern points
		Arrays.sort(cityPairs, (city1, city2)-> city1.xSouth - city2.xSouth);
		
		//Problem is now reduced to finding longest increasing subsequence(lis) for the northern points of the cityPairs
		//t[j] denotes the maximum bridges that can be build with city "j" as the last city
		int t[] = new int[n];
		
		for(int i = 0; i < n; ++i) {
			t[i] = 1;
		}
		
		for(int j = 1; j < n; ++j) {
			for(int i = 0; i < j; ++i) {
				if(cityPairs[i].xNorth < cityPairs[j].xNorth) {
					int temp = t[i] + 1;
					if(temp > t[j]) {
						t[j] = temp;
					}
				}
			}
		}
		
		int res = max(t);
		return res;
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
