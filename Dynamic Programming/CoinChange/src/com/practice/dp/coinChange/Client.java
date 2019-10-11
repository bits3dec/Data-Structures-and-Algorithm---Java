package com.practice.dp.coinChange;

public class Client {
	public static void main(String[] args) {
		int coins[] = { 9, 6, 5, 1 };
        int n = coins.length;
        int v = 11;
        
        int res = CoinChange.minCoinChange(coins, v);
        System.out.println(res);
        
        
        int[] coins2 = { 1, 2, 3 };
        int n2 = coins2.length;
        int v2 = 4;
        
        int res2 = TotalCoinChange.totalCoinChange(coins2, v2);
        System.out.println(res2);
	}
}
