package com.practice.dp.fibonacci;

public class Client {
	public static void main(String[] args) {
		int res = FibonacciBottomUp.printFibonacciBottomUp(6);
		System.out.println(res);
		
		int res2 = FibonacciTopDown.printFibonacciTopDown(6);
		System.out.println(res2);
	}
}
