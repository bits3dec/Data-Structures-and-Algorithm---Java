package com.practice.dp.knapsack;

public class Client {
	public static void main(String[] args) {
		int c = 50;
        int n = 4;
        int wt[] = { 10, 40, 20, 30 };
        int val[] = { 60, 40, 100, 120 };
        
        int res =  Knapsack.maxProfit(n, c, val, wt);
        System.out.println(res);
        
        FractionalKnapsack fractional = new FractionalKnapsack();
        int res2 = fractional.maxProfit(n, c, val, wt);
        System.out.println(res2);
	}
}
