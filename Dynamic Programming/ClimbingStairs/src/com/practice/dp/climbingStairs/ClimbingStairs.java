package com.practice.dp.climbingStairs;

public class ClimbingStairs {
	
	public int countWaysUsingStep1_2(int n) {
		int res[] = new int [n+1];
		//res[j] denotes the num of ways to reach nth stair using step1 and step2
		//e.g-
		//Fibonacci series res[5] = res[4] + res[3] => res[j] = res[j-1] + res[j-2]
		
		res[0] = 1;
		res[1] = 1;		
		for(int i = 2; i <= n; ++i) {
			res[i] = res[i-1] + res[i-2];
		}
		return res[n];
	}
	
	public int countWaysUsingStep1_2_3(int n) {
		int res[] = new int[n+1];
		//res[j] denotes the num of ways to reach the nth stair using step1, step2 and step3
		
		res[0] = 1;
		res[1] = 1;
		res[2] = 2;	
		for(int i = 3; i <= n; ++i) {
			res[i] = res[i-1] + res[i-2] + res[i-3];
		}
		return res[n];
	}
	
	public int countWaysUsingUptoMSteps(int n, int m) {
		int res[] = new int[n+1];
		//res[j] denotes the num of ways to reach nth stair using upto m steps
		
		res[0] = 1;
		res[1] = 1;
		for(int i = 2; i <= n; ++i) {
			for(int j = 1; j <= m && j <= i; ++j) {
				res[i] += res[i-j];
			}
		}
		return res[n];
	}
}
