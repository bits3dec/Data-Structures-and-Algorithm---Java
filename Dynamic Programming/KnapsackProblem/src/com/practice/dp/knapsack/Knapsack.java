package com.practice.dp.knapsack;

public class Knapsack {
	public static int maxProfit(int n, int c, int val[], int wt[]) {
		//t[i][j] denotes the max profit that can be achieved with items[0...i] and with capacity "j"
		int t[][] = new int [n][c+1];
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j <= c; ++j) {
				if(j == 0) {
					t[i][j] = 0;
				} else if(i == 0) {
					if(wt[i] <= j) {
						t[i][j] = val[i];
					}
				} else {
					if(wt[i] <= j) {
						t[i][j] = Math.max(val[i] + t[i-1][j-wt[i]], t[i-1][j]);
					} else {
						t[i][j] = t[i-1][j];
					}
				}
			}
		}
		
		return t[n-1][c];
	}
}
