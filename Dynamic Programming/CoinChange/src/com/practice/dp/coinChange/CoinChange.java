package com.practice.dp.coinChange;

import java.util.Arrays;

public class CoinChange {
	public static int minCoinChange(int coins[], int v) {
		int n = coins.length;
		
		//t[j] denotes the minimum coin change needed to get sum "j"
		int t[] = new int[v+1];
		Arrays.fill(t, Integer.MAX_VALUE);
		
		t[0] = 0;
		for(int j = 1; j <= v; ++j) {
			for(int i = 0; i < n; ++i) {
				if(coins[i] <= j) {
					int subRes = t[j-coins[i]];
					if(subRes != Integer.MAX_VALUE && subRes + 1 < t[j]) {
						t[j] = subRes + 1;
					}				
				}
			}
		}
		return t[v];
	}
}
