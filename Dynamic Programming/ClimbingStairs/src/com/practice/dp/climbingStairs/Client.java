package com.practice.dp.climbingStairs;

public class Client {
	public static void main(String[] args) {
		ClimbingStairs test = new ClimbingStairs();
		
		int s = 4, m = 2;
		System.out.println("Number of ways  = " + test.countWaysUsingStep1_2(s));
		System.out.println("Number of ways = " + test.countWaysUsingStep1_2_3(s));
		System.out.println("Number of ways = " + test.countWaysUsingUptoMSteps(s, m));
	}
}
