package com.practice.dp.knapsack;

import java.util.Arrays;

public class FractionalKnapsack {
	public int maxProfit(int n, int c, int val[], int wt[]) {
		Item items[] = new Item[n];
		for(int i = 0; i < n; ++i) {
			items[i] = new Item(val[i], wt[i]);
		}
		Arrays.sort(items, (item1, item2) -> (int) (item2.getRatio() - item1.getRatio()));
		
		int currentWeight = 0;
		int profit = 0;
		for(int i = 0; i < n; ++i) {
			if(currentWeight + items[i].wt <= c) {
				currentWeight += items[i].wt;
				profit += items[i].val;
			} else {
				int remWeight = c - currentWeight;
				double remValue = items[i].val * ((double) remWeight/items[i].wt);
				profit += remValue;
				break;
			}
		}
		
		return profit;
	}
}

class Item {
	int val;
	int wt;
	double ratio;
	
	public Item(int val, int wt) {
		this.val = val;
		this.wt = wt;
		this.ratio = val/wt;
	}
	
	public double getRatio() {
		return ratio;
	}
}
