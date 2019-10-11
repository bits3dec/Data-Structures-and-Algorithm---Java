package com.practice.dp.coinChange;

public class TotalCoinChange {
	//Assume unlimited supply of each coins
	public static int totalCoinChange(int coins[], int v) {
		int n = coins.length;
		
		//t[i][j] denotes the total ways of coin change with coins[0...i] and sum "j"
		int t[][] = new int[n][v+1];
		
		for(int i = 0; i < n; ++i) {
			t[i][0] = 1;//one way only i.e. no change
		}
		for(int j = 1; j <= v; ++j) {
			t[0][j] = 1;//Assuming coins[0] = 1
		}
		for(int i = 1; i < n; ++i) {
			for(int j = 1; j <= v; ++j) {
				int x = t[i-1][j];//Not considering the coin
				int y = coins[i] <= j ? t[i][j-coins[i]] : 0; //Considering the coin
				t[i][j] = x + y;
			}
		}
		return t[n-1][v];
	}
}
